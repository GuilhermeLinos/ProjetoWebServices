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

import web_services.modelo.entidade.Order;
import web_services.modelo.entidade.User;
import web_services.modelo.servico.OrderService;
import web_services.modelo.servico.Service;
import web_services.modelo.servico.UserService;


@RestController
@RequestMapping("/web_serv")
public class UserControl extends CRUD_Control<User>{
	
	@Autowired
	UserService userServico;
	
	@Autowired
	OrderService pedidoServico;

	@Override
	public Service<User> getService() {
		return userServico;
	}
	
	@PostMapping("/{idUser}/pedidos")
	@ResponseStatus(HttpStatus.CREATED)
	public Order cadastrarPedido(@PathVariable int idUser, @RequestBody Order pedido) throws Throwable{
		return userServico.cadastrarPedido(idUser, pedido);
	}

    @PutMapping("/{idUser}/pedidos/{idPedido}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPedido(@PathVariable int idUser, @PathVariable int idPedido, @RequestBody Order pedido) throws Throwable {
        pedido.setId(idPedido);
        userServico.atualizarPedido(idUser, pedido );
    }

    @GetMapping("/{idUser}/pedidos/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public Order recuperarPedido(@PathVariable int idUser, @PathVariable int idPedido) throws Throwable {
        return userServico.recuperarPedido(idUser, idPedido);
    }

    
    @GetMapping("/{idUser}/pedidos/")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> listarPedido(@PathVariable int idUser) throws Throwable {
        return userServico.listarPedido(idUser);
    }
    
    @DeleteMapping("/{idUser}/pedidos/{idPedido}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelarPedido(@PathVariable int idUser, @PathVariable int idPedido) throws Throwable {
        userServico.cancelarPedido(idUser, idPedido);
    }
    
    
    @GetMapping("/{idUser}/pedidos/{idPedido}/pagamento")
    public void recuperarPagamento(@PathVariable int idUser, @PathVariable int idPedido) throws Throwable{
    	pedidoServico.recuperarPagamento(idPedido);
    }
	
}
