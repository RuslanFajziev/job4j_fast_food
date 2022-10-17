package domain.model;

import lombok.Data;

import java.util.List;

//заказ
@Data
public class Order {
    private int id;
    private List<Product> productList;
    private String status;

    public static Order of(List<Product> productList) {
        Order orderNew = new Order();
        return orderNew;
    }
}