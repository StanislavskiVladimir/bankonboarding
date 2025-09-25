package ru.alfabank.practice.vstanislavskiy.bankonboarding.exception;

public class NoSuchProductException extends RuntimeException{
    private Object object;

    public NoSuchProductException(Object object, String message) {
        super(message);
        this.object = object;
    }

    public Object getObject() {
        return object;
    }
}
