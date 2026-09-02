package com.portfolio.anshul_portforlio.Services;

import com.portfolio.anshul_portforlio.DTO.ContactDto;
import com.portfolio.anshul_portforlio.Entities.ContactEntity;
import com.portfolio.anshul_portforlio.Repository.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import java.time.LocalDate;

@Service
public class ContactServiceImplementation implements ContactService{
    @Autowired
    private ContactRepository repo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ContactEntity saveContact(ContactDto dto) {
      //  ContactEntity entity = new ContactEntity();
      //  entity.setName(dto.getName());
       // entity.setEmail(dto.getEmail());
       // entity.setMessage(dto.getMessage());
      //  entity.setSubject(dto.getSubject());
       // entity.setDatetime(LocalDate.now().toString());
      ContactEntity entity = modelMapper.map(dto, ContactEntity.class);
        return repo.save(entity);

    }

    @Override
    public boolean isContactEmailExist(String email) {
       return  repo.existsByEmail(email);

    }

    @Override
    public List<ContactEntity> readAllContacts() {
        return repo.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        repo.deleteById(id);
        return true;
    }

}
