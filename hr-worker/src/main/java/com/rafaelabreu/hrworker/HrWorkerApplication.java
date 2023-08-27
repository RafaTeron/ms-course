package com.rafaelabreu.hrworker;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafaelabreu.hrworker.entities.Worker;
import com.rafaelabreu.hrworker.repositories.WorkerRepository;

@SpringBootApplication
public class HrWorkerApplication implements CommandLineRunner {

	@Autowired
	private WorkerRepository workerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HrWorkerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Worker worker1 = new Worker(null, "Bob" , 200.0);
		Worker worker2 = new Worker(null, "Maria" , 300.0);
		Worker worker3 = new Worker(null, "Alex" , 250.0);
		
		workerRepository.saveAll(Arrays.asList(worker1,worker2,worker3));
	}

}
