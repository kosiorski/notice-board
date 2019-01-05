package pl.kosiorski.services;

import pl.kosiorski.model.Category;

import java.util.List;

public interface CategoryService {

    Category findById(Long id);

    List<Category> findAll();

    void save(Category Category);
}
