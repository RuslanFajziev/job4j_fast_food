package domain.model;

import lombok.Data;

//продукты заказа
@Data
public class Product {
    private int id;
    private String name;
    private int quantity;
}