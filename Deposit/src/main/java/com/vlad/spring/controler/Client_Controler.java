package com.vlad.spring.controler;

import com.vlad.spring.Entity.Client;
import com.vlad.spring.Service.Client_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/BankProject/client")
public class Client_Controler {
    private final Client_Service client_service;

    @Autowired
    public Client_Controler(Client_Service client_service) {
        this.client_service = client_service;
    }

    @GetMapping
    public List<Client> getClient(){
        return client_service.getClient();
    }

    @PostMapping
    public void addClient(@RequestBody Client client){
        client_service.addClient(client);
    }

    @DeleteMapping(path = "{clientID}")
    public void removeClient(@PathVariable("clientID")Long clientID){
        client_service.removeClient(clientID);
    }

}
