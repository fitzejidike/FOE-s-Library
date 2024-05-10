package org.africa.semicolon.Data.Model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document("User")
public class User {
    private String firstName;
    private String lastName;;
    private String userName;
    private String phoneNumber;
    private Role role;
    private String email;
    private String password;
    private String address;
    private boolean login;
    private List<Book> books = new ArrayList<>();

}
