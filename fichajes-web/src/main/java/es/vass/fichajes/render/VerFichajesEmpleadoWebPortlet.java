package es.vass.fichajes.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import es.vass.fichajes.constants.FichajesWebPortletKeys;
import es.vass.fichajes.model.Tarea;
import es.vass.fichajes.model.TipoTarea;
import es.vass.fichajes.service.TareaLocalServiceUtil;
import es.vass.fichajes.service.TipoTareaLocalServiceUtil;

@Component(
		immediate = true, 
		property = { 
			"javax.portlet.name=" + FichajesWebPortletKeys.FichajesWeb,
			"mvc.command.name=/verFichajesEmpleado" 
		}, 
		service = MVCRenderCommand.class
	)
public class VerFichajesEmpleadoWebPortlet implements MVCRenderCommand {
	
	public String render (RenderRequest request, RenderResponse response) throws PortletException {		
		
		final ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		Date hoy = new Date();
		Long tiempoTrabajado = (long) 0;
		List<TipoTarea> tiposTarea = TipoTareaLocalServiceUtil.getTipoTareas(0, Integer.MAX_VALUE);
		List<Tarea> totalTareas = TareaLocalServiceUtil.findByUserId(td.getUserId());
		List<Tarea> esteMes = new ArrayList<Tarea>();
		
		for (Tarea t : totalTareas) {
			if (hoy.getMonth()==t.getCreateDate().getMonth() && !t.getActiva()) {
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
		
		return "/verFichajes.jsp";
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
