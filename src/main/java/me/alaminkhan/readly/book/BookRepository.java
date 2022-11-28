package me.alaminkhan.readly.book;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

  Optional<Book> findBookById(Long id);
}
