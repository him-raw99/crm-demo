package in.xeno.api.crm.pubSub;
import in.xeno.api.crm.config.RabbitMQConfig;
import in.xeno.api.crm.lib.ProxyRequest;
import in.xeno.api.crm.model.Campaign;
import in.xeno.api.crm.model.Customer;
import in.xeno.api.crm.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = RabbitMQConfig.CUSTOMER_QUEUE_NAME)
    public void receiveCustomerRequest(ProxyRequest<Customer> message)
    {
        System.out.println("Received customer: " + message);
    }

    @RabbitListener(queues = RabbitMQConfig.ORDER_QUEUE_NAME)
    public void receiveOrderRequest(ProxyRequest<Order> message)
    {
        System.out.println("Received order: " + message);
    }

    @RabbitListener(queues = RabbitMQConfig.CAMPAIGN_QUEUE_NAME)
    public void receiveCampaignRequest(ProxyRequest<Campaign> message)
    {
        System.out.println("Received campaign: " + message);
    }
}