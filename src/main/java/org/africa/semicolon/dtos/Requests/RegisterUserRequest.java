package org.africa.semicolon.dtos.Requests;

import lombok.Data;
import org.africa.semicolon.Data.Model.Role;

@Data
public class RegisterUserRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
    private String email;
    private String phoneNumber;
    private String address;

}
