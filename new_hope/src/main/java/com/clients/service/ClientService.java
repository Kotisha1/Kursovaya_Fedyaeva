package com.clients.service;

import com.clients.dao.ClientDao;
import com.clients.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientDao clientDAO;

    public void setClientDAO(ClientDao clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Transactional
    public List<Client> listClient() {
        return this.clientDAO.listClient();
    }

    @Transactional
    public void addClient(Client client) { this.clientDAO.addClient(client);}

    @Transactional
    public void updateClient(Client client) { this.clientDAO.updateClient(client);}

    @Transactional
    public void removeClient(int id) { this.clientDAO.removeClient(id);}

    @Transactional
    public Client getClientById(int id) { return this.clientDAO.getClientById(id);}
}
