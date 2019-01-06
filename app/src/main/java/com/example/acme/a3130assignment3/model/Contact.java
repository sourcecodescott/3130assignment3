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

    public  Contact()
    {

    }

    public Contact(String name, String email)
    {
        this.name = name;
        this.email = email;
    }


    @Override
    public String toString()
    {
        return "Name: " + name + " e-mail: " + email;
    }
}
