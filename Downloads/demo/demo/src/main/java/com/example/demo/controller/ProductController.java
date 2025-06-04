   package com.example.demo.controller;

   import com.example.demo.model.Product;
   import com.example.demo.repository.ProductRepository;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.http.ResponseEntity;
   import org.springframework.web.bind.annotation.*;

   import java.util.List;

   @RestController
   @RequestMapping("/api/products")
   public class ProductController {
       @Autowired
       private ProductRepository productRepository;

       @GetMapping
       public List<Product> getAllProducts(@RequestParam(defaultValue = "0") int page) {

           return productRepository.findAll();
       }

       @PostMapping
       public Product createProduct(@RequestBody Product product) {
           return productRepository.save(product);
       }

       @GetMapping("/{id}")
       public ResponseEntity<Product> getProductById(@PathVariable Long id) {
           return productRepository.findById(id)
                   .map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
       }

       @PutMapping("/{id}")
       public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {

           return ResponseEntity.ok().build();
       }

       @DeleteMapping("/{id}")
       public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
           productRepository.deleteById(id);
           return ResponseEntity.noContent().build();
       }
   }
   