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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link TipoTarea}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoTarea
 * @generated
 */
@ProviderType
public class TipoTareaWrapper implements TipoTarea, ModelWrapper<TipoTarea> {
	public TipoTareaWrapper(TipoTarea tipoTarea) {
		_tipoTarea = tipoTarea;
	}

	@Override
	public Class<?> getModelClass() {
		return TipoTarea.class;
	}

	@Override
	public String getModelClassName() {
		return TipoTarea.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tipoTareaId", getTipoTareaId());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tipoTareaId = (Long)attributes.get("tipoTareaId");

		if (tipoTareaId != null) {
			setTipoTareaId(tipoTareaId);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
	}

	@Override
	public Object clone() {
		return new TipoTareaWrapper((TipoTarea)_tipoTarea.clone());
	}

	@Override
	public int compareTo(TipoTarea tipoTarea) {
		return _tipoTarea.compareTo(tipoTarea);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _tipoTarea.getExpandoBridge();
	}

	/**
	* Returns the nombre of this tipo tarea.
	*
	* @return the nombre of this tipo tarea
	*/
	@Override
	public String getNombre() {
		return _tipoTarea.getNombre();
	}

	/**
	* Returns the primary key of this tipo tarea.
	*
	* @return the primary key of this tipo tarea
	*/
	@Override
	public long getPrimaryKey() {
		return _tipoTarea.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tipoTarea.getPrimaryKeyObj();
	}

	/**
	* Returns the tipo tarea ID of this tipo tarea.
	*
	* @return the tipo tarea ID of this tipo tarea
	*/
	@Override
	public long getTipoTareaId() {
		return _tipoTarea.getTipoTareaId();
	}

	@Override
	public int hashCode() {
		return _tipoTarea.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _tipoTarea.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _tipoTarea.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tipoTarea.isNew();
	}

	@Override
	public void persist() {
		_tipoTarea.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tipoTarea.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_tipoTarea.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_tipoTarea.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_tipoTarea.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_tipoTarea.setNew(n);
	}

	/**
	* Sets the nombre of this tipo tarea.
	*
	* @param nombre the nombre of this tipo tarea
	*/
	@Override
	public void setNombre(String nombre) {
		_tipoTarea.setNombre(nombre);
	}

	/**
	* Sets the primary key of this tipo tarea.
	*
	* @param primaryKey the primary key of this tipo tarea
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tipoTarea.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_tipoTarea.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the tipo tarea ID of this tipo tarea.
	*
	* @param tipoTareaId the tipo tarea ID of this tipo tarea
	*/
	@Override
	public void setTipoTareaId(long tipoTareaId) {
		_tipoTarea.setTipoTareaId(tipoTareaId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TipoTarea> toCacheModel() {
		return _tipoTarea.toCacheModel();
	}

	@Override
	public TipoTarea toEscapedModel() {
		return new TipoTareaWrapper(_tipoTarea.toEscapedModel());
	}

	@Override
	public String toString() {
		return _tipoTarea.toString();
	}

	@Override
	public TipoTarea toUnescapedModel() {
		return new TipoTareaWrapper(_tipoTarea.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _tipoTarea.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipoTareaWrapper)) {
			return false;
		}

		TipoTareaWrapper tipoTareaWrapper = (TipoTareaWrapper)obj;

		if (Objects.equals(_tipoTarea, tipoTareaWrapper._tipoTarea)) {
			return true;
		}

		return false;
	}

	@Override
	public TipoTarea getWrappedModel() {
		return _tipoTarea;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tipoTarea.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tipoTarea.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tipoTarea.resetOriginalValues();
	}

	private final TipoTarea _tipoTarea;
}