# Hibernate ile Adım Adım Proje Oluşturma

1. Veritabanı sunucusunda bir vt oluştur. (Java12OrnekETicaret)
2. Packageları oluşturalım
3. Resources package içine config dosyasını at
4. hibernate.cfg.xml gerekli değişiklikleri yap
5. build. gradle dosyasına dependencies ekle
6. gerekli entity'leri yaz (Sepet, urun)
7. Entityler için 
    1. (boş const)
   2. id siz dolu cons
   3. dolu const
   4. getter & setter
   5. toString
8. config dosyasında (hibernate.cfg.xml) gerekli mapping.class işlemlerini yaz.
9. utility package içine HibernateUtility.java dosyasını ekle

# Kullanma Adımları
1. Session oluştur
   1.  Session session = HibernateUtility.getSessionFactory().openSession();
   2. session.close();
2. Transaction oluştur ve başlat 
   1. Transaction transaction =session.beginTransaction();
   2. transaction.commit();
3. CRUD işlemlerini yap

# Türkçe karakter sorunu için ekle
1. build.gradle içine:

# Lombok kullanılan anotasyonlar
1. @NoArgsConstructor //boş cons
2. @AllArgsConstructor //dolu cons
3. @Data

