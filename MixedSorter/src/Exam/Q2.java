package Exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Q2 {

	public static void main(String[] args) {
		Map<Integer, Integer> numberCountMap = rasgeleSayilar(1, 100, 10000);
		System.out.println("Rastgele Sayılar ve Üretim Sayıları: " + numberCountMap);
		
		List<Integer> randomNumberList = new ArrayList<>();
		numberCountMap.forEach((number, count) -> {
		    for (int i = 0; i < count; i++) {
		        randomNumberList.add(number);
		    }
		});

		Collections.shuffle(randomNumberList);
		System.out.println("Karıştırılmış Rastgele Sayı Listesi: " + randomNumberList);
		
		
		
		
		
		
		
		
		
	}
	
	 public static Map<Integer, Integer> rasgeleSayilar(int min, int max, int count) {
	        Random random = new Random();
	        Map<Integer, Integer> numberCountMap = new HashMap<>();

	        for (int i = 0; i < count; i++) {
	            int randomNumber = random.nextInt(max - min + 1) + min;
	            numberCountMap.put(randomNumber, numberCountMap.getOrDefault(randomNumber, 0) + 1);
	        }

	        return numberCountMap;
	    }
	
	
	
	
	
	
	
	
	
	
}
