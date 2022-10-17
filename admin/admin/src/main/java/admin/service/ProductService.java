package admin.service;

import domain.model.Product;
import admin.repos.ProductRepos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepos productRepos;

    public ProductService(ProductRepos productRepos) {
        this.productRepos = productRepos;
    }

    public List<Product> getAll() {
        return productRepos.getAll();
    }

    public Product getTop() {
        return productRepos.getTop();
    }
}