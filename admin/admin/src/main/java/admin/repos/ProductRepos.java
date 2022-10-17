package admin.repos;

import domain.model.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Repository
public class ProductRepos {
    public List<Product> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8081/allproduct";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<List<Product>> response = restTemplate.exchange(fooResourceUrl,
                HttpMethod.GET, entity, new ParameterizedTypeReference<List<Product>>() {
                });
        return response.getBody();
    }

    public Product getTop() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8081/top";
        var restString = restTemplate.getForObject(fooResourceUrl, String.class);
        Gson gson = new GsonBuilder().create();
        Product product = gson.fromJson(restString, Product.class);
        return product;
    }
}