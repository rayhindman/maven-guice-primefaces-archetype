package it.swimm.webapp.web;

import java.io.Serializable;

import org.primefaces.optimus.config.Scope;
import org.primefaces.optimus.config.annotations.Controller;

@Controller(name = "propertiesHandler", scope = Scope.APPLICATION, startup = true)
public class PropertiesHandler implements Serializable {
	private String test = "prova!";

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
}
