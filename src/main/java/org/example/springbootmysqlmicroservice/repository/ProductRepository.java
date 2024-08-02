package org.example.springbootmysqlmicroservice.repository;


import org.example.springbootmysqlmicroservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    //We can add Abstract class methods

//    @Query("select p from product where p.price>:price")
//    public List<Product> findByPrice(@Param("price") double price);
}
