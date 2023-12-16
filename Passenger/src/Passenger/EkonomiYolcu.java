package Passenger;

import java.util.ArrayList;
import java.util.Random;

public class EkonomiYolcu extends Yolcu {

	private final double EKONOMIFIYAT = 100;
	private ArrayList<String> biletler;

	public EkonomiYolcu(String ad, String soyad) {
		super(ad, soyad);
		this.biletler = new ArrayList<>();
	}

	@Override
	public void yolcuBilgileriniGetir() {
		System.out.println("Yolcu Bilgileri: " + ad + " " + soyad);
		for (String bilet : biletler) {
			System.out.println(bilet);
		}
	}

	@Override
	public void biletAl(FirmaAdi firmaAdi) {
		double biletFiyati = BASEFIYAT + EKONOMIFIYAT;

		// Aynı firmadan daha önce bilet alındı mı? kontrolü
		for (String bilet : biletler) {
			if (bilet.contains(firmaAdi.toString())) {
				String[] biletBilgileri = bilet.split(" - ");
				double eskiFiyat = Double.parseDouble(biletBilgileri[1]);
				biletFiyati = eskiFiyat + EKONOMIFIYAT;
				break;
			}
		}

		String biletBilgisi = firmaAdi + " - " + biletFiyati;
		biletler.add(biletBilgisi);
		System.out.println("Bilet alındı: " + biletBilgisi);
	}

}
