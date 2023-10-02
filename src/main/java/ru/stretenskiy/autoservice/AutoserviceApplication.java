package ru.stretenskiy.autoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.stretenskiy.autoservice.entity.Work;
import ru.stretenskiy.autoservice.repository.CarsRepository;
import ru.stretenskiy.autoservice.repository.WorksRepository;

import java.util.List;

@SpringBootApplication/*(exclude = {DataSourceAutoConfiguration.class})*/
public class AutoserviceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AutoserviceApplication.class, args);
	}

	@Autowired
	WorksRepository worksRepository;

	@Autowired
	CarsRepository carsRepository;

	@Override
	public void run(String... args) throws Exception {

		//System.out.println(worksRepository.findAll());
		//System.out.println(carsRepository.findAll());
	}
}
