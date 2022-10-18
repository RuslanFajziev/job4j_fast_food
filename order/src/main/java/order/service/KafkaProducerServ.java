package order.service;

import order.model.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class KafkaProducerServ {

    @Autowired
    private KafkaTemplate<Integer, MessageDTO> kafkaTemplate;

    public void send(int idOrder, MessageDTO messageDTO) {
        ListenableFuture<SendResult<Integer, MessageDTO>> future = kafkaTemplate.send("message", idOrder, messageDTO);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
    }
}
