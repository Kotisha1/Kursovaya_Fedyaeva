package com.clients.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import java.util.List;

public class ClientsCRUD {
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
        //create(session);
        //update(session, id, name, dateofbirth, education, experience, areaofwork, skill, phone);
        //foundId(session, id);
        //delete(session, id);
        session.close();
    }

    public void read(Session session){
        List<Client> clientList = session.createQuery("SELECT s FROM Client s").list();
        for (Client s : clientList) {
            System.out.println("List:" + s);
        }
    }

    private void create(Session session){
        Client client = new Client();
        client.setClientName("Тимофеева Екатерина Викторовна");
        client.setDateOfBirth("02.03.1986");
        client.setEducation("Высшее педагогическое");
        client.setExperience("10 лет");
        client.setAreaOfWork("Образование");
        client.setSkills("Стрессоустойчивость");
        client.setPhone("89530981262");
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
    }

    private void update(Session session, Integer id, String clientname, String dateofbirth, String education,
                        String experience, String areaofwork, String skill, String phone){
        Client client = (Client) session.load(Client.class, id);
        System.out.println("Update of data:" + client);
        System.out.println(" ");
        client.setClientName(clientname);
        client.setDateOfBirth(dateofbirth);
        client.setEducation(education);
        client.setExperience(experience);
        client.setAreaOfWork(areaofwork);
        client.setSkills(skill);
        client.setPhone(phone);
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
    }

    private void delete(Session session, Integer id){
        Client client = (Client) session.load(Client.class, id);
        System.out.println("Delete:" + client);
        System.out.println(" ");
        session.beginTransaction();
        session.delete(client);
        session.getTransaction().commit();
    }

    private void foundId(Session session, Integer id){
        Client client = (Client) session.load(Client.class, id);
        System.out.println("Data:" + client);
    }
}