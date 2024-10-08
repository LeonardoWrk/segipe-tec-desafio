package com.sefaz.demo.dtos;

import java.math.BigDecimal;

public record WithdrawalDTO(Long receiverId, String obText, BigDecimal amount)  {
    
}
