package ru.alfabank.practice.vstanislavskiy.bankonboarding.service;

import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> getProducts();
    public Optional<Product> getProduct(int id);
}
