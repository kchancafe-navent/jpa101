package com.kchancafe.transactional101;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public long count() {
        return repository.count();
    }

//    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Book save(Book book) {
        if (book.getTitle() != null) {
            throw new RuntimeException("Boom!");
        }
        return repository.save(book);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<Book> saveAll(Iterable<Book> books) {
        try {
            return CollectionUtils.toList(repository.saveAll(books));
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }
        return new ArrayList<>();
    }

    public List<Book> findAll() {
        return CollectionUtils.toList(repository.findAll());
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(Book book) {
        repository.delete(book);
    }

}
