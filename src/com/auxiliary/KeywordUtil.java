package com.auxiliary;

import java.util.logging.Logger;

import com.exception.StepFailedException;

public class KeywordUtil {
    
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void markFailed(String message) {
    	//do something here...
    }

    public static void markFailedAndStop(String message) {
        throw new StepFailedException(message);
    }

    public static void logInfo(String message) {
    	LOGGER.fine(message);
    }


    public static void markWarning(String message) {
    	LOGGER.warning(message);
    }


    public static void markPassed(String message) {
    	LOGGER.finest(message);
    }
    

    public static void markError(String message) {
    	LOGGER.severe(message);
    }
    

    public static void markErrorAndStop(String message) {
    	LOGGER.severe(message);
    	throw new StepFailedException(message);
    }
}
