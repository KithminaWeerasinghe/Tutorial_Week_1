package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Products")

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/summaries")
    public List<String> getSummaries(){
        return productService.getAllSummaries();
    }

    @GetMapping("/produts/{id}")
    public Product getProductById(@PathVariable Long id){
        return ProductService.getProductById(id).orElse(null);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping ("/products/{id}")
    public void deleteProduct (@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping ("/product/serch")
    public List<Product> search(@RequestParam String name){
        return productService.findByName(name);
    }
}
