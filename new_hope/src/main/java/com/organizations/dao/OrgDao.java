package com.organizations.dao;

import com.organizations.model.Organizations;
import com.posts.model.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class OrgDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(String.valueOf(OrgDao.class));

    @SuppressWarnings("unchecked")
    public List<Organizations> listOrg () {
        Session session = this.sessionFactory.getCurrentSession();
        List<Organizations> orgList = session.createQuery("SELECT p FROM Organizations p").list();
        for(Organizations p: orgList) {
            logger.info(p.toString());
        }
        return orgList;
    }

   public void addOrg(Organizations org) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(org);
        logger.info("Org successfully added." +
                "Organization: " + org);
    }

    public void updateOrg(Organizations org){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(org);
        logger.info("Org INFO successfully changed." +
                "Organization: " + org);
    }

    public void removeOrg(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Organizations org = (Organizations) session.load(Organizations.class, new Integer(id));
        if(org != null) {
            session.delete(org);
        }
        logger.info("Org INFO successfully deleted." +
                "Organization: " + org);
    }

    public Organizations getOrgById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Organizations org = (Organizations) session.load(Organizations.class, new Integer(id));
        logger.info("Organization: " + org);
        return org;
    }
}
