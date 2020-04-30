package com.organizations.organization;

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
@Controller("/organizations")
public class OrganizationsController {
    private OrgService orgService;

    Logger logger = Logger.getLogger(String.valueOf(OrgDao.class));

    @Autowired()
    @Qualifier(value = "orgService")
    public void setOrgService(OrgService orgService) {
        this.orgService = orgService;
    }

    @RequestMapping(value ={"/organizations"}, method = RequestMethod.GET)
    public String listOrg(Model model) {
        try {
        model.addAttribute("organization", new Organizations());
        model.addAttribute("list", this.orgService.listOrg());
        } catch (Exception error){
            return "/error";
        }
        return "/organizations";
    }

   @RequestMapping(value ="/organizations", method = RequestMethod.POST)
    public String addOrg(@ModelAttribute("organization") Organizations s) {
        try {
            if (s.getOrgId() == null) {
                this.orgService.addOrg(s);
            } else {
                this.orgService.updateOrg(s);
            }
        } catch (Exception error){
            return "/error";
        }
        return "redirect:/organizations";
    }

    @RequestMapping("/deleteO/{id}")
    public String removeOrg(@PathVariable("id") int id) {
        try {
            this.orgService.removeOrg(id);
        } catch(Exception error) {
            return "/OrgError";
        }
        return "redirect:/organizations";
    }

    @RequestMapping("/editO/{id}")
    public String editOrg(Model model, @PathVariable("id") int id) {
        try {
        model.addAttribute("organization", this.orgService.getOrgById(id));
        model.addAttribute("list", this.orgService.listOrg());
        } catch (Exception error){
            return "/error";
        }
        return "/organizations";
    }
}
