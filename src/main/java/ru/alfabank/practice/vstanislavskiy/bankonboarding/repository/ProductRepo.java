package ru.alfabank.practice.vstanislavskiy.bankonboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.entity.Product;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepo extends MongoRepository<Product, String> {
    List<Product> findAll();
    List<Product> findAllByAvailableIsTrue();
    Optional<Product> findById(String id);
    Product save(Product product);
}
