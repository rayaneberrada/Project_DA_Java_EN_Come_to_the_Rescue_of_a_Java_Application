package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Map;

public class WriteMapSymptomDataInOneFile implements ISymptomWriter {
	
	private String filePath;
	
	/**
	 * Set the path for the file where the data are going to be saved in.	
	 * 
	 * @param destination a full or partial path to a file containing strings of symptoms.
	 */
	public void setDataDestination(String[] destination) {
		this.filePath = (String) Array.get(destination, 0);
	}
	/**
	 * Create a new file if doens't exist and remove all content if already exist, then instantiate a BufferedWriter
	 * and iterate over symptoms. For each key/value in symptoms, write it in test.out and then go to the line.
	 * 
	 * @param symptoms is a Map object containing the name of a symptom as a key and it's occurrences as a value. 
	 */
	public void createFileFromMap(Map<String, Integer> symptoms) {
        try (FileWriter writer = new FileWriter(this.filePath); BufferedWriter bw = new BufferedWriter(writer)) {
        	for (Map.Entry<String, Integer> entry: symptoms.entrySet()) {
        		bw.write(entry.getKey() + " : " + entry.getValue());
        		bw.newLine();
        	}
        } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**(non-javadoc)
	 * @see com.hemebiotech.analytics.Analytics#writeData(symptoms)
	 */
	public void writeData(Map<String, Integer> symptoms) {
		this.createFileFromMap(symptoms);
	}
}
