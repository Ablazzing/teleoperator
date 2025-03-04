package com.javaacademy.teleoperator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaacademy.teleoperator.dto.ClientDto;
import com.javaacademy.teleoperator.entity.Client;
import com.javaacademy.teleoperator.mapper.ClientMapper;
import com.javaacademy.teleoperator.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public void findAll(int pageNumber, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);
        Page<Client> clients = clientRepository.findAll(pageRequest);
        List<ClientDto> dtos = clientMapper.toDto(clients.getContent());
        System.out.println("___________________________________________");
        log.info(
                objectMapper.writeValueAsString(new PageImpl<>(dtos, pageRequest, clients.getTotalElements()))

        );
    }
}
