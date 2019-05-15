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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TipoTareaSoap implements Serializable {
	public static TipoTareaSoap toSoapModel(TipoTarea model) {
		TipoTareaSoap soapModel = new TipoTareaSoap();

		soapModel.setTipoTareaId(model.getTipoTareaId());
		soapModel.setNombre(model.getNombre());

		return soapModel;
	}

	public static TipoTareaSoap[] toSoapModels(TipoTarea[] models) {
		TipoTareaSoap[] soapModels = new TipoTareaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TipoTareaSoap[][] toSoapModels(TipoTarea[][] models) {
		TipoTareaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TipoTareaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TipoTareaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TipoTareaSoap[] toSoapModels(List<TipoTarea> models) {
		List<TipoTareaSoap> soapModels = new ArrayList<TipoTareaSoap>(models.size());

		for (TipoTarea model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TipoTareaSoap[soapModels.size()]);
	}

	public TipoTareaSoap() {
	}

	public long getPrimaryKey() {
		return _tipoTareaId;
	}

	public void setPrimaryKey(long pk) {
		setTipoTareaId(pk);
	}

	public long getTipoTareaId() {
		return _tipoTareaId;
	}

	public void setTipoTareaId(long tipoTareaId) {
		_tipoTareaId = tipoTareaId;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	private long _tipoTareaId;
	private String _nombre;
}