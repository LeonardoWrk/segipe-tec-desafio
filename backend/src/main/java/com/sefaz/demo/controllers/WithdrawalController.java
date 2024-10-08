package com.sefaz.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sefaz.demo.domain.withdrawal.Withdrawal;
import com.sefaz.demo.dtos.WithdrawalDTO;
import com.sefaz.demo.services.WithdrawalService;

@RestController
@RequestMapping("/api/saque")
public class WithdrawalController {
    
    @Autowired
    private WithdrawalService withdrawalService;

    @PostMapping
    public ResponseEntity<Withdrawal> createWithdrawal(@RequestBody WithdrawalDTO withdrawal) throws Exception{
        Withdrawal newWithdrawal = this.withdrawalService.createWithdrawl(withdrawal);
        return new ResponseEntity<>(newWithdrawal, HttpStatus.OK);
    }
}
