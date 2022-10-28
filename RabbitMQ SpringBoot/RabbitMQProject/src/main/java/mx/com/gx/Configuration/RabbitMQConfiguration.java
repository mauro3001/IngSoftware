package mx.com.gx.Configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfiguration {

    public static final String QUEUE = "queue";
    public static final String EXCHANGE = "exchange.fanout";
    /*
    Routing_key lo implementacion si tenemos un DirectExchange
    Para el caso resulto mas facil y funcional un FanoutExchange
     */
    public static final String ROUTING_KEY = "routing";
    //Cola creada para comunicacion con python
    public static final String QUEUEPY = "queue2";
    //Cola creada para comunicacion con python
    public static final String QUEUECONSUMER = "queue3";


    @Bean
    Queue queue(){
        return new Queue(QUEUE);
    }

    @Bean
    Queue queuePy(){
        return new Queue(QUEUEPY);
    }

    @Bean
    Queue queueConsumer(){
        return new Queue(QUEUECONSUMER);
    }

    @Bean
    FanoutExchange exchange(){
        return new FanoutExchange(EXCHANGE);
    }

    @Bean
    Binding binding(Queue queue, FanoutExchange exchange){
        return BindingBuilder.bind(queue)
                .to(exchange);
                /*.with(ROUTING_KEY);*/
    }

    @Bean
    Binding bindingPy(Queue queuePy, FanoutExchange exchange){
        return BindingBuilder.bind(queuePy)
                .to(exchange);
    }

    @Bean
    Binding bindingConsumer(Queue queueConsumer, FanoutExchange exchange){
        return BindingBuilder.bind(queueConsumer)
                .to(exchange);
    }

    @Bean
    MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    AmqpTemplate rabbitTemplate(ConnectionFactory factory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
