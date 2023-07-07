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
        Customer customer = new Customer("1", "Naziye", "Güler", "Gold", LocalDate.now());

        // Act
        String customerId = customer.getCustomerId("Naziye", "Güler");

        // Assert
        Assertions.assertEquals("1", customerId);
    }

    @Test
    public void testGetCustomerId_InvalidNameSurname_ReturnsErrorMessage() {
        // Arrange
        Customer customer = new Customer("1", "Naziye", "Güler", "Gold", LocalDate.now());

        // Act
        String customerId = customer.getCustomerId("Naziye", "Güler");

        // Assert
        Assertions.assertEquals("Invalid variable or customer does not exist!", customerId);
    }

    @Test
    public void testGetCustomerId_CaseInsensitiveNameSurname_ReturnsId() {
        // Arrange
        Customer customer = new Customer("1", "Naziye", "Güler", "Gold", LocalDate.now());

        // Act
        String customerId = customer.getCustomerId("NAZİYE", "GÜLER");

        // Assert
        Assertions.assertEquals("1", customerId);
    }
}
