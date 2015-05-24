package demo.metadata;

import demo.metadata.CustomRepositoryMetadata;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;

/**
 * @author Petar Tahchiev
 * @since 0.6
 */
public class CustomJpaRepositoryFactory extends JpaRepositoryFactory {

    private EntityManager entityManager;

    public CustomJpaRepositoryFactory(EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    @Override
    protected RepositoryMetadata getRepositoryMetadata(Class<?> repositoryInterface) {
        return new CustomRepositoryMetadata(repositoryInterface, this.entityManager.getMetamodel());
    }
}
