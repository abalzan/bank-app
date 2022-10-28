package com.andrei.bankapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Loans  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanNumber;
    private int customerId;
    private Date startDate;
    private String loanType;
    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;

}
