package org.africa.semicolon.Services;

import org.africa.semicolon.dtos.Requests.LoginRequest;
import org.africa.semicolon.dtos.Requests.LogoutRequest;
import org.africa.semicolon.dtos.Requests.RegisterUserRequest;
import org.africa.semicolon.dtos.Response.LoginResponse;
import org.africa.semicolon.dtos.Response.LogoutResponse;
import org.africa.semicolon.dtos.Response.RegisterUserResponse;

public interface UserService {
    LoginResponse Login(LoginRequest loginRequest);
    LogoutResponse Logout(LogoutRequest logoutRequest);
    RegisterUserResponse Register(RegisterUserRequest registerUserRequest);



}
