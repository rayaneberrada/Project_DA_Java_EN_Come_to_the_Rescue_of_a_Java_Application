package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromOneFile implements ISymptomReader {
	/** path to the file that will be read by the class **/
	private String filepath;
	
	private List<String> symptomsList = new ArrayList<String>();
	
	/**
	 * @param filepath a full or partial path to a file containing strings of symptoms.
	 */
	public void setDataOrigin (String[] filepath) {
		this.filepath = (String) Array.get(filepath, 0);
	}
	
	/**
	 * 
	 * @return symptomsList a list of the symptoms inside the file defined by filepath
	 */
	public List<String> getSymptoms() {
		if (filepath != null) {
			try(BufferedReader br = new BufferedReader(new FileReader(this.filepath))) {
				
				// returns a stream and convert it into a list
				this.symptomsList = br.lines().collect(Collectors.toList());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return this.symptomsList;
	}

}
