package com.prashantjain.yummyrest.controller;

import com.prashantjain.yummyrest.dto.ProductsRequest;
import com.prashantjain.yummyrest.entity.Products;
import com.prashantjain.yummyrest.service.ProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    private ProductsService productsService;

    public ProductsController(ProductsService productService) {
        this.productsService = productService;
    }

    @PostMapping("/")
    public ResponseEntity<String> addProduct(@RequestBody ProductsRequest product) {
        return ResponseEntity.ok(productsService.addProduct(product));
    }


    // Read Product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long id) {
        Products product = productsService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    // Read Product by Name
    @GetMapping("/name/{name}")
    public ResponseEntity<Products> getProductByName(@PathVariable String name) {
        Products product = productsService.getProductByName(name);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    // Read All Products
    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = productsService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // Update Product
    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable Long id, @RequestBody Products updatedProduct) {
        Products product = productsService.updateProduct(id, updatedProduct);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    // Delete Product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productsService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/products/{low}/{high}")
    public ResponseEntity<String> getProducts(@PathVariable String low, @PathVariable String high) {
        return ResponseEntity.ok(productsService.getProductsWithPriceRange(low,high));
    }
}