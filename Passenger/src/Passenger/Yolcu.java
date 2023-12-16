package Passenger;

import java.util.Random;

public abstract class Yolcu {

	private static int koltukNoCounter = 1;
	protected int id;
	protected String ad;
	protected String soyad;
	protected int koltukNo;
	protected boolean checkin;
	protected final double BASEFIYAT = 100;

	public Yolcu(String ad, String soyad) {
	        this.id = koltukNoCounter++;
	        this.ad = ad;
	        this.soyad = soyad;
	        this.koltukNo = generateRandomKoltukNo();
	        this.checkin = false;
	    }

	public abstract void yolcuBilgileriniGetir();

	public abstract void biletAl(FirmaAdi firmaAdi);

	public void checkInYap() {
		if (!checkin) {
			checkin = true;
			System.out.println(ad + " " + soyad + " check-in yapıldı.");
		} else {
			System.out.println(ad + " " + soyad + " zaten check-in yapılmış.");
		}
	}

	public void uçağaBin() {
		if (checkin) {
			System.out.println(ad + " " + soyad + " uçağa binmek için hazır. Koltuk No: " + koltukNo);
		} else {
			System.out.println(ad + " " + soyad + " check-in yapmadan uçağa binemez.");
		}
	}

	private int generateRandomKoltukNo() {
		Random random = new Random();
		return random.nextInt(200) + 1; // 1 ile 200 arasında rastgele koltuk numarası
	}

}
