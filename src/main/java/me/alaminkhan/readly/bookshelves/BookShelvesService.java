package me.alaminkhan.readly.bookshelves;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import me.alaminkhan.readly.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookShelvesService {
  @Autowired
  BookShelvesRepository bookShelvesRepository;

  public List<BookShelves> getAllBooksFromShelves(Long bookId){
    List<BookShelves> bookListFromShelves = new ArrayList<>();
    bookShelvesRepository.findByBookId(bookId).forEach(bookListFromShelves::add);
    return bookListFromShelves;
  }

  public Optional<BookShelves> getBookFromShelves(Long id){
    return bookShelvesRepository.findById(id);
  }

  public void addBookToShelves(BookShelves bookShelves){
    bookShelvesRepository.save(bookShelves);
  }

  public void updateBookToShelves(BookShelves bookShelves){
    bookShelvesRepository.save(bookShelves);
  }

  public void deleteBookFromShelves(Long id) {
    bookShelvesRepository.deleteById(id);
  }

}
