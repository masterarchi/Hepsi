package Passenger;

public class Main {

	public static void main(String[] args) {

		BusinessYolcu businessYolcu1 = new BusinessYolcu("Taha", "Cinli", true);
        BusinessYolcu businessYolcu2 = new BusinessYolcu("Gürcan", "Oruç", false);

        EkonomiYolcu ekonomiYolcu1 = new EkonomiYolcu("Büyük", "İskender");
        EkonomiYolcu ekonomiYolcu2 = new EkonomiYolcu("Kanuni Sultan", "Süleyman");

        businessYolcu1.biletAl(FirmaAdi.THY);
        businessYolcu2.biletAl(FirmaAdi.ADJ);

        ekonomiYolcu1.biletAl(FirmaAdi.THY);
        ekonomiYolcu2.biletAl(FirmaAdi.THY);
        ekonomiYolcu2.biletAl(FirmaAdi.DIGER);

        businessYolcu1.checkInYap();
        ekonomiYolcu1.checkInYap();

        businessYolcu1.uçağaBin();
        ekonomiYolcu1.uçağaBin();
        ekonomiYolcu2.uçağaBin();

        businessYolcu1.yolcuBilgileriniGetir();
        ekonomiYolcu2.yolcuBilgileriniGetir();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
