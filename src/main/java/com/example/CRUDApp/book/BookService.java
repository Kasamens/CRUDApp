package com.example.CRUDApp.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> getBooks(){
        return repository.findAll();
    }

    public Book getBookById(Long id){

        if(!repository.existsById(id)){
            throw new IllegalStateException("Not found");
        }

        return repository.findById(id).get();

    }

    public void addBook(Book book){
        repository.save(book);
    }

    @Transactional
    public void updateBook(Long id, String author, String title ){

        Book updateBook = repository.findById(id)
                        .orElseThrow( () -> new IllegalStateException("Book not found"));

        if(title != null && title.length() > 0 && !Objects.equals(updateBook.getTitle(),title)){
            updateBook.setTitle(title);
        }

        if(author != null && author.length() > 0 && !Objects.equals(updateBook.getAuthor(),author)){
            updateBook.setAuthor(author);
        }

    }

    public void deleteByID(Long id){
        if(!repository.existsById(id)){
            throw new IllegalStateException("Book not found");
        }
        repository.deleteById(id);
    }

}
