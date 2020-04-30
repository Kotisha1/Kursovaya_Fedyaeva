package com.contracts.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import java.util.List;

public class ContractCRUD {
    @Test
    public void crud(){
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        read(session);
        session.close();
    }

    public void read(Session session){
        List<Contract> contractList = session.createQuery("SELECT s FROM Contract s").list();
        for (Contract s : contractList) {
            System.out.println("List:" + s);
        }
    }
}
