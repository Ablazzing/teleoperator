package com.javaacademy.teleoperator.mapper;

import com.javaacademy.teleoperator.dto.ClientDto;
import com.javaacademy.teleoperator.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientMapper {

    public List<ClientDto> toDto(List<Client> clients) {
        return clients.stream()
                .map(e -> new ClientDto(e.getId(), e.getName()))
                .toList();
    }
}
