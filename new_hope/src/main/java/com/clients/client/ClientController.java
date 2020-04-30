package com.clients.client;

import com.clients.model.Client;
import com.clients.dao.ClientDao;
import com.clients.service.ClientService;
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
@Controller("/clients")
public class ClientController {
    private ClientService clientService;

    Logger logger = Logger.getLogger(String.valueOf(ClientDao.class));

    @Autowired()
    @Qualifier(value = "clientService")
    public void setClientService(ClientService ps) {
        this.clientService = ps;
    }

    @RequestMapping(value ={"/clients"}, method = RequestMethod.GET)
    public String listClients(Model model) {
        try {
        model.addAttribute("client", new Client());
        model.addAttribute("list", this.clientService.listClient());
        } catch (Exception error){
            return "/error";
        }
        return "/clients";
    }

    @RequestMapping(value ="/clients", method = RequestMethod.POST)
    public String addClient(@ModelAttribute("clients") Client s) {
        try {
            if (s.getClientId() == null) {
                this.clientService.addClient(s);
            } else {
                this.clientService.updateClient(s);
            }
        } catch (Exception error){
            return "/error";
        }
        return "redirect:/clients";
    }

    @RequestMapping("/delete/{id}")
    public String removeClient(@PathVariable("id") int id) {
        try {
            this.clientService.removeClient(id);
        }catch(Exception error) {
            return "/ClientError";
        }
        return "redirect:/clients";
    }

    @RequestMapping("/edit/{id}")
    public String editClient(Model model, @PathVariable("id") int id) {
        try {
        model.addAttribute("client", this.clientService.getClientById(id));
        model.addAttribute("list", this.clientService.listClient());
        }catch(Exception error) {
            return "/error";
        }
        return "/clients";
    }
}
