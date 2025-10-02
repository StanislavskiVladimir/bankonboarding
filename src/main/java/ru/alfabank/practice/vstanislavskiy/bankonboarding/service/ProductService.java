package ru.alfabank.practice.vstanislavskiy.bankonboarding.service;

import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.CalcRequest;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.CalcResponse;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> getProducts();
    public Optional<Product> getProduct(String id);
    public CalcResponse getCalculateTotalSum(CalcRequest calcRequest);
}
