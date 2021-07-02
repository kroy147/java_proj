package in.ongrid.kshitijroy.service;

import in.ongrid.kshitijroy.model.dto.*;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserService {
    void userSignUpService(UserSignUpRequestDTO userSignUpRequestDTO);

    UserProfileResponseDTO viewProfile(Long id);

    void updateProfile(UserProfileUpdateRequestDTO userProfileUpdateRequestDTO, Long id);

    CartAddResponseDTO addToCart(Long id, CartAddRequestDTO cartAddRequestDTO);

    UserSignInResponseDTO UserSignIn(UserSignInRequestDTO userSignInRequestDTO);

    Long issue(Long id);

    CartAddResponseDTO getCart(Long id);


    List<ViewOrder> viewOrder(Long id);

    ReturnBookResponseDTO returnBook(Long userId,Long BookId);

    Integer cartInitialise(Long userId);


}
