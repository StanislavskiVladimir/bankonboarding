package ru.alfabank.practice.vstanislavskiy.bankonboarding.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class NoSuchDiscountException extends ApplicationException{
    public NoSuchDiscountException(String discountID) {
        super("NO_SUCH_DISCOUNT", "Discount with ID = " + discountID + " does not exist",
                Map.of("missingDiscountID", discountID), HttpStatus.NOT_FOUND, null);
    }
}