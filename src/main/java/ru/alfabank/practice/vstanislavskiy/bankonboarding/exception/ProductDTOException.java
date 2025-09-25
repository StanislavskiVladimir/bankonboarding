package ru.alfabank.practice.vstanislavskiy.bankonboarding.exception;


import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.ProductDTO;

public class ProductDTOException {
    private ProductDTO productDTO;
    private String info;

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
