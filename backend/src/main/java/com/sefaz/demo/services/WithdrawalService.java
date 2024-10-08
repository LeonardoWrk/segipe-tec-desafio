package com.sefaz.demo.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sefaz.demo.domain.user.User;
import com.sefaz.demo.domain.withdrawal.Withdrawal;
import com.sefaz.demo.dtos.WithdrawalDTO;
import com.sefaz.demo.repositories.WithdrawalRepository;



@Service
public class WithdrawalService {
    @Autowired
    private UserService userService;

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    public Withdrawal createWithdrawl(WithdrawalDTO withdrawal) throws Exception{

        User receiver = this.userService.findUserById(withdrawal.receiverId());

        userService.validateWithdrawal(receiver, withdrawal.value());
        //atualizar valores
        Withdrawal newWithdrawal = new Withdrawal();
        newWithdrawal.setAmount(withdrawal.value());
        newWithdrawal.setReceiver(receiver);
        newWithdrawal.setTimestamp(LocalDateTime.now());
        newWithdrawal.setObText(withdrawal.obText());

        receiver.setBalance(receiver.getBalance().subtract(withdrawal.value()));

        this.withdrawalRepository.save(newWithdrawal);
        this.userService.saveUser(receiver);

        return newWithdrawal;
    }
}