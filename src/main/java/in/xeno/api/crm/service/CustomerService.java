package in.xeno.api.crm.service;

import in.xeno.api.crm.constants.ProxyAction;
import in.xeno.api.crm.lib.ProxyRequest;
import in.xeno.api.crm.model.Customer;
import in.xeno.api.crm.pubSub.Producer;
import in.xeno.api.crm.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired private CustomerRepo customerRepo;
    @Autowired private Producer producer;

    public List<Customer> getUsers() {

        return customerRepo.findAll();
    }

    public List<Customer> getUsersByRule(String rule) {
        return customerRepo.findByRule(rule);
    }

    public Customer addNewUser(Customer customer) throws Exception {
        producer.saveCustomer(new ProxyRequest<>( ProxyAction.ADD, customer));
        return customer;
    }
}
