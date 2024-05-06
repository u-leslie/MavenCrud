package com.hibernate.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
        private static SessionFactory sessionFactory;
        public static SessionFactory getSessionFactory(){
            if (sessionFactory==null){
                try {
                    Configuration con = new Configuration().configure();
                    sessionFactory = con.buildSessionFactory();
                }catch (Exception e){
                    e.getMessage();
                }

            }
            return sessionFactory;
        }
    }
