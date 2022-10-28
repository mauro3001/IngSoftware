package mx.com.gx.consumer;

import lombok.extern.slf4j.Slf4j;
import mx.com.gx.Model.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    @RabbitListener(queues = "queue")
    private void receive(Message message){
        log.info("Consumidor 1 a recibido el mensaje de la cola QUEUEA-->{}",message);
    }
}
