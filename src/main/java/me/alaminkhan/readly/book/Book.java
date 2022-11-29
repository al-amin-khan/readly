package me.alaminkhan.readly.book;

import com.sun.istack.NotNull;
import java.io.Serializable;
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
import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String title;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
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
}
