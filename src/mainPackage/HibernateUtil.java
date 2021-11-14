package mainPackage;


import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

// Class to provide simple access for Hibernate sessions

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from config file
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    // Method to get access to sessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}