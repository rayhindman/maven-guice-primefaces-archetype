package ${groupId}.${artifactId}.jpa;

import java.util.List;

import ${groupId}.${artifactId}.par.PersistentEntity;

public interface Controller {

	public void persist(PersistentEntity entity);
	public void delete(PersistentEntity entity);
	public void update(PersistentEntity entity);
	public PersistentEntity find(Long id);
	public List<PersistentEntity> getAllEntities();

}
