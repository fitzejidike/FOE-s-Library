package org.africa.semicolon.Services;

import org.africa.semicolon.Data.Model.Book;
import org.africa.semicolon.dtos.Requests.*;
import org.africa.semicolon.dtos.Response.*;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    AddBookResponse addBook(AddBookRequest addBookRequest);
    DeleteBookResponse deleteBook(DeleteBookRequest deleteBookRequest);
    DeleteAllBookResponse deleteAllBooks(DeleteAllBooksRequest deleteAllBooksRequest);
    DeleteBookResponse deleteBookByAuthor(DeleteBookRequest deleteBookRequest);
    Book getBookInfo(GetBookInfoRequest getBookInfoRequest);
    long count();
    FindBookResponse findBookByTitle(FindBookRequest findBookRequest);

}


