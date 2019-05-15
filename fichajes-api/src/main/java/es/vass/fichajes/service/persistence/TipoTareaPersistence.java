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

package es.vass.fichajes.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import es.vass.fichajes.exception.NoSuchTipoTareaException;
import es.vass.fichajes.model.TipoTarea;

/**
 * The persistence interface for the tipo tarea service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see es.vass.fichajes.service.persistence.impl.TipoTareaPersistenceImpl
 * @see TipoTareaUtil
 * @generated
 */
@ProviderType
public interface TipoTareaPersistence extends BasePersistence<TipoTarea> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TipoTareaUtil} to access the tipo tarea persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tipo tareas where tipoTareaId = &#63;.
	*
	* @param tipoTareaId the tipo tarea ID
	* @return the matching tipo tareas
	*/
	public java.util.List<TipoTarea> findBytipoTareaId(long tipoTareaId);

	/**
	* Returns a range of all the tipo tareas where tipoTareaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoTareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tipoTareaId the tipo tarea ID
	* @param start the lower bound of the range of tipo tareas
	* @param end the upper bound of the range of tipo tareas (not inclusive)
	* @return the range of matching tipo tareas
	*/
	public java.util.List<TipoTarea> findBytipoTareaId(long tipoTareaId,
		int start, int end);

	/**
	* Returns an ordered range of all the tipo tareas where tipoTareaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoTareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tipoTareaId the tipo tarea ID
	* @param start the lower bound of the range of tipo tareas
	* @param end the upper bound of the range of tipo tareas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tipo tareas
	*/
	public java.util.List<TipoTarea> findBytipoTareaId(long tipoTareaId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoTarea> orderByComparator);

	/**
	* Returns an ordered range of all the tipo tareas where tipoTareaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoTareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tipoTareaId the tipo tarea ID
	* @param start the lower bound of the range of tipo tareas
	* @param end the upper bound of the range of tipo tareas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tipo tareas
	*/
	public java.util.List<TipoTarea> findBytipoTareaId(long tipoTareaId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoTarea> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first tipo tarea in the ordered set where tipoTareaId = &#63;.
	*
	* @param tipoTareaId the tipo tarea ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tipo tarea
	* @throws NoSuchTipoTareaException if a matching tipo tarea could not be found
	*/
	public TipoTarea findBytipoTareaId_First(long tipoTareaId,
		com.liferay.portal.kernel.util.OrderByComparator<TipoTarea> orderByComparator)
		throws NoSuchTipoTareaException;

	/**
	* Returns the first tipo tarea in the ordered set where tipoTareaId = &#63;.
	*
	* @param tipoTareaId the tipo tarea ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tipo tarea, or <code>null</code> if a matching tipo tarea could not be found
	*/
	public TipoTarea fetchBytipoTareaId_First(long tipoTareaId,
		com.liferay.portal.kernel.util.OrderByComparator<TipoTarea> orderByComparator);

	/**
	* Returns the last tipo tarea in the ordered set where tipoTareaId = &#63;.
	*
	* @param tipoTareaId the tipo tarea ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tipo tarea
	* @throws NoSuchTipoTareaException if a matching tipo tarea could not be found
	*/
	public TipoTarea findBytipoTareaId_Last(long tipoTareaId,
		com.liferay.portal.kernel.util.OrderByComparator<TipoTarea> orderByComparator)
		throws NoSuchTipoTareaException;

	/**
	* Returns the last tipo tarea in the ordered set where tipoTareaId = &#63;.
	*
	* @param tipoTareaId the tipo tarea ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tipo tarea, or <code>null</code> if a matching tipo tarea could not be found
	*/
	public TipoTarea fetchBytipoTareaId_Last(long tipoTareaId,
		com.liferay.portal.kernel.util.OrderByComparator<TipoTarea> orderByComparator);

	/**
	* Removes all the tipo tareas where tipoTareaId = &#63; from the database.
	*
	* @param tipoTareaId the tipo tarea ID
	*/
	public void removeBytipoTareaId(long tipoTareaId);

	/**
	* Returns the number of tipo tareas where tipoTareaId = &#63;.
	*
	* @param tipoTareaId the tipo tarea ID
	* @return the number of matching tipo tareas
	*/
	public int countBytipoTareaId(long tipoTareaId);

	/**
	* Caches the tipo tarea in the entity cache if it is enabled.
	*
	* @param tipoTarea the tipo tarea
	*/
	public void cacheResult(TipoTarea tipoTarea);

	/**
	* Caches the tipo tareas in the entity cache if it is enabled.
	*
	* @param tipoTareas the tipo tareas
	*/
	public void cacheResult(java.util.List<TipoTarea> tipoTareas);

	/**
	* Creates a new tipo tarea with the primary key. Does not add the tipo tarea to the database.
	*
	* @param tipoTareaId the primary key for the new tipo tarea
	* @return the new tipo tarea
	*/
	public TipoTarea create(long tipoTareaId);

	/**
	* Removes the tipo tarea with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tipoTareaId the primary key of the tipo tarea
	* @return the tipo tarea that was removed
	* @throws NoSuchTipoTareaException if a tipo tarea with the primary key could not be found
	*/
	public TipoTarea remove(long tipoTareaId) throws NoSuchTipoTareaException;

	public TipoTarea updateImpl(TipoTarea tipoTarea);

	/**
	* Returns the tipo tarea with the primary key or throws a {@link NoSuchTipoTareaException} if it could not be found.
	*
	* @param tipoTareaId the primary key of the tipo tarea
	* @return the tipo tarea
	* @throws NoSuchTipoTareaException if a tipo tarea with the primary key could not be found
	*/
	public TipoTarea findByPrimaryKey(long tipoTareaId)
		throws NoSuchTipoTareaException;

	/**
	* Returns the tipo tarea with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tipoTareaId the primary key of the tipo tarea
	* @return the tipo tarea, or <code>null</code> if a tipo tarea with the primary key could not be found
	*/
	public TipoTarea fetchByPrimaryKey(long tipoTareaId);

	@Override
	public java.util.Map<java.io.Serializable, TipoTarea> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the tipo tareas.
	*
	* @return the tipo tareas
	*/
	public java.util.List<TipoTarea> findAll();

	/**
	* Returns a range of all the tipo tareas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoTareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo tareas
	* @param end the upper bound of the range of tipo tareas (not inclusive)
	* @return the range of tipo tareas
	*/
	public java.util.List<TipoTarea> findAll(int start, int end);

	/**
	* Returns an ordered range of all the tipo tareas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoTareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo tareas
	* @param end the upper bound of the range of tipo tareas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tipo tareas
	*/
	public java.util.List<TipoTarea> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoTarea> orderByComparator);

	/**
	* Returns an ordered range of all the tipo tareas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TipoTareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo tareas
	* @param end the upper bound of the range of tipo tareas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tipo tareas
	*/
	public java.util.List<TipoTarea> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TipoTarea> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tipo tareas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of tipo tareas.
	*
	* @return the number of tipo tareas
	*/
	public int countAll();
}