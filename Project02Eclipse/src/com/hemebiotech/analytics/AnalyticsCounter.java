package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> lSymptoms = reader.getSymptoms();
		Map<String, Integer> mapSymptoms = countSymptoms(lSymptoms);
		
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		for (String key : mapSymptoms.keySet()) {
			writer.write(key + ":" + mapSymptoms.get(key) + "\n"); 
			}
		writer.close();
	
	}
	
	public static Map<String, Integer> countSymptoms( List<String> lSymptoms ){
		Map<String, Integer> newMap = new TreeMap<String, Integer>();
	
		for( String symptom : lSymptoms ) {
			if (newMap.get(symptom) != null) {
				newMap.put(symptom,newMap.get(symptom) +1) ;
			}
			else {
				newMap.put(symptom,1);
			}
		}
		
		System.out.println(newMap);
		
		return newMap;
	}
}
