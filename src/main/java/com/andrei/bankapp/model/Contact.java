package com.andrei.bankapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "contact_messages")
public class Contact extends BaseEntity {

    @Id
    private String contactId;
    private String contactName;
    private String contactEmail;
    private String message;
    private String subject;
}
