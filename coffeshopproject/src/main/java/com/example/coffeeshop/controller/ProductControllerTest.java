//package com.example.coffeeshop.controller;
//
//import com.example.coffeeshop.domain.Product;
//import com.example.coffeeshop.domain.ProductType;
//import com.example.coffeeshop.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.List;
//@Controller
//@RequestMapping("/product")
//public class ProductControllerTest {
//
//    @Autowired
//    ProductService productService;
//
//    @RequestMapping(value="/type/{type}", method= RequestMethod.GET)
//    public String findByProductType(@PathVariable("type") String type, Model model) {
//        System.out.println("Hello I am here producttype");
//        ProductType productType = ProductType.valueOf(type.toUpperCase());
//        List<Product> products = productService.findByProductType(productType);
//        model.addAttribute("products", products);
//        return "userindex";
//    }
//}
