package in.ongrid.kshitijroy.controller;


import in.ongrid.kshitijroy.model.dto.BaseResponse;
import in.ongrid.kshitijroy.model.dto.BookFilterResponseDTO;
import in.ongrid.kshitijroy.model.dto.BookTitleResponseDTO;
import in.ongrid.kshitijroy.service.BookTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booktitle")
public class BookTitleController {

    @Autowired
    BookTitleService bookTitleServiceInterface;

    @GetMapping("/{id}")
    public BaseResponse<BookTitleResponseDTO> getBookInfo(@PathVariable Long id) {
        return new BaseResponse<>(HttpStatus.OK.value(),
                "Success",bookTitleServiceInterface.getBookInfo(id));
    }

    @GetMapping("")
    public BaseResponse<BookFilterResponseDTO> searchBook(@RequestParam(name = "category") Long id,
                                                         @RequestParam(name = "name") String key) {
        return new BaseResponse<>(HttpStatus.OK.value(),"Success",
                bookTitleServiceInterface.searchBook(id ,key));
    }
}
