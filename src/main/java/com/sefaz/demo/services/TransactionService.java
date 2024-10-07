package com.sefaz.demo.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sefaz.demo.domain.transaction.Transaction;
import com.sefaz.demo.domain.user.User;
import com.sefaz.demo.dtos.TransacitonDTO;
import com.sefaz.demo.repositories.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository transactionrepo;
    //dto = data transfer objects
    public Transaction createTransaciton(TransacitonDTO transaction) throws Exception{
        // VOLTAR NESSA PARTE user -> string
       User sender = this.userService.findUserById(transaction.senderId());
       User receiver = this.userService.findUserById(transaction.receiverId());

       userService.validateTransaction(sender, transaction.value());
        // atualizar valores
       Transaction newTransaction = new Transaction();
       newTransaction.setAmount(transaction.value());
       newTransaction.setSender(sender);
       newTransaction.setReceiver(receiver);
       newTransaction.setTimestamp(LocalDateTime.now());
        // minha balance atual e meu get balance subitraido o valor da transa;ao
       sender.setBalance(sender.getBalance().subtract(transaction.value()));
       // o contrario da de cima
       receiver.setBalance(receiver.getBalance().add(transaction.value()));

       //persistir no banco, this pegar instacia da classe
       this.transactionrepo.save(newTransaction);
       this.userService.saveUser(sender);
       this.userService.saveUser(receiver);

       return newTransaction;
    }
}
