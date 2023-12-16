package product;


import product.app.Menu;
import product.util.HibernateUtility;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.menu();

       // HibernateUtility.getSessionFactory().openSession();








    }
}