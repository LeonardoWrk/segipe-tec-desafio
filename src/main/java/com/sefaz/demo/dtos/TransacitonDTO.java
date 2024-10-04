package com.sefaz.demo.dtos;

import java.math.BigDecimal;

public record TransacitonDTO(BigDecimal value, Long senderId, Long receiverId) {
    
}
