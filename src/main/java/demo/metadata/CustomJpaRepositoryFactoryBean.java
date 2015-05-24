package demo.metadata;

import demo.metadata.CustomJpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;

/**
 * @author Petar Tahchiev
 * @since 0.6
 */
public class CustomJpaRepositoryFactoryBean extends JpaRepositoryFactoryBean {
    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new CustomJpaRepositoryFactory(entityManager);
    }
}
