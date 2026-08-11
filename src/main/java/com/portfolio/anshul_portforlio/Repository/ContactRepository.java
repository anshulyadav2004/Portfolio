package com.portfolio.anshul_portforlio.Repository;

import com.portfolio.anshul_portforlio.Entities.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity,Integer> {
}
