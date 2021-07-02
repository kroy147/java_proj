package in.ongrid.kshitijroy.service;

import in.ongrid.kshitijroy.dao.CategoryRepo;
import in.ongrid.kshitijroy.model.dto.CategoryResponseDTO;
import in.ongrid.kshitijroy.model.entity.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public CategoryResponseDTO viewCategory(){
        CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();
        List<BookCategory> temp=categoryRepo.findAll();
        categoryResponseDTO.setCategories(temp);
        return categoryResponseDTO;
    }
}
