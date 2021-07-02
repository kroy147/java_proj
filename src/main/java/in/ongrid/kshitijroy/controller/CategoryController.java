package in.ongrid.kshitijroy.controller;

import in.ongrid.kshitijroy.model.dto.BaseResponse;
import in.ongrid.kshitijroy.model.dto.CategoryResponseDTO;
import in.ongrid.kshitijroy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryServiceInterface;

    @GetMapping("/category")
    public BaseResponse<CategoryResponseDTO> viewCategories(){
       return new BaseResponse<>(HttpStatus.OK.value(), "Success",categoryServiceInterface.viewCategory());
    }
}
