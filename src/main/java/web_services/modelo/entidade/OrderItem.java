package web_services.modelo.entidade;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web_services.modelo.entidade.pk.OrderItemPK;

@Entity @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode @Getter @Setter
public class OrderItem {

	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	
	private Integer quantity;
	private Double price;
	
	@ManyToOne
	private Product produto;

	
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	

	public Double getSubTotal() {
		return price * quantity;
	}
}
