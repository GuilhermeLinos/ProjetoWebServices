package web_services.modelo.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import web_services.excecoes.NaoEncontrado;
import web_services.modelo.entidade.Category;
import web_services.modelo.entidade.Product;
import web_services.modelo.repositorios.CategoryRepository;
import web_services.modelo.repositorios.ProductRepository;
import web_services.modelo.rn.RegraNegocio;

@Component
public class ProductService extends Service <Product>{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public JpaRepository <Product, Integer> getRepository() {
        return productRepository;
    }
	
	public Category cadastrarCategoria(int idProduto, Category categoria) throws Throwable {
        Product produto = this.recuperar(idProduto);
        categoria.setId(0);
        Category categoriaBanco = categoryRepository.save(categoria);
        produto.getCategories().add(categoriaBanco);
        productRepository.save(produto);
        return categoriaBanco;
    }

    public Category recuperarCategoria(int idProduto, int idCategory) throws Throwable {
        Product produto = this.recuperar(idProduto);
        List<Category> categorias = produto.getCategories();
        for (Category categoria : categorias) {
            if (categoria.getId() == idCategory) {
                return categoria;
            }
        }
        throw new NaoEncontrado("id " + idCategory + " não foi encontrada");
    }

    public void atualizarCategoria(int idProduto, Category categoria) throws Throwable {
        this.recuperarCategoria(idProduto, categoria.getId());
        categoryRepository.save(categoria);
    }

    public List<Category> listarCategoria(int idProduto) throws Throwable {
        return this.recuperar(idProduto).getCategories();
    }

    public void excluirCategoria(int idProduto, int idCategory) throws Throwable {
        Product produto = this.recuperar(idProduto);
        List<Category> categorias = produto.getCategories();
        for (Category categoria : categorias) {
            if (categoria.getId() == idCategory) {
                produto.getCategories().remove(categoria);
                productRepository.save(produto);
                return;
            }
        }
        throw new NaoEncontrado("id " + idCategory + " não foi encontrada");
    }
	
	@Override
    public RegraNegocio<Product> getRegraNegocio() {
        return null;
    }
}
