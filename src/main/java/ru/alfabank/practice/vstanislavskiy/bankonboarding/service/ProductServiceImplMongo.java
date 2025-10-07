package ru.alfabank.practice.vstanislavskiy.bankonboarding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.exception.ApplicationException;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.exception.NoSuchProductException;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.exception.ProductOutException;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.mapper.ProductMapper;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.CalcRequest;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.CalcResponse;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.ItemDTO;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.entity.Product;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.repository.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplMongo implements ProductService {
    @Autowired
    public ProductRepo productRepo;
    @Autowired
    public ProductMapper productMapper;

    @Override
    public List<Product> getProducts() {
        return productRepo.findAllByAvailableIsTrue();
    }

    @Override
    public Optional<Product> getProduct(String id) {
        return productRepo.findById(id);
    }

    @Override
    public CalcResponse getCalculateTotalSum(CalcRequest calcRequest) {
        List<ItemDTO> itemDTOList = calcRequest.getOrderList().stream().map(e -> {
            Optional<Product> optionalProduct = productRepo.findById(e.getId());
            if (optionalProduct.isEmpty()) {
                throw new NoSuchProductException(e.getId());
            } else if (!optionalProduct.map(Product::getAvailable).orElse(false)) {
                throw new ProductOutException(e.getId());
            }
            ItemDTO itemDTO = productMapper.toDTO(optionalProduct.get());
            itemDTO.setNumber(e.getNumber());
            itemDTO.setTotalPrice(itemDTO.getPrice() * itemDTO.getNumber());
            return itemDTO;
        }).toList();
        return new CalcResponse(itemDTOList);
    }


}
