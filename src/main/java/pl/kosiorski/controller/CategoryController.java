package pl.kosiorski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kosiorski.model.Category;
import pl.kosiorski.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

  private final CategoryService categoryService;

  @Autowired
  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @RequestMapping("/list")
  public List<Category> cattegoryList() {
    return categoryService.findAll();
  }

  @RequestMapping("/add")
  public Category categoryAdd(Category category) {
    return categoryService.save(category);
  }
}
