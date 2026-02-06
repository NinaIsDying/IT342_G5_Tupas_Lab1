package com.tupas.wildcatsden.repository;

import com.tupas.wildcatsden.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
    AdminEntity findByUserId(Long userId);
}
