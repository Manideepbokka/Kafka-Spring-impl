package org.example.dao;
import lombok.Data;


@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private boolean isActive;

}
