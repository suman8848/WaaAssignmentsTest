package com.example.coffeeshop.controller;

import com.example.coffeeshop.domain.*;
import com.example.coffeeshop.service.OrderService;
import com.example.coffeeshop.service.PersonService;
import com.example.coffeeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value="product/{type}", method=RequestMethod.GET)
    public String findByProductType(@PathVariable("type") String type, Model model) {
        System.out.println("Hello I am here producttype");
        ProductType productType = ProductType.valueOf(type.toUpperCase());
        List<Product> products = productService.findByProductType(productType);
        model.addAttribute("products", products);
        return "userindex";
    }

    /*
    Listing products with the help of service
    and sending it to the view
     */
    @GetMapping({"/product/products"})
    public String listProduct(Model model) {

        model.addAttribute("products", productService.getAllProduct());
//        model.addAttribute("cartlist",mapping1FormObject);
        System.out.println(productService.getAllProduct());
        return "productList";
    }

    @GetMapping({"/product/addProduct"})
    public String addProduct(Product product) {
        return "addProduct";
    }

    @PostMapping({"product/addProduct"})
    public String addProduct(Model model, Product product,BindingResult bindingResult) {
        System.out.println("Add Prod+++" +product);
//        model.addAttribute("products",product);
        productService.save(product);
        return "redirect:/product/products";

    }

    @GetMapping({"/product/productDetail/{id}"})
    public String getProductDetail(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        return "productDetail";
    }

    @PutMapping({"/product/productDetail/{id}"})
    public String updateProduct(@PathVariable int id, Product productDetails){
        Product product= productService.getProduct(id);
        System.out.println(" i am in update "+id + "product" + product);
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setProductName(productDetails.getProductName());
        product.setProductType(productDetails.getProductType());
        productService.save(product);
        return "redirect:/product/products";
    }

    @PostMapping({"/product/deleteProduct/{id}"})
    public String deleteProduct(@PathVariable int id){
        Product product = productService.getProduct(id);
        System.out.println(" i am in delete "+id + "product" + product);
        productService.delete(product);
        return "redirect:/product/products";
    }


}
