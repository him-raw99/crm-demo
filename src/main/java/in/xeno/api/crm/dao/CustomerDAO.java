package in.xeno.api.crm.dao;

import in.xeno.api.crm.lib.ProxyRequest;
import in.xeno.api.crm.model.Customer;
import in.xeno.api.crm.pubSub.Producer;
import in.xeno.api.crm.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CustomerDAO {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private Producer producer;


    public Customer save(Customer customer) {
        try {
            producer.sendMessage(new ProxyRequest<>("customer", customer));
            return customer;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            customerRepo.save(customer);
            return customer;
        }
    }


    public List<Customer> findAll() {
        return customerRepo.findAll();
    }


    public Customer find(Customer Data) {
        return null;
    }


    public Customer update(Customer Data) {
        return null;
    }


    public Customer delete(Customer Data) {
        return null;
    }
}
