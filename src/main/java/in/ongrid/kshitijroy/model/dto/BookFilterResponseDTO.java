package in.ongrid.kshitijroy.model.dto;

import in.ongrid.kshitijroy.model.entity.BookTitle;

import java.util.List;

public class BookFilterResponseDTO {
    List<BookTitle> bookTitleList;

    public List<BookTitle> getBookTitleList() {
        return bookTitleList;
    }

    public void setBookTitleList(List<BookTitle> bookTitleList) {
        this.bookTitleList = bookTitleList;
    }

    public BookFilterResponseDTO(List<BookTitle> bookTitleList) {
        this.bookTitleList = bookTitleList;
    }
}
