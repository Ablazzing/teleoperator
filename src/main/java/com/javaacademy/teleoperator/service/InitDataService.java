package com.javaacademy.teleoperator.service;

import com.javaacademy.teleoperator.entity.Client;
import com.javaacademy.teleoperator.repository.ClientRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
@Profile("init")
@RequiredArgsConstructor
@Slf4j
public class InitDataService {
    private static final Integer PORTION_SIZE = 10_000;
    private final ClientRepository clientRepository;

    @PostConstruct
    public void init() {
        List<Client> clients = IntStream.range(0, 100_000)
                .boxed()
                .map(e -> new Client("client" + e))
                .toList();
        for (int i = 0; i < 100; i++) {
            List<Client> subList = clients.subList(i * PORTION_SIZE, i * PORTION_SIZE + PORTION_SIZE);
            clientRepository.saveAll(subList);
            log.info("Порция №{} вставлена", i + 1);
        }

    }
}
