package web_services.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import web_services.modelo.entidade.Category;
import web_services.modelo.servico.CategoryService;

@RestController
@RequestMapping("/web_serv")
public class CategoryControl {
	
	
	/*@Autowired
	CategoryService categoriaServico;
	
	@PostMapping ("/category/")
	@ResponseStatus(HttpStatus.CREATED)
	public Category cadastrarCategoria (@RequestBody Category categoria) {
		return categoriaServico.cadastrar(categoria);
	}
	
	@GetMapping ("/category/")
	@ResponseStatus(HttpStatus.CREATED)
	public Iterable<Category> listarCategorias(){
		return categoriaServico.listar();
	}*/
	
}