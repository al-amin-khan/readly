package me.alaminkhan.readly.bookshelves;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.alaminkhan.readly.book.Book;

@Entity
@Table(name = "bookshelves")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookShelves {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Date addedDate;
  private Date startDate;
  private Date finishedDate;
  private Long readingStatus;
  @Column(columnDefinition = "TEXT")
  private String remarks;
  @ManyToOne
  private Book book;

}
