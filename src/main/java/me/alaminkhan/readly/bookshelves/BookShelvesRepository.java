package me.alaminkhan.readly.bookshelves;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BookShelvesRepository extends CrudRepository<BookShelves, Long> {
  public List<BookShelves> findByBookId(Long bookId);
}
