package ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto;



public class OrderDTO {
    private String id;
    private Integer number;

    public OrderDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
