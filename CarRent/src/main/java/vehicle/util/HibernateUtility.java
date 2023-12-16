package product.util;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import product.entity.*;


public class HibernateUtility {
        private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

        private static SessionFactory sessionFactoryHibernate() {
            try{
                Configuration configuration = new Configuration();

                configuration.addAnnotatedClass(Admin.class);
                configuration.addAnnotatedClass(Category.class);
                configuration.addAnnotatedClass(Customer.class);
                configuration.addAnnotatedClass(Vehicle.class);
                configuration.addAnnotatedClass(VehicleDetail.class);
                configuration.addAnnotatedClass(Information.class);


                SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
                return sessionFactory;
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
            return null;
        }
        public static SessionFactory getSessionFactory(){
            return SESSION_FACTORY;
        }
















}
