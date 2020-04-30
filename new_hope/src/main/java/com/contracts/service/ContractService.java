package com.contracts.service;

import com.contracts.dao.ContractDao;
import com.contracts.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    private ContractDao contractDAO;

    public void setContractDAO(ContractDao contractDAO) {
        this.contractDAO = contractDAO;
    }

    @Transactional
    public List<Contract> listContract() {
        return this.contractDAO.listContract();
    }

    @Transactional
    public void addContract(Contract contract) { this.contractDAO.addContract(contract);}

    @Transactional
    public void updateContract(Contract contract) { this.contractDAO.updateContract(contract);}

    @Transactional
    public void removeContract(int id) { this.contractDAO.removeContract(id);}

    @Transactional
    public Contract getContractById(int id) { return this.contractDAO.getContractById(id);}
}
