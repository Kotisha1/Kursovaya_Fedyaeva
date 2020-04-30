package com.organizations.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import java.util.List;

public class OrgCRUD {
    @Test
    public void crud(){
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        read(session);
        session.close();
    }

    public void read(Session session){
        List<Organizations> orgList = session.createQuery("SELECT s FROM Organizations s").list();
        for (Organizations s : orgList) {
            System.out.println("List:" + s);
        }
    }
}
