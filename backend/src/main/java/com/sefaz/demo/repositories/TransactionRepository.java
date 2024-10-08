package com.sefaz.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sefaz.demo.domain.transaction.Transaction;
import java.util.List;
import com.sefaz.demo.domain.user.User;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findBySender_id(Long id);
    List<Transaction> findByReceiver_id(Long id);
}
