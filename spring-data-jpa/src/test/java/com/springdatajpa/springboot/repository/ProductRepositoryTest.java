package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        //Create Product
        Product product = new Product();
        product.setName("Product 1");
        product.setDescription("Product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("Product1.png");

        //Save Product
        Product savedProduct = productRepository.save(product);

        //Display Product info
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct.toString());

    }

    @Test
    void updateUsingSaveMethod(){

        // find or retrieve an entity by id
        long id = 1L;
        Product product = productRepository.findById(id).get();

        // update entity information
        product.setName("Updated product 1..");
        product.setDescription("Updated product 1 description");

        //save updated entity
        productRepository.save(product);
    }

    @Test
    void findById(){

        Long id = 1L;

        Product product = productRepository.findById(id).get();
    }

    @Test
    void saveAll(){

        //Create Product
        Product product = new Product();
        product.setName("Product 2");
        product.setDescription("Product 2 description");
        product.setSku("100AC");
        product.setPrice(new BigDecimal(200));
        product.setActive(true);
        product.setImageUrl("Product2.png");

        //Create Product
        Product product3 = new Product();
        product3.setName("Product 3");
        product3.setDescription("Product 3 description");
        product3.setSku("100ABCD");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);
        product3.setImageUrl("Product3.png");

        productRepository.saveAll(List.of(product, product3));
    }

    @Test
    void findAllMethod(){

        List<Product> products = productRepository.findAll();

        products.forEach((p) -> {
            System.out.println(p.getId() + " " + p.getName());
        });
    }

    @Test
    void deleteByIdMethod(){

        Long id = 1L;

        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){

        // Find an entity by id
        Long id = 2L;
        Product product = productRepository.findById(id).get();

        // delete(entity)
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod(){

//        productRepository.deleteAll();

        Product p1 = productRepository.getById(5L);

        Product p2 = productRepository.getById(6L);

        productRepository.deleteAll(List.of(p1, p2));
    }

    @Test
    void countMethod(){

        long count = productRepository.count();
        System.out.println("Number of Records : " + count);
    }
}