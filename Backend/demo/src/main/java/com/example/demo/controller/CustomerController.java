package com.example.demo.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;

@RestController
@CrossOrigin(origins = "http://localhost:3000") //  react.js 3000 ports for cors policy
public class CustomerController {
    private List<Customer> Customers;

    public CustomerController() {
        Customers = new ArrayList<>();
        Customers.add(new Customer("0", "Ahmet", "Kocaman", "Gold", LocalDate.of(2023, 06, 30)));
        Customers.add(new Customer("1", "Ayşe", "Boztoprak", "Gold", LocalDate.of(2022, 06, 30)));
        Customers.add(new Customer("2", "Feyza", "Kocaman", "Silver", LocalDate.of(2021, 06, 30)));
        Customers.add(new Customer("3", "Ali", "Kocaman", "Silver", LocalDate.of(2020, 06, 30)));
        Customers.add(new Customer("4", "Fatma", "Kocaman", "Partner", LocalDate.of(2019, 06, 30)));
        Customers.add(new Customer("5", "Can", "Kocaman", "", LocalDate.of(2018, 06, 30)));

    }

    @GetMapping("/Customers")
    public List<Customer> getAll() {
        return Customers;
    }

    // Bu kısımları gerekirse endpoint olarak açmayabilirim. Internal service olarak
    // kalması daha mantıklı
    // @GetMapping("/getID/{name}/{surname}")
    public String getID(@PathVariable String name, @PathVariable String surname) {
        for (Customer customer : Customers) {
            if (customer.getName().toLowerCase().equals(name.toLowerCase()) && customer.getSurname().toLowerCase().equals(surname.toLowerCase())) {
                return customer.getId();

            }
        }
        return "Invalid variable or customer does not exist!";
    }

    public String getCardType(@PathVariable String id) {

        for (Customer customer : Customers) {
            if (customer.getId().equals(id)) {
                return customer.getCardType();
            }
        }
        return "";
    }

   // @GetMapping("/PercentageDiscount/{name}/{surname}/{amount}/{isPhone}")
    public int getPercentageDiscount(@PathVariable String name, @PathVariable String surname,
            @PathVariable int amount,@PathVariable boolean isPhone) {
        String customerID = getID(name, surname);
        String customerCardType = getCardType(customerID);
        int amountDiscounted = getAmountDiscount(amount);
        LocalDate regisDate = getRegisDate(customerID);
        Long dateDifference = ChronoUnit.YEARS.between(regisDate, LocalDate.now());
        int phonePrice=0;

        //Task içinde indirim öncelik bilgisi verilmediği için algoritma geçici olarak bu şekilde oluşturulmuştur. Küçük bir düzeltme ile bunun önüne geçilebilir.
        //Faturada telefon olma durumunu boolean veri tipiyle kontrol ediyorum. Dinamik olarak ücreti çekmedim, geçici süreliğine statik olarak ücreti algoritmaya ekledim.
        if(isPhone==true && amount>200)phonePrice=200; amount=amount-phonePrice; // faturada telefon değeri çıkarılıp daha sonra yüzdesel indirimler uygulanır
         if (customerCardType.equals("Gold")) {
            return (amount - (amount * 30) / 100) - amountDiscounted + phonePrice; // Gold üyelere %30
        } else if (customerCardType.equals("Silver")) {
            return (amount - (amount * 20) / 100) - amountDiscounted +phonePrice; // Silver üyelere %20
        } else if (customerCardType.equals("Partner")) {
            return (amount - (amount * 10) / 100) - amountDiscounted +phonePrice;// Ortaklara ise %10
        } else if (dateDifference >= 2) {
            return (amount - (amount * 5) / 100) - amountDiscounted +phonePrice;// 2 yıl ya da daha uzun müşterilere %5
        }
        return 0;
    }

   // @GetMapping("/AmountDiscount/{amount}")
    public int getAmountDiscount(@PathVariable int amount) {
        int sonuc = (amount / 200) * 5;
        return sonuc;
    }

    public LocalDate getRegisDate(String id) {
        for (Customer customer : Customers) {
            if (customer.getId().equals(id)) {
                return customer.getRegisDate();
            }
        }
        return LocalDate.now();
    }

   // @GetMapping("/Getdate")
    public LocalDate getDate() {
        return LocalDate.now();
    }

    //Tek bir kontrol noktası oluşturmak istediğim için bir ana metod yazdım ve bunu endpoint olarak açtım
    @GetMapping("GetAmount/{name}/{surname}/{amount}/{isPhone}")
    public int getTotalAmount(@PathVariable String name,@PathVariable String surname, @PathVariable int amount, @PathVariable boolean isPhone){
        return getPercentageDiscount(name, surname, amount, isPhone);
    }
}
