package com.product;

import com.product.app.Menu;
import com.product.util.HibernateUtility;

public class Main {
    public static void main(String[] args) {

        //HibernateUtility.getSessionFactory().openSession();

        Menu menu = new Menu();
        while (true){
            menu.menu();
        }

    }
}