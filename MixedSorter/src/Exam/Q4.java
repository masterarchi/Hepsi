package Exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Q4 {

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

		// Şanslı 10 sayıyı bir liste haline getirme
		List<Integer> luckyNumbersList = new ArrayList<>(luckyNumbers);

		
		// a) 42'den büyük sayıları getiren bir akış
		List<Integer> greaterThan42 = luckyNumbersList.stream()
		        .filter(number -> number > 42)
		        .collect(Collectors.toList());

		System.out.println("42'den Büyük Sayılar: " + greaterThan42);

		
		// b) Tüm sayıların toplamını getiren bir akış
		int total = luckyNumbersList.stream()
		        .mapToInt(Integer::intValue)
		        .sum();

		System.out.println("Tüm Sayıların Toplamı: " + total);

		// c) Tüm sayıların ortalamasını getiren bir akış
		double average = luckyNumbersList.stream()
		        .mapToInt(Integer::intValue)
		        .average()
		        .orElse(0.0);

		System.out.println("Tüm Sayıların Ortalaması: " + average);

		// d) 42'den büyük sayıların toplamını getiren bir akış
		int totalGreaterThan42 = luckyNumbersList.stream()
		        .filter(number -> number > 42)
		        .mapToInt(Integer::intValue)
		        .sum();

		System.out.println("42'den Büyük Sayıların Toplamı: " + totalGreaterThan42);

		// e) 42'den büyük sayıların ortalamasını getiren bir akış
		double averageGreaterThan42 = luckyNumbersList.stream()
		        .filter(number -> number > 42)
		        .mapToInt(Integer::intValue)
		        .average()
		        .orElse(0.0);

		System.out.println("42'den Büyük Sayıların Ortalaması: " + averageGreaterThan42);

		// f) En büyük değeri getiren bir akış
		int max = luckyNumbersList.stream()
		        .mapToInt(Integer::intValue)
		        .max()
		        .orElse(0);

		System.out.println("En Büyük Değer: " + max);

		// g) En küçük değeri getiren bir akış
		int min = luckyNumbersList.stream()
		        .mapToInt(Integer::intValue)
		        .min()
		        .orElse(0);

		System.out.println("En Küçük Değer: " + min);

		// h) 50'den büyük değerlerin sayısını getiren bir akış
		long countGreaterThan50 = luckyNumbersList.stream()
		        .filter(number -> number > 50)
		        .count();

		System.out.println("50'den Büyük Değerlerin Sayısı: " + countGreaterThan50);

		// i) Bu 10 sayıyı bir string listesine çevirme
		List<String> luckyNumbersAsString = luckyNumbersList.stream()
		        .map(String::valueOf)
		        .collect(Collectors.toList());

		System.out.println("Şanslı 10 Sayı (String Listesi): " + luckyNumbersAsString);

		// j) Daha sonra bu string listesini tek bir stringde aralarına virgül kullanarak yazdırma
		String joinedNumbers = String.join(", ", luckyNumbersAsString);
		System.out.println("Şanslı 10 Sayılar (Virgül ile Birleştirilmiş): " + joinedNumbers);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
