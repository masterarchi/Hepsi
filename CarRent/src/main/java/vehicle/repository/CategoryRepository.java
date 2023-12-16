package product.repository;

import product.entity.Category;
import product.util.MyRepositoryFactory;

public class CategoryRepository extends MyRepositoryFactory<Category,Long> {
    public CategoryRepository() {
        super(Category.class);
    }
}
