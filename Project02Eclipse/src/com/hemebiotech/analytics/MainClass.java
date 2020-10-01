package com.hemebiotech.analytics;

public class MainClass {

	public static void main(String[] args) {
		ISymptomReader symptomsReader = new ReadSymptomDataFromOneFile();
		Analytics analyticsCounter = new AnalyticsCounter();
		ISymptomWriter symptomsWriter = new WriteMapSymptomDataInOneFile();
		DataManager fileManager = new DataManager(symptomsReader, analyticsCounter, symptomsWriter);
		
		fileManager.readFile(new String[]{"Project02Eclipse\\symptoms.txt"});
		fileManager.analyzeDatas();
		fileManager.writeDatasInFile(new String[]{"Project02Eclipse\\results.out"});
	}

}
