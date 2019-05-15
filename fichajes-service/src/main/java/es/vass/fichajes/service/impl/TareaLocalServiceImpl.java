/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package es.vass.fichajes.service.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;

import java.util.Date;
import java.util.List;

import es.vass.fichajes.exception.NoSuchTareaException;
import es.vass.fichajes.model.Tarea;
import es.vass.fichajes.model.impl.TareaImpl;
import es.vass.fichajes.service.TareaLocalServiceUtil;
import es.vass.fichajes.service.base.TareaLocalServiceBaseImpl;
import es.vass.fichajes.service.persistence.TareaUtil;

/**
 * The implementation of the tarea local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link es.vass.fichajes.service.TareaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TareaLocalServiceBaseImpl
 * @see es.vass.fichajes.service.TareaLocalServiceUtil
 */
public class TareaLocalServiceImpl extends TareaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link es.vass.fichajes.service.TareaLocalServiceUtil} to access the tarea local service.
	 */
	
	public void addTarea(long userId, String userName, Date createDate, Date horaInicio, double latitud, double longitud, long tipoTarea) {
		final Tarea tarea = new TareaImpl();
        
		tarea.setTareaId(counterLocalService.increment());
		tarea.setUserId(userId);
		tarea.setUserName(userName);
		tarea.setCreateDate(createDate);
		tarea.setHoraInicio(horaInicio);
		tarea.setActiva(true);
		tarea.setLatitud(latitud);
		tarea.setLongitud(longitud);
		tarea.setTipoTarea(tipoTarea);

        addTarea(tarea);
	}
	
	public List<Tarea> findByUserId(long userId){
		return TareaUtil.findByuserId(userId);
	}
	
	public Tarea findLast(long userId) {
		
		try {
			return TareaUtil.findByuserId_Last(userId, null);
		} catch (NoSuchTareaException e) {
		
			e.printStackTrace();
		}
		return null;
	}
	
	public void endTarea(long tareaId, Date modifiedDate, Date horaFin) throws NoSuchTareaException {
		
		Tarea tarea = TareaUtil.findByPrimaryKey(tareaId);
		
		tarea.setModifiedDate(modifiedDate);
		tarea.setHoraFin(horaFin);
		tarea.setActiva(false);
		
		updateTarea(tarea);
	}
	
	public List<Tarea> findByUsuario(String userName){
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Tarea.class, TareaImpl.class.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("userName").like("%" + userName + "%"));
		List<Tarea> tareaList = TareaLocalServiceUtil.dynamicQuery(dynamicQuery);
		return tareaList;
		
	}
}