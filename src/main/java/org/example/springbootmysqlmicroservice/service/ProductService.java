package org.example.springbootmysqlmicroservice.service;

import org.example.springbootmysqlmicroservice.model.Product;
import org.example.springbootmysqlmicroservice.model.Response;
import org.example.springbootmysqlmicroservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public ResponseEntity<Response> getAllProducts() {
        try {
            List<Product> products = productRepository.findAll();
            String message = "Products ["+ products.size() + "] Fetched successfully";
            Integer code = 101;
            Response response = new Response(code, message, products);
            return new ResponseEntity<Response>(response, HttpStatus.OK);

        } catch (Exception exception) {
            String message = "Product list cannot be Fetched Successfully. Something went Wrong! Exception: " + exception.getMessage();
            Integer code = 401;
            Response response = new Response(code, message);
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    public ResponseEntity<Response> addProduct(Product product) {
        try {
            Product newProduct = new Product();
            newProduct.setName(product.getName());
            newProduct.setPrice(product.getPrice());
            newProduct.setBrandName(product.getBrandName());
            productRepository.save(newProduct);
            String message = "Product"+ product + " added successfully";
            Integer code = 101;
            Response response = new Response(code, message);
            return new ResponseEntity<Response>(response, HttpStatus.OK);

        } catch (Exception exception) {
            String message = "Product"+ product + " NOT added successfully. Something went Wrong! Exception: " + exception.getMessage();
            Integer code = 401;
            Response response = new Response(code, message);
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    public ResponseEntity<Response> updateProduct(Product product) {

        String message = "";
        int code = 401;
        try {
            Optional<Product> result = productRepository.findById(product.getPid());
            if (result.isPresent()) {
                Product p = result.get();
                p.setName(product.getName());
                p.setBrandName(product.getBrandName());
                p.setPrice(product.getPrice());
                productRepository.save(p);
                message = "Product"+ product + " updated successfully";
                code = 101;
            } else {
                message = "Product Not Found";
                code = 404;

            }
            Response response = new Response(code, message);
            return new ResponseEntity<Response>(response, HttpStatus.OK);

        } catch (Exception exception) {
            message = "Something went Wrong! Exception: " + exception.getMessage();
            code = 501;
            Response response = new Response(code, message);
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    public ResponseEntity<Response> deleteProduct(int pid) {

        String message = "";
        int code = 401;
        try {
            Optional<Product> result = productRepository.findById(pid);
            if (result.isPresent()) {
                productRepository.deleteById(pid);
                message = "Product deleted successfully";
                code = 200;
            } else {
                message = "Product Not Found";
                code = 404;

            }
            Response response = new Response(code, message);
            return new ResponseEntity<Response>(response, HttpStatus.OK);

        } catch (Exception exception) {
            message = "Something went Wrong! Exception: " + exception.getMessage();
            code = 501;
            Response response = new Response(code, message);
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


//    public ResponseEntity<Response> findByPrice (double price) {
//        String message = "";
//        int code = 401;
//        try {
//            List<Product> products = productRepository.findByPrice(price);
//            message = "Product fetched successfully";
//            code = 200;
//            Response response = new Response(code, message, products);
//            return new ResponseEntity<Response>(response, HttpStatus.OK);
//
//        } catch (Exception exception) {
//            message = "Something went Wrong! Exception: " + exception.getMessage();
//            code = 501;
//            Response response = new Response(code, message);
//            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//
//        }

//    }


}
