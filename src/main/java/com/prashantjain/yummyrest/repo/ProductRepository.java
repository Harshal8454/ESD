package com.prashantjain.yummyrest.repo;

import com.prashantjain.yummyrest.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

    Products findByProductName(String productName);


    @Query("SELECT p FROM Products p WHERE p.price BETWEEN :low AND :high ORDER BY p.price ASC")
    List<Products> findTop2ByPriceBetweenOrderByPriceAsc(@Param("low") String low, @Param("high") String high);
}