package com.vlad.spring.controler;

import com.vlad.spring.Entity.Deposit;
import com.vlad.spring.Service.Deposit_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/BankProject/deposit")
public class Deposit_Controler {

    private final Deposit_Service deposit_service;

    @Autowired
    public Deposit_Controler(Deposit_Service deposit_service) {
        this.deposit_service = deposit_service;
    }

    @GetMapping
    public List<Deposit> getDeposit(){
        return deposit_service.getDeposit();
    }

    @PostMapping
    public void addDeposit(@RequestBody Deposit deposit){
        deposit_service.addDeposit(deposit);
    }

    @DeleteMapping(path = "{depositID}")
    public void removeDeposit(@PathVariable("depositID")Long depositID){
        deposit_service.removeDeposit(depositID);
    }

}
