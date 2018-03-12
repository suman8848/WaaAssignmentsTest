package com.example.coffeeshop.controller.api;


import com.example.coffeeshop.domain.Order;
import com.example.coffeeshop.domain.Orderline;
import com.example.coffeeshop.domain.Person;
import com.example.coffeeshop.domain.Product;
import com.example.coffeeshop.service.OrderService;
import com.example.coffeeshop.service.PersonService;
import com.example.coffeeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class RestCoffeeController {

    @Autowired
    ProductService productService;
    @Autowired
    PersonService personService;

    @Autowired
    OrderService orderService;

    private final String sharedKey = "SHARED_KEY";
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody Product product) {
        BaseResponse response = new BaseResponse();
        System.out.println("HERE IN API=");
        if (sharedKey.equalsIgnoreCase(key)) {
            String productName = product.getProductName();
            System.out.println(productName);
//            String itemId = request.getItemId();
//            double discount = request.getDiscount();
            // Process the request
            // ....
            // Return success response to the client.
//            productService.save(product);
            response.setStatus(SUCCESS_STATUS);
            response.setCode(CODE_SUCCESS);
        } else {
            response.setStatus(ERROR_STATUS);
            response.setCode(AUTH_FAILURE);
        }
        return response;
    }

    @PostMapping({"/api/person/addPerson"})
    public Person addPerson(@RequestBody Person person) {
        if(person!=null) {
            personService.savePerson(person);
        }
        return person;

    }


    @PostMapping({"/api/product/addProduct"})
    public Product addProduct(@RequestBody Product product) {
        if(product!=null) {
            productService.save(product);
        }
        return product;

    }

    @GetMapping({"/api/product/products"})
    public List<Product> listProduct() {
        List<Product> productList = productService.getAllProduct();
        return productList;

    }

    @GetMapping({"/api/person/persons"})
    public List<Person> listPersons() {
        List<Person> productList = personService.getAll();
        return productList;

    }
    @GetMapping({"/api/product/productDetail"})
    public Product productDetail(@RequestParam("id") int id) {
        Product product = productService.getProduct(id);
        System.out.println("Product by id"+ product);
        return product;

    }

    @GetMapping({"/api/person/personDetail"})
    public Person personDetail(@RequestParam("id") long id) {
           Person person  = personService.findById(id);
        return person;

    }

    @PutMapping({"/api/product/deleteProduct"})
    public BaseResponse deleteProduct(@RequestParam("id")int id){
        BaseResponse response = new BaseResponse();
        Product product = productService.getProduct(id);
        if (product!=null){
            productService.delete(product);
            response.setStatus(SUCCESS_STATUS);
            response.setCode(CODE_SUCCESS);

        }else {
            response.setStatus(ERROR_STATUS);

        }
        return response;
    }
    @PostMapping({"/api/person/deletePerson/{id}"})
    public BaseResponse deletePerson(@RequestParam("id") long id){
        BaseResponse response = new BaseResponse();
        Person person = personService.findById(id);
        if (person!=null){
            personService.removePerson(person);
            response.setStatus(SUCCESS_STATUS);
            response.setCode(CODE_SUCCESS);

        }else {
            response.setStatus(ERROR_STATUS);

        }
        return response;
    }
    @PutMapping({"/api/person/personDetail/{id}"})
    public Person updatePerson(@PathVariable long id, @RequestBody Person personDetails){
            Person person = personService.findById(id);
            person.setAddress(personDetails.getAddress());
            person.setEmail(personDetails.getEmail());
            person.setFirstName(personDetails.getFirstName());
            person.setLastName(personDetails.getLastName());
            person.setPhone(personDetails.getPhone());
            person.setEnable(personDetails.isEnable());
            personService.savePerson(person);
            return person;
    }
    @GetMapping("/api/order/orders")
    public List<Order> getOrders(Model model) {
       List<Order> orders =orderService.findAll();
        return orders ;
    }

    @PostMapping("api/order/addToCart")
    public List<Orderline> addOrder(@RequestParam("id") int id, Order order) {
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
        System.out.println("ADDTOCART:::___---"+order);
        orderService.save(order);

//        List<Order> orders =orderService.findByPerson(p);
//        System.out.println("ORDERS"+orders);
//        List<Orderline> orderlineList = new ArrayList<>();
//        for(int i =0 ;i<orders.size();i++){
//            Orderline orderlineList1 = orders.get(i).getOrderLines().get(0);
//            orderlineList.add(orderlineList1);
//            System.out.println("Helloooo+++"+orders.get(i).getOrderLines());
//        }
//        System.out.println("SIZZE"+ orderlineList.size());

        return null;
    }

    @PostMapping({"api/order/deleteOrder"})
    public BaseResponse deleteOrder(@RequestParam("id") int id) {
        BaseResponse response = new BaseResponse();
        Order order = orderService.findById(id);
        if (order!=null){
            orderService.delete(order);
            response.setStatus(SUCCESS_STATUS);
            response.setCode(CODE_SUCCESS);

        }else {
            response.setStatus(ERROR_STATUS);

        }
        return response;
    }


}
