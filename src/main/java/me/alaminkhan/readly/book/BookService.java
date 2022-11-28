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

  public List<Book> getAllBooks(){
    List<Book> books = new ArrayList<>();
    bookRepository.findAll().forEach(books::add);
    return books;
  }

  public Book findBookById(Long id) {
    return bookRepository.findBookById(id)
        .orElseThrow(() -> new BookNotFoundException("Book by id " + id + " was not found"));
  }

  public Optional<Book> getBook(Long id){
    return bookRepository.findById(id);
  }

  public void addBook(Book book) {
    bookRepository.save(book);
  }

  public void updateBook(Long id, Book book) {
    bookRepository.save(book);
  }

  public void deleteBookById(Long id) {
    bookRepository.deleteById(id);
  }
}
