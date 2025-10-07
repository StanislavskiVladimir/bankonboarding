package ru.alfabank.practice.vstanislavskiy.bankonboarding.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.exception.ApplicationException;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.exception.NoSuchProductException;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.mapper.ProductMapper;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.CalcRequest;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.CalcResponse;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.ItemDTO;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.entity.Product;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplList implements ProductService{
    private List<Product> products;
    @Autowired
    private ProductMapper productMapper;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product("1", "Телефон", 20000.0));
        products.add(new Product("2", "Ноутбук", 80000.0));
        products.add(new Product("3", "Телевизор", 120000.0));
        products.add(new Product("4", "Приставка", 50000.0));
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Optional<Product> getProduct(String id) {
        return products.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    @Override
    public CalcResponse getCalculateTotalSum(CalcRequest calcRequest) {
        List<ItemDTO> itemDTOList = calcRequest.getOrderList().stream().map(e->
        {
            Optional<Product> optionalProduct = this.getProduct(e.getId());
            if(optionalProduct.isEmpty()){
                throw new NoSuchProductException(e.getId());
            }
            ItemDTO itemDTO = productMapper.toDTO(optionalProduct.get());
            itemDTO.setNumber(e.getNumber());
            itemDTO.setTotalPrice(itemDTO.getPrice() * itemDTO.getNumber());
            return itemDTO;
        }).toList();
        return new CalcResponse(itemDTOList);
    }
}
