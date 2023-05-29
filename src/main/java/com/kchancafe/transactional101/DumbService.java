package com.kchancafe.transactional101;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DumbService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookService bookService;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void save(Author author, String title) {
        Author save = authorRepository.save(author);
        bookService.save(new Book(title, save.getId()));
    }

//    private void saveBook(Book book) {
//        if (book != null) {
//            throw new RuntimeException("boom!");
//        }
//        bookRepository.save(book);
//    }
}
