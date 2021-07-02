package in.ongrid.kshitijroy.model.dto;

import in.ongrid.kshitijroy.model.entity.BookTitle;

import java.util.List;

public class CartAddResponseDTO {
    private int cartCount;
    private List<CartInfo> bookTitleList;

    public int getCartCount() {
        return cartCount;
    }

    public void setCartCount(int cartCount) {
        this.cartCount = cartCount;
    }

    public List<CartInfo> getBookTitleList() {
        return bookTitleList;
    }

    public void setBookTitleList(List<CartInfo> bookTitleList) {
        this.bookTitleList = bookTitleList;
    }
}
