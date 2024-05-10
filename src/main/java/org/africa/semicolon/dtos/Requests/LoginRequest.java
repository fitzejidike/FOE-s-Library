package org.africa.semicolon.dtos.Requests;

import lombok.Data;
import org.africa.semicolon.Data.Model.Role;

@Data
public class LoginRequest {
    private String username;
    private String password;
    private Role role;
    private Boolean isLogin;

}
