package web_services.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import web_services.modelo.entidade.Category;
import web_services.modelo.entidade.Product;
import web_services.modelo.servico.ProductService;
import web_services.modelo.servico.Service;

@RestController
@RequestMapping("/web_serv")
public class ProductControl extends CRUD_Control<Product>{
	
	@Autowired
	ProductService servico;

	@Override
	public Service <Product> getService() {
		return servico;
	}
	
	@PostMapping("/{idProduct}/categorias")
	@ResponseStatus(HttpStatus.CREATED)
	public Category cadastrarCategoria(@PathVariable int idProduct, @RequestBody Category categoria) throws Throwable{
		return servico.cadastrarCategoria(idProduct, categoria);
	}

    @PutMapping("/{idProduct}/categorias/{idCategory}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCategoria(@PathVariable int idProduct, @PathVariable int idCategory, @RequestBody Category categoria) throws Throwable {
        categoria.setId(idCategory);
        servico.atualizarCategoria(idProduct, categoria );
    }

    @GetMapping("/{idProduct}/categorias/{idCategory}")
    @ResponseStatus(HttpStatus.OK)
    public Category recuperarCategoria(@PathVariable int idProduct, @PathVariable int idCategory) throws Throwable {
        return servico.recuperarCategoria(idProduct, idCategory);
    }

    
    @GetMapping("/{idProduct}/categorias/")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> listarCategoria(@PathVariable int idProduct) throws Throwable {
        return servico.listarCategoria(idProduct);
    }
    
    @DeleteMapping("/{idProduct}/categorias/{idCategory}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirCategoria(@PathVariable int idProduct, @PathVariable int idCategory) throws Throwable {
        servico.excluirCategoria(idProduct, idCategory);
    }
	
}
