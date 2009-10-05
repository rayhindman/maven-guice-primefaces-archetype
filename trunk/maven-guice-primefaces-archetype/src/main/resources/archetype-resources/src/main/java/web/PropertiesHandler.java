package ${groupId}.${artifactId}.web;

import {groupId}.${artifactId}.web.utils.JSFUtil;

import java.io.Serializable;

import org.primefaces.optimus.config.Scope;
import org.primefaces.optimus.config.annotations.Controller;

@Controller(name = "propertiesHandler", scope = Scope.APPLICATION, startup = true)
public class PropertiesHandler implements Serializable {
	
	public String getAbsolutePath() {
		// System.out.println("ABS: " + Util.getAbsolutePath());
		return JSFUtil.getAbsolutePath();
	}

	public String getCurrentPage() {
		String dove = JSFUtil.getCurrentPage().trim();
		String path = JSFUtil.getContextPath().replace("/", "").trim();

		// System.out.println("PATH: " + path + "- DOVE: " + dove);
		String[] dovs = dove.split("/");
		StringBuffer res = new StringBuffer();
		for (int i = 0; i < dovs.length; i++) {
			// System.out.println(i + ")" + dovs[i] + ".");
			if (i == 0) {
				res.append("<a href=\"/" + path + "\">home</a>");
			}

			if ((dovs[i] != null) && (dovs[i].trim().compareTo("") != 0)
					&& (dovs[i].trim().compareTo(path) != 0)) {
				if ((dovs[i].trim().compareTo("") != 0)
						&& (dovs[i].trim().compareTo(path) != 0)) {
					// System.out.println("SCRIVO -");
					res.append(" - ");
				}
				if (dovs[i].endsWith(".jsf")) {
					res.append("<b>" + dovs[i].replace(".jsf", "") + "</b>");
				} else {
					res.append("<a href=\"/" + path + "/" + dovs[i] + "\">"
							+ dovs[i] + "</a>");
				}

			}
		}
		return res.toString();
	}
}
