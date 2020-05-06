package com.organizations.service;

import com.organizations.dao.OrgDao;
import com.organizations.model.Organizations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrgService {
    @Autowired
    private OrgDao orgDAO;

    public void setOrgDAO(OrgDao orgDAO) {
        this.orgDAO = orgDAO;
    }

    @Transactional
    public List<Organizations> listOrg() {
        return this.orgDAO.listOrg();
    }

    @Transactional
    public void addOrg(Organizations org) { this.orgDAO.addOrg(org);}

    @Transactional
    public void updateOrg(Organizations org) { this.orgDAO.updateOrg(org);}

    @Transactional
    public void removeOrg(int id) { this.orgDAO.removeOrg(id);}

    @Transactional
    public Organizations getOrgById(int id) { return this.orgDAO.getOrgById(id);}
}
