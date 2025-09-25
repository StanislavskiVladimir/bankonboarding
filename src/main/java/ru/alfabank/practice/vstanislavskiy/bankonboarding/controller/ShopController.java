package ru.alfabank.practice.vstanislavskiy.bankonboarding.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.exception.NoSuchProductException;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.mapper.ProductMapper;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.CalcResponse;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.ProductDTO;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.entity.Product;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.service.ProductService;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class ShopController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/welcome")
    public Map<String,String> getWelcome(){
        return Collections.singletonMap("message", "Добро пожаловать в наш чудесный магазин");
    }

    @GetMapping("/product")
    public List<Product> getProducts(){
        return productService.getProducts() ;
    }

    @PostMapping("/calc")
    public CalcResponse getProductTotalPrice(@RequestBody List<ProductDTO> productRequest){
        List<ProductDTO> productDTOS = productRequest.stream().map(e->{
            Optional<Product> optionalProduct = productService.getProduct(e.getId());
            if(optionalProduct.isEmpty()){
                throw new NoSuchProductException(e,"Product with ID = " + e.getId() + " does not exist");
            }
            ProductDTO productDTO = productMapper.toDTO(optionalProduct.get());
            productDTO.setId(0);
            productDTO.setNumber(e.getNumber());
            productDTO.setTotalPrice(productDTO.getPrice()*productDTO.getNumber());
            return productDTO;
        }).toList();
        CalcResponse calcResponse = new CalcResponse();
        calcResponse.setProductDTO(productDTOS);
        calcResponse.setSum(productDTOS.stream().mapToDouble(e->e.getNumber()).sum());
        return calcResponse;
    }

}
