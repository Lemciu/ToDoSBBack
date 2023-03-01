package pl.ml.controller;

import org.springframework.web.bind.annotation.*;
import pl.ml.model.Category;
import pl.ml.service.CategoryService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable Long id) {
        return categoryService.findById(id).orElseThrow();
    }

}
