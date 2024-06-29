package in.xeno.api.crm.pubSub;

import in.xeno.api.crm.config.RabbitMQConfig;
import in.xeno.api.crm.lib.ProxyRequest;
import in.xeno.api.crm.model.Campaign;
import in.xeno.api.crm.model.Customer;
import in.xeno.api.crm.model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired private RabbitTemplate rabbitTemplate;

    public void saveCustomer(ProxyRequest<Customer> data)
    {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.CUSTOMER_ROUTING_KEY,
                data
        );
    }
    public void saveOrder(ProxyRequest<Order> data)
    {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ORDER_ROUTING_KEY,
                data
        );
    }
    public void saveCampaign(ProxyRequest<Campaign> data)
    {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.CAMPAIGN_ROUTING_KEY,
                data
        );
    }
}
