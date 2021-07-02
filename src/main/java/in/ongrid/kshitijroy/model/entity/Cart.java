package in.ongrid.kshitijroy.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;
@Entity
public class Cart extends ResourceInfo {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "boolean default false")
    private boolean purchased;

    @ManyToOne
    private User userCart;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "cart_book_title",joinColumns = @JoinColumn(name = "cart_id"),inverseJoinColumns = @JoinColumn(name = "book_title_id"))
    List<BookTitle> bookTitleList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public User getUserCart() {
        return userCart;
    }

    public void setUserCart(User userCart) {
        this.userCart = userCart;
    }

    public List<BookTitle> getBookTitleList() {
        return bookTitleList;
    }

    public void setBookTitleList(List<BookTitle> bookTitleList) {
        this.bookTitleList = bookTitleList;
    }

}
