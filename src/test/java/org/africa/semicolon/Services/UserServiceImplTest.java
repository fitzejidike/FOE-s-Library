package org.africa.semicolon.Services;

import org.africa.semicolon.Data.Model.Role;
import org.africa.semicolon.Data.Model.User;
import org.africa.semicolon.Data.Repository.UserRepo;
import org.africa.semicolon.dtos.Requests.LoginRequest;
import org.africa.semicolon.dtos.Requests.RegisterUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepo userRepo;
    @BeforeEach
    public void clearAll(){
        userRepo.deleteAll();
    }
    @Test
    void test_register() {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setFirstName("john");
        request.setLastName("fitz");
        request.setRole(Role.USER);
        request.setEmail("fitzi@gmail.com");
        request.setPassword("Fitz23");
        request.setUsername("leo19");
        request.setPassword("12Fitz23");
        userService.Register(request);
        assertEquals(1,userRepo.count());



    }


    @Test
    void test_login() {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setFirstName("john");
        request.setLastName("fitz");
        request.setRole(Role.USER);
        request.setEmail("fitzigmail.com");
        request.setPassword("Fitz23");
        request.setUsername("leo19");
        request.setPassword("12Fitz23");
        userService.Register(request);
        assertEquals(1,userRepo.count());

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("leo19");
        loginRequest.setPassword("12Fitz23");
        loginRequest.setRole(Role.USER);
        userService.Login(loginRequest);
        User user = userRepo.findByUserName(loginRequest.getUsername());
        assertTrue(user.isLogin());
    }

    @Test
    void logout() {
    }

    @Test
    void register() {
    }
}