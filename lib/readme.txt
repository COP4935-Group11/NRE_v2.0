<Description>
NRE is a runtime engine designed to execute test suites and test collection of test automation projects. This software is intended to be used by Dr. Glenn Martin and Dr. Bruce Caulkins at
the University of Central Florida and their respective teams.

<Usage and Parameters>

-->Project Path: (mandatory parameter)
The project path is the path to the test automation project where all of the files required to execute a test suite are stored.
The project path is an absolute path.

-->Test Suite Path: (mandatory parameter)
The test suite path is the relative path containing the test suite files.
The test suite path is a relative path from the project path.
the test suite path is used either for test suites allocating test cases or test collections that allocates test suites.

-->Report Folder: (optional parameter)
The desired directory for storing the generated reports can be entered. (absolute path recommended)
Default path for reports is ./NRE/NRE_Reports

-->Execution Profile: (optional parameter)
The execution profile is the name of the profile selected to run with the test suite.
Default profile is applied if -executionProfile parameter is omitted.

-->Browser Type: (optional parameter)
The browser type specifies which browser to execute the tests in along with determing if the program should run in a headless state.
	+Currently supported browsers:
	 [Chrome | Firefox | Edge | Opera | Chrome(headless) | Firefox(headless)]
	+Chrome(headless) is set as default browser if -browser parameter is omitted.

-->Failure Handling: (optional parameter)
The parameter controls the manner in which failures will be handled during execution.
There are currently three different ways to handle the failures:
	+CONTINUE_ON_FAILURE (continue)	executes as much test as possible even if failure is encountered.	
	+STOP_ON_FAILURE     (stop)	interrupt the execution upon encountering any failure. 
	+OPTIONAL	     (optional)	similar to continue mode, but it mars failed test with a warning.
+STOP_ON_FAILURE is set as default control if -failureHandling parameter is omitted.

	EXAMPLE:
-projectPath=/media/psf/Home/Desktop/Projects/new_prj/PCTE -testSuitePath=Test Suites/9001-9500 Smoke/S9001 All Smoke Tests -browserType=firefox -executionProfile=Authentication -failureHandling=continue -reportFolder=/media/psf/Home/Desktop/Reports

<Output>
After a test suite has been run a cucumber report will be generated detailing the number of successful and unsuccessful test cases.
If a test case is unsuccessful there will be additional information detailing why that test case failed.
This report can be accessed under the "testOutput" folder.

<Support>
This project will not receive updates following May 2021.
More information can be found at our repo @https://github.com/COP4935-Group11/NRE_v1.0

<Developers>
Ben, Scott, Tomer, David, Sebastian, Richard, Sean, Wanda, Triet

