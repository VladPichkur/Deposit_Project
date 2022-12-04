package com.vlad.spring.Service;
import com.vlad.spring.Dao.Bank_Repository;
import com.vlad.spring.Dao.Deposit_Repository;
import com.vlad.spring.Entity.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Deposit_Service {
    private final Deposit_Repository deposit_repository;
    private final Bank_Repository bank_repository;

    @Autowired
    public Deposit_Service(Deposit_Repository deposit_repository, Bank_Repository bank_repository) {
        this.deposit_repository = deposit_repository;
        this.bank_repository = bank_repository;
    }
    @Transactional
    public List<Deposit> getDeposit(){
        return deposit_repository.findAll();
    }

    @Transactional
    public void addDeposit(Deposit deposit){

        deposit_repository.save(deposit);
    }
    @Transactional
    public void removeDeposit(Long depositID){
        boolean exists= deposit_repository.existsById(depositID);
        if (!exists){
            throw new IllegalStateException("Депозит з ID "+depositID+" не існує");
        }

        if (deposit_repository.getReferenceById(depositID).getBank()!=null){
            throw new IllegalStateException("Депозит з ID "+depositID+" використується");
        }
        if (!deposit_repository.getReferenceById(depositID).getContractList().isEmpty()){
            throw new IllegalStateException("Депозит з ID "+depositID+" використується");
        }
        deposit_repository.deleteById(depositID);
    }
}
