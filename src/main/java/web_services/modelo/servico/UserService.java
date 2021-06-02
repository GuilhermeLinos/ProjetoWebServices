package web_services.modelo.servico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import web_services.excecoes.NaoEncontrado;
import web_services.modelo.entidade.User;
import web_services.modelo.entidade.enums.OrderStatus;
import web_services.modelo.repositorios.OrderRepository;
import web_services.modelo.repositorios.UserRepository;
import web_services.modelo.rn.RegraNegocio;
import web_services.modelo.entidade.Order;

@Component
public class UserService extends Service <User>{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	public JpaRepository <User, Integer> getRepository() {
        return userRepository;
    }
	
	public Order cadastrarPedido (int idUser, Order pedido) throws Throwable {
		User usuario = this.recuperar(idUser);
		pedido.getId();
		Order pedidoBanco = orderRepository.save(pedido);
		usuario.getOrders().add(pedidoBanco);
		userRepository.save(usuario);
		return pedidoBanco;
		
	}
	
	public Order recuperarPedido (int idUser, int idPedido) throws Throwable {
		User usuario = this.recuperar(idUser);
		List <Order> pedidos = usuario.getOrders();
		for (Order pedido : pedidos) {
			if(pedido.getId() == idPedido) {
				return pedido;
			}
		}
		 throw new NaoEncontrado("id " +idPedido + " não foi encontrada");	
	}
	
	
	public void atualizarPedido(int idUser, Order pedido) throws Throwable {
        this.recuperarPedido(idUser, pedido.getId());
        orderRepository.save(pedido);
    }
	
	public List<Order> listarPedido(int idUser) throws Throwable {
        return this.recuperar(idUser).getOrders();
    }

    public OrderStatus cancelarPedido(int idUser, int idPedido) throws Throwable {
        User usuario = this.recuperar(idUser);
        List<Order> pedidos = usuario.getOrders();
        OrderStatus orderStatus = OrderStatus.CANCELED;
        
        for (Order pedido : pedidos) {
            if (pedido.getId() == idPedido) {
                usuario.getOrders().remove(pedido);
                userRepository.save(usuario);
                return orderStatus;
            }
        }
        throw new NaoEncontrado("id " + idPedido + " não foi encontrada");
    }

	@Override
	RegraNegocio<User> getRegraNegocio() {
		return null;
	}
}
