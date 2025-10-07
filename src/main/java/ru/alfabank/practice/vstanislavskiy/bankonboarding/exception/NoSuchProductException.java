package ru.alfabank.practice.vstanislavskiy.bankonboarding.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class NoSuchProductException extends ApplicationException{
    public NoSuchProductException(String productID) {
        super("NO_SUCH_PRODUCT", "Product with ID = " + productID + " does not exist",
                Map.of("missingProductID", productID), HttpStatus.NOT_FOUND, null);
    }
}
