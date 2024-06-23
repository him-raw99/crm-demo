package in.xeno.api.crm.service;

import in.xeno.api.crm.dao.OrderDAO;
import in.xeno.api.crm.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    public void addOrder(Order order) {
        orderDAO.addOrder(order);

    }
}
