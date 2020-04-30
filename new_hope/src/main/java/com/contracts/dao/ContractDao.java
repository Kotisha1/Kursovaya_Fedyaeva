package com.contracts.dao;

import com.contracts.model.Contract;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class ContractDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(String.valueOf(ContractDao.class));

    @SuppressWarnings("unchecked")
    public List<Contract> listContract() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Contract> contractList = session.createQuery("SELECT p FROM Contract p").list();
        for(Contract p: contractList){
            logger.info(p.toString());
        }
        return contractList;
    }

    public void addContract(Contract contract) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(contract);
        logger.info("Contract successfully added." +
                "Contract: " + contract);
    }

    public void updateContract(Contract contract){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(contract);
        logger.info("Contract INFO successfully changed." +
                "Contract: " + contract);
    }

    public void removeContract(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Contract contract = (Contract) session.load(Contract.class, new Integer(id));
        if(contract != null) {
            session.delete(contract);
        }
        logger.info("Contract INFO successfully deleted." +
                "Contract: " + contract);
    }

    public Contract getContractById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Contract contract = (Contract) session.load(Contract.class, new Integer(id));
        logger.info("Contract: " + contract);
        return contract;
    }
}
