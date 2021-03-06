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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the TipoTarea service. Represents a row in the &quot;Fichajes_TipoTarea&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TipoTareaModel
 * @see es.vass.fichajes.model.impl.TipoTareaImpl
 * @see es.vass.fichajes.model.impl.TipoTareaModelImpl
 * @generated
 */
@ImplementationClassName("es.vass.fichajes.model.impl.TipoTareaImpl")
@ProviderType
public interface TipoTarea extends TipoTareaModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link es.vass.fichajes.model.impl.TipoTareaImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TipoTarea, Long> TIPO_TAREA_ID_ACCESSOR = new Accessor<TipoTarea, Long>() {
			@Override
			public Long get(TipoTarea tipoTarea) {
				return tipoTarea.getTipoTareaId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TipoTarea> getTypeClass() {
				return TipoTarea.class;
			}
		};
}