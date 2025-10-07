package ru.alfabank.practice.vstanislavskiy.bankonboarding.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.entity.Product;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.repository.ProductRepo;

import java.util.List;
import java.util.Random;

@Service

public class ScheduledTaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTaskService.class);

    @Autowired
    public ProductRepo productRepo;

    @Scheduled(fixedDelayString = "${scheduledTaskService.changeRandomProductAvailable.fixedDelay}", initialDelayString = "${scheduledTaskService.changeRandomProductAvailable.initialDelay}")

    public void changeRandomProductAvailable(){
        LOGGER.info("Start changeRandomProductAvailable");
        List<Product> productList = productRepo.findAll();
        int sizeProduct = productList.size();
        int numberRandom = new Random().nextInt(sizeProduct+1);
        for(int i = 0; i < numberRandom; i++){
            Product product = productList.get(new Random().nextInt(sizeProduct));
            product.setAvailable(!product.getAvailable());
            LOGGER.info("Product with id=" + product.getId() + " available changed " + !product.getAvailable() + "->"  + product.getAvailable());
            productRepo.save(product);
        }

        LOGGER.info("End changeRandomProductAvailable");
    }
}
