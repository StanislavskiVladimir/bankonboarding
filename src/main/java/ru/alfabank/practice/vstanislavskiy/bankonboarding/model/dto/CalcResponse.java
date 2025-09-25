package ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto;

import java.util.List;

public class CalcResponse {
    private List<ProductDTO> productDTO;
    private Double sum;

    public List<ProductDTO> getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(List<ProductDTO> productDTO) {
        this.productDTO = productDTO;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
