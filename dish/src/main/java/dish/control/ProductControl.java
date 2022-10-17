package dish.control;

import dish.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dish.service.ProductService;

import java.util.List;

@RestController
public class ProductControl {
    private final ProductService service;

    public ProductControl(ProductService service) {
        this.service = service;
    }

    @GetMapping("/allproduct")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<List<Product>>(
                service.getAll(), HttpStatus.OK
        );
    }

    @GetMapping("/top")
    public ResponseEntity<Product> getTop() {
        return new ResponseEntity<Product>(
                service.getTop(), HttpStatus.OK
        );
    }
}