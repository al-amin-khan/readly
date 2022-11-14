package me.alaminkhan.readly.book;

import com.sun.istack.NotNull;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Lob;
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
    private Long id;
    @NotNull
    private String title;
    @Lob
    private byte[] cover;
    private String author;
    private String genre;
    private Long isbn;
    private String rating;
    @Column(columnDefinition = "TEXT", length = Integer.MIN_VALUE)
    private String description;
    private Long pages;
    private Date publishedDate;
    private String language;

    public Book(Long bookId) {
        this.id = bookId;
    }
}
