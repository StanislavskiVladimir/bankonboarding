package ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto;

import java.util.List;

public class CalcRequest {
    private List<OrderDTO> orderList;
    private List<String> discountList;

    public CalcRequest() {
    }

    public List<OrderDTO> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderDTO> orderList) {
        this.orderList = orderList;
    }

    public List<String> getDiscountList() {
        return discountList;
    }

    public void setDiscountList(List<String> discountList) {
        this.discountList = discountList;
    }
}
