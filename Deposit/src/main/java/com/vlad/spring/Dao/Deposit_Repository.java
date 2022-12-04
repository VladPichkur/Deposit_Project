package com.vlad.spring.Dao;

import com.vlad.spring.Entity.Bank;
import com.vlad.spring.Entity.Contract;
import com.vlad.spring.Entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface Deposit_Repository
        extends JpaRepository<Deposit,Long> {
    @Query("SELECT obj FROM Deposit obj WHERE obj.ID=?1")
    Optional<Deposit> findById(Long id);

}