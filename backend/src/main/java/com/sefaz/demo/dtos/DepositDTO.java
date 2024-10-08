package com.sefaz.demo.dtos;

import java.math.BigDecimal;

public record DepositDTO(Long receiverId, String obText, BigDecimal amount)  {
    
}
