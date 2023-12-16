package example;


import example.entity.Kiralama;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        Kiralama kiralama = Kiralama.builder()
                .kiralamaTarihi(LocalDate.now())
                .arac(arac)
                .kisi(customer)
                .build();
        arac.setisActive(false);
        musteri.getKiralamaList.add(kiralama);
        kiralamacontroller.save(kiralama);
        arac.update;
        kisi.getKiraladıgıAraclar.foreach(x-> System.out.println());












    }
}