package com.sefaz.demo.dots;

import java.math.BigDecimal;

public record TransacitonDTO(BigDecimal value, Long senderId, Long receiverId) {
    
}
