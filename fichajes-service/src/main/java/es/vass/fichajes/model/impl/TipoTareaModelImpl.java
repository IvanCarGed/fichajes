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

package es.vass.fichajes.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import es.vass.fichajes.model.TipoTarea;
import es.vass.fichajes.model.TipoTareaModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the TipoTarea service. Represents a row in the &quot;Fichajes_TipoTarea&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TipoTareaModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TipoTareaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoTareaImpl
 * @see TipoTarea
 * @see TipoTareaModel
 * @generated
 */
@ProviderType
public class TipoTareaModelImpl extends BaseModelImpl<TipoTarea>
	implements TipoTareaModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tipo tarea model instance should use the {@link TipoTarea} interface instead.
	 */
	public static final String TABLE_NAME = "Fichajes_TipoTarea";
	public static final Object[][] TABLE_COLUMNS = {
			{ "tipoTareaId", Types.BIGINT },
			{ "nombre", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("tipoTareaId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("nombre", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table Fichajes_TipoTarea (tipoTareaId LONG not null primary key,nombre VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Fichajes_TipoTarea";
	public static final String ORDER_BY_JPQL = " ORDER BY tipoTarea.tipoTareaId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Fichajes_TipoTarea.tipoTareaId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(es.vass.fichajes.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.es.vass.fichajes.model.TipoTarea"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(es.vass.fichajes.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.es.vass.fichajes.model.TipoTarea"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(es.vass.fichajes.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.es.vass.fichajes.model.TipoTarea"),
			true);
	public static final long TIPOTAREAID_COLUMN_BITMASK = 1L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(es.vass.fichajes.service.util.ServiceProps.get(
				"lock.expiration.time.es.vass.fichajes.model.TipoTarea"));

	public TipoTareaModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _tipoTareaId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTipoTareaId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tipoTareaId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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
	public long getTipoTareaId() {
		return _tipoTareaId;
	}

	@Override
	public void setTipoTareaId(long tipoTareaId) {
		_columnBitmask |= TIPOTAREAID_COLUMN_BITMASK;

		if (!_setOriginalTipoTareaId) {
			_setOriginalTipoTareaId = true;

			_originalTipoTareaId = _tipoTareaId;
		}

		_tipoTareaId = tipoTareaId;
	}

	public long getOriginalTipoTareaId() {
		return _originalTipoTareaId;
	}

	@Override
	public String getNombre() {
		if (_nombre == null) {
			return "";
		}
		else {
			return _nombre;
		}
	}

	@Override
	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			TipoTarea.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TipoTarea toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TipoTarea)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TipoTareaImpl tipoTareaImpl = new TipoTareaImpl();

		tipoTareaImpl.setTipoTareaId(getTipoTareaId());
		tipoTareaImpl.setNombre(getNombre());

		tipoTareaImpl.resetOriginalValues();

		return tipoTareaImpl;
	}

	@Override
	public int compareTo(TipoTarea tipoTarea) {
		long primaryKey = tipoTarea.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipoTarea)) {
			return false;
		}

		TipoTarea tipoTarea = (TipoTarea)obj;

		long primaryKey = tipoTarea.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		TipoTareaModelImpl tipoTareaModelImpl = this;

		tipoTareaModelImpl._originalTipoTareaId = tipoTareaModelImpl._tipoTareaId;

		tipoTareaModelImpl._setOriginalTipoTareaId = false;

		tipoTareaModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TipoTarea> toCacheModel() {
		TipoTareaCacheModel tipoTareaCacheModel = new TipoTareaCacheModel();

		tipoTareaCacheModel.tipoTareaId = getTipoTareaId();

		tipoTareaCacheModel.nombre = getNombre();

		String nombre = tipoTareaCacheModel.nombre;

		if ((nombre != null) && (nombre.length() == 0)) {
			tipoTareaCacheModel.nombre = null;
		}

		return tipoTareaCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{tipoTareaId=");
		sb.append(getTipoTareaId());
		sb.append(", nombre=");
		sb.append(getNombre());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("es.vass.fichajes.model.TipoTarea");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tipoTareaId</column-name><column-value><![CDATA[");
		sb.append(getTipoTareaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombre</column-name><column-value><![CDATA[");
		sb.append(getNombre());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = TipoTarea.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			TipoTarea.class, ModelWrapper.class
		};
	private long _tipoTareaId;
	private long _originalTipoTareaId;
	private boolean _setOriginalTipoTareaId;
	private String _nombre;
	private long _columnBitmask;
	private TipoTarea _escapedModel;
}