package org.africa.semicolon.Data.Model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Book")
public class Book {
        private String  id;
        private  String author;
        private String title;
        private String body;
        private String introduction;
        private Genre genre;

}


