package in.ongrid.kshitijroy.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class BookTitle extends ResourceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String bookName;

    @Column
    private String authorName;

    @Column
    private String bookCover;

    @Column
    private int available;

    @JsonIgnore
    @ManyToOne
    private BookCategory bookCategory;


    @JsonIgnore
    @OneToMany(mappedBy = "bookTitle",cascade = CascadeType.ALL)
    List<Book> book;

    @JsonIgnore
    @ManyToMany
    List<Cart> carts;

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts( List<Cart> carts) {
        this.carts = carts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }





}
