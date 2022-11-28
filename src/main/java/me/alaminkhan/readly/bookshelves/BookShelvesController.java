package me.alaminkhan.readly.bookshelves;

import java.util.List;
import java.util.Optional;
import me.alaminkhan.readly.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookShelvesController {
  @Autowired
  private BookShelvesService bookShelvesService;

  @RequestMapping("/mybooks")
  public List<BookShelves> getAllCourses(Long bookId){
    return bookShelvesService.getAllBooksFromShelves(bookId);
  }

  @RequestMapping("/mybooks/{id}")
  public Optional<BookShelves> getCourse(@PathVariable Long id){
    return bookShelvesService.getBookFromShelves(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/mybooks")
  public void addBookToShelves(@RequestBody BookShelves bookShelves){
    bookShelves.setBook(new Book());
    bookShelvesService.addBookToShelves(bookShelves);
  }
}
