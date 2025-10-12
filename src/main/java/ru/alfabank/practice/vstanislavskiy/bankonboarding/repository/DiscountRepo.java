package ru.alfabank.practice.vstanislavskiy.bankonboarding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.entity.Discount;

public interface DiscountRepo extends MongoRepository<Discount, String> {
}
