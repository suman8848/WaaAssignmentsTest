package com.example.coffeeshop.controller;

import com.example.coffeeshop.domain.Order;
import com.example.coffeeshop.domain.Orderline;
import com.example.coffeeshop.domain.Person;
import com.example.coffeeshop.domain.Product;
import com.example.coffeeshop.service.OrderService;
import com.example.coffeeshop.service.PersonService;
import com.example.coffeeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    PersonService personService;
    @Autowired
    ProductService productService;


    @GetMapping("/order/orders")
    public String getOrders(Model model) {
//        System.out.println("Id+++"+id);
        model.addAttribute("orders", orderService.findAll());
        System.out.println(orderService.findAll());
        return "orderList";
    }


    @PostMapping("/order/addToCart/{id}")
    public String addOrder(@PathVariable int id, RedirectAttributes redirectAttributes, Order order, Product product) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        System.out.println("Order "+ order);
        order.setOrderDate(date);
//        Person p =personService.findByEmail("suman");
//        order.setPerson(p);

        Orderline orderline = new Orderline();
        orderline.setQuantity(2);
        orderline.setOrder(order);
        Product pro =productService.getProduct(id);
        orderline.setProduct(pro);
        order.addOrderLine(orderline);
        System.out.println("ORDERCA++++"+order);
        orderService.save(order);
        return "redirect:/order/orderLineList";
    }

    @PostMapping({"/order/addOrder/{id}"})
    public String placeOrder(@PathVariable int id) {
        Order order = orderService.findById(id);
        System.out.println("Order---///--" + order);
        return "redirect:/order/orderLineList/" + order.getId();
    }

    @GetMapping({"/order/orderLineList"})
    public String getCurrentOrderLineList( Model model) {
//        Person person =personService.findByEmail("suman");
//       List<Order> orders= orderService.findByPerson(person);
//        System.out.println("ORDERSSSSLINEESS::::::::"+orders);
//        model.addAttribute("orders", orders);
        return "orderLineList";
    }

    @PostMapping({"/order/deleteOrder/{id}"})
    public String deleteOrder(@PathVariable int id) {
        Order order = orderService.findById(id);
        System.out.println(" i am in delete " + id + "order" + order);
//        order.getOrderLines()
        orderService.delete(order);
        return "redirect:/order/orderLineList";
    }
}
