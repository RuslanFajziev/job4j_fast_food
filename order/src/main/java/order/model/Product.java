package order.model;

import lombok.Data;

import javax.persistence.*;

//продукты заказа
@Entity
@Table(name = "Products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;
}