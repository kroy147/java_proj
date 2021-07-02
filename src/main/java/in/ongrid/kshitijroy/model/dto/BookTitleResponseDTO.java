package in.ongrid.kshitijroy.model.dto;

public class BookTitleResponseDTO {
    private Long id;
    private String bookName;
    private String authorName;
    private String bookCover;
    private int available;
    private String categoryName;

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BookTitleResponseDTO(Long id, String bookName, String authorName, String bookCover, int available,
                                String categoryName) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookCover = bookCover;
        this.available = available;
        this.categoryName = categoryName;
    }
}
