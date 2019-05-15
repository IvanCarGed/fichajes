package es.vass.fichajes.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
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

import es.vass.fichajes.constants.FichajesWebPortletKeys;
import es.vass.fichajes.exception.NoSuchTareaException;
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
		"javax.portlet.name=" + FichajesWebPortletKeys.FichajesWeb,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FichajesWebPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {

		final ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		if (onlyForYourEyes(td.getUser())) {
			request.setAttribute("rol", Boolean.TRUE);
			Tarea ultimaTarea = TareaLocalServiceUtil.findLast(td.getUserId());
			if (ultimaTarea.getActiva()) {
				request.setAttribute("activo", Boolean.TRUE);
				request.setAttribute("tareaId", ultimaTarea.getTareaId());
				try {
					request.setAttribute("tareaAbierta", TipoTareaLocalServiceUtil.getTipoTarea(ultimaTarea.getTipoTarea()));
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
		}
		
		List<TipoTarea> tiposTarea = TipoTareaLocalServiceUtil.getTipoTareas(0, Integer.MAX_VALUE);	
		
		request.setAttribute("tiposTarea", tiposTarea);
		super.render(request, response);
	}
	
	public boolean onlyForYourEyes(User user) {
		List<Role> roles = user.getRoles();

		for (Role r : roles) {
			if (r.getName().equals("Administrator")||r.getName().equals("RRHH")||r.getName().equals("Empleado")) {
				return true;
			}
		}
		return false;
	}
	
	
	@ProcessAction(name = "nuevoFichaje")
	public void nuevoFichaje(ActionRequest request, ActionResponse response) {
		final ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		Date createDate = new Date();
		
		final long tipoTareaId = ParamUtil.getLong(request, "tipoTarea");
		final double latitud = ParamUtil.getDouble(request, "lat");
		final double longitud = ParamUtil.getDouble(request, "long");
		
		TareaLocalServiceUtil.addTarea(td.getUserId(), td.getUser().getFirstName(), createDate, createDate, latitud, longitud, tipoTareaId);

	}
	
	@ProcessAction(name = "finalizarFichaje")
	public void finalizarFichaje(ActionRequest request, ActionResponse response) throws NoSuchTareaException {
		
		Date modifiedDate = new Date();
		
		final long tareaId = ParamUtil.getLong(request, "tareaId");
		
		TareaLocalServiceUtil.endTarea(tareaId, modifiedDate, modifiedDate);
	}
	
	@ProcessAction(name = "buscarMes")
	public void buscarMes(ActionRequest request, ActionResponse response) {
		final ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		final int mes = ParamUtil.getInteger(request, "mes");
		
		Long tiempoTrabajado = (long) 0;
		
		List<TipoTarea> tiposTarea = TipoTareaLocalServiceUtil.getTipoTareas(0, Integer.MAX_VALUE);

		List<Tarea> totalTareas = TareaLocalServiceUtil.findByUserId(td.getUserId());
		List<Tarea> esteMes = new ArrayList<Tarea>();
		
		
		for (Tarea t : totalTareas) {
			if (mes==t.getHoraInicio().getMonth() && !t.getActiva()) {
				esteMes.add(t);
				tiempoTrabajado += (t.getHoraFin().getTime()-t.getHoraInicio().getTime());
			}
		}
		if (horasTrabajadas(tiempoTrabajado)<205) {
			float parcial =  (((float)tiempoTrabajado/3600000)-horasTrabajadas(tiempoTrabajado));
			request.setAttribute("horasTrabajadas", horasTrabajadas(tiempoTrabajado));
			request.setAttribute("minutosTrabajados", minutosTrabajados(parcial));
		}
		else {
			request.setAttribute("horasTrabajadas", 205);
			request.setAttribute("minutosTrabajados", 00);
			float parcialMinutosExtra =  (((float)tiempoTrabajado/3600000)-horasTrabajadas(tiempoTrabajado));
			request.setAttribute("horasExtra", (horasTrabajadas(tiempoTrabajado)-205));
			request.setAttribute("minutosExtra",  minutosTrabajados(parcialMinutosExtra));
		}
		
		request.setAttribute("tiposTarea", tiposTarea);
		request.setAttribute("tareas", esteMes);
			
		response.setRenderParameter("jspPage","/META-INF/resources/verFichajes.jsp");

	}
	

	public static Double formatearDecimales(Double numero, Integer numeroDecimales) {
		return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
		}
	
	public static int horasTrabajadas(double tiempoTrabajado) {

		return (int) ((float)tiempoTrabajado/3600000);
	}
	
	public static int minutosTrabajados(double minutosTrabajados) {
		double parcial = (minutosTrabajados*60/100);
		return (int) (formatearDecimales(parcial, 2)*100);
	}
	
}