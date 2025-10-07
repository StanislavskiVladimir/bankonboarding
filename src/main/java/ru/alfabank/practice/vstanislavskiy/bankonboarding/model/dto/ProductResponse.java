package ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto;

import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.entity.Product;

import java.util.List;

public class ProductResponse {
    private List<Product> productList;

    public ProductResponse(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
