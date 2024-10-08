package com.sefaz.demo.domain.withdrawal;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.sefaz.demo.domain.transaction.Transaction;
import com.sefaz.demo.domain.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "withdrawal")
@Table(name = "withdrawal")
public class Withdrawal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private LocalDateTime timestamp;

    private String obText;

    public Withdrawal(long id, BigDecimal amount, User receiver, LocalDateTime timestamp, String obText) {
        this.id = id;
        this.amount = amount;
        this.receiver = receiver;
        this.timestamp = timestamp;
        this.obText = obText;
    }

    public Withdrawal() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getObText() {
        return obText;
    }

    public void setObText(String obText) {
        this.obText = obText;
    }

    
}

