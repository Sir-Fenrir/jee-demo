package nl.quintor.jeerestdemo.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import nl.quintor.jeerestdemo.model.Product;

import java.util.List;

@ApplicationScoped
@Transactional
public class ProductRepository {

    @PersistenceContext(name = "TenderNed")
    private EntityManager entityManager;

    public List<Product> getAllProducts() {
        TypedQuery<Product> products = this.entityManager.createQuery("select p from Product p", Product.class);
        return products.getResultList();
    }

    public Product saveProduct(Product product) {
        this.entityManager.persist(product);
        return product;
    }

    public Product getProductById(long id) {
        return this.entityManager.find(Product.class, id);
    }


}
