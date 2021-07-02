package in.ongrid.kshitijroy.model.entity;

import javax.persistence.*;

@Entity
public class Book extends ResourceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;


    @Column
    private String paperback;


    @Column(columnDefinition = "boolean default false")
    private boolean booked;

    @ManyToOne
    private BookTitle bookTitle;

    @OneToOne(cascade = CascadeType.ALL)
    private BooksOrdered booksOrder;


    public BooksOrdered getBookOrder() {

        return booksOrder;
    }

    public void setBookOrder(BooksOrdered booksOrder) {
        this.booksOrder = booksOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaperback() {
        return paperback;
    }

    public void setPaperback(String paperback) {
        this.paperback = paperback;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public BookTitle getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(BookTitle bookTitle) {
        this.bookTitle = bookTitle;
    }
}
