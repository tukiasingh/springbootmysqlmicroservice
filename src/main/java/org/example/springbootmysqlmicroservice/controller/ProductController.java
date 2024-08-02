package org.example.springbootmysqlmicroservice.controller;

import jakarta.websocket.server.PathParam;
import org.example.springbootmysqlmicroservice.model.Product;
import org.example.springbootmysqlmicroservice.model.Response;
import org.example.springbootmysqlmicroservice.repository.ProductRepository;
import org.example.springbootmysqlmicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(path="/add")
    public ResponseEntity<Response> addProduct(@RequestBody Product product) {
        return productService.addProduct(product);

    }



    @GetMapping(path="/list")
    public ResponseEntity<Response> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping(path="/update")
    public ResponseEntity<Response> updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping(path="/delete/{pid}")
    public ResponseEntity<Response> deleteProduct(@PathVariable("pid") Integer pid) {
        return productService.deleteProduct(pid);
    }





}
