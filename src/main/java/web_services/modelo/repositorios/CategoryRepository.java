package web_services.modelo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import web_services.modelo.entidade.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
