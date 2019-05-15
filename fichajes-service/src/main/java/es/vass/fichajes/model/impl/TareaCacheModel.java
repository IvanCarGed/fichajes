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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import es.vass.fichajes.model.Tarea;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Tarea in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Tarea
 * @generated
 */
@ProviderType
public class TareaCacheModel implements CacheModel<Tarea>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TareaCacheModel)) {
			return false;
		}

		TareaCacheModel tareaCacheModel = (TareaCacheModel)obj;

		if (tareaId == tareaCacheModel.tareaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tareaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{tareaId=");
		sb.append(tareaId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", horaInicio=");
		sb.append(horaInicio);
		sb.append(", horaFin=");
		sb.append(horaFin);
		sb.append(", activa=");
		sb.append(activa);
		sb.append(", latitud=");
		sb.append(latitud);
		sb.append(", longitud=");
		sb.append(longitud);
		sb.append(", tipoTarea=");
		sb.append(tipoTarea);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Tarea toEntityModel() {
		TareaImpl tareaImpl = new TareaImpl();

		tareaImpl.setTareaId(tareaId);
		tareaImpl.setUserId(userId);

		if (userName == null) {
			tareaImpl.setUserName("");
		}
		else {
			tareaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tareaImpl.setCreateDate(null);
		}
		else {
			tareaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tareaImpl.setModifiedDate(null);
		}
		else {
			tareaImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (horaInicio == Long.MIN_VALUE) {
			tareaImpl.setHoraInicio(null);
		}
		else {
			tareaImpl.setHoraInicio(new Date(horaInicio));
		}

		if (horaFin == Long.MIN_VALUE) {
			tareaImpl.setHoraFin(null);
		}
		else {
			tareaImpl.setHoraFin(new Date(horaFin));
		}

		tareaImpl.setActiva(activa);
		tareaImpl.setLatitud(latitud);
		tareaImpl.setLongitud(longitud);
		tareaImpl.setTipoTarea(tipoTarea);

		tareaImpl.resetOriginalValues();

		return tareaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tareaId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		horaInicio = objectInput.readLong();
		horaFin = objectInput.readLong();

		activa = objectInput.readBoolean();

		latitud = objectInput.readDouble();

		longitud = objectInput.readDouble();

		tipoTarea = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tareaId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(horaInicio);
		objectOutput.writeLong(horaFin);

		objectOutput.writeBoolean(activa);

		objectOutput.writeDouble(latitud);

		objectOutput.writeDouble(longitud);

		objectOutput.writeLong(tipoTarea);
	}

	public long tareaId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long horaInicio;
	public long horaFin;
	public boolean activa;
	public double latitud;
	public double longitud;
	public long tipoTarea;
}