package com.portfolio.anshul_portforlio.Repository;

import com.portfolio.anshul_portforlio.Entities.resumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResumeRepository extends JpaRepository<resumeEntity, Integer> {
    Optional<resumeEntity> findTopByOrderByIdDesc();
}
