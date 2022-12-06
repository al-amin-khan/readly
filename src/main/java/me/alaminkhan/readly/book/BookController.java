package me.alaminkhan.readly.book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")
@RestController
public class BookController {
  @Autowired
  private BookService bookService;

  @RequestMapping("/books")
  public List<Book> getAllBooks(){
    return bookService.getAllBooks();
  }

  @RequestMapping("/books/{id}")
  public Optional<Book> getBook(@PathVariable Long id){
    return bookService.getBook(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/books/add")
  public void addBook(@RequestParam Map<String, String> reqParam, @RequestParam("publishedDate") Date publishedDate, @RequestParam("cover") MultipartFile file)
      throws IOException, ParseException {
    Book book = new Book();
    book.setTitle(reqParam.get("title"));
    book.setAuthor(reqParam.get("author"));
    book.setGenre(reqParam.get("genre"));
    book.setIsbn(Long.parseLong(reqParam.get("isbn")));
    book.setRating(reqParam.get("rating"));
    book.setDescription(reqParam.get("description"));
    book.setPages(Long.parseLong(reqParam.get("pages")));
    book.setPublishedDate(publishedDate);
    book.setLanguage(reqParam.get("language"));
    book.setCoverPhotoName(file.getOriginalFilename());
    book.setCover(file.getBytes());


    Path absolutePath = Paths.get(".");
    Path path = Paths.get(absolutePath + "/photos/" + file.getOriginalFilename());
    Files.write(path, file.getBytes());
//    book.setCover(file.getOriginalFilename());

    bookService.addBook(book);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/books/update")
  public void updateBook(@RequestParam Map<String, String> reqParam, @RequestParam("publishedDate") Date publishedDate, @RequestParam("cover") MultipartFile file)
      throws IOException {
    Book updateBook = new Book();
    updateBook.setTitle(reqParam.get("title"));
    updateBook.setAuthor(reqParam.get("author"));
    updateBook.setGenre(reqParam.get("genre"));
    updateBook.setIsbn(Long.parseLong(reqParam.get("isbn")));
    updateBook.setRating(reqParam.get("rating"));
    updateBook.setDescription(reqParam.get("description"));
    updateBook.setPages(Long.parseLong(reqParam.get("pages")));
    updateBook.setPublishedDate(publishedDate);
    updateBook.setLanguage(reqParam.get("language"));
    updateBook.setCover(file.getBytes());
    bookService.updateBook(updateBook);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/books/delete/{id}")
  public void deleteBook( @PathVariable Long id){
    bookService.deleteBookById(id);
  }

}
