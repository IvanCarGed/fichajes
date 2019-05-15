package es.vass.fichajes.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import es.vass.fichajes.constants.FichajesRrhhWebPortletKeys;
import es.vass.fichajes.service.TareaLocalServiceUtil;

@Component(
		immediate = true, 
		property = { 
			"javax.portlet.name=" + FichajesRrhhWebPortletKeys.FichajesRrhhWeb,
			"mvc.command.name=/verDetalleTarea" 
		}, 
		service = MVCRenderCommand.class
	)
public class VerDetallesFichajeWebPortlet implements MVCRenderCommand {
	
	public String render(RenderRequest request, RenderResponse response) throws PortletException{
		
		int tareaId = ParamUtil.getInteger(request, "tareaId");
		
		try {
			request.setAttribute("tarea", TareaLocalServiceUtil.getTarea(tareaId));
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return "/detalleTarea.jsp";
	}

}
