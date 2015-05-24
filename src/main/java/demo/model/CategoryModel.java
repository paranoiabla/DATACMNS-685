package demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Petar Tahchiev
 * @since 0.6
 */
@Entity
public class CategoryModel {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
