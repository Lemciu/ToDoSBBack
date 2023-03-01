package pl.ml.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ml.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
