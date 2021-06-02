package web_services.modelo.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import web_services.modelo.entidade.Product;
import web_services.modelo.repositorios.ProductRepository;
import web_services.modelo.rn.RegraNegocio;

@Component
public class ProductService extends Service <Product>{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public JpaRepository <Product, Integer> getRepository() {
        return productRepository;
    }
	
	@Override
    public RegraNegocio<Product> getRegraNegocio() {
        return null;
    }
}
