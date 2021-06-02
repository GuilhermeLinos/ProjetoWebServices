package web_services.modelo.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import web_services.modelo.entidade.Category;
import web_services.modelo.repositorios.CategoryRepository;
import web_services.modelo.rn.RegraNegocio;

@Component
public class CategoryService extends Service <Category>{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public JpaRepository <Category, Integer> getRepository() {
        return categoryRepository;
    }
	
	@Override
    public RegraNegocio<Category> getRegraNegocio() {
        return null;
    }
}
