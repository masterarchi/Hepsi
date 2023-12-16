package Exam;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q1 {

	public static void main(String[] args) {

		Map<Integer, Integer> numberCountMap = rasgeleSayilar(1, 100, 10000);
		System.out.println("Rastgele Sayılar ve Üretim Sayıları: " + numberCountMap);

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
