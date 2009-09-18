package ${groupId}.${artifactId}.web;

import ${groupId}.${artifactId}.jpa.Controller;
import ${groupId}.${artifactId}.par.PersistentEntity;

import java.io.Serializable;
import java.util.List;

import org.primefaces.optimus.config.Scope;
import org.primefaces.optimus.config.annotations.Controller;

import com.google.inject.Inject;

@Controller(name = "entityHandler", scope = Scope.SESSION)
public class EntityHandler implements Serializable {

	@Inject
	private Controller controller;

	private PersistentEntity singleEntity;

	
	public EntityHandler(Controller controller) {
		this.controller = controller;
	}

	public PersistentEntity getSingleEntity() {
		return singleEntity;
	}

	public void setSingleEntity(PersistentEntity singleEntity) {
		this.singleEntity = singleEntity;
	}

	public String getTestProps() {
		return propertiesHandler.getTest();
	}

	public List<Entity> getAllEntities() {
		List<Entity> lista = controller.getAllEntities();
		// DataModel data = new ArrayDataModel();
		// data.setWrappedData(lista);
		return lista;
	}
}
