package com.sefaz.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sefaz.demo.domain.deposit.Deposit;
import com.sefaz.demo.domain.user.User;

public interface DepositRepository extends JpaRepository<Deposit, Long> {
    Optional<Deposit> findDepositById(long id);
}
