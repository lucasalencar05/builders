package com.builders;

import com.builders.domain.Cliente;
import com.builders.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class BuildersApplication implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    public static void main(String[] args) {
        SpringApplication.run(BuildersApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Cliente cli1 = new Cliente(null, "Baroadan", "48957335056", LocalDate.now(), 0);
        Cliente cli2 = new Cliente(null, "Amlapen", "61441544003", LocalDate.now(), 0);

        clienteRepository.saveAll(Arrays.asList(cli1, cli2));

    }

}
