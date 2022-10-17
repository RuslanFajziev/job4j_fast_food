package order.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//заказ
@Entity
@Table(name = "Orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "Order_Product")
    private Set<Product> productSet = new HashSet<>();
    private String status;

    public static Order of(Set<Product> productSet) {
        Order orderNew = new Order();
        orderNew.setProductSet(productSet);
        return orderNew;
    }
}