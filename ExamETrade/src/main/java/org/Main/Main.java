package org.Main;

import org.entity.Urun;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.utility.HibernateUtility;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction =session.beginTransaction();
        session.save(new Urun("Seker",50));
        transaction.commit();
        session.close();

        }
    }
