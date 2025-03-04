package com.javaacademy.teleoperator.service;

import com.javaacademy.teleoperator.entity.Client;
import com.javaacademy.teleoperator.entity.PhoneContract;
import com.javaacademy.teleoperator.entity.TariffPlan;
import com.javaacademy.teleoperator.exception.ClientNotExistsException;
import com.javaacademy.teleoperator.repository.ClientRepository;
import com.javaacademy.teleoperator.repository.PhoneContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneContractService {
    private final PhoneContractRepository phoneContractRepository;
    private final ClientRepository clientRepository;
    @Autowired
    private PhoneContractService phoneContractService;

    @Transactional
    public void create(PhoneContract phoneContract) {
        Integer clientId = phoneContract.getClient().getId();
        checkClientIsExists(clientId);
        if (phoneContract.getTariffPlan() == null) {
            throw new RuntimeException("Не проставлен контракт");
        }
        phoneContractRepository.save(phoneContract);
    }

    @Transactional
    public void createOrUpdate(Client client, TariffPlan tariffPlan) {
            if (client.getId() == null || !clientRepository.existsById(client.getId())) {
                phoneContractService.create(new PhoneContract(tariffPlan, client));
            }
            List<PhoneContract> contracts = phoneContractRepository.findAllByClient(client);
            contracts.forEach(contract -> contract.setTariffPlan(tariffPlan));
            phoneContractRepository.saveAll(contracts);
    }

    private void checkClientIsExists(Integer clientId) {
        if (clientId != null && !clientRepository.existsById(clientId)) {
            throw new ClientNotExistsException("Такого клиента нет!");
        }
    }

    @Transactional(readOnly = true)
    public PhoneContract findContractById(Integer id) {
        PhoneContract phoneContract = phoneContractRepository.findById(id).orElseThrow();
        String name = phoneContract.getClient().getName();
        System.out.println(name);
        if (phoneContract.getTariffPlan() == TariffPlan.ECONOM) {
            System.out.println("Вы должны 1000 рублей");
        }
        return phoneContract;
    }

}
