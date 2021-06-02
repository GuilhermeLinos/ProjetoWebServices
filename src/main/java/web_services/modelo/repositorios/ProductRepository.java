package web_services.modelo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import web_services.modelo.entidade.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
