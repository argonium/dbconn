package io.miti.dbconn.app;

import io.miti.dbconn.console.LineConsole;
import io.miti.dbconn.util.Logger;

public final class DBConn {

	/**
	 * Default constructor.
	 */
	public DBConn() {
		super();
	}
	
	
	/**
	 * Entry point to the application.
	 * 
	 * @param args arguments passed to the application
	 */
	public static void main(String[] args) {
		
		// Initialize the logger
		Logger.initialize(3, "stdout", true);
		
		// Parse any arguments sent to the application
		final ArgumentParser argParser = new ArgumentParser(args);
		if (argParser.exit()) {
			return;
		}
		
		// Start the console
		new LineConsole().start(argParser.loadClassNames);
	}
}
