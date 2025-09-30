package ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto;

import java.util.List;

public class CalcRequest {
    private List<OrderDTO> orderList;

    public CalcRequest() {
    }

    public List<OrderDTO> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderDTO> orderList) {
        this.orderList = orderList;
    }

}
