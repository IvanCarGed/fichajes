package es.vass.fichajes.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import es.vass.fichajes.constants.FichajesRrhhWebPortletKeys;
import es.vass.fichajes.model.Tarea;
import es.vass.fichajes.model.TipoTarea;
import es.vass.fichajes.service.TareaLocalServiceUtil;
import es.vass.fichajes.service.TipoTareaLocalServiceUtil;

/**
 * @author Ivan
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FichajesRrhhWebPortletKeys.FichajesRrhhWeb,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FichajesRrhhWebPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		
		final ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		if(onlyForYourEyes(td.getUser())) {
			request.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		}
				
		super.render(request, response);
	}
	
	public boolean onlyForYourEyes(User user) {
		List<Role> roles = user.getRoles();
	
		for (Role r : roles) {
			if (r.getName().equals("Administrator")||r.getName().equals("RRHH")) {
				return false;
			}
		}
		return true;
	}
	
	@ProcessAction(name = "buscarMes")
	public void buscarMes(ActionRequest request, ActionResponse response) {
			
		final int mes = ParamUtil.getInteger(request, "mes");
			
		List<TipoTarea> tiposTarea = TipoTareaLocalServiceUtil.getTipoTareas(0, Integer.MAX_VALUE);

		List<Tarea> totalTareas = TareaLocalServiceUtil.getTareas(0, Integer.MAX_VALUE);
		List<Tarea> esteMes = new ArrayList<Tarea>();
		
		
		for (Tarea t : totalTareas) {
			if (mes==t.getHoraInicio().getMonth() && !t.getActiva()) {
				esteMes.add(t);
				
			}
		}
		request.setAttribute("tiposTarea", tiposTarea);
		request.setAttribute("tareas", esteMes);
			
		response.setRenderParameter("jspPage","/META-INF/resources/verFichajesMes.jsp");

	}
	
	@ProcessAction(name = "buscarUsuario")
	public void buscarUsuario(ActionRequest request, ActionResponse response) {
		
		final String userName = ParamUtil.getString(request, "nombreUsuario");
			
		List<TipoTarea> tiposTarea = TipoTareaLocalServiceUtil.getTipoTareas(0, Integer.MAX_VALUE);

		List<Tarea> tareasUsuario = TareaLocalServiceUtil.findByUsuario(userName);
		
		request.setAttribute("tiposTarea", tiposTarea);
		request.setAttribute("tareas", tareasUsuario);
		request.setAttribute("usuario", tareasUsuario.get(0).getUserName());
			
		response.setRenderParameter("jspPage","/META-INF/resources/verFichajesUsuario.jsp");

	}
	
	@ProcessAction(name = "buscarMesUsuario")
	public void buscarMesUsuario(ActionRequest request, ActionResponse response) {
		
		final String userName = ParamUtil.getString(request, "nombreUsuario");
		final int mes = ParamUtil.getInteger(request, "mes");
			
		List<TipoTarea> tiposTarea = TipoTareaLocalServiceUtil.getTipoTareas(0, Integer.MAX_VALUE);

		List<Tarea> tareasUsuario = TareaLocalServiceUtil.findByUsuario(userName);
		List<Tarea> esteMes = new ArrayList<Tarea>();
		
		for (Tarea t : tareasUsuario) {
			if (mes==t.getHoraInicio().getMonth() && !t.getActiva()) {
				esteMes.add(t);
				
			}
		}
		
		request.setAttribute("tiposTarea", tiposTarea);
		request.setAttribute("tareas", esteMes);
		request.setAttribute("usuario", tareasUsuario.get(0).getUserName());
			
		response.setRenderParameter("jspPage","/META-INF/resources/verFichajesUsuario.jsp");

	}
	
	@ProcessAction(name = "modificarTarea")
	public void modificarTarea(ActionRequest request, ActionResponse response) throws PortalException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date hoy = new Date();

		final Long tareaId = ParamUtil.getLong(request, "tareaId");
		final Long userId = ParamUtil.getLong(request, "userId");
		final Date fechaInicio = ParamUtil.getDate(request, "fechaInicio", format);
		final String horaInicio = ParamUtil.getString(request, "horaInicio");
		final Date fechaFin = ParamUtil.getDate(request, "fechaFin", format);
		final String horaFin = ParamUtil.getString(request, "horaFin");
		final Long latitud = ParamUtil.getLong(request, "latitud");
		final Long longitud = ParamUtil.getLong(request, "longitud");
		
		User empleado = UserLocalServiceUtil.getUser(userId);
		String[] partsInicio = horaInicio.split(":");
		
		fechaInicio.setHours(Integer.parseInt(partsInicio[0]));
		fechaInicio.setMinutes(Integer.parseInt(partsInicio[1]));
				
		String[] partsFin = horaFin.split(":");
		
		fechaFin.setHours(Integer.parseInt(partsFin[0]));
		fechaFin.setMinutes(Integer.parseInt(partsFin[1]));
		
		try {
			Tarea tarea = TareaLocalServiceUtil.getTarea(tareaId);
			tarea.setModifiedDate(hoy);
			tarea.setUserId(empleado.getUserId());
			tarea.setUserName(empleado.getFirstName());
			tarea.setHoraInicio(fechaInicio);
			tarea.setHoraFin(fechaFin);
			
			if (fechaFin.after(fechaInicio)) {
				tarea.setActiva(Boolean.FALSE);
			}
			else {
				tarea.setActiva(Boolean.TRUE);
			}
			
			tarea.setLongitud(longitud);
			tarea.setLatitud(latitud);
			
			TareaLocalServiceUtil.updateTarea(tarea);
			
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
			
		response.setRenderParameter("jspPage","/META-INF/resources/view.jsp");

	}
}

