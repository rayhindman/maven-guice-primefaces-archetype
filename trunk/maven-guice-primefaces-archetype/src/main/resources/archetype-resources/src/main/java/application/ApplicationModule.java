package ${groupId}.${artifactId}.application;

import ${groupId}.${artifactId}.jpa.Controller;
import ${groupId}.${artifactId}.jpa.ContollerBean;

import com.google.inject.AbstractModule;

public class ApplicationModule extends AbstractModule {

	@Override
	protected void configure() {
		binder().bind(Controller.class).to(ControllerBean.class);
	}
}
