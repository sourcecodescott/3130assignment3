package com.example.acme.a3130assignment3.model;

import java.io.Serializable;

/*
Simple POJO class to hold Contact information
in Realtime database or Firestore database
 */
public class Contact implements Serializable {

    public String id;
    public String name;
    public String email;

   // private String number;
    private String type;
    private String address;
    private String province;
    private int business_num;

    public  Contact()
    {

    }


    public Contact(String name, String email)
    {
        this.name = name;
        this.email = email;
    }

    public int getBusiness_num() {
        return business_num;
    }

    public void setBusiness_num(int business_num) {
        this.business_num = business_num;
    }

    //public String getBusiness_number() {
      //  return number;
    //}

    //public void setBusiness_number(String number) {
      //  this.number = number;
   // }


    public void setBusiness_type(String type) {
        this.type = type;
    }

    public String getBusiness_type() {
        return type;
    }

    public String getBusiness_address() {
        return address;
    }

    public void setBusiness_address(String address) {
        this.address = address;
    }

    public String getBusiness_province() {
        return province;
    }

    public void setBusiness_province(String province) {
        this.province = province;
    }


    @Override
    public String toString()
    {
        return "Name: " + name + " e-mail: " + email;
    }
}
