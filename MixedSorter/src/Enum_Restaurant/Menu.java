package Enum_Restaurant;

public class Menu {

	private ECorbalar corba;
	private EIcecekler icecek;
	private EYemekler yemek;
	private ETatlilar tatli;
	
	public Menu(ECorbalar corba, EIcecekler icecek, EYemekler yemek, ETatlilar tatli) {
		this.corba = corba;
		this.icecek = icecek;
		this.yemek = yemek;
		this.tatli = tatli;
	}

	
	@Override
    public String toString() {
        return "Çorba: " + corba + ", İçecek: " + icecek + ", Yemek: " + yemek + ", Tatlı: " + tatli;
    }
	
	
	
	
	
	
	
	
	
}
