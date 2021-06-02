package web_services.modelo.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import web_services.excecoes.NaoEncontrado;
import web_services.modelo.entidade.Order;
import web_services.modelo.entidade.Payment;
import web_services.modelo.repositorios.OrderRepository;
import web_services.modelo.rn.RegraNegocio;

@Component
public class OrderService extends Service <Order>{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public JpaRepository <Order, Integer> getRepository() {
        return orderRepository;
    }
	
	public Payment recuperarPagamento (int idUser, int idPedido) throws Throwable {
		
		Order pedido = this.recuperar(idPedido);
		
		if(pedido.getId() == idPedido) {
			return pedido.getPayment();
		}
		 throw new NaoEncontrado("id " +idPedido + " não foi encontrada");
	}
	
	@Override
    public RegraNegocio<Order> getRegraNegocio() {
        return null;
    }
}
