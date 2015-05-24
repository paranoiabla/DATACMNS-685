package demo;

import demo.metadata.CustomJpaRepositoryFactoryBean;
import demo.pocessor.ProductResourceProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.ResourceProcessor;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomJpaRepositoryFactoryBean.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public ResourceProcessor defaultProductResourceProcessor() {
        return new ProductResourceProcessor();
    }
}
