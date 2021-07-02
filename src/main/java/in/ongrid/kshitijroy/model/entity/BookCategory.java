package in.ongrid.kshitijroy.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.*;

@Entity
public class BookCategory extends ResourceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;


    @JsonIgnore
    @OneToMany(mappedBy = "bookCategory",cascade=CascadeType.ALL)
    List<BookTitle> bookTitle= new ArrayList<BookTitle>();



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

    public List<BookTitle> getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(List<BookTitle> bookTitle) {
        this.bookTitle = bookTitle;
    }


}
