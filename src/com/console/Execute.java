package com.console;

import com.configuration.RunConfiguration;
import com.constants.StringConstants;


public class Execute {
	
	private static final String SKIPPED_MESSAGE = "SKIPPED : Suite stopped on failure!";
	private static final String TEST_CASE_LABEL = "TEST CASE";
		
	public static void run() throws Exception
	{		
		RunScript.beforeSuite(); 
	
//		for(TestCase tc : RunConfiguration.getTestSuiteObj().getTestCases()) {
//				
//			RunConfiguration.getTestSuiteObj().setTestCase(RunConfiguration.getTestSuiteObj().getSuiteCase().
//					createNode(TEST_CASE_LABEL + StringConstants.COLON + tc.getName()).assignCategory(StringConstants.TEST_CASES_REPORT_TAG).
//					assignAuthor(RunConfiguration.getTestSuiteObj().getProfile() + StringConstants.HYPHEN + 
//							RunConfiguration.getTestSuiteObj().getBrowser()));
//			
//			RunConfiguration.getTestSuiteObj().setCurrentNode(RunConfiguration.getTestSuiteObj().getTestCase());
//				
//			if(RunConfiguration.getTestSuiteObj().getShouldStop())
//			{
//					RunConfiguration.getTestSuiteObj().getTestCase().skip(SKIPPED_MESSAGE);
//			}
//			else {
//				RunConfiguration.getTestSuiteObj().setInTestCase(true);
//				RunConfiguration.getTestSuiteObj().setCurrentTestcase(tc);
//
//				RunScript.beforeTest();
//	
//				if(!RunConfiguration.getTestSuiteObj().getCurrentTestCase().getShouldStop())
//				{	
//					RunScript.beforeCase();
//
//					
//					if(!RunConfiguration.getTestSuiteObj().getCurrentTestCase().getShouldStop())
//					{	
//						RunScript.runScript();
//						
//						if(!RunConfiguration.getTestSuiteObj().getCurrentTestCase().getShouldStop())
//						{
//							RunScript.afterCase(0);
//							if(!RunConfiguration.getTestSuiteObj().getCurrentTestCase().getShouldStop())
//							{
//								RunScript.afterTest(0);
//							}
//							else 
//							{
//								RunScript.afterTest(-1);	
//							}
//						}
//						else 
//						{
//								RunScript.afterCase(-1);
//								RunScript.afterTest(-1);
//						}
//					}
//					else 
//					{ 
//							RunScript.afterCase(-1);
//							RunScript.afterTest(-1);
//					}							
//				}
//				else 
//				{
//					RunScript.afterTest(-1);	
//				}
//			}	
//				
//			RunConfiguration.getExtent().flush();
//		}
		
		for(TestCase tc : RunConfiguration.getTestSuiteObj().getTestCases()) {
			
			RunConfiguration.getTestSuiteObj().setTestCase(RunConfiguration.getTestSuiteObj().getSuiteCase().
					createNode(TEST_CASE_LABEL + StringConstants.COLON + tc.getName()).assignCategory(StringConstants.TEST_CASES_REPORT_TAG).
					assignAuthor(RunConfiguration.getTestSuiteObj().getProfile() + StringConstants.HYPHEN + 
							RunConfiguration.getTestSuiteObj().getBrowser()));
			
			RunConfiguration.getTestSuiteObj().setCurrentNode(RunConfiguration.getTestSuiteObj().getTestCase());
				
			if(RunConfiguration.getTestSuiteObj().getShouldStop())
			{
					RunConfiguration.getTestSuiteObj().getTestCase().skip(SKIPPED_MESSAGE);
			}
			else {
				RunConfiguration.getTestSuiteObj().setInTestCase(true);
				RunConfiguration.getTestSuiteObj().setCurrentTestcase(tc);

				RunScript.beforeTest();
				
				if(!RunConfiguration.getTestSuiteObj().getCurrentTestCase().getShouldStop())
				{
					RunScript.beforeCase();
					
					if(!RunConfiguration.getTestSuiteObj().getCurrentTestCase().getShouldStop())
					{
						RunScript.runScript();
					}
					
					if(RunConfiguration.getTestSuiteObj().getCurrentTestCase().setupStatus != 3)
					{
						RunScript.afterCase(0);
					}else
					{
						RunScript.afterCase(-1);
					}
					
				}
	
				if(RunConfiguration.getTestSuiteObj().getCurrentTestCase().tsSetupStatus != 3)
				{
					RunScript.afterTest(0);
				}else
				{
					RunScript.afterTest(-1);
				}
						
			}	
				
			RunConfiguration.getExtent().flush();
		}
		
		RunConfiguration.getTestSuiteObj().setCurrentNode(RunConfiguration.getTestSuiteObj().getSuiteCase());
		
		if(RunConfiguration.getTestSuiteObj().setupStatus != 3)
		{
			
			RunConfiguration.getTestSuiteObj().setInTestCase(false);
			RunScript.afterSuite(0);		
		}
		else
		{
			RunConfiguration.getTestSuiteObj().setInTestCase(false);
			RunScript.afterSuite(-1);	
		}
		
		RunConfiguration.getExtent().flush();
	}
	
}