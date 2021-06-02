package web_services.modelo.entidade;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import web_services.modelo.entidade.enums.OrderStatus;

@Entity @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode @Getter @Setter
public class Order implements Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private Integer orderStatus;

	@ManyToOne
	private User client;

	@OneToMany
	private List<OrderItem> itens = new ArrayList<>();
	
	@OneToOne
	private Payment payment;
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
	}
	
	public Double getTotal() {
		double sum = 0.0;
		for (OrderItem x : itens) {
			sum += x.getSubTotal();
		}
		return sum;
	}
}
