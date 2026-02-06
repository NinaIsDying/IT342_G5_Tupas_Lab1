package com.tupas.wildcatsden.repository;

import com.tupas.wildcatsden.entity.CoordinatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CoordinatorRepository extends JpaRepository<CoordinatorEntity, Long> {
    List<CoordinatorEntity> findByAffiliation(String affiliation);
}