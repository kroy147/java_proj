package in.ongrid.kshitijroy.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BooksOrdered extends ResourceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="orders_id")
    private Orders ordersInfo;

    @ManyToOne
    private User userBook;

    @OneToOne(mappedBy="booksOrder")
    @JoinColumn(name = "book_id")
    private Book bookBought;

    @Column
    public Date returnDate;

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orders getOrdersInfo() {
        return ordersInfo;
    }

    public void setOrdersInfo(Orders ordersInfo) {
        this.ordersInfo = ordersInfo;
    }

    public User getUserBook() {
        return userBook;
    }

    public void setUserBook(User userBook) {
        this.userBook = userBook;
    }

    public Book getBookBought() {
        return bookBought;
    }

    public void setBookBought(Book bookBought) {
        this.bookBought = bookBought;
    }
}
