package ${groupId}.${artifactId}.jpa;

import ${groupId}.${artifactId}.par.PersistentEntity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.wideplay.warp.persist.Transactional;

public class EntityControllerBean implements EntityController {

	@Inject
	Provider<EntityManager> em;

	private Logger log = LoggerFactory.getLogger(EntityControllerBean.class);

	@Transactional
	public void delete(PersistentEntity lastEntity) {
		try {
			PersistentEntity lastE = em.get().find(PersistentEntity.class, lastEntity.getId());
			em.get().remove(lastE);
		} catch (Exception e) {
			log.info("delete error");
		}

	}

	public PersistentEntity find(Long id) {
		try {
			return em.get().find(PersistentEntity.class, id);
		} catch (Exception e) {
			log.info("find error");
			return null;
		}

	}

	@Transactional
	public void persist(PersistentEntity lastEntity) {
		try {
			em.get().persist(lastEntity);
		} catch (Exception e) {
			log.info("persist error");
		}

	}

	@Transactional
	public void update(PersistentEntity lastEntity) {
		try {
			em.get().merge(lastEntity);
		} catch (Exception e) {
			log.info("update error");
		}

	}
	
	public List<PersistentEntity> getAllEntities() {
		List<PersistentEntity> result = new ArrayList<PersistentEntity>();
		try {
			result = em.get().createQuery(
					"select e from PersistentEntity e order by e.id desc").getResultList();
			log.info("getAllNews: " + result.size());
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

}
