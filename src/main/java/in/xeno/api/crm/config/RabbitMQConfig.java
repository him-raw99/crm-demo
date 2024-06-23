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
    
    public static final String QUEUE_NAME = "data-ingestion-queue";
    public static final String EXCHANGE_NAME = "data-ingestion-exchange";
    public static final String ROUTING_KEY = "key_123";

    @Bean
    public Queue queue() {
        return new Queue(RabbitMQConfig.QUEUE_NAME, false);
    }

    @Bean
    public Exchange exchange() {
        return new DirectExchange(RabbitMQConfig.EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(RabbitMQConfig.ROUTING_KEY).noargs();
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
