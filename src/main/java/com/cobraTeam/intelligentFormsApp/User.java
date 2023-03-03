package com.cobraTeam.intelligentFormsApp;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;

@Container(containerName = "myCollection")
public class User {
    @Id
    private String id;
    private String firstName;

    @PartitionKey
    private String address;
    private String lastName;

    public User() {

    }

    public User(String id, String firstName, String address, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.address = address;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return String.format("%s %s, %s", firstName, lastName, address);
    }
}
