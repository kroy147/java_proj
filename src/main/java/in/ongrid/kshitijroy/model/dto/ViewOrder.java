package in.ongrid.kshitijroy.model.dto;

import java.util.Date;

public class ViewOrder {
    public Long bookId;
    public String bookName;
    public Date issueDate;
    public Date returnDate;

    public ViewOrder(Long bookId, String bookName, Date issueDate, Date returnDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }
}
