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
import web_services.modelo.entidade.Order;
import web_services.modelo.entidade.Product;
import web_services.modelo.entidade.User;
import web_services.modelo.servico.ProductService;
import web_services.modelo.servico.Service;

/*@RestController
@RequestMapping("/web_serv")
public class ProductControl {
	
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
	public Category atualizarCategoria() {}
	
	@GetMapping("/{idProduct}/categorias/{idCategory}")
    @ResponseStatus(HttpStatus.OK)
	public Category recuperarCategoria() {}
	
    @GetMapping("/{idCategory}/categorias/")
    @ResponseStatus(HttpStatus.OK)
	public List<Category> listarCategoria() {}
    
    @DeleteMapping("/{idCategory}/categorias/{idCategory}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public Category excluirCategoria() {}
	
	
	/*@PostMapping("/{idUser}/pedidos")
	@ResponseStatus(HttpStatus.CREATED)
	public Order cadastrarPedido(@PathVariable int idUser, @RequestBody Order pedido) throws Throwable{
		return servico.cadastrarPedido(idUser, pedido);
	}

    @PutMapping("/{idUser}/pedidos/{idPedido}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPedido(@PathVariable int idUser, @PathVariable int idPedido, @RequestBody Order pedido) throws Throwable {
        pedido.setId(idPedido);
        servico.atualizarPedido(idUser, pedido );
    }

    @GetMapping("/{idUser}/pedidos/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public Order recuperarPedido(@PathVariable int idUser, @PathVariable int idPedido) throws Throwable {
        return servico.recuperarPedido(idUser, idPedido);
    }

    
    @GetMapping("/{idUser}/pedidos/")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> listarPedido(@PathVariable int idUser) throws Throwable {
        return servico.listarPedido(idUser);
    }
    
    @DeleteMapping("/{idUser}/pedidos/{idPedido}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelarPedido(@PathVariable int idUser, @PathVariable int idPedido) throws Throwable {
        servico.cancelarPedido(idUser, idPedido);
    }*/
	
}
