
package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private static List<Product> products = new ArrayList<>();
    private long nextId = 1L;

    //Both DigitalProduct and PhysicalProduct inherit id, name and price from the Product superclass.
    public ProductService(){

        DigitalProduct digital = new DigitalProduct(
                0L,
                "Learning Java",
                2500.00,
                "https://www.google.com"
        );

        PhysicalProduct physical = new PhysicalProduct(
                0L,
                "Computer Mouse",
                3500.00,
                0.2,
                "10 x 6 x 4 cm"
        );

        addProduct(digital);
        addProduct(physical);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public static Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }

    public List<String> getAllSummaries() {
        List<String> summaries = new ArrayList<>();
        for (Product p : products){
            summaries.add(p.getSummary());
        }
        return summaries;
    }
}
