package ru.alfabank.practice.vstanislavskiy.bankonboarding.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.*;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.entity.Product;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.service.ProductService;


import java.util.Collections;
import java.util.List;
import java.util.Map;


@RestController
public class ShopController {

    @Autowired
    @Qualifier("productServiceImplMongo")
    private ProductService productService;


    @GetMapping("/welcome")
    public Map<String, String> getWelcome() {
        return Collections.singletonMap("message", "Добро пожаловать в наш чудесный магазин");
    }

    @GetMapping("/product")
    public ProductResponse getProducts() {
        return new ProductResponse(productService.getProducts());
    }

    @PostMapping("/calc")
    public CalcResponse getCalculateTotalSum(@RequestBody CalcRequest calcRequest) {
        return productService.getCalculateTotalSum(calcRequest);
    }

}
