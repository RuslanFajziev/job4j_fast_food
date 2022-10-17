package dish.service;

import dish.model.Product;
import org.springframework.stereotype.Service;
import dish.repos.ProductRepos;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepos repos;

    public ProductService(ProductRepos repos) {
        this.repos = repos;
    }

    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        repos.findAll().forEach(productList::add);
        return productList;
    }

    public Product getTop() {
        return repos.findById(1).orElse(new Product());
    }
}