package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	/**
	 * Fonction principal qui utilise les fonction ReadSymptomDataFromFile() et getSymptoms().
	 * Crer un fichier text result.out qui liste les symptomes et leurs occurences.
	 */
	
	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt"); 
		List<String> lSymptoms = reader.getSymptoms(); 
		Map<String, Integer> mapSymptoms = countSymptoms(lSymptoms);
		
		
		
		FileWriter writer = new FileWriter ("result.out");
		for (String key : mapSymptoms.keySet()) {
			writer.write(key + ":" + mapSymptoms.get(key) + "\n"); 
			}
		writer.close();
	
	}
	
	/**
	 * @return une liste (TreeMap) des symptoms triée par ordre alphabétique avec leur nombres d'occurences
	 */
	
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
