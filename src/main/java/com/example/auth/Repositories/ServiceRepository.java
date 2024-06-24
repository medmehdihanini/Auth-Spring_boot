package com.example.auth.Repositories;

import com.example.auth.Enteties.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}