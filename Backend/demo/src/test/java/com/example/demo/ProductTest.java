package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Product;

public class ProductTest {
    
    @Test
    public void testGetProductName_ReturnsProductName() {
        // Arrange
        String expectedProductName = "Example Product";
        double price = 10.0;
        Product product = new Product(expectedProductName, price);

        // Act
        String actualProductName = product.getProductName();

        // Assert
        Assertions.assertEquals(expectedProductName, actualProductName);
    }

    @Test
    public void testGetPrice_ReturnsPrice() {
        // Arrange
        String productName = "Example Product";
        double expectedPrice = 10.0;
        Product product = new Product(productName, expectedPrice);

        // Act
        double actualPrice = product.getPrice();

        // Assert
        Assertions.assertEquals(expectedPrice, actualPrice);
    }
}
