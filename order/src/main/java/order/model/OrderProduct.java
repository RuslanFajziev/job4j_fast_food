package order.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Order_Product")
@Data
public class OrderProduct {
    @Id
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "product_set_id")
    private int productId;
}