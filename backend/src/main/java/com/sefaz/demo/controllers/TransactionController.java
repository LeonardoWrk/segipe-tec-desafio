package com.sefaz.demo.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sefaz.demo.dtos.TransacitonDTO;
import com.sefaz.demo.repositories.DepositRepository;
import com.sefaz.demo.repositories.TransactionRepository;
import com.sefaz.demo.repositories.UserRepository;
import com.sefaz.demo.repositories.WithdrawalRepository;
import com.sefaz.demo.domain.deposit.Deposit;
import com.sefaz.demo.domain.transaction.Transaction;
import com.sefaz.demo.domain.user.User;
import com.sefaz.demo.domain.withdrawal.Withdrawal;
import com.sefaz.demo.services.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private WithdrawalRepository withdrawalRepositoryl;

    @Autowired
    private DepositRepository depositRepository;

    @Autowired 
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    // <> = oq vem no corpo da responseEntity
    public ResponseEntity<Transaction> createTransaciton(@RequestBody TransacitonDTO transaction) throws Exception{
        Transaction newTransaction = this.transactionService.createTransaciton(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }

    // @GetMapping("/extrato/{id}")
    // public ResponseEntity<Map<String, Object>> getExtrato(@PathVariable Long id) {
    //     // Buscar conta pelo ID
    //     var userP = userRepository.findById(id);
    //     if (userP.isEmpty()) {
    //         return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Conta não encontrada."));
    //     }
    
    //     List<Deposit> depositList = depositRepository.findDepositById(id)
    //         .map(Collections::singletonList)
    //         .orElse(Collections.emptyList());
    //     List<Withdrawal> withdrawalList = withdrawalRepositoryl.findWithById(id)
    //         .map(Collections::singletonList)
    //         .orElse(Collections.emptyList());
    
    //     List<Transaction> allTransactions = new ArrayList<>();
    //     depositList.forEach(deposit -> allTransactions.add(transactionService.convertToTransaction(deposit)));
    //     withdrawalList.forEach(withdrawal -> allTransactions.add(transactionService.convertToTransaction(withdrawal)));
    
    //     // Ordenando por timestamp
    //     allTransactions.sort(Comparator.comparing(Transaction::getTimestamp));
    
    //     Map<String, Object> responseMap = new HashMap<>();
    //     responseMap.put("transactions", allTransactions);
    
    //     return ResponseEntity.ok(responseMap);
    // }
    @GetMapping("/extrato/{id}")
    public ResponseEntity getExtrato(@PathVariable Long id) {
        // Buscar conta pelo ID
        var userP = userRepository.findById(id);
        if (userP.isEmpty()) {
            return ResponseEntity.badRequest().body("Conta não encontrada.");
        }

        List<Deposit> depositList = depositRepository.findDepositById(id)
            .map(Collections::singletonList)
            .orElse(Collections.emptyList());
        List<Withdrawal> withdrawalList = withdrawalRepositoryl.findWithById(id)
            .map(Collections::singletonList)
            .orElse(Collections.emptyList());

        List<Transaction> allTransactions = new ArrayList<>();
        depositList.forEach(deposit -> allTransactions.add(transactionService.convertToTransaction(deposit)));
        withdrawalList.forEach(withdrawal -> allTransactions.add(transactionService.convertToTransaction(withdrawal)));

        // Ordenando por timestamp
        allTransactions.sort(Comparator.comparing(Transaction::getTimestamp));

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("transactions", allTransactions);

        return ResponseEntity.ok(responseMap);
        
    }

}
