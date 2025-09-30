package ru.alfabank.practice.vstanislavskiy.bankonboarding.mapper;

import org.springframework.stereotype.Service;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.ItemDTO;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.entity.Product;

@Service
public class ProductMapper {

    public ItemDTO toDTO(Product productEntity){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setName(productEntity.getName());
        itemDTO.setPrice(productEntity.getPrice());
        return itemDTO;
    }

}
