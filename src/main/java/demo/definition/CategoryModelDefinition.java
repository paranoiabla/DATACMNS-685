package demo.definition;

import javax.persistence.Id;

/**
 * @author Petar Tahchiev
 * @since 0.6
 */
public interface CategoryModelDefinition {
    @Id
    Long getId();

    void setId(Long id);
}
