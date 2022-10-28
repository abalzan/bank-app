package com.andrei.bankapp.service;

import com.andrei.bankapp.model.Contact;
import com.andrei.bankapp.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    public Contact saveContactInquiryDetails(Contact contact) {
        contact.setContactId(getServiceRequestNumber());
        return contactRepository.save(contact);

    }

    private String getServiceRequestNumber() {
        Random random = new Random();
        int number = random.nextInt(999999 - 999) + 9999;
        return "SR"+number;
    }
}
