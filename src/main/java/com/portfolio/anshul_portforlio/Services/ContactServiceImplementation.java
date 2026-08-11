package com.portfolio.anshul_portforlio.Services;

import com.portfolio.anshul_portforlio.DTO.ContactDto;
import com.portfolio.anshul_portforlio.Entities.ContactEntity;
import com.portfolio.anshul_portforlio.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContactServiceImplementation implements ContactService{
    @Autowired
    private ContactRepository repo;
    @Override
    public ContactEntity saveContact(ContactDto dto) {
        ContactEntity entity = new ContactEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setMessage(dto.getMessage());
        entity.setSubject(dto.getSubject());
        entity.setDatetime(LocalDate.now().toString());
        return repo.save(entity);

    }
}
