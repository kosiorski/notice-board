package pl.kosiorski.services;

import pl.kosiorski.model.Category;

import java.util.List;

public interface CategoryService {

    Category findById(Long id);

    List<Category> findAll();

    Category save(Category category);
}
