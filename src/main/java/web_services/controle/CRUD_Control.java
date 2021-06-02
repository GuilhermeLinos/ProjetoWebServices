package web_services.controle;

import web_services.modelo.entidade.Entidade;
import web_services.modelo.servico.Service;

public abstract class CRUD_Control <T extends Entidade>{

	public abstract Service<T> getService();

}
