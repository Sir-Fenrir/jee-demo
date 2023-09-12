package nl.quintor.jeerestdemo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path ("/products")
@ApplicationScoped
public class ProductResource {

    private List<Product> products = new ArrayList<>();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Product addProduct(Product product) {
        this.products.add(product);
        return product;
    }

}
