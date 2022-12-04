package com.vlad.spring.controler;

import com.vlad.spring.Entity.Bank;
import com.vlad.spring.Service.Bank_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/BankProject/bank")
public class Bank_Controler {
    private final Bank_Service bank_service;

    @Autowired
    public Bank_Controler(Bank_Service bank_service) {
        this.bank_service = bank_service;
    }

    @GetMapping
    public List<Bank> getBank(){
        return bank_service.getBank();
    }

    @PostMapping
    public void addBank(@RequestBody Bank bank){
        bank_service.addBank(bank);
    }

    @DeleteMapping(path = "{bankID}")
    public void removeBank(@PathVariable("bankID")Long bankID){
        bank_service.removeBank(bankID);
    }
}
