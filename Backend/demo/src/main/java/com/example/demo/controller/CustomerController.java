package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;

@RestController
@CrossOrigin(origins = "http://localhost:3000") //  react.js 3000 ports for cors policy
public class CustomerController {
    private List<Customer> Customers;

    public List<Customer> getCustomers(){
        return Customers;
    }
    public CustomerController() {
        Customers = new ArrayList<>();
        Customers.add(new Customer("0", "Ahmet", "Kocaman", "Gold", LocalDate.of(2023, 06, 30)));
        Customers.add(new Customer("1", "Naziye", "Güler", "Gold", LocalDate.of(2022, 06, 30)));
        Customers.add(new Customer("2", "Cenk", "Osmanoğlu", "Silver", LocalDate.of(2021, 06, 30)));
        Customers.add(new Customer("3", "Recaizade", "Hacıoğlu", "Silver", LocalDate.of(2020, 06, 30)));
        Customers.add(new Customer("4", "Orhan", "Veli", "Partner", LocalDate.of(2019, 06, 30)));
        Customers.add(new Customer("5", "Namık", "Bilgiç", "", LocalDate.of(2018, 06, 30)));

    }

    @GetMapping("/Customers")
    public List<Customer> getAll() {
        return Customers;
    }
}
