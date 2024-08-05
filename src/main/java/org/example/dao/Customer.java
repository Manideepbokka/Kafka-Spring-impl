package org.example.dao;

import lombok.Data;

@Data
public class Customer {

    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;

}
