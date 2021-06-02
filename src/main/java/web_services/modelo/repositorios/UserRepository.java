package web_services.modelo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import web_services.modelo.entidade.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
