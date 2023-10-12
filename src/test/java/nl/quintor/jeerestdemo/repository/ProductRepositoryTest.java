package nl.quintor.jeerestdemo.repository;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableAutoWeld
@AddPackages(ProductRepository.class)
@Testcontainers
public class ProductRepositoryTest {

    @Container
    private final MySQLContainer<?> mysql = new MySQLContainer<>("mysql:latest")
            .withExposedPorts(3306)
            .withDatabaseName("test")
            .withUsername("root")
            .withPassword("root");

    @Inject
    private ProductRepository repository;

    @Test
    public void test() {
        System.out.println(mysql.getJdbcUrl());
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("integration-test", Map.of("javax.persistence.jdbc.url", mysql.getJdbcUrl()));
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        assertNotNull(entityManager);
    }

}
