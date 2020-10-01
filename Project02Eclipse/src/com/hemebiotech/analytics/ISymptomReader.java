package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * Method used to set the origin of the data read
	 * 
	 * @param origin could be one or multiple paths, database connection informations or anything else creating
	 * a link between the implementation of this interface and a data source
	 */
	public void setDataOrigin(String[] origin);
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	List<String> getSymptoms ();
}
