package es.vass.fichajes.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import es.vass.fichajes.constants.FichajesRrhhWebPortletKeys;
import es.vass.fichajes.model.Tarea;
import es.vass.fichajes.model.TipoTarea;
import es.vass.fichajes.service.TareaLocalServiceUtil;
import es.vass.fichajes.service.TipoTareaLocalServiceUtil;

@Component(
		immediate = true, 
		property = { 
			"javax.portlet.name=" + FichajesRrhhWebPortletKeys.FichajesRrhhWeb,
			"mvc.command.name=/modificarTarea" 
		}, 
		service = MVCRenderCommand.class
	)
public class ModificarTareaWebPortlet implements MVCRenderCommand {
	public String render(RenderRequest request, RenderResponse response) throws PortletException{
		
		int tareaId = ParamUtil.getInteger(request, "tareaId");
		
		List<TipoTarea> tiposTarea = TipoTareaLocalServiceUtil.getTipoTareas(0, Integer.MAX_VALUE);
		request.setAttribute("tiposTarea", tiposTarea);
		
		List<User> usuarios;
		usuarios = UserLocalServiceUtil.getUsers(0, Integer.MAX_VALUE);
		request.setAttribute("usuarios", usuarios);
		
		Tarea tarea;
		try {
			tarea = TareaLocalServiceUtil.getTarea(tareaId);
			
			request.setAttribute("tarea", tarea);
			request.setAttribute("fechaInicio", formatParaDate(tarea.getHoraInicio()));
			request.setAttribute("horaInicio", formatParaHoras(tarea.getHoraInicio()));
			request.setAttribute("fechaFin", formatParaDate(tarea.getHoraFin()));
			request.setAttribute("horaFin", formatParaHoras(tarea.getHoraFin()));
			
		} catch (PortalException e1) {		
			e1.printStackTrace();
		}
		
		return "/modificarTarea.jsp";
	}
	
	public static String formatParaDate(Date date) {
		
		String ano = Integer.toString(date.getYear()+1900);
		
		String mes = "";
		if (date.getMonth()<9) {
			mes = "0"+Integer.toString(date.getMonth()+1);
		}
		else{
			mes = Integer.toString(date.getMonth()+1);
		}

		String dia = Integer.toString(date.getDate());
		return ano+"-"+mes+"-"+dia;

	}
	
	public static String formatParaHoras(Date date) {
		
		String hora = Integer.toString(date.getHours());
		String minutos="";
		if (date.getMinutes()<10) {
			minutos = "0"+Integer.toString(date.getMinutes());
		}
		else {
			minutos = Integer.toString(date.getMinutes());
		}
		return hora+":"+minutos;
		
	}

}
