package com.example.coffeeshop.controller.api;


import com.example.coffeeshop.domain.Product;
import com.example.coffeeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestProductController {

    @Autowired
    ProductService productService;


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

}
