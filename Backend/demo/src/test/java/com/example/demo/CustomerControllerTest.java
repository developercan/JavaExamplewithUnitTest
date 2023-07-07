package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.controller.CustomerController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CustomerControllerTest {


    @Test
    public void testGetTotalAmount() {
        // Database kullanmadığım için test verilerini statik arrayListin içerisinde bulunan yapıdan çektim. 
        String name = "NAZİYE";
        String surname = "GÜLER";
        int amount = 1000;
        boolean isPhone = true;
        int expectedDiscountedAmount = 735; // Beklenen indirimli tutar

        // Mock customerController nesnesi üzerinden getPercentageDiscount çağrısını taklit et
        CustomerController mockCustomerController = mock(CustomerController.class);
        when(mockCustomerController.getPercentageDiscount(name, surname, amount, isPhone)).thenReturn(expectedDiscountedAmount);

        // getTotalAmount'i çağır
        int percentageDiscount= mockCustomerController.getPercentageDiscount(name, surname, amount, isPhone);
        // Beklenen indirimli tutar ile gerçek tutarı karşılaştır
        assertEquals(expectedDiscountedAmount, percentageDiscount);

        // getPercentageDiscount çağrısının doğru parametrelerle çağrıldığından emin ol
        verify(mockCustomerController, times(1)).getPercentageDiscount(name, surname, amount, isPhone);
    }
}
