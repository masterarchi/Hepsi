package Passenger;

import java.util.ArrayList;
import java.util.Random;

public class BusinessYolcu extends Yolcu {

	private final double BUSINESSFIYAT = 200;
    private final double BUSINESSVIPFIYAT = 150;
    private boolean isVip;
    private ArrayList<Bilet> biletler; // Biletleri tutmak için ArrayList kullanılıyor

    public BusinessYolcu(String ad, String soyad, boolean isVip) {
        super(ad, soyad);
        this.isVip = isVip;
        this.biletler = new ArrayList<>(); // Biletler için ArrayList oluşturuluyor
    }

    @Override
    public void yolcuBilgileriniGetir() {
        System.out.println("Yolcu Bilgileri: " + ad + " " + soyad);
        for (Bilet bilet : biletler) {
            System.out.println(bilet.getFirmaAdi() + " - " + bilet.getBiletFiyati());
        }
    }

    @Override
    public void biletAl(FirmaAdi firmaAdi) {
        double biletFiyati;
        if (isVip) {
            biletFiyati = BASEFIYAT + BUSINESSFIYAT + BUSINESSVIPFIYAT;
        } else {
            biletFiyati = BASEFIYAT + BUSINESSFIYAT;
        }

        Bilet yeniBilet = new Bilet(firmaAdi, biletFiyati);
        biletler.add(yeniBilet); // Yeni bilet ArrayList'e ekleniyor
        System.out.println("Bilet alındı: " + firmaAdi + " - " + biletFiyati);
    }

}
