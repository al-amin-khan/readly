package me.alaminkhan.readly.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  @Autowired
  private BookRepository bookRepository;

  public List<Book> getAllTopics(){
    List<Book> books = new ArrayList<>();
    bookRepository.findAll().forEach(books::add);
    return books;
  }

  public Optional<Book> getTopic(Long id){
    return bookRepository.findById(id);
  }

  public void addTopic(Book book) {
    bookRepository.save(book);
  }

  public void updateTopic(Long id, Book book) {
    bookRepository.save(book);
  }

  public void deleteTopic(Long id) {
    bookRepository.deleteById(id);
  }
}
