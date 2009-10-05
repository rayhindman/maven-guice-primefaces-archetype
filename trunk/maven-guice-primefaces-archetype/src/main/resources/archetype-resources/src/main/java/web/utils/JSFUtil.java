package ${groupId}.${artifactId}.web.utils;

import java.security.Principal;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class JSFUtil {

	public static Object getManagedBean(String name) {
		FacesContext fc = FacesContext.getCurrentInstance();
		if (fc == null) {
			System.out.println("Faces Context Application NULLO");
		}
		return fc.getApplication().getELResolver().getValue(fc.getELContext(),
				null, name);
	}

	public static Object getParameter(String name) {
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getExternalContext().getRequestParameterMap().get(name);
	}

	public static String getCurrentPage() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest httpRequest = (HttpServletRequest) fc
				.getExternalContext().getRequest();
		return httpRequest.getRequestURI();
	}

	public static String getUserName() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) context
				.getExternalContext().getRequest();
		String rem = req.getRemoteUser();
		// System.out.println("******************************");
		// System.out.println("REM USER: " + rem);
		Principal pr = req.getUserPrincipal();
		// System.out.println("PRINC USER: " + pr.getName());
		// System.out.println("******************************");

		if (pr == null)
			return "ucs";
		return pr.getName();
	}

	public static boolean isUserInRole(String role) {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) context
				.getExternalContext().getRequest();
		return req.isUserInRole(role);
	}

	public static String getContextPath() {
		FacesContext fc = FacesContext.getCurrentInstance();
		String cp = fc.getExternalContext().getRequestContextPath();
		return cp;
	}

	public static String getAbsolutePath() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest httpServletRequest = (HttpServletRequest) fc
				.getExternalContext().getRequest();
		String scheme = httpServletRequest.getScheme();
		String hostName = httpServletRequest.getServerName();
		int port = httpServletRequest.getServerPort();
		// Because this is rendered in a <div> layer, portlets for some reason
		// need the scheme://hostname:port part of the URL prepended.
		return scheme + "://" + hostName + ":" + port + getContextPath();
	}

	public static String getHostPort() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest httpServletRequest = (HttpServletRequest) fc
				.getExternalContext().getRequest();
		String scheme = httpServletRequest.getScheme();
		String hostName = httpServletRequest.getServerName();
		int port = httpServletRequest.getServerPort();

		return scheme + "://" + hostName + ":" + port + "/";
	}

}
