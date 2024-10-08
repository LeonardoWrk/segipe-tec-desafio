package com.sefaz.demo.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sefaz.demo.domain.deposit.Deposit;
import com.sefaz.demo.domain.user.User;
import com.sefaz.demo.dtos.DepositDTO;
import com.sefaz.demo.repositories.DepositRepository;

@Service
public class DepositService {
    @Autowired
    private UserService userService;

    @Autowired
    private DepositRepository depositRepository;
     //voltar e modularizar funçao + melhorar logica
    public Deposit createDeposit(DepositDTO deposit) throws Exception{

      User receiver = this.userService.findUserById(deposit.receiverId());

      userService.validateDeposit(deposit.value());
      //atualizar valores
      Deposit newDeposit = new Deposit();
      newDeposit.setAmount(deposit.value());
      newDeposit.setReceiver(receiver);
      newDeposit.setTimestamp(LocalDateTime.now());
      newDeposit.setObText(deposit.obText());

      receiver.setBalance(receiver.getBalance().add(deposit.value()));

      this.depositRepository.save(newDeposit);
      this.userService.saveUser(receiver);

      return newDeposit;
    }
}