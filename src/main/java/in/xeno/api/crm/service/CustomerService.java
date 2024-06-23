package in.xeno.api.crm.service;

import in.xeno.api.crm.dao.CustomerDAO;
import in.xeno.api.crm.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> getUsers() {
        return customerDAO.findAll();
    }

    public Customer addNewUser(Customer user) throws Exception {
        return customerDAO.save(user);
    }
}
