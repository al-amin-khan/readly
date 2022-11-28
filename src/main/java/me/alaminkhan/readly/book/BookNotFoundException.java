package me.alaminkhan.readly.book;

public class BookNotFoundException extends RuntimeException{
  public BookNotFoundException(String message) {
    super(message);
  }
}
