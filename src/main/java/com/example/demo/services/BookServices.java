package com.example.demo.services;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServices {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> createBookList(List<Book> list) {
        return bookRepository.saveAll(list);
    }

    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book updateBookById(Book book) {
        Optional<Book> bookFound = bookRepository.findById(book.getId());

        if (bookFound.isPresent()) {
            Book bookUpdate = bookFound.get();
            bookUpdate.setAuteur(book.getAuteur());
            bookUpdate.setNbp(book.getNbp());
            bookUpdate.setPrice(book.getPrice());

            return bookRepository.save(book);
        } else {
            return null;
        }
    }

    public String deleteBookById(int id) {
        bookRepository.deleteById(id);
        return "Book "+ id +" deleted";
    }
}
