package org.africa.semicolon.Data.Repository;

import org.africa.semicolon.Data.Model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends MongoRepository<Book,String> {
    Book findAllByTitle(String title);

    Book findBookByAuthor(String author);
}
