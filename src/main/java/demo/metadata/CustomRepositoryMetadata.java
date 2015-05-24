package demo.metadata;

import demo.definition.ProductModelDefinition;
import demo.model.CategoryModel;
import demo.model.ProductModel;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.AbstractRepositoryMetadata;
import org.springframework.util.Assert;

import javax.persistence.metamodel.Metamodel;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Set;

/**
 * An implementation of {@link org.springframework.data.repository.core.RepositoryMetadata} that we customize because
 * our JPA repositories deal with interfaces instead of entity classes.
 *
 * @author Petar Tahchiev
 * @since 0.6
 */
public class CustomRepositoryMetadata implements RepositoryMetadata {

    private final RepositoryMetadata delegate;

    private final Class<?> domainClass;

    private final Class<?> domainInterface;

    public CustomRepositoryMetadata(Class<?> repositoryInterface, Metamodel metamodel) {

        this.delegate = AbstractRepositoryMetadata.getMetadata(repositoryInterface);

        // Translate interface into domain class

        this.domainClass = CustomRepositoryMetadata.findDomainClass(delegate.getDomainType(), metamodel);
        this.domainInterface = this.delegate.getDomainType();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.core.RepositoryMetadata#getIdType()
     */
    @Override
    public Class<? extends Serializable> getIdType() {
        return this.delegate.getIdType();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.core.RepositoryMetadata#getDomainType()
     */
    @Override
    public Class<?> getDomainType() {
        return this.domainClass;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.core.RepositoryMetadata#getRepositoryInterface()
     */
    @Override
    public Class<?> getRepositoryInterface() {
        return this.delegate.getRepositoryInterface();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.core.RepositoryMetadata#getReturnedDomainClass(java.lang.reflect.Method)
     */
    @Override
    public Class<?> getReturnedDomainClass(Method method) {
        Class<?> c = delegate.getReturnedDomainClass(method);
        return domainInterface.equals(c) ? domainClass : c;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.core.RepositoryMetadata#getCrudMethods()
     */
    @Override
    public CrudMethods getCrudMethods() {
        return this.delegate.getCrudMethods();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.repository.core.RepositoryMetadata#isPagingRepository()
     */
    @Override
    public boolean isPagingRepository() {
        return this.delegate.isPagingRepository();
    }

    private static Class<?> findDomainClass(Class<?> domainClass, Metamodel metamodel) {
        Assert.notNull(metamodel);
        if (domainClass.isInterface()) {
            if (domainClass.equals(ProductModelDefinition.class)) {
                return ProductModel.class;
            } else {
                return CategoryModel.class;
            }
        }
        return domainClass;
    }

    @Override
    public Set<Class<?>> getAlternativeDomainTypes() {
        return Collections.<Class<?>>singleton(domainInterface);
    }

}

