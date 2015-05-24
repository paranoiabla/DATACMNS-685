package demo.repository;

import demo.definition.CategoryModelDefinition;
import demo.definition.ProductModelDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Petar Tahchiev
 * @since 0.6
 */
public interface ProductRepository extends JpaRepository<ProductModelDefinition, Long> {

    Iterable<ProductModelDefinition> findByIdEquals(Long id);

    Iterable<ProductModelDefinition> findByCategoryEquals(@Param("category") CategoryModelDefinition category);
}
