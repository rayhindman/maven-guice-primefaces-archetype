package ${groupId}.${artifactId}.web;

import ${groupId}.${artifactId}.jpa.EntityController;
import ${groupId}.${artifactId}.par.PersistentEntity;

import ${groupId}.${artifactId}.web.PropertiesHandler;

import java.io.Serializable;
import java.util.List;

import org.primefaces.optimus.config.Scope;
import org.primefaces.optimus.config.annotations.Controller;

import com.google.inject.Inject;

@Controller(name = "entityHandler", scope = Scope.SESSION)
public class EntityHandler implements Serializable {

	@Inject
	private EntityController controller;
	
	@Inject
	PropertiesHandler propertiesHandler;

	private PersistentEntity singleEntity;

	
	public EntityHandler(EntityController controller) {
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

	public List<PersistentEntity> getAllEntities() {
		List<PersistentEntity> lista = controller.getAllEntities();
		// DataModel data = new ArrayDataModel();
		// data.setWrappedData(lista);
		return lista;
	}
}
