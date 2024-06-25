package in.xeno.api.crm.controller;

import in.xeno.api.crm.lib.APIResponse;
import in.xeno.api.crm.model.Order;
import in.xeno.api.crm.service.OrderService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/order")
public class OrderController {

    @Autowired private OrderService orderService;


    @PostMapping
    public APIResponse<Object> addOrder(Order order){
        orderService.addOrder(order);
        return new APIResponse<>(
                200,
                "order added",
                null,
                true
        );
    }

}
