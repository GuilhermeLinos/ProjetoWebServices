package web_services.modelo.servico;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import web_services.excecoes.DatabaseException;
import web_services.excecoes.NaoEncontrado;
import web_services.excecoes.ResourceNotFoundException;
import web_services.modelo.entidade.Entidade;
import web_services.modelo.rn.RegraNegocio;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

public abstract class Service <T extends Entidade>{
	
	public abstract JpaRepository <T, Integer> getRepository();
	abstract RegraNegocio<T> getRegraNegocio();
    
    public T cadastrar (T entidade){
    	entidade.setId(0);
    	if (getRegraNegocio()!=null)
    		getRegraNegocio().validarCadastrar(entidade);
    	T save = getRepository().save(entidade);
    	return save;
    }
    
    public Iterable<T> listar (){
    	return getRepository().findAll();
    }
    
    public void atualizar (T entidade) {
    	if (getRegraNegocio()!=null) {
    		T entidadeAntiga = getRepository().findById(entidade.getId()).get();
    		getRegraNegocio().validarAtualizar(entidadeAntiga, entidade);
    	}
    	getRepository().save(entidade);
    }
    
    public T recuperar (int id) throws Throwable {
    	Optional <T> optional = getRepository().findById(id);
    	if(!optional.isPresent()) {
    		throw new NaoEncontrado("id" + id +"não foi encontrada");
    	}
    	return optional.get();
    }
    
    public void excluir (int id) throws Throwable {
    	
    	try {
			getRepository().deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException msg) {
			throw new DatabaseException(msg.getMessage());
		}
    	
    	if (!getRepository().existsById(id)) {
    		throw new NaoEncontrado("id"+id +"não foi encontrada");
    	}
    	
    	if(getRegraNegocio()!=null)
    		getRegraNegocio().validarExcluir(recuperar(id));
    }
}