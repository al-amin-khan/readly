package me.alaminkhan.readly.book;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
  @Autowired
  private BookService bookService;

  @RequestMapping("/books")
  public List<Book> getAllBooks(){
    return bookService.getAllTopics();
  }

  @RequestMapping("/books/{id}")
  public Optional<Book> getBook(@PathVariable Long id){
    return bookService.getTopic(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/books")
  public void addBook(@RequestBody Book book){
    bookService.addTopic(book);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
  public void updateBook(@RequestBody Book book, @PathVariable Long id){
    bookService.updateTopic(id, book);
  }
}
