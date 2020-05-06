package com.contracts.contract;

import com.contracts.model.Contract;
import com.contracts.dao.ContractDao;
import com.contracts.service.ContractService;
import com.clients.model.Client;
import com.clients.dao.ClientDao;
import com.clients.service.ClientService;
import com.posts.model.Post;
import com.posts.dao.PostDao;
import com.posts.service.PostService;
import com.organizations.model.Organizations;
import com.organizations.dao.OrgDao;
import com.organizations.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.logging.Logger;

@ImportResource("/WEB-INF/dispatcher-servlet.xml")
@Controller("/contracts")
public class ContractController {
    private ContractService contractService;
    private ClientService clientService;
    private PostService postService;
    private OrgService orgService;

    Logger logger = Logger.getLogger(String.valueOf(ContractDao.class));

    @Autowired()
    @Qualifier(value = "contractService")
    public void setContractService(ContractService ps) {
        this.contractService = ps;
    }

    @Autowired()
    @Qualifier(value = "orgService")
    public void setOrgService(OrgService orgService) {
        this.orgService = orgService;
    }

    @Autowired()
    @Qualifier(value = "postService")
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @Autowired()
    @Qualifier(value = "clientService")
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value ={"/contracts"}, method = RequestMethod.GET)
    public String listContracts(Model model) {
        try {
        model.addAttribute("contract", new Contract());
        model.addAttribute("list", this.contractService.listContract());
        model.addAttribute("client", new Client());
        model.addAttribute("listClient", this.clientService.listClient());
        model.addAttribute("post", new Post());
        model.addAttribute("listPost", this.postService.listPost());
        model.addAttribute("org", new Organizations());
        model.addAttribute("listOrg", this.orgService.listOrg());
        } catch (Exception error){
            return "/error";
        }
        return "/contracts";
    }

    @RequestMapping(value ="/contracts", method = RequestMethod.POST)
    public String addContract(@ModelAttribute("contract") Contract s) {
        try {
            if (s.getIdOfCont() == null) {
                this.contractService.addContract(s);
            } else {
                this.contractService.updateContract(s);
            }
        } catch (Exception error){
            return "/error";
        }
        return "redirect:/contracts";
    }

    @RequestMapping("/deleteC/{id}")
    public String removeContract(@PathVariable("id") int id) {
        try {
        this.contractService.removeContract(id);
        } catch (Exception error){
            return "/error";
        }
        return "redirect:/contracts";
    }

    @RequestMapping("/editC/{id}")
    public String editContract(Model model, @PathVariable("id") int id) {
        try {
        model.addAttribute("contract", this.contractService.getContractById(id));
        model.addAttribute("list", this.contractService.listContract());
        } catch (Exception error){
            return "/error";
        }
        return "/contracts";
    }
}
