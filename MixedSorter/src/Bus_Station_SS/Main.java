package Bus_Station_SS;

public class Main {

	public static void main(String[] args) {

		OtobusDuragi otobusDuragi = new OtobusDuragi();

		// Yolcular otobüs kuyruğuna giriyor
		otobusDuragi.otobusKuyrugunaGir(new Yolcu("Yolcu1"));
		otobusDuragi.otobusKuyrugunaGir(new Yolcu("Yolcu2"));
		otobusDuragi.otobusKuyrugunaGir(new Yolcu("Yolcu3"));
		otobusDuragi.otobusKuyrugunaGir(new Yolcu("Yolcu4"));
		otobusDuragi.otobusKuyrugunaGir(new Yolcu("Yolcu5"));
		otobusDuragi.otobusKuyrugunaGir(new Yolcu("Yolcu6"));
		otobusDuragi.otobusKuyrugunaGir(new Yolcu("Yolcu7"));
		otobusDuragi.otobusKuyrugunaGir(new Yolcu("Yolcu8"));
		otobusDuragi.otobusKuyrugunaGir(new Yolcu("Yolcu9"));
		otobusDuragi.otobusKuyrugunaGir(new Yolcu("Yolcu10"));
		otobusDuragi.otobusKuyrugunaGir(new Yolcu("Yolcu11"));

		System.out.println();
		
		// Otobüse yolcular biniyor
		otobusDuragi.otobuseBin();
		otobusDuragi.otobuseBin();
		otobusDuragi.otobuseBin();
		System.out.println();
		
		// Otobüs içindeki yolcuları listeleme
		otobusDuragi.otobusIciYolculariListele();
		System.out.println();
		
		// Yolcu otobüsten iniyor
		otobusDuragi.otobustenIn(new Yolcu("Yolcu2"));
		System.out.println();
		
		// Otobüs içindeki yolcuları tekrar listeleme
		otobusDuragi.otobusIciYolculariListele();

	}

}
