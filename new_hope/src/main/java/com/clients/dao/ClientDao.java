package com.clients.dao;

import com.clients.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class ClientDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(String.valueOf(ClientDao.class));

    @SuppressWarnings("unchecked")
    public List<Client> listClient() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Client> clientList = session.createQuery("SELECT p FROM Client p").list();
        for(Client p: clientList){
            logger.info(p.toString());
        }
        return clientList;
    }

     public void addClient(Client client) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(client);
        logger.info("Client successfully added." +
                "Client: " + client);
    }

    public void updateClient(Client client){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(client);
        logger.info("Client INFO successfully changed." +
                "Client: " + client);
    }

    public void removeClient(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Client client = (Client) session.load(Client.class, new Integer(id));
        if(client != null) {
            session.delete(client);
        }
        logger.info("Client INFO successfully deleted." +
                "Client: " + client);
    }

    public Client getClientById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Client client = (Client) session.load(Client.class, new Integer(id));
        logger.info("Client: " + client);
        return client;
    }
}