package ru.alfabank.practice.vstanislavskiy.bankonboarding.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class ProductOutException extends ApplicationException{
    public ProductOutException(String productID) {
        super("PRODUCT_OUT_OF_STOCK", "Product with ID = " + productID + " is out of stock",
                null, HttpStatus.NOT_FOUND, null);
    }
}
