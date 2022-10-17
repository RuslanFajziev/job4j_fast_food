package order.model;

import lombok.Data;

import java.util.Set;

//заказDTO
@Data
public class OrderDTO {
    private Set<Product> productSet;
}