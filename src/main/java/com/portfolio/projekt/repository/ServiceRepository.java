package com.portfolio.projekt.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.projekt.entity.ServiceEntity;
import com.portfolio.projekt.entity.User;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
    List<ServiceEntity> findByProvider(User provider);
}
