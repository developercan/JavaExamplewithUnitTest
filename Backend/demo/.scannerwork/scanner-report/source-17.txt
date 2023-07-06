package com.example.demo.model;

import java.time.LocalDate;


public class Customer {
    // Normalde id değişkenini database'de oluştururdum fakat algoritma sorusu için sabit değerler kullanmak daha mantıklı
    private String id;

    private String name;
    private String surname;
    /* Tarih tipini String olarak ayarlıyorum çünkü müşteri verilerinin hepsini internal olarak tanımlıyorum. Farklı
     * tarihlerin kıyaslanmasını if statment'lar içerisinde değerlendirmek zorunda olduğum için sabit değerler gerek
     */
    private LocalDate regisDate;
    private String cardType;

    public Customer(String name, String surname){
       this.name=name;
       this.surname=surname;
    }
    public Customer(String id, String name, String surname,String cardType, LocalDate regisDate){
        this.id=id;
        this.name=name;
        this.regisDate=regisDate;
        this.surname=surname;
        this.cardType=cardType;
    }

    //Getter Setter & constructor
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public LocalDate getRegisDate(){
        return regisDate;
    }
    public String getCardType(){
        return cardType;
    }
    public void setCardType(String cardType){
        this.cardType=cardType;
    }
   public String getCustomerId(String name, String surname) {
        if (this.name.toLowerCase().equals(name.toLowerCase()) && this.surname.toLowerCase().equals(surname.toLowerCase())) {
            return this.id;
        }
        return "Invalid variable or customer does not exist!";
    }
}
