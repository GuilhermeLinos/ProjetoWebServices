package web_services.modelo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import web_services.modelo.entidade.OrderItem;
import web_services.modelo.entidade.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
