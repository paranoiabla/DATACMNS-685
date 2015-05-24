package demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Petar Tahchiev
 * @since 0.6
 */
@Entity
public class ProductModel {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CategoryModel.class)
    @JoinColumn(name = "category", nullable = true, referencedColumnName = "id")
    private CategoryModel category;

    /* getters/setters */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }
}
