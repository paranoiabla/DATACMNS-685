package demo.pocessor;

import demo.definition.ProductModelDefinition;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.Resources;

/**
 * @author Petar Tahchiev
 * @since 0.6
 */
public class ProductResourceProcessor implements ResourceProcessor<Resources<ProductModelDefinition>> {

    @Override
    public Resources<ProductModelDefinition> process(Resources<ProductModelDefinition> resource) {
        resource.add(new Link("/synchronize"));
        return resource;
    }
}
