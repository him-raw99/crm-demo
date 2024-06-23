package in.xeno.api.crm.pubSub;
import in.xeno.api.crm.config.RabbitMQConfig;
import in.xeno.api.crm.lib.ProxyRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(ProxyRequest<Object> message)
    {
        System.out.println("Received message: " + message);
    }
}