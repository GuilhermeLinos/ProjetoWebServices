package web_services.modelo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import web_services.modelo.entidade.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
