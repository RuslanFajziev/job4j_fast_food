package order.control;

import order.model.MessageDTO;
import order.model.Order;
import order.model.OrderDTO;
import order.service.OrderServ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderControl {
    private static final Logger LOG = LoggerFactory.getLogger(OrderControl.class.getSimpleName());

    private final OrderServ orderServ;

    @Autowired
    private KafkaTemplate<Integer, MessageDTO> kafkaTemplate;

    public OrderControl(OrderServ orderServ) {
        this.orderServ = orderServ;
    }

    @PostMapping("/make")
    public ResponseEntity<Order> make(@RequestBody OrderDTO orderDTO) {
        Order order = orderServ.makeOrder(orderDTO);
        LOG.info("Input OrderDTO={}, Output Order={}", orderDTO, order);

        int idOrder = order.getId();
        String address = "To MSK " + idOrder;
        MessageDTO messageDTO = MessageDTO.of(idOrder, address);
        ListenableFuture<SendResult<Integer, MessageDTO>> future = kafkaTemplate.send("message", idOrder, messageDTO);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();

        return new ResponseEntity<Order>(
                order,
                HttpStatus.CREATED
        );
    }

    @PostMapping("/cancel/{id}")
    public Map<String, String> cancel(@PathVariable int id) {
        Map<String, String> rsl = orderServ.cancelOrder(id);
        LOG.info("Status order number:{} rsl={}", id, rsl);
        return rsl;
    }

    @GetMapping("/status/{id}")
    public Map<String, String> status(@PathVariable int id) {
        Map<String, String> rsl = orderServ.getStatusOrder(id);
        LOG.info("Status order number:{} rsl={}", id, rsl);
        return rsl;
    }
}