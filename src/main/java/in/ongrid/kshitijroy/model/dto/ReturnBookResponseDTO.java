package in.ongrid.kshitijroy.model.dto;

import java.util.Date;

public class ReturnBookResponseDTO {
    private Long bookId;
    private Date returnDate;
    private Long cost;

    public ReturnBookResponseDTO(Long bookId, Date returnDate, Long cost) {
        this.bookId = bookId;
        this.returnDate = returnDate;
        this.cost = cost;
    }
}
