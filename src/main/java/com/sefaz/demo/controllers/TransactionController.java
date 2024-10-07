package com.sefaz.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sefaz.demo.domain.transaction.Transaction;
import com.sefaz.demo.dtos.TransacitonDTO;
import com.sefaz.demo.services.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    // <> = oq vem no corpo da responseEntity
    public ResponseEntity<Transaction> createTransaciton(@RequestBody TransacitonDTO transaction){
        
    }
}
