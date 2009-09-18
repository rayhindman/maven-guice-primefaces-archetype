package ${groupId}.${artifactId}.application;

import ${groupId}.${artifactId}.jpa.EntityController;
import ${groupId}.${artifactId}.jpa.EntityControllerBean;

import com.google.inject.AbstractModule;

public class ApplicationModule extends AbstractModule {

	@Override
	protected void configure() {
		binder().bind(EntityController.class).to(EntityControllerBean.class);
	}
}
