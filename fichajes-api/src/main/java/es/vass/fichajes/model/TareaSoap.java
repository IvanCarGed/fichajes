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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TareaSoap implements Serializable {
	public static TareaSoap toSoapModel(Tarea model) {
		TareaSoap soapModel = new TareaSoap();

		soapModel.setTareaId(model.getTareaId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setHoraInicio(model.getHoraInicio());
		soapModel.setHoraFin(model.getHoraFin());
		soapModel.setActiva(model.isActiva());
		soapModel.setLatitud(model.getLatitud());
		soapModel.setLongitud(model.getLongitud());
		soapModel.setTipoTarea(model.getTipoTarea());

		return soapModel;
	}

	public static TareaSoap[] toSoapModels(Tarea[] models) {
		TareaSoap[] soapModels = new TareaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TareaSoap[][] toSoapModels(Tarea[][] models) {
		TareaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TareaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TareaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TareaSoap[] toSoapModels(List<Tarea> models) {
		List<TareaSoap> soapModels = new ArrayList<TareaSoap>(models.size());

		for (Tarea model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TareaSoap[soapModels.size()]);
	}

	public TareaSoap() {
	}

	public long getPrimaryKey() {
		return _tareaId;
	}

	public void setPrimaryKey(long pk) {
		setTareaId(pk);
	}

	public long getTareaId() {
		return _tareaId;
	}

	public void setTareaId(long tareaId) {
		_tareaId = tareaId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getHoraInicio() {
		return _horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		_horaInicio = horaInicio;
	}

	public Date getHoraFin() {
		return _horaFin;
	}

	public void setHoraFin(Date horaFin) {
		_horaFin = horaFin;
	}

	public boolean getActiva() {
		return _activa;
	}

	public boolean isActiva() {
		return _activa;
	}

	public void setActiva(boolean activa) {
		_activa = activa;
	}

	public double getLatitud() {
		return _latitud;
	}

	public void setLatitud(double latitud) {
		_latitud = latitud;
	}

	public double getLongitud() {
		return _longitud;
	}

	public void setLongitud(double longitud) {
		_longitud = longitud;
	}

	public long getTipoTarea() {
		return _tipoTarea;
	}

	public void setTipoTarea(long tipoTarea) {
		_tipoTarea = tipoTarea;
	}

	private long _tareaId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _horaInicio;
	private Date _horaFin;
	private boolean _activa;
	private double _latitud;
	private double _longitud;
	private long _tipoTarea;
}