package ru.alfabank.practice.vstanislavskiy.bankonboarding.exception;

import org.springframework.http.HttpStatus;

public class DiscountOverException extends ApplicationException{
    public DiscountOverException(String discountID) {
        super("DISCOUNT_OVER", "Discount with ID = " + discountID + " is over",
                null, HttpStatus.NOT_FOUND, null);
    }
}