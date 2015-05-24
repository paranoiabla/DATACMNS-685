package demo.repository;

import demo.definition.CategoryModelDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Petar Tahchiev
 * @since 0.6
 */
public interface CategoryRepository extends JpaRepository<CategoryModelDefinition, Long> {
}
