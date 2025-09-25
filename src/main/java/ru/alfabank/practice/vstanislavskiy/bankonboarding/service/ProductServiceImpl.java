package ru.alfabank.practice.vstanislavskiy.bankonboarding.service;

import org.springframework.stereotype.Service;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    List<Product> products;

    ProductServiceImpl(){
        products = new ArrayList<>();
        products.add(new Product(1, "Телефон", 20000));
        products.add(new Product(2, "Ноутбук", 80000));
        products.add(new Product(3, "Телевизор", 120000));
        products.add(new Product(4, "Приставка", 50000));
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Optional<Product> getProduct(int id) {
        return products.stream().filter(e -> e.getId()==id).findFirst();
    }
}
