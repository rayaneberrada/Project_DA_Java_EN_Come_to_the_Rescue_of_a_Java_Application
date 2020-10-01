package com.hemebiotech.analytics;

import java.util.Map;

/**
 * 
 * @author Rayane Berrada
 *
 * Create a new file using information
 */
public interface ISymptomWriter {
	/**
	 * Method used to set the destination of the data written
	 * 
	 * @param destination could be one or multiple paths, database connection informations or anything else creating
	 * a link between the implementation of this interface and a data source
	 */
	public void setDataDestination(String[] destination);
	/**
	 * Write data into a data source
	 */
	public void writeData(Map<String, Integer> symptoms);
}
