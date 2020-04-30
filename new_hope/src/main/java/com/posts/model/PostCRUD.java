package com.posts.model;

import com.clients.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import java.util.List;

public class PostCRUD {
    public Integer id = 1410;
    public String name = "Муругин Иван Николвевич";
    public String dateofbirth = "25.10.1975";
    public String education = "Высшее техническое";
    public String experience = "15 лет";
    public String areaofwork = "Инженерия";
    public String skill = "Стрессоустойчивость";
    public String phone = "89081633729";
    @Test
    public void crud(){
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        read(session);
        session.close();
    }

    public void read(Session session){
        List<Post> postList = session.createQuery("SELECT s FROM Post s").list();
        for (Post s : postList) {
            System.out.println("List:" + s);
        }
    }
}
