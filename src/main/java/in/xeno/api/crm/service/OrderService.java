package in.xeno.api.crm.service;

import in.xeno.api.crm.constants.ProxyAction;
import in.xeno.api.crm.lib.ProxyRequest;
import in.xeno.api.crm.model.Order;
import in.xeno.api.crm.pubSub.Producer;
import in.xeno.api.crm.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private Producer producer;

    @Autowired
    private OrderRepo orderRepo;

    public void addOrder(Order order) {
        producer.saveOrder(new ProxyRequest<>( ProxyAction.ADD, order));
    }
}
