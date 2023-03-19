package com.cobraTeam.intelligentFormsApp.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Data
@Container(containerName = "User", ru = "400")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String firstName;

    @PartitionKey
    private String lastName;

    private int age;

    private String emailAddress;

    private String address;

    private String role;

    public User(String firstName, String lastName, int age, String emailAddress, String address, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.emailAddress = emailAddress;
        this.address = address;
        this.role = role;
    }
}
