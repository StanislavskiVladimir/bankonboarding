package ru.alfabank.practice.vstanislavskiy.bankonboarding.mapper;

import org.springframework.stereotype.Service;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.ProductDTO;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.entity.Product;

@Service
public class ProductMapper {

    public ProductDTO toDTO(Product entity){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(entity.getId());
        productDTO.setName(entity.getName());
        productDTO.setPrice(entity.getPrice());
        return productDTO;
    }

    public Product toEntity(ProductDTO dto){
        Product productEntity = new Product();
        productEntity.setId(dto.getId());
        productEntity.setName(dto.getName());
        productEntity.setPrice(dto.getPrice());
        return productEntity;
    }
}
