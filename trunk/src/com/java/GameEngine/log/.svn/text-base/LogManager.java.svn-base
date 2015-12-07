package com.java.GameEngine.log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

import com.java.GameEngine.GameEngineConstants;

/**
 * Log manager that can be used by the game developer to create log files.
 * 
 * @author Serkan Demirci
 */
public class LogManager
{
	private Queue<String> logMessages;
	private int logLimit;
	private static LogManager instance = null;
	
	/**
	 * Creates a new log file. Since class uses Singleton design pattern
	 * this constructor is private.
	 */
	private LogManager()
	{
		logMessages = new LinkedList<>();
		logLimit = GameEngineConstants.Logging.LOG_LIMIT;
	}
	
	/**
	 * Returns the instance of the LogManager class
	 * @return Single instance of the class.
	 */
	public static LogManager getInstance()
	{
		if (instance == null)
			instance = new LogManager();
		return instance;
	}
	
	/**
	 *  Returns the maximum log limit that can be stored in the memory
	 * @return Log limit
	 */
	public int getLogLimit()
	{
		return logLimit;
	}
	
	/**
	 *   Sets the maximum log limit that can be stored in the memory.
	 * @param parLimit Log limit that will be set
	 */
	public void setLogLimit(int parLimit)
	{
		this.logLimit = parLimit;
	}
	
	/**
	 * Logs the message
	 * @param parStr Message to be logged
	 */
	public void log(String parStr)
	{
		//Removes old log message
		if (logMessages.size() == logLimit)
			logMessages.poll();
		
		//Adds new log message
		logMessages.add(parStr);
	}
	
	/**
	 *  Logs message as Exception
	 * @param parStr Message to be logged.
	 */
	public void logException(String parStr)
	{
		this.log(GameEngineConstants.Logging.EXCEPTION+parStr);
	}
	
	/**
	 *  Logs message as Warning
	 * @param parStr Message to be logged.
	 */
	public void logWarning(String parStr)
	{
		this.log(GameEngineConstants.Logging.WARNING+parStr);
	}
	
	/**
	 *  Logs message as Info
	 * @param parStr Message to be logged.
	 */
	public void logInfo(String parStr)
	{
		this.log(GameEngineConstants.Logging.INFO+parStr);
	}
	
	/**
	 * Clears all data inside the log manager
	 */
	public void clear()
	{
		logMessages.clear();
	}
	
	/**
	 *  Saves the contents of the log into a file.<br>
	 *  After method executed the log messages are deleted from memory.
	 *  @param parFile File that is created.
	 * @throws IOException 
	 */
	public void save(File parFile) throws IOException
	{
		StringBuffer logs = new StringBuffer();//StringBuffer is used to hold the log messages
		
		//Creates log string
		while (!logMessages.isEmpty())
			logs.append(logMessages.poll() + "\n");
		
		//Opens a printWriter to write data
		PrintWriter fileWriter = new PrintWriter(parFile);
		
		fileWriter.write(logs.toString());//Writes the log
		
		//Flushes and closes print writer
		fileWriter.flush();
		fileWriter.close();
	}
}
