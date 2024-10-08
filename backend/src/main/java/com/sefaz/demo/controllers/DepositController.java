package com.sefaz.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sefaz.demo.domain.deposit.Deposit;
import com.sefaz.demo.dtos.DepositDTO;
import com.sefaz.demo.services.DepositService;

@RestController
@RequestMapping("/api/deposit")
public class DepositController {
    
    @Autowired
    private DepositService depositService;

    @PostMapping
    public ResponseEntity<Deposit> createDeposit(@RequestBody DepositDTO deposit) throws Exception{
        Deposit newdDeposit = this.depositService.createDeposit(deposit);
        return new ResponseEntity<>(newdDeposit, HttpStatus.OK);
    }
}
