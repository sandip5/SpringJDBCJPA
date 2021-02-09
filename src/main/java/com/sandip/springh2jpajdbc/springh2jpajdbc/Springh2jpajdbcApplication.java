package com.sandip.springh2jpajdbc.springh2jpajdbc;

import com.sandip.springh2jpajdbc.springh2jpajdbc.entity.Person;
import com.sandip.springh2jpajdbc.springh2jpajdbc.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Springh2jpajdbcApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    PersonJdbcDao dao;

    @Autowired
    PersonJpaRepository repository;


    public static void main(String[] args) {
        SpringApplication.run(Springh2jpajdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Find User By id -> {}", repository.findById(10002));
        logger.info("Insert New Row - > {}", repository.insert(new Person(10004, "neha", "chennai", new Date())));
        logger.info("Update Existing Row - > {}", repository.insert(new Person( "neha", "asansol", new Date())));
        repository.deleteById(10003);
        logger.info("All User -> {}", repository.findAll());
//        logger.info("Delete By Id, Rows Deletes - > {}", repository.deleteById(10003));
//        logger.info("Insert New Row - > {}", repository.insert(new Person(10004, "neha", "chennai", new Date())));
//        logger.info("Update Existing Row - > {}", repository.updatePerson(new Person(10004, "neha", "asansol", new Date())));
//        logger.info("All User -> {}", repository.findAll());
//        logger.info("All User -> {}", repository.findAll());
    }
}
