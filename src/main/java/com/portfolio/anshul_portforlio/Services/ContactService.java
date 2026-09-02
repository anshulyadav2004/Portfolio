package com.portfolio.anshul_portforlio.Services;

import com.portfolio.anshul_portforlio.DTO.ContactDto;
import com.portfolio.anshul_portforlio.Entities.ContactEntity;

import java.util.List;

public interface ContactService {
    ContactEntity saveContact(ContactDto dto);
    boolean isContactEmailExist(String email);
    List<ContactEntity> readAllContacts();
    boolean deleteById(int id);
}
