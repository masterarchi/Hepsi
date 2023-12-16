package Urun;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Urun> urunler = new ArrayList<>();
		urunler.add(new Urun("Ürün1", 25.0));
		urunler.add(new Urun("Ürün2", 35.0));
		urunler.add(new Urun("Ürün3", 45.0));
		urunler.add(new Urun("Ürün4", 55.0));
		urunler.add(new Urun("Ürün5", 15.0));
		urunler.add(new Urun("Ürün6", 56.0));
		urunler.add(new Urun("Ürün7", 57.0));
		urunler.add(new Urun("Ürün8", 18.0));
		urunler.add(new Urun("Ürün9", 88.0));
		urunler.add(new Urun("Ürün10", 42.0));
		

		// Belirli bir fiyat aralığına göre filtreleme yapın (örneğin, 40 ile 60 arası)
		double minFiyat = 40.0;
		double maxFiyat = 60.0;

		List<Urun> filtrelenmisUrunler = urunler.stream()
				.filter(urun -> urun.getFiyat() >= minFiyat && urun.getFiyat() <= maxFiyat)
				.collect(Collectors.toList());

		// Filtrelenmiş ürünleri HashMap'e ekleyin (ürün adı -> ürün fiyatı)
		Map<String, Double> urunMap = filtrelenmisUrunler.stream()
				.collect(Collectors.toMap(Urun::getAd, Urun::getFiyat));

		// HashMap key ve value'ları ekrana yazdırın
		for (Map.Entry<String, Double> entry : urunMap.entrySet()) {
			System.out.println("Ürün Adı: " + entry.getKey() + ", Ürün Fiyatı: " + entry.getValue());
		}
		
		System.out.println();
		System.out.println("*-Ürünlerin Tamamı-*");
		
		
		for (Urun urun : urunler) {
            System.out.println("Ürün Adı: " + urun.getAd() + ", Ürün Fiyatı: " + urun.getFiyat());
        }
		
		
		
		
		
		
		
		
		
		
		

	}

}
