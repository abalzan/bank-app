package com.andrei.bankapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class AccountTransactions  extends BaseEntity {

    @Id
    private String transactionId;
    private long accountNumber;
    private int customerId;
    private Date transactionDate;
    private String transactionSummary;
    private String transactionType;
    private int transactionAmount;
    private int closingBalance;
}
