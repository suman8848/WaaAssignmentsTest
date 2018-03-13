package com.example.coffeeshop.controller;

import com.example.coffeeshop.config.SessionHandlerListener;
import com.example.coffeeshop.domain.Order;
import com.example.coffeeshop.domain.Orderline;
import com.example.coffeeshop.domain.Product;
import com.example.coffeeshop.service.OrderService;
import com.example.coffeeshop.service.PersonService;
import com.example.coffeeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes({"currentUserOrder"})
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    PersonService personService;
    @Autowired
    ProductService productService;


    @Autowired
    private SessionHandlerListener session;

    public Order getCurOrd(ModelMap map) {
        Order currentUserOrder = (Order)map.get("currentUserOrder");
        System.out.println("CURRENTUSERORDER---->>>"+currentUserOrder);

        if (currentUserOrder == null) {
            //do stuff if you get current order null
            currentUserOrder = new Order();
            map.addAttribute("currentUserOrder", currentUserOrder);
        }
        return currentUserOrder;
    }

    public void addOrderToSession(ModelMap map, Order order) {
        map.addAttribute("currentUserOrder", order);
    }

    @GetMapping("/order/orders")
    public String getOrders(Model model) {
//        System.out.println("Id+++"+id);

        model.addAttribute("orders", orderService.findAll());
        System.out.println(orderService.findAll());
        return "orderList";
    }

    ///TODO
    @GetMapping("/order/getmyorders")
    public String getMyOrders(ModelMap map, @ModelAttribute Order order){
        Order currentUserOrder = this.getCurOrd(map);
        addOrderToSession(map, currentUserOrder);
        return  "mycart";
    }



    @GetMapping("/order/confirmation")
    public String submitAndAddOrder(ModelMap map, @ModelAttribute("currentUserOrder") Order order, Product product) {

        Order finalOrder = getCurOrd(map);
        for (int i = 0; i < finalOrder.getOrderLines().size(); i++) {
            finalOrder.getOrderLines().get(i).setQuantity(order.getOrderLines().get(i).getQuantity());
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        System.out.println("Order "+ order);
        finalOrder.setOrderDate(date);
        finalOrder.setPerson(session.getPerson());
        orderService.save(finalOrder);
        //creating new order after confirmation
        map.addAttribute("currentUserOrder", new Order());
        return "redirect:/user/order";
    }


    @PostMapping("/order/addToMyCart/{id}")
    public String addToCartOrder(@PathVariable int id, ModelMap map, @ModelAttribute Order order){
        Order myOrder = getCurOrd(map);
        Product product = productService.getProduct(id);
        Orderline orderLine = new Orderline();
        orderLine.setProduct(product);
        System.out.println("ORDERSSS__>>>>"+myOrder);
        orderLine.setOrder(myOrder);
        orderLine.setQuantity(1); // default
        myOrder.addOrderLine(orderLine);
        addOrderToSession(map, myOrder);
        return "redirect:/order/getmyorders";
    }



    @PostMapping({"/order/addOrder/{id}"})
    public String placeOrder(@PathVariable int id) {
        Order order = orderService.findById(id);
        System.out.println("Order---///--" + order);
        return "redirect:/order/orderLineList/" + order.getId();
    }


    @GetMapping({"/order/deleteOrder/{id}"})
    public String deleteCurrentOrder(@PathVariable int id, ModelMap map) {
        Orderline deleteOrderline = null;
        Order currentOrder = getCurOrd(map);
        List<Orderline> orderlineList =currentOrder.getOrderLines();
        for (Orderline orderline : orderlineList) {
            if (id == orderline.getProduct().getId()) {
                deleteOrderline = orderline;
            }
        }
        if (deleteOrderline != null) {
            currentOrder.removeOrderLine(deleteOrderline);
        }
        addOrderToSession(map, currentOrder);

        return "redirect:/order/getmyorders";
    }
    @PostMapping({"/order/deleteOrder/{id}"})
    public String deleteOrder(@PathVariable int id) {
        Order order = orderService.findById(id);
        System.out.println(" i am in delete " + id + "order" + order);
        orderService.delete(order);
        return "redirect:/order/orders";
    }

}
