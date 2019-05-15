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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import es.vass.fichajes.model.TipoTarea;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the tipo tarea service. This utility wraps {@link es.vass.fichajes.service.persistence.impl.TipoTareaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoTareaPersistence
 * @see es.vass.fichajes.service.persistence.impl.TipoTareaPersistenceImpl
 * @generated
 */
@ProviderType
public class TipoTareaUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TipoTarea tipoTarea) {
		getPersistence().clearCache(tipoTarea);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TipoTarea> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TipoTarea> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TipoTarea> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TipoTarea> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TipoTarea update(TipoTarea tipoTarea) {
		return getPersistence().update(tipoTarea);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TipoTarea update(TipoTarea tipoTarea,
		ServiceContext serviceContext) {
		return getPersistence().update(tipoTarea, serviceContext);
	}

	/**
	* Returns all the tipo tareas where tipoTareaId = &#63;.
	*
	* @param tipoTareaId the tipo tarea ID
	* @return the matching tipo tareas
	*/
	public static List<TipoTarea> findBytipoTareaId(long tipoTareaId) {
		return getPersistence().findBytipoTareaId(tipoTareaId);
	}

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
	public static List<TipoTarea> findBytipoTareaId(long tipoTareaId,
		int start, int end) {
		return getPersistence().findBytipoTareaId(tipoTareaId, start, end);
	}

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
	public static List<TipoTarea> findBytipoTareaId(long tipoTareaId,
		int start, int end, OrderByComparator<TipoTarea> orderByComparator) {
		return getPersistence()
				   .findBytipoTareaId(tipoTareaId, start, end, orderByComparator);
	}

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
	public static List<TipoTarea> findBytipoTareaId(long tipoTareaId,
		int start, int end, OrderByComparator<TipoTarea> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBytipoTareaId(tipoTareaId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first tipo tarea in the ordered set where tipoTareaId = &#63;.
	*
	* @param tipoTareaId the tipo tarea ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tipo tarea
	* @throws NoSuchTipoTareaException if a matching tipo tarea could not be found
	*/
	public static TipoTarea findBytipoTareaId_First(long tipoTareaId,
		OrderByComparator<TipoTarea> orderByComparator)
		throws es.vass.fichajes.exception.NoSuchTipoTareaException {
		return getPersistence()
				   .findBytipoTareaId_First(tipoTareaId, orderByComparator);
	}

	/**
	* Returns the first tipo tarea in the ordered set where tipoTareaId = &#63;.
	*
	* @param tipoTareaId the tipo tarea ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tipo tarea, or <code>null</code> if a matching tipo tarea could not be found
	*/
	public static TipoTarea fetchBytipoTareaId_First(long tipoTareaId,
		OrderByComparator<TipoTarea> orderByComparator) {
		return getPersistence()
				   .fetchBytipoTareaId_First(tipoTareaId, orderByComparator);
	}

	/**
	* Returns the last tipo tarea in the ordered set where tipoTareaId = &#63;.
	*
	* @param tipoTareaId the tipo tarea ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tipo tarea
	* @throws NoSuchTipoTareaException if a matching tipo tarea could not be found
	*/
	public static TipoTarea findBytipoTareaId_Last(long tipoTareaId,
		OrderByComparator<TipoTarea> orderByComparator)
		throws es.vass.fichajes.exception.NoSuchTipoTareaException {
		return getPersistence()
				   .findBytipoTareaId_Last(tipoTareaId, orderByComparator);
	}

	/**
	* Returns the last tipo tarea in the ordered set where tipoTareaId = &#63;.
	*
	* @param tipoTareaId the tipo tarea ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tipo tarea, or <code>null</code> if a matching tipo tarea could not be found
	*/
	public static TipoTarea fetchBytipoTareaId_Last(long tipoTareaId,
		OrderByComparator<TipoTarea> orderByComparator) {
		return getPersistence()
				   .fetchBytipoTareaId_Last(tipoTareaId, orderByComparator);
	}

	/**
	* Removes all the tipo tareas where tipoTareaId = &#63; from the database.
	*
	* @param tipoTareaId the tipo tarea ID
	*/
	public static void removeBytipoTareaId(long tipoTareaId) {
		getPersistence().removeBytipoTareaId(tipoTareaId);
	}

	/**
	* Returns the number of tipo tareas where tipoTareaId = &#63;.
	*
	* @param tipoTareaId the tipo tarea ID
	* @return the number of matching tipo tareas
	*/
	public static int countBytipoTareaId(long tipoTareaId) {
		return getPersistence().countBytipoTareaId(tipoTareaId);
	}

	/**
	* Caches the tipo tarea in the entity cache if it is enabled.
	*
	* @param tipoTarea the tipo tarea
	*/
	public static void cacheResult(TipoTarea tipoTarea) {
		getPersistence().cacheResult(tipoTarea);
	}

	/**
	* Caches the tipo tareas in the entity cache if it is enabled.
	*
	* @param tipoTareas the tipo tareas
	*/
	public static void cacheResult(List<TipoTarea> tipoTareas) {
		getPersistence().cacheResult(tipoTareas);
	}

	/**
	* Creates a new tipo tarea with the primary key. Does not add the tipo tarea to the database.
	*
	* @param tipoTareaId the primary key for the new tipo tarea
	* @return the new tipo tarea
	*/
	public static TipoTarea create(long tipoTareaId) {
		return getPersistence().create(tipoTareaId);
	}

	/**
	* Removes the tipo tarea with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tipoTareaId the primary key of the tipo tarea
	* @return the tipo tarea that was removed
	* @throws NoSuchTipoTareaException if a tipo tarea with the primary key could not be found
	*/
	public static TipoTarea remove(long tipoTareaId)
		throws es.vass.fichajes.exception.NoSuchTipoTareaException {
		return getPersistence().remove(tipoTareaId);
	}

	public static TipoTarea updateImpl(TipoTarea tipoTarea) {
		return getPersistence().updateImpl(tipoTarea);
	}

	/**
	* Returns the tipo tarea with the primary key or throws a {@link NoSuchTipoTareaException} if it could not be found.
	*
	* @param tipoTareaId the primary key of the tipo tarea
	* @return the tipo tarea
	* @throws NoSuchTipoTareaException if a tipo tarea with the primary key could not be found
	*/
	public static TipoTarea findByPrimaryKey(long tipoTareaId)
		throws es.vass.fichajes.exception.NoSuchTipoTareaException {
		return getPersistence().findByPrimaryKey(tipoTareaId);
	}

	/**
	* Returns the tipo tarea with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tipoTareaId the primary key of the tipo tarea
	* @return the tipo tarea, or <code>null</code> if a tipo tarea with the primary key could not be found
	*/
	public static TipoTarea fetchByPrimaryKey(long tipoTareaId) {
		return getPersistence().fetchByPrimaryKey(tipoTareaId);
	}

	public static java.util.Map<java.io.Serializable, TipoTarea> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the tipo tareas.
	*
	* @return the tipo tareas
	*/
	public static List<TipoTarea> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<TipoTarea> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<TipoTarea> findAll(int start, int end,
		OrderByComparator<TipoTarea> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<TipoTarea> findAll(int start, int end,
		OrderByComparator<TipoTarea> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tipo tareas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tipo tareas.
	*
	* @return the number of tipo tareas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TipoTareaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TipoTareaPersistence, TipoTareaPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TipoTareaPersistence.class);

		ServiceTracker<TipoTareaPersistence, TipoTareaPersistence> serviceTracker =
			new ServiceTracker<TipoTareaPersistence, TipoTareaPersistence>(bundle.getBundleContext(),
				TipoTareaPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}