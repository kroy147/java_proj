package in.ongrid.kshitijroy.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.*;

@Entity
public class User extends ResourceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "userCart",cascade = CascadeType.ALL)
    List<Cart> uCart;

    @OneToMany(mappedBy = "userOrder",cascade =CascadeType.ALL )
    List<Orders> userOrder= new ArrayList<>();

    @OneToMany(mappedBy = "userBook",cascade =CascadeType.ALL )
    List<BooksOrdered> userBooks= new ArrayList<>();

    public User(){

    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User( String name, String email, String password, Address address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Cart> getuCart() {
        return uCart;
    }

    public void setuCart(List<Cart> uCart) {
        this.uCart = uCart;
    }

    public List<Orders> getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(List<Orders> userOrder) {
        this.userOrder = userOrder;
    }

    public List<BooksOrdered> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(List<BooksOrdered> userBooks) {
        this.userBooks = userBooks;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
