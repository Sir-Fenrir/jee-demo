package nl.quintor.jeerestdemo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import nl.quintor.jeerestdemo.model.Product;
import nl.quintor.jeerestdemo.repository.ProductRepository;

import javax.print.attribute.standard.Media;
import java.util.List;

@Path ("/products")
@ApplicationScoped
public class ProductResource {

    private ProductRepository productRepository;


    public ProductResource() {}

    @Inject
    public ProductResource(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") long id) {
        return productRepository.getProductById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product addProduct(Product product) {
        return productRepository.saveProduct(product);
    }

}
