package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Customer;

import java.time.LocalDate;

public class CustomerTest {

    @Test
    public void testGetCustomerId_ValidNameSurname_ReturnsId() {
        // Sabit bir Array'in içinden verileri çektiğim için Array üzerinde olan verileri kullanıyorum
        // Arrange
        Customer customer = new Customer("1", "Ayşe", "Boztoprak", "Gold", LocalDate.now());

        // Act
        String customerId = customer.getCustomerId("Ayşe", "Boztoprak");

        // Assert
        Assertions.assertEquals("1", customerId);
    }

    @Test
    public void testGetCustomerId_InvalidNameSurname_ReturnsErrorMessage() {
        // Arrange
        Customer customer = new Customer("1", "Ayşe", "Boztoprak", "Gold", LocalDate.now());

        // Act
        String customerId = customer.getCustomerId("Ahmet", "Kocaman");

        // Assert
        Assertions.assertEquals("Invalid variable or customer does not exist!", customerId);
    }

    @Test
    public void testGetCustomerId_CaseInsensitiveNameSurname_ReturnsId() {
        // Arrange
        Customer customer = new Customer("1", "Ayşe", "Boztoprak", "Gold", LocalDate.now());

        // Act
        String customerId = customer.getCustomerId("AYŞE", "BOZTOPRAK");

        // Assert
        Assertions.assertEquals("1", customerId);
    }
}
