package com.sefaz.demo.domain.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.sefaz.demo.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "transactions")
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal amount;
    // um usuario pode varias transa;oes, mas uma transa;ao so pode ter um sender e
    // um reciever, rela;ao com a tabalea usuario
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender; // User da classe user

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private LocalDateTime timestamp;

    private String obText;

    private String type;

    public Transaction(long id, BigDecimal amount, User sender, User receiver, LocalDateTime timestamp, String obText, String type) {
        this.id = id;
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = timestamp;
        this.obText = obText;
        this.type = type;
    }
    //criar um instacia da classe sem precisar passar nada
    public Transaction() {
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
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