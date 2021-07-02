package in.ongrid.kshitijroy.service;

import in.ongrid.kshitijroy.model.dto.BookFilterResponseDTO;
import in.ongrid.kshitijroy.model.dto.BookTitleResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface BookTitleService {
    BookTitleResponseDTO getBookInfo(Long id);
    BookFilterResponseDTO searchBook(Long id,String key);


}
