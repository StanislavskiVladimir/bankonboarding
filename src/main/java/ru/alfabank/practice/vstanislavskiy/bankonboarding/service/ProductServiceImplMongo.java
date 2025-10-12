package ru.alfabank.practice.vstanislavskiy.bankonboarding.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.exception.*;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.mapper.ProductMapper;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.CalcRequest;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.CalcResponse;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.ItemDTO;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.entity.Discount;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.entity.Product;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.repository.DiscountRepo;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.repository.ProductRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplMongo implements ProductService {
    @Autowired
    public ProductRepo productRepo;
    @Autowired
    public ProductMapper productMapper;
    @Autowired
    private DiscountRepo discountRepo;

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
        List<Discount> discountList;
        if (calcRequest.getDiscountList() != null) {
            discountList = calcRequest.getDiscountList().stream().map(e -> {
                Optional<Discount> optionalDiscount = discountRepo.findById(e);
                if (optionalDiscount.isEmpty()) {
                    throw new NoSuchDiscountException(e);
                } else if (!optionalDiscount.map(Discount::getAvailable).orElse(false)) {
                    throw new DiscountOverException(e);
                }
                return optionalDiscount.get();
            }).toList();
        } else {
            discountList = new ArrayList<>();
        }

        List<ItemDTO> itemDTOList = calcRequest.getOrderList().stream().map(e -> {
            Optional<Product> optionalProduct = productRepo.findById(e.getId());
            if (optionalProduct.isEmpty()) {
                throw new NoSuchProductException(e.getId());
            } else if (!optionalProduct.map(Product::getAvailable).orElse(false)) {
                throw new ProductOutException(e.getId());
            }
            ItemDTO itemDTO = productMapper.toDTO(optionalProduct.get());
            itemDTO.setNumber(e.getNumber());
            calcPrice(itemDTO, optionalProduct.get(), discountList);
            return itemDTO;
        }).toList();
        return new CalcResponse(itemDTOList);
    }


    public void calcPrice(ItemDTO itemDTO, Product product, List<Discount> discountList) {
        double discountTotalPercent = 0;
//        for (Discount d : discountList) {
//            for (String s : d.getProductListID()) {
//                if (s.equals(product.getId())) {
//                    discountTotalPercent += d.getPercent();
//                }
//            }
//        }
        discountTotalPercent = discountList.stream().filter(e -> e.getProductListID().contains(product.getId())).mapToDouble(e -> e.getPercent()).sum();
        discountTotalPercent = Math.min(discountTotalPercent, 50.0);
        itemDTO.setTotalPrice(itemDTO.getPrice() * (100.0 - discountTotalPercent) / 100 * itemDTO.getNumber());
    }

}
