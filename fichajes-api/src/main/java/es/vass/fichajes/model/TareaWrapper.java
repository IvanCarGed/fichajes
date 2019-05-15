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

package es.vass.fichajes.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Tarea}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Tarea
 * @generated
 */
@ProviderType
public class TareaWrapper implements Tarea, ModelWrapper<Tarea> {
	public TareaWrapper(Tarea tarea) {
		_tarea = tarea;
	}

	@Override
	public Class<?> getModelClass() {
		return Tarea.class;
	}

	@Override
	public String getModelClassName() {
		return Tarea.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tareaId", getTareaId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("horaInicio", getHoraInicio());
		attributes.put("horaFin", getHoraFin());
		attributes.put("activa", isActiva());
		attributes.put("latitud", getLatitud());
		attributes.put("longitud", getLongitud());
		attributes.put("tipoTarea", getTipoTarea());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tareaId = (Long)attributes.get("tareaId");

		if (tareaId != null) {
			setTareaId(tareaId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date horaInicio = (Date)attributes.get("horaInicio");

		if (horaInicio != null) {
			setHoraInicio(horaInicio);
		}

		Date horaFin = (Date)attributes.get("horaFin");

		if (horaFin != null) {
			setHoraFin(horaFin);
		}

		Boolean activa = (Boolean)attributes.get("activa");

		if (activa != null) {
			setActiva(activa);
		}

		Double latitud = (Double)attributes.get("latitud");

		if (latitud != null) {
			setLatitud(latitud);
		}

		Double longitud = (Double)attributes.get("longitud");

		if (longitud != null) {
			setLongitud(longitud);
		}

		Long tipoTarea = (Long)attributes.get("tipoTarea");

		if (tipoTarea != null) {
			setTipoTarea(tipoTarea);
		}
	}

	@Override
	public Object clone() {
		return new TareaWrapper((Tarea)_tarea.clone());
	}

	@Override
	public int compareTo(Tarea tarea) {
		return _tarea.compareTo(tarea);
	}

	/**
	* Returns the activa of this tarea.
	*
	* @return the activa of this tarea
	*/
	@Override
	public boolean getActiva() {
		return _tarea.getActiva();
	}

	/**
	* Returns the create date of this tarea.
	*
	* @return the create date of this tarea
	*/
	@Override
	public Date getCreateDate() {
		return _tarea.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _tarea.getExpandoBridge();
	}

	/**
	* Returns the hora fin of this tarea.
	*
	* @return the hora fin of this tarea
	*/
	@Override
	public Date getHoraFin() {
		return _tarea.getHoraFin();
	}

	/**
	* Returns the hora inicio of this tarea.
	*
	* @return the hora inicio of this tarea
	*/
	@Override
	public Date getHoraInicio() {
		return _tarea.getHoraInicio();
	}

	/**
	* Returns the latitud of this tarea.
	*
	* @return the latitud of this tarea
	*/
	@Override
	public double getLatitud() {
		return _tarea.getLatitud();
	}

	/**
	* Returns the longitud of this tarea.
	*
	* @return the longitud of this tarea
	*/
	@Override
	public double getLongitud() {
		return _tarea.getLongitud();
	}

	/**
	* Returns the modified date of this tarea.
	*
	* @return the modified date of this tarea
	*/
	@Override
	public Date getModifiedDate() {
		return _tarea.getModifiedDate();
	}

	/**
	* Returns the primary key of this tarea.
	*
	* @return the primary key of this tarea
	*/
	@Override
	public long getPrimaryKey() {
		return _tarea.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tarea.getPrimaryKeyObj();
	}

	/**
	* Returns the tarea ID of this tarea.
	*
	* @return the tarea ID of this tarea
	*/
	@Override
	public long getTareaId() {
		return _tarea.getTareaId();
	}

	/**
	* Returns the tipo tarea of this tarea.
	*
	* @return the tipo tarea of this tarea
	*/
	@Override
	public long getTipoTarea() {
		return _tarea.getTipoTarea();
	}

	/**
	* Returns the user ID of this tarea.
	*
	* @return the user ID of this tarea
	*/
	@Override
	public long getUserId() {
		return _tarea.getUserId();
	}

	/**
	* Returns the user name of this tarea.
	*
	* @return the user name of this tarea
	*/
	@Override
	public String getUserName() {
		return _tarea.getUserName();
	}

	/**
	* Returns the user uuid of this tarea.
	*
	* @return the user uuid of this tarea
	*/
	@Override
	public String getUserUuid() {
		return _tarea.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _tarea.hashCode();
	}

	/**
	* Returns <code>true</code> if this tarea is activa.
	*
	* @return <code>true</code> if this tarea is activa; <code>false</code> otherwise
	*/
	@Override
	public boolean isActiva() {
		return _tarea.isActiva();
	}

	@Override
	public boolean isCachedModel() {
		return _tarea.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _tarea.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tarea.isNew();
	}

	@Override
	public void persist() {
		_tarea.persist();
	}

	/**
	* Sets whether this tarea is activa.
	*
	* @param activa the activa of this tarea
	*/
	@Override
	public void setActiva(boolean activa) {
		_tarea.setActiva(activa);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tarea.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this tarea.
	*
	* @param createDate the create date of this tarea
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_tarea.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_tarea.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_tarea.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_tarea.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the hora fin of this tarea.
	*
	* @param horaFin the hora fin of this tarea
	*/
	@Override
	public void setHoraFin(Date horaFin) {
		_tarea.setHoraFin(horaFin);
	}

	/**
	* Sets the hora inicio of this tarea.
	*
	* @param horaInicio the hora inicio of this tarea
	*/
	@Override
	public void setHoraInicio(Date horaInicio) {
		_tarea.setHoraInicio(horaInicio);
	}

	/**
	* Sets the latitud of this tarea.
	*
	* @param latitud the latitud of this tarea
	*/
	@Override
	public void setLatitud(double latitud) {
		_tarea.setLatitud(latitud);
	}

	/**
	* Sets the longitud of this tarea.
	*
	* @param longitud the longitud of this tarea
	*/
	@Override
	public void setLongitud(double longitud) {
		_tarea.setLongitud(longitud);
	}

	/**
	* Sets the modified date of this tarea.
	*
	* @param modifiedDate the modified date of this tarea
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_tarea.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_tarea.setNew(n);
	}

	/**
	* Sets the primary key of this tarea.
	*
	* @param primaryKey the primary key of this tarea
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tarea.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_tarea.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the tarea ID of this tarea.
	*
	* @param tareaId the tarea ID of this tarea
	*/
	@Override
	public void setTareaId(long tareaId) {
		_tarea.setTareaId(tareaId);
	}

	/**
	* Sets the tipo tarea of this tarea.
	*
	* @param tipoTarea the tipo tarea of this tarea
	*/
	@Override
	public void setTipoTarea(long tipoTarea) {
		_tarea.setTipoTarea(tipoTarea);
	}

	/**
	* Sets the user ID of this tarea.
	*
	* @param userId the user ID of this tarea
	*/
	@Override
	public void setUserId(long userId) {
		_tarea.setUserId(userId);
	}

	/**
	* Sets the user name of this tarea.
	*
	* @param userName the user name of this tarea
	*/
	@Override
	public void setUserName(String userName) {
		_tarea.setUserName(userName);
	}

	/**
	* Sets the user uuid of this tarea.
	*
	* @param userUuid the user uuid of this tarea
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_tarea.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Tarea> toCacheModel() {
		return _tarea.toCacheModel();
	}

	@Override
	public Tarea toEscapedModel() {
		return new TareaWrapper(_tarea.toEscapedModel());
	}

	@Override
	public String toString() {
		return _tarea.toString();
	}

	@Override
	public Tarea toUnescapedModel() {
		return new TareaWrapper(_tarea.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _tarea.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TareaWrapper)) {
			return false;
		}

		TareaWrapper tareaWrapper = (TareaWrapper)obj;

		if (Objects.equals(_tarea, tareaWrapper._tarea)) {
			return true;
		}

		return false;
	}

	@Override
	public Tarea getWrappedModel() {
		return _tarea;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tarea.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tarea.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tarea.resetOriginalValues();
	}

	private final Tarea _tarea;
}