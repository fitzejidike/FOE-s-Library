package org.africa.semicolon.Services;

import org.africa.semicolon.Data.Model.User;
import org.africa.semicolon.Data.Repository.UserRepo;
import org.africa.semicolon.Exception.InvalidEmailFoundException;
import org.africa.semicolon.Exception.InvalidPasswordException;
import org.africa.semicolon.Exception.UserNameNotFoundException;
import org.africa.semicolon.dtos.Requests.LoginRequest;
import org.africa.semicolon.dtos.Requests.LogoutRequest;
import org.africa.semicolon.dtos.Requests.RegisterUserRequest;
import org.africa.semicolon.dtos.Response.LoginResponse;
import org.africa.semicolon.dtos.Response.LogoutResponse;
import org.africa.semicolon.dtos.Response.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public LoginResponse Login(LoginRequest loginRequest) {
        User user = userRepo.findByUserName(loginRequest.getUsername());
        if (user == null) {
            throw new UserNameNotFoundException("UserName " + " does not exist");
        }
        validatePassword(loginRequest.getPassword(), user);
        user.setLogin(true);
        userRepo.save(user);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(loginRequest.getUsername());
        loginResponse.setMessage("Login Successful");
        return loginResponse;
    }

    @Override
    public LogoutResponse Logout(LogoutRequest logoutRequest) {
    User user = userRepo.findByUserName(logoutRequest.getUsername());
    if (user == null) {
        throw new UserNameNotFoundException("UserName " + " does not exist");
    }
    LogoutResponse logoutResponse = new LogoutResponse();
    logoutResponse.setUsername(logoutRequest.getUsername());
    logoutResponse.setMessage("Logout Successful");
    return logoutResponse;
    }

    @Override
    public RegisterUserResponse Register(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setFirstName(registerUserRequest.getFirstName());
        user.setLastName(registerUserRequest.getLastName());
        user.setUserName(registerUserRequest.getUsername());
        validateEmail(registerUserRequest.getEmail());
        user.setPassword(registerUserRequest.getPassword());
        user.setRole(registerUserRequest.getRole());
        userRepo.save(user);

        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setUsername(registerUserRequest.getUsername());
        registerUserResponse.setMessage("Registration Successful");
        return registerUserResponse;

    }

    private void validatePassword(String password, User user) {
        if (password.length() < 8) {
            throw new UserNameNotFoundException("Password must be at least 8 characters");
        }
        if (!password.matches("[a-zA-Z0-9]*")) {
            throw new UserNameNotFoundException("Password must be alphanumeric");
        }
        if (!password.matches(".*\\d.*")) {
            throw new UserNameNotFoundException("Password must contain at least one digit");
        }
        if (user != null && !password.equals(user.getPassword()))
            throw new InvalidPasswordException("Invalid Password Entered");

    }

    private void validateEmail(String email) {
        if (!email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new InvalidEmailFoundException("Invalid Email");
        }
    }
}
