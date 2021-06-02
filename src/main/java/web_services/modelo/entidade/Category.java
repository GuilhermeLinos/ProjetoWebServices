package web_services.modelo.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class Category implements Entidade {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private int id;
	@Getter @Setter  String name;
	
	@JsonIgnore
	@ManyToMany (mappedBy = "categories")
	@Getter @Setter private List<Product> products = new ArrayList<>();
}
