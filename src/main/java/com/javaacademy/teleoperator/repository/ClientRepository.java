package com.javaacademy.teleoperator.repository;

import com.javaacademy.teleoperator.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
