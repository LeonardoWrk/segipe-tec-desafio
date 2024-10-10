package com.sefaz.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sefaz.demo.domain.user.User;
import com.sefaz.demo.domain.withdrawal.Withdrawal;

public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long>{
    Optional<List<Withdrawal>> findWithdrawalsByReceiverId(Long userId);

}
