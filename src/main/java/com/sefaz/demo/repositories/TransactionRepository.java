package com.sefaz.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sefaz.demo.domain.transaction.Transaction;;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
