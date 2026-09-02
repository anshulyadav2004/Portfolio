package com.portfolio.anshul_portforlio.Repository;

import com.portfolio.anshul_portforlio.Entities.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity,Integer> {

}
