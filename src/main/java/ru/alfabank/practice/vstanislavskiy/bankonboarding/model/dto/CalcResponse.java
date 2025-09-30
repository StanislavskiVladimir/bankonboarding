package ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto;

import java.util.List;

public class CalcResponse {
    private List<ItemDTO> itemList;
    private Double totalSum;

    public CalcResponse() {
    }

    public CalcResponse(List<ItemDTO> itemList) {
        this.itemList = itemList;
        this.totalSum = itemList.stream().mapToDouble(e->e.getTotalPrice()).sum();
    }

    public List<ItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemDTO> itemList) {
        this.itemList = itemList;
    }

    public Double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Double totalSum) {
        this.totalSum = totalSum;
    }
}
