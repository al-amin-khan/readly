package me.alaminkhan.readly.book;

import java.io.IOException;
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

  @RequestMapping(method = RequestMethod.POST, value = "/books")
  public void addBook(@RequestParam Map<String, String> reqParam,  @RequestParam("cover") MultipartFile file)
      throws IOException, ParseException {
    Book book = new Book();
    book.setTitle(reqParam.get("title"));
    book.setAuthor(reqParam.get("author"));
    book.setGenre(reqParam.get("genre"));
    book.setIsbn(Long.parseLong(reqParam.get("isbn")));
    book.setRating(reqParam.get("rating"));
    book.setDescription(reqParam.get("description"));
    book.setPages(Long.parseLong(reqParam.get("pages")));

    String date = reqParam.get("publishedDate");
    Date publishedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
    book.setPublishedDate(publishedDate);
    book.setLanguage(reqParam.get("language"));
    book.setCover(file.getBytes());
//    bookService.uploadImageFile(bookCoverImage);
    bookService.addBook(book);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/books/saveImage")
  public void uploadImage(@RequestParam("cover") MultipartFile file) throws IOException {
    Book bookCoverImage = new Book();
    bookCoverImage.setCover(file.getBytes());
    bookService.uploadImageFile(bookCoverImage);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/books/update")
  public void updateBook(@RequestBody Book book){
    bookService.updateBook(book);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/books/{id}")
  public void deleteBook( @PathVariable Long id){
    bookService.deleteBookById(id);
  }



}
