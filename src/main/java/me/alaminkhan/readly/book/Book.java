package me.alaminkhan.readly.book;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotNull
    String title;
    String author;
    String genre;
    Long isbn;
    String rating;
    @Column(columnDefinition = "TEXT")
    String description;
    Long pages;
    Date publishedDate;
    String language;
}
