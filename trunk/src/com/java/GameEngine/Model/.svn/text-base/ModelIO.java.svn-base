package com.java.GameEngine.Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Writes and reads the objects that implements 
 * Serializable interface to a file.
 * 
 * @see java.io.Serializable
 * @author Serkan Demirci
 */
public class ModelIO {

	/**
	 * Loads a serialized data from a file and converts it into an object
	 * by deserializing it.
	 * @param parFile File that will be read
	 * @return Returns the deserialized object
	 * @throws IOException IOException is thrown when the file that is given is not 
	 * 						exist or program is not authorized to read the file.
	 * @throws ClassNotFoundException ClassNotFoundException is thrown when 
	 * 						the data read from file has no meaning.
	 */
	public static Serializable loadModel(File parFile) throws IOException, ClassNotFoundException {
		//Open streams
		FileInputStream fileIn = new FileInputStream(parFile);
		ObjectInputStream objectIn = new ObjectInputStream(fileIn);
		
		//Loads object
		Serializable obj = (Serializable)objectIn.readObject();
		
		//Closes streams
		objectIn.close();
		fileIn.close();
		
		return obj;
	}

	/**
	 * Saves an Serializable object into a file.
	 * @param parFile File to be saved.
	 * @param parObject Object to be saved.
	 * @throws IOException IOException is thrown when the program
	 * 				is unauthorized to save the file in that directory.
	 */
	public static void saveModel(File parFile, Serializable parObject) throws IOException {
		//Opens a stream		
		FileOutputStream fileOut = new FileOutputStream(parFile);
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
		
		objectOut.writeObject(parObject);//Writes object to a file
		
		//Flushes and closes the streams
		objectOut.flush();
		objectOut.close();
		fileOut.close();
	}
}