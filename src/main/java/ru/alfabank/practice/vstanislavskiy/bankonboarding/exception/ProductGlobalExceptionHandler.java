package ru.alfabank.practice.vstanislavskiy.bankonboarding.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.ProductDTO;

@ControllerAdvice
public class ProductGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ProductDTOException> handleException(NoSuchProductException exception) {
        ProductDTOException productException = new ProductDTOException();
        productException.setInfo(exception.getMessage());
        productException.setProductDTO(((ProductDTO) exception.getObject()));
        return new ResponseEntity<>(productException, HttpStatus.BAD_REQUEST);
    }
}
