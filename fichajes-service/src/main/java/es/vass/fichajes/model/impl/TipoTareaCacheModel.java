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

import es.vass.fichajes.model.TipoTarea;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TipoTarea in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TipoTarea
 * @generated
 */
@ProviderType
public class TipoTareaCacheModel implements CacheModel<TipoTarea>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipoTareaCacheModel)) {
			return false;
		}

		TipoTareaCacheModel tipoTareaCacheModel = (TipoTareaCacheModel)obj;

		if (tipoTareaId == tipoTareaCacheModel.tipoTareaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tipoTareaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{tipoTareaId=");
		sb.append(tipoTareaId);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TipoTarea toEntityModel() {
		TipoTareaImpl tipoTareaImpl = new TipoTareaImpl();

		tipoTareaImpl.setTipoTareaId(tipoTareaId);

		if (nombre == null) {
			tipoTareaImpl.setNombre("");
		}
		else {
			tipoTareaImpl.setNombre(nombre);
		}

		tipoTareaImpl.resetOriginalValues();

		return tipoTareaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tipoTareaId = objectInput.readLong();
		nombre = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tipoTareaId);

		if (nombre == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nombre);
		}
	}

	public long tipoTareaId;
	public String nombre;
}