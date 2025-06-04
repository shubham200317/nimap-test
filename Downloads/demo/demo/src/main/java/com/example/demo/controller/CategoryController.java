   package com.example.demo.controller;

   import com.example.demo.model.Category;
   import com.example.demo.repository.CategoryRepository;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.http.ResponseEntity;
   import org.springframework.web.bind.annotation.*;

   import java.util.List;

   @RestController
   @RequestMapping("/api/categories")
   public class CategoryController {
       @Autowired
       private CategoryRepository categoryRepository;

       @GetMapping
       public List<Category> getAllCategories(@RequestParam(defaultValue = "0") int page) {

           return categoryRepository.findAll();
       }

       @PostMapping
       public Category createCategory(@RequestBody Category category) {
           return categoryRepository.save(category);
       }

       @GetMapping("/{id}")
       public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
           return categoryRepository.findById(id)
                   .map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
       }

       @PutMapping("/{id}")
       public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
 
           return ResponseEntity.ok().build();
       }

       @DeleteMapping("/{id}")
       public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
           categoryRepository.deleteById(id);
           return ResponseEntity.noContent().build();
       }
   }
   