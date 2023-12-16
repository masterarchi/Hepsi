package Exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Q3 {

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
		
		Set<Integer> luckyNumbers = new HashSet<>();
		for (int i = 0; i < 10; i++) {
		    luckyNumbers.add(randomNumberList.get(i));
		}

		System.out.println("Şanslı 10 Sayı: " + luckyNumbers);
		
		
		
		
		
		
		
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
