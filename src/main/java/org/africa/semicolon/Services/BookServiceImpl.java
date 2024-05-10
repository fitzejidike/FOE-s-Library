package org.africa.semicolon.Services;

import org.africa.semicolon.Data.Model.Book;
import org.africa.semicolon.Data.Repository.BookRepo;
import org.africa.semicolon.Exception.BookNotFoundException;
import org.africa.semicolon.dtos.Requests.*;
import org.africa.semicolon.dtos.Response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepo bookRepo;
    @Override
    public AddBookResponse addBook(AddBookRequest addBookRequest) {
        Book book = new Book();
        book.setTitle(addBookRequest.getTitle());
        book.setAuthor(addBookRequest.getAuthor());
        book.setIntroduction(addBookRequest.getIntroduction());
        bookRepo.save(book);
        AddBookResponse addBookResponse = new AddBookResponse();
        addBookResponse.setAuthor(addBookRequest.getAuthor());
        addBookResponse.setTitle(addBookRequest.getTitle());
        addBookResponse.setMessage("Book added");
        return addBookResponse;
    }

    @Override
    public DeleteBookResponse deleteBook(DeleteBookRequest deleteBookRequest) {
        Book book = bookRepo.findAllByTitle(deleteBookRequest.getTitle());
        bookRepo.delete(book);

        DeleteBookResponse deleteBookResponse = new DeleteBookResponse();
        deleteBookResponse.setTitle(deleteBookRequest.getTitle());
        deleteBookResponse.setMessage("Book deleted");
        return deleteBookResponse;
    }

    @Override
    public DeleteAllBookResponse deleteAllBooks(DeleteAllBooksRequest deleteAllBooksRequest) {
//        Book book = bookRepo.findBookBy(deleteAllBooksRequest.)
//
        return null;
    }

    @Override
    public DeleteBookResponse deleteBookByAuthor(DeleteBookRequest deleteBookRequest) {
        Book book = bookRepo.findBookByAuthor(deleteBookRequest.getTitle());
        bookRepo.delete(book);
        DeleteBookResponse deleteBookResponse = new DeleteBookResponse();
        deleteBookResponse.setMessage("Book deleted successfully");
        return deleteBookResponse;
    }

    @Override
    public Book getBookInfo(GetBookInfoRequest getBookInfoRequest) {
        Book book = bookRepo.findAllByTitle(getBookInfoRequest.getTitle());
        if (book == null) throw new BookNotFoundException("Book not found");
        return book;
    }

    @Override
    public long count() {
        return bookRepo.count();
    }

    @Override
    public FindBookResponse findBookByTitle(FindBookRequest findBookRequest) {
        Book book = bookRepo.findAllByTitle(findBookRequest.getTitle());
        if (book == null) throw new BookNotFoundException("Book not found");

        FindBookResponse findBookResponse = new FindBookResponse();
        findBookResponse.setTitle(book.getTitle());
        findBookResponse.setMessage("These are all the books with this title");
        return findBookResponse;
    }
}
