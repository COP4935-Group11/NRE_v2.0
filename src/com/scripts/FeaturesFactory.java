package com.scripts;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.configuration.RunConfiguration;
import com.constants.StringConstants;


public class FeaturesFactory {

	protected static ArrayList<File> listOfFeatures = null;
	protected static ArrayList<File> listOfNewFeatures = null;	
	
	protected static Map<String, ArrayList<String>> tagsMap = new HashMap<String, ArrayList<String>>();
	
	public static Map<String, ArrayList<String>> getTags(){return tagsMap;}

	public static void copyFeatures() throws IllegalAccessException, InstantiationException, IOException {

		listOfFeatures = getFeaturesFiles();
		listOfNewFeatures = new ArrayList<>();
		
		
		for(File file : listOfFeatures) { 
			readTags(file);
			listOfNewFeatures.add(getFeature(file));	
		}
		
	}

	protected static ArrayList<File> getFeaturesFiles() {

		ArrayList<File> features = new ArrayList<>();

		String folder = RunConfiguration.getProjectDir().concat(StringConstants.ID_SEPARATOR).
				concat(StringConstants.FEATURES_SOURCE).concat(StringConstants.ID_SEPARATOR);
		
//		System.out.println(folder); //debugging mode
		
		File rootFolder = new File(folder);
		 List<Path> result = null;
		    try (Stream<Path> walk = Files.walk(Paths.get(folder))) {
		        result = walk
		                .filter(Files::isRegularFile)   // is a file
		                .filter(p -> p.getFileName().toString().endsWith(".feature"))
		                .collect(Collectors.toList());
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
		}
	      
	     for(Path path : result)
	     {
	    	 features.add(path.toFile());
	     }
	       
			
		return features;
	}

	protected static File getFeature(File rootScript) throws IOException {

		String sourceCode= null;
		
		ArrayList<String> fileContent = new ArrayList<String>(Files.readAllLines(Paths.get(rootScript.toURI()), StandardCharsets.UTF_8));
		sourceCode = String.join(StringConstants.NEW_LINE, fileContent);
				
		new File(StringConstants.ROOT_DIR + StringConstants.ID_SEPARATOR + 
				StringConstants.FEATURES_FOLDER).mkdirs();		
		Path targetPath = Paths.get(new File(StringConstants.ROOT_DIR + StringConstants.ID_SEPARATOR + 
											StringConstants.FEATURES_FOLDER + StringConstants.ID_SEPARATOR + 
											rootScript.getName()).getAbsolutePath());
		Files.writeString(targetPath, sourceCode, StringConstants.STANDARD_CHARSET);
		return new File(targetPath.toAbsolutePath().toString());	
	}
	
	protected static void readTags(File featureFile) throws IOException {
		
		ArrayList<String> fileContent = new ArrayList<String>(Files.readAllLines(Paths.get(featureFile.toURI()), 
				StringConstants.STANDARD_CHARSET));
		ArrayList<String> tags = new ArrayList<>();
		
		Iterator<String> iter = fileContent.iterator();
		while (iter.hasNext()) {
			 String line = iter.next();
			  if (line.contains("@")) 
				  tags.add(line);
			  else if(line.contains("Feature")) {				 
				  tagsMap.put(line.replace("Feature:", "").trim(), tags);
				  break;
			  }			  
		}	
		
	}
}
