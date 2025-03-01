package com.javaacademy.teleoperator;

import com.javaacademy.teleoperator.entity.Client;
import com.javaacademy.teleoperator.entity.PhoneContract;
import com.javaacademy.teleoperator.entity.TariffPlan;
import com.javaacademy.teleoperator.repository.PhoneContractRepository;
import com.javaacademy.teleoperator.service.PhoneContractService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TeleoperatorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TeleoperatorApplication.class, args);
		PhoneContractService phoneContractService = context.getBean(PhoneContractService.class);


//		PhoneContractRepository phoneContractRepository = context.getBean(PhoneContractRepository.class);
//		Client client = new Client("Ivan");
//		PhoneContract phoneContract = new PhoneContract(TariffPlan.ECONOM, client);
//		phoneContractRepository.save(phoneContract);

//
		Client client = new Client("Ivan");
		PhoneContract phoneContract = new PhoneContract(TariffPlan.ECONOM, client);
		phoneContractService.create(phoneContract);
//
//		Client petr = new Client("Petr");
//		phoneContractService.createOrUpdate(petr, TariffPlan.ECONOM);

	}
}
