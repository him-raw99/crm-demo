package in.xeno.api.crm.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String CUSTOMER_QUEUE_NAME = "customer-ingestion-queue";
    public static final String ORDER_QUEUE_NAME = "order-ingestion-queue";
    public static final String CAMPAIGN_QUEUE_NAME = "campaign-ingestion-queue";
    public static final String EXCHANGE_NAME = "data-ingestion-exchange";
    public static final String CUSTOMER_ROUTING_KEY = "customer";
    public static final String ORDER_ROUTING_KEY = "order";
    public static final String CAMPAIGN_ROUTING_KEY = "campaign";

    @Bean
    public Queue customerQueue() {
        return new Queue(RabbitMQConfig.CUSTOMER_QUEUE_NAME, false);
    }

    @Bean
    public Queue orderQueue() {
        return new Queue(RabbitMQConfig.ORDER_QUEUE_NAME, false);
    }

    @Bean
    public Queue campaignQueue() {
        return new Queue(RabbitMQConfig.CAMPAIGN_QUEUE_NAME, false);
    }

    @Bean
    public Exchange exchange() {
        return new DirectExchange(RabbitMQConfig.EXCHANGE_NAME);
    }

    @Bean
    public Binding customerBinding(Exchange exchange) {
        return BindingBuilder
                .bind(customerQueue())
                .to(exchange)
                .with(RabbitMQConfig.CUSTOMER_ROUTING_KEY)
                .noargs();
    }

    @Bean
    public Binding orderBinding(Exchange exchange) {
        return BindingBuilder
                .bind(orderQueue())
                .to(exchange)
                .with(RabbitMQConfig.ORDER_ROUTING_KEY)
                .noargs();
    }

    @Bean
    public Binding campaignBinding(Exchange exchange) {
        return BindingBuilder
                .bind(campaignQueue())
                .to(exchange)
                .with(RabbitMQConfig.CAMPAIGN_ROUTING_KEY)
                .noargs();
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
