package es.vass.fichajes.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import es.vass.fichajes.constants.FichajesRrhhWebPortletKeys;

@Component(
		immediate = true, 
		property = { 
			"javax.portlet.name=" + FichajesRrhhWebPortletKeys.FichajesRrhhWeb,
			"mvc.command.name=/volver" 
		}, 
		service = MVCRenderCommand.class
	)
public class VolverWebPortlet  implements MVCRenderCommand {
	public String render(RenderRequest request, RenderResponse response) throws PortletException {
		return "/view.jsp";
	}

}