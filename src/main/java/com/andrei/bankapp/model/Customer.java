package com.andrei.bankapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;
    private String name;
    private String email;
    private String mobileNumber;
//    @JsonIgnore
    private String password;
    private String role;
}
