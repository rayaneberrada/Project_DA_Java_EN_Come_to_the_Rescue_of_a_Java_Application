package com.hemebiotech.analytics;

public class MainClass {

	public static void main(String[] args) {
		ISymptomReader symptomsReader = new ReadSymptomDataFromOneFile();
		IAnalytics analyticsCounter = new AnalyticsCounter();
		ISymptomWriter symptomsWriter = new WriteMapSymptomDataInOneFile();
		DataManager fileManager = new DataManager(symptomsReader, analyticsCounter, symptomsWriter);
		
		fileManager.readData(new String[]{"Project02Eclipse\\symptoms.txt"});
		fileManager.analyzeData();
		fileManager.writeData(new String[]{"Project02Eclipse\\results.out"});
	}

}
