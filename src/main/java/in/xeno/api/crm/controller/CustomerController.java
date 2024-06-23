package in.xeno.api.crm.controller;

import in.xeno.api.crm.lib.APIResponse;
import in.xeno.api.crm.model.Customer;
import in.xeno.api.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public APIResponse<List<Customer>> getUsers() {
        List<Customer> customerRec = this.customerService.getUsers();
        return new APIResponse<>(
                200,
                "successfully listed",
                customerRec,
                true
        );
    }

    @PostMapping
    public APIResponse<Customer> addUser(@RequestBody Customer user) throws Exception {
        Customer customer = customerService.addNewUser(user);
        return new APIResponse<>(
                200,
                "successfully added user",
                customer,
                true
        );
    }
}
