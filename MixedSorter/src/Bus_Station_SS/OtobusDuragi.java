package Bus_Station_SS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class OtobusDuragi {

	private Queue<Yolcu> otobusKuyrugu;
	private ArrayList<Yolcu> otobusIci;
	private final int OTOBUS_KAPASITE = 10;

	public OtobusDuragi(Queue<Yolcu> otobusKuyrugu, ArrayList<Yolcu> otobusIci) {

		this.otobusKuyrugu = otobusKuyrugu;
		this.otobusIci = otobusIci;
	}

	public OtobusDuragi() {
		otobusKuyrugu = new LinkedList<>(); // LinkedList kullanıldı çünkü ilk giren ilk çıkar mantığı uygundur.
		otobusIci = new ArrayList<>(); // ArrayList kullanıldı çünkü içindeki verileri kolayca erişmek için uygundur.
	}

	// Otobüs kuyruğuna yolcu ekleme
	public void otobusKuyrugunaGir(Yolcu yolcu) {
		if (otobusKuyrugu.size() < OTOBUS_KAPASITE) {
			otobusKuyrugu.offer(yolcu); // Yolcu eklemek için offer() kullanılır.
			System.out.println(yolcu.getAd() + " otobüs kuyruğuna girdi.");
		} else {
			System.out.println("Otobüs dolu, " + yolcu.getAd() + " otobüse binemedi.");
		}
	}

	// Otobüse yolcu alma
	public void otobuseBin() {
		if (!otobusKuyrugu.isEmpty()) {
			Yolcu yolcu = otobusKuyrugu.poll(); // İlk gelen yolcu alınır.
			otobusIci.add(yolcu);
			System.out.println(yolcu.getAd() + " otobüse bindi.");
		} else {
			System.out.println("Otobüs kuyruğu boş, yolcu yok.");
		}
	}

	// Otobüsten yolcu indirme
	public void otobustenIn(Yolcu yolcu) {
		if (otobusIci.contains(yolcu)) {
			otobusIci.remove(yolcu);
			System.out.println(yolcu.getAd() + " otobüsten indi.");
		} else {
			System.out.println(yolcu.getAd() + " otobüste değil, indirme işlemi yapılamadı.");
		}
	}

	// Otobüs içindeki yolcuları listeleme
	public void otobusIciYolculariListele() {
		System.out.println("Otobüs İçindeki Yolcular:");
		for (Yolcu yolcu : otobusIci) {
			System.out.println(yolcu.getAd());
		}
	}

}
