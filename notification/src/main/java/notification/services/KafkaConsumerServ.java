package notification.services;

import notification.model.MessageDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerServ {

    @KafkaListener(topics = "message")
    public void orderListener(ConsumerRecord<Integer, MessageDTO> record) {
        System.out.printf("partition:%s, key:%s, value:%s\n",
                record.partition(), record.key(), record.value());
    }
}
