package Exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Q4_AB {

	public static void main(String[] args) {
		 List<Integer> numberList = createNumberList(10000);

	        // a) Listeyi karıştır, sonra 250 değer atlayarak 20 eleman seç
	        Collections.shuffle(numberList);
	        List<Integer> selectedNumbers = new ArrayList<>();
	        for (int i = 0; i < 20; i++) {
	            selectedNumbers.add(numberList.get(i * 250));
	        }

	        // b) 20 eleman içinde 50 sayısını kontrol et
	        boolean contains50 = selectedNumbers.contains(50);
	        System.out.println("20 eleman içinde 50 sayısı bulunuyor mu? " + contains50);
	    

	}

	public static List<Integer> createNumberList(int count) {
        List<Integer> numberList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            numberList.add(random.nextInt(100) + 1);
        }
        return numberList;
    }
	
	
	
	
	
	
	
	
}
