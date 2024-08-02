package org.example.springbootmysqlmicroservice.model;

import java.util.List;

public class Response {
    private Integer code;
    private String message;
    List<Product> productList;

    public Response() {};

    public Response(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(Integer code, String message, List<Product> productList) {
        this.code = code;
        this.message = message;
        this.productList = productList;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", productList=" + productList +
                '}';
    }
}
