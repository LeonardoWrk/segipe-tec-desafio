package com.sefaz.demo.dtos;

import java.math.BigDecimal;

public record TransacitonDTO(BigDecimal amount, Long senderId, Long receiverId, String obText) {
    
}
