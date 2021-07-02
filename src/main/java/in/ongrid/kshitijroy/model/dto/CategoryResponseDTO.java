package in.ongrid.kshitijroy.model.dto;

import in.ongrid.kshitijroy.model.entity.BookCategory;

import java.util.*;

public class CategoryResponseDTO {
    private List<BookCategory> categories;

    public List<BookCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<BookCategory> categories) {
        this.categories = categories;
    }
}
