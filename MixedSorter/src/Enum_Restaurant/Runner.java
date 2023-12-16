package Enum_Restaurant;

public class Runner {

	public static void main(String[] args) {
		Manager manager = new Manager();
		EGunler[] gunler = EGunler.values();

		for (int i = 0; i < gunler.length; i++) {
			EGunler gun = gunler[i];
			Menu menu = manager.createMenu(gun);
			System.out.println(gun + " Menü: " + menu);
		}
	}
}
