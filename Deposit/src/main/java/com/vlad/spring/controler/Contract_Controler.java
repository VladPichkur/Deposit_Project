package com.vlad.spring.controler;

import com.vlad.spring.Entity.Contract;
import com.vlad.spring.Service.Contract_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/BankProject/contracts")
public class Contract_Controler {
    private final Contract_Service contract_service;


    @Autowired
    public Contract_Controler(Contract_Service contract_service) {
        this.contract_service = contract_service;
    }
    @GetMapping
    public List<Contract> getContract(){
        return contract_service.getContract();
    }
    @GetMapping(path ="Sum_more_than")
    public List<Contract> getContractBySum_more_than(@RequestParam() Double sum){
        return contract_service.getContractBySum_more_than(sum);
    }
    @GetMapping(path ="Sum_less_than")
    public List<Contract> getContractBySum_less_than(@RequestParam() Double sum){
        return contract_service.getContractBySum_less_than(sum);
    }
    @GetMapping(path ="poshyk")
    public List<Contract> getContractBySum_poshyk(@RequestParam() Double sum){
        return contract_service.getContractBySum_poshyk(sum);
    }

    @DeleteMapping(path = "{contractID}")
    public void removeContract(@PathVariable("contractID")Long contractID){
        contract_service.removeContract(contractID);
    }
    @PostMapping()
    public void addContract(
            @RequestParam() Long deposit,
            @RequestParam() Double sum_contarct,
            @RequestParam() Long client
    ){
        contract_service.addContract(deposit,sum_contarct,client);
    }
    @PostMapping(path = "previous")
    public void addPreviousContract(
            @RequestParam() Long deposit,
            @RequestParam() Double sum_contarct,
            @RequestParam() Long client

    ){
        contract_service.addContract1(deposit,sum_contarct,client, LocalDate.of(2022,03,02));
    }
    @PutMapping(path = "{contractID}")
    public void Znyatya(
            @PathVariable("contractID") Long contractID
    ){
        contract_service.Znatya(contractID);
    }
    @PutMapping(path = "/Dostrokove/{contractID}")
    public void DostrokoveZnyatya(
            @PathVariable("contractID") Long contractID
    ){
        contract_service.Znyatya_Dostrokove(contractID);
    }
    @PutMapping(path = "/Popovnutu/{contractID}")
    public void Popovnutu(
            @PathVariable("contractID") Long contractID,
            @RequestParam() Double sum
    ){
        contract_service.Popovnutu(contractID,sum);
    }
}
