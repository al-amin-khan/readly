package me.alaminkhan.readly.book;

import java.io.IOException;
import java.util.List;
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
  public void addBook(@RequestParam String title,  @RequestParam("cover") MultipartFile file)
      throws IOException {
    Book bookCoverImage = new Book();
    bookCoverImage.setCover(file.getBytes());
    bookService.uploadImageFile(bookCoverImage);
//    bookService.addBook(book);
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
