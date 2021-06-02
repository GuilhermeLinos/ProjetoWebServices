package web_services.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import web_services.modelo.entidade.Order;
import web_services.modelo.entidade.OrderItem;
import web_services.modelo.entidade.pk.OrderItemPK;
import web_services.modelo.servico.OrderService;
import web_services.modelo.servico.Service;

@RestController
@RequestMapping("/web_serv/{idUser}")
public class OrderControl extends CRUD_Control<Order>{
	
	@Autowired
	OrderService pedidoServico;
	
	@Override
	public Service<Order> getService() {
		return pedidoServico;
	}
	
	@PostMapping("/{idOrder}/itens")
	@ResponseStatus(HttpStatus.CREATED)
	public OrderItem cadastrarPedidoItem(@PathVariable int idOrder, @RequestBody OrderItem pedItem) throws Throwable{
		return pedidoServico.cadastrarPedidoItem(idOrder, pedItem);
	}

    @PutMapping("/{idOrder}/itens/{idOrderItemPK}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPedidoItem(@PathVariable int idOrder, @PathVariable OrderItemPK idOrderItemPK, @RequestBody OrderItem pedItem) throws Throwable {
        pedItem.setId(idOrderItemPK);
        pedidoServico.atualizarPedidoItem(idOrder, pedItem);
    }

    @GetMapping("/{idOrder}/itens/{idOrderItemPK}")
    @ResponseStatus(HttpStatus.OK)
    public OrderItem recuperarPedidoItem(@PathVariable int idOrder, @PathVariable OrderItemPK idOrderItemPK) throws Throwable {
        return pedidoServico.recuperarPedidoItem(idOrder, idOrderItemPK);
    }

    
    @GetMapping("/{idOrder}/itens/")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderItem> listarPedidoItem(@PathVariable int idOrder) throws Throwable {
        return pedidoServico.listarPedidoItem(idOrder);
    }
    
    /*@DeleteMapping("/{idOrder}/itens/{idOrderItemPK}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirPedidoItem(@PathVariable int idOrder, @PathVariable int idOrderItemPK) throws Throwable {
        pedidoServico.excluirPedidoItem(idOrder, idOrderItemPK);
    }*/

}
