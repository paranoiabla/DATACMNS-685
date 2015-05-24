package demo.definition;

import demo.model.CategoryModel;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Petar Tahchiev
 * @since 0.6
 */
public interface ProductModelDefinition {

    @Id
    Long getId();

    void setId(Long id);

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CategoryModel.class)
    @JoinColumn(name = "category", nullable = true, referencedColumnName = "id")
    CategoryModel getCategory();

    void setCategory(CategoryModel category);
}
