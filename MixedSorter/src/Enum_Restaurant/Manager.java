package Enum_Restaurant;

import java.util.Random;

public class Manager {

	private Random random = new Random();
    private EIcecekler[] icecekler = EIcecekler.values();
    private int icecekIndex = 0;

    public Menu createMenu(EGunler gun) {
        ECorbalar corba = ECorbalar.values()[random.nextInt(ECorbalar.values().length)];
        EIcecekler icecek = getNextIcecek();
        EYemekler yemek = EYemekler.values()[random.nextInt(EYemekler.values().length)];
        ETatlilar tatli = ETatlilar.values()[random.nextInt(ETatlilar.values().length)];
        return new Menu(corba, icecek, yemek, tatli);
    }

    private EIcecekler getNextIcecek() {
        EIcecekler icecek = icecekler[icecekIndex];
        icecekIndex = (icecekIndex + 1) % icecekler.length;
        return icecek;
    }
	
	
	
	
	
	
	
	
	
	
	
}
