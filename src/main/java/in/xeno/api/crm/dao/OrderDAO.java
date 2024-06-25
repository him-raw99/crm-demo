package in.xeno.api.crm.dao;

import in.xeno.api.crm.constants.ProxyAction;
import in.xeno.api.crm.constants.ProxyContext;
import in.xeno.api.crm.lib.ProxyRequest;
import in.xeno.api.crm.model.Order;
import in.xeno.api.crm.pubSub.Producer;
import in.xeno.api.crm.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDAO {

    @Autowired
    private Producer producer;

    @Autowired
    private OrderRepo orderRepo;

    public void addOrder(Order order) {
        try {
            producer.sendMessage(new ProxyRequest<>(ProxyContext.ORDER, ProxyAction.ADD, order));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            orderRepo.save(order);
        }
    }
}
