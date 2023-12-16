package product.app;

import product.controller.CustomerController;
import product.entity.Customer;
import product.service.CustomerService;
import product.util.BAUtils;

import java.util.HashMap;
import java.util.Optional;

public class Menu {

    private  final CustomerController customerController;
    public Menu(){
        this.customerController=new CustomerController();
    }

    public void menu(){
        HashMap<Integer,String> menuItems = new HashMap<>();
        //menuItems.put(1,"admin");
        menuItems.put(2,"Müşteri Menüsü");

        int key = BAUtils.menu(menuItems);

        switch(key){
            case 1:
                //adminMenu();
                break;
            case 2:
                customerMenu();
                break;


        }










    }



    private void customerMenu() {
        HashMap<Integer,String> menuItems = new HashMap<>();
        menuItems.put(1,"Araç Ekle");
        menuItems.put(2,"Araç Arama");
        menuItems.put(3,"Kişi Ekleme");
        menuItems.put(4,"Araç Kiralama");
        menuItems.put(5,"Rapor");
        menuItems.put(0,"Çıkış");

        int key = BAUtils.menu(menuItems);

        switch(key){
            case 1:
                customerController.aracEkle();
                System.out.println("ARAÇ SİSTEME EKLENMİŞTİR");
                break;
            case 2:
                //customerController.findCustomerByIdentity();
                break;
            case 3:
                //personController.register();
                customerController.register();
                System.out.println("KİŞİ SİSTEME EKLENMİŞTİR");
                break;
            case 4:

                break;
            case 5:

                break;
            case 0:
                System.exit(0);
                break;
        }
    }


    private void customerManagerMenu(Customer customer){
        HashMap<Integer,String> menuItems = new HashMap<>();
        menuItems.put(1,"Satın al");

        int key = BAUtils.menu(menuItems);

        switch(key){
            case 1:
                //customerController.register();

                break;
            case 2:
                //System.out.println("Giriş Yap");
                break;
    }}

        private void adminMenu(){
            HashMap<Integer,String> menuItems = new HashMap<>();
            menuItems.put(1,"Product Ekle");
            menuItems.put(2,"Category Ekle");
            int key = BAUtils.menu(menuItems);

            switch(key){
                case 1:

                    break;
                case 2:
                    //categoryController.save();
                    break;
            }
        }







}

