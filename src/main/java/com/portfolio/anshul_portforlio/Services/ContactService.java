package com.portfolio.anshul_portforlio.Services;

import com.portfolio.anshul_portforlio.DTO.ContactDto;
import com.portfolio.anshul_portforlio.Entities.ContactEntity;

public interface ContactService {
    ContactEntity saveContact(ContactDto dto);
}
