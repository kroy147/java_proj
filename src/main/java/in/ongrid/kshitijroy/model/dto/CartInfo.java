package in.ongrid.kshitijroy.model.dto;

public class CartInfo {
    private Long BookTitleId;
    private String bookName;

    public Long getBookTitleId() {
        return BookTitleId;
    }

    public void setBookTitleId(Long bookTitleId) {
        BookTitleId = bookTitleId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public CartInfo(Long bookTitleId, String bookName) {
        BookTitleId = bookTitleId;
        this.bookName = bookName;
    }
}
