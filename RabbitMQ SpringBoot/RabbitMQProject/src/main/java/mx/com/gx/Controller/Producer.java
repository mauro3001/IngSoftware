package mx.com.gx.Controller;

import mx.com.gx.Configuration.RabbitMQConfiguration;
import mx.com.gx.Model.Message;
import mx.com.gx.RabbitMqProducerApplication;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Producer {

    /*
    Esta es la configuracion para el productor
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/post")
    public String send(@RequestBody Message message){
        rabbitTemplate.convertAndSend(RabbitMQConfiguration.EXCHANGE,"",message);
        return "Mensaje enviado correctamente";
    }
}
