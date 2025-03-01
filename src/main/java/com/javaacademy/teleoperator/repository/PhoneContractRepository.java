package com.javaacademy.teleoperator.repository;

import com.javaacademy.teleoperator.entity.Client;
import com.javaacademy.teleoperator.entity.PhoneContract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneContractRepository extends JpaRepository<PhoneContract, Integer> {

    List<PhoneContract> findAllByClient(Client client);
}
