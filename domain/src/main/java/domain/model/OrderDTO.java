package domain.model;

import lombok.Data;

import java.util.List;

//заказDTO
@Data
public class OrderDTO {
    private List<Product> productList;
}