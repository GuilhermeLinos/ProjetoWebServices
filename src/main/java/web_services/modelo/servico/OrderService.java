package web_services.modelo.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import web_services.excecoes.NaoEncontrado;
import web_services.modelo.entidade.Order;
import web_services.modelo.entidade.OrderItem;
import web_services.modelo.entidade.Payment;
import web_services.modelo.entidade.pk.OrderItemPK;
import web_services.modelo.repositorios.OrderItemRepository;
import web_services.modelo.repositorios.OrderRepository;
import web_services.modelo.rn.RegraNegocio;

@Component
public class OrderService extends Service <Order>{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository order_itemRepository;
	
	@Override
	public JpaRepository <Order, Integer> getRepository() {
        return orderRepository;
    }
	
	public Payment recuperarPagamento (int idPedido) throws Throwable {
		
		Order pedido = this.recuperar(idPedido);
		
		if(pedido.getId() == idPedido) {
			return pedido.getPayment();
		}
		 throw new NaoEncontrado("id " +idPedido + " não foi encontrada");
	}
	
	public OrderItem cadastrarPedidoItem(int idOrder, OrderItem pedidoItem) throws Throwable {
        Order pedido = this.recuperar(idOrder);
        pedidoItem.getId();
        OrderItem pedidoItemBanco = order_itemRepository.save(pedidoItem);
        pedido.getItens().add(pedidoItemBanco);
        orderRepository.save(pedido);
        return pedidoItemBanco;
    }

    public OrderItem recuperarPedidoItem(int idOrder, OrderItemPK idOrderItemPK) throws Throwable {
        Order pedido = this.recuperar(idOrder);
        List<OrderItem> pedidosItens = pedido.getItens();
        for (OrderItem pedidoItem : pedidosItens) {
            if (pedidoItem.getId() == idOrderItemPK) {
                return pedidoItem;
            }
        }
        throw new NaoEncontrado("id " + idOrderItemPK + " não foi encontrada");
    }

    public void atualizarPedidoItem(int idOrder, OrderItem pedidoItem) throws Throwable {
        this.recuperarPedidoItem(idOrder, pedidoItem.getId());
        order_itemRepository.save(pedidoItem);
    }

    public List<OrderItem> listarPedidoItem(int idOrder) throws Throwable {
        return this.recuperar(idOrder).getItens();
    }

    public void excluirPedidoItem(int idOrder, OrderItemPK idOrderItemPK) throws Throwable {
        Order pedido = this.recuperar(idOrder);
        List<OrderItem> pedidosItens = pedido.getItens();
        for (OrderItem pedidoItem : pedidosItens) {
            if (pedidoItem.getId() == idOrderItemPK) {
                pedido.getItens().remove(pedidoItem);
                orderRepository.save(pedido);
                return;
            }
        }
        throw new NaoEncontrado("id " + idOrderItemPK + " não foi encontrada");
    }
	
	@Override
    public RegraNegocio<Order> getRegraNegocio() {
        return null;
    }
}
