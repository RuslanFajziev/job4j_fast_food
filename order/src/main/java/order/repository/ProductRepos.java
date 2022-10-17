package order.repository;

import order.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepos extends CrudRepository<Product, Integer> {
}