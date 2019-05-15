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

package es.vass.fichajes.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Tarea. This utility wraps
 * {@link es.vass.fichajes.service.impl.TareaLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TareaLocalService
 * @see es.vass.fichajes.service.base.TareaLocalServiceBaseImpl
 * @see es.vass.fichajes.service.impl.TareaLocalServiceImpl
 * @generated
 */
@ProviderType
public class TareaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link es.vass.fichajes.service.impl.TareaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addTarea(long userId, String userName,
		java.util.Date createDate, java.util.Date horaInicio, double latitud,
		double longitud, long tipoTarea) {
		getService()
			.addTarea(userId, userName, createDate, horaInicio, latitud,
			longitud, tipoTarea);
	}

	/**
	* Adds the tarea to the database. Also notifies the appropriate model listeners.
	*
	* @param tarea the tarea
	* @return the tarea that was added
	*/
	public static es.vass.fichajes.model.Tarea addTarea(
		es.vass.fichajes.model.Tarea tarea) {
		return getService().addTarea(tarea);
	}

	/**
	* Creates a new tarea with the primary key. Does not add the tarea to the database.
	*
	* @param tareaId the primary key for the new tarea
	* @return the new tarea
	*/
	public static es.vass.fichajes.model.Tarea createTarea(long tareaId) {
		return getService().createTarea(tareaId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the tarea with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tareaId the primary key of the tarea
	* @return the tarea that was removed
	* @throws PortalException if a tarea with the primary key could not be found
	*/
	public static es.vass.fichajes.model.Tarea deleteTarea(long tareaId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTarea(tareaId);
	}

	/**
	* Deletes the tarea from the database. Also notifies the appropriate model listeners.
	*
	* @param tarea the tarea
	* @return the tarea that was removed
	*/
	public static es.vass.fichajes.model.Tarea deleteTarea(
		es.vass.fichajes.model.Tarea tarea) {
		return getService().deleteTarea(tarea);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link es.vass.fichajes.model.impl.TareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link es.vass.fichajes.model.impl.TareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static void endTarea(long tareaId, java.util.Date modifiedDate,
		java.util.Date horaFin)
		throws es.vass.fichajes.exception.NoSuchTareaException {
		getService().endTarea(tareaId, modifiedDate, horaFin);
	}

	public static es.vass.fichajes.model.Tarea fetchTarea(long tareaId) {
		return getService().fetchTarea(tareaId);
	}

	public static java.util.List<es.vass.fichajes.model.Tarea> findByUserId(
		long userId) {
		return getService().findByUserId(userId);
	}

	public static java.util.List<es.vass.fichajes.model.Tarea> findByUsuario(
		String userName) {
		return getService().findByUsuario(userName);
	}

	public static es.vass.fichajes.model.Tarea findLast(long userId) {
		return getService().findLast(userId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the tarea with the primary key.
	*
	* @param tareaId the primary key of the tarea
	* @return the tarea
	* @throws PortalException if a tarea with the primary key could not be found
	*/
	public static es.vass.fichajes.model.Tarea getTarea(long tareaId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTarea(tareaId);
	}

	/**
	* Returns a range of all the tareas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link es.vass.fichajes.model.impl.TareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tareas
	* @param end the upper bound of the range of tareas (not inclusive)
	* @return the range of tareas
	*/
	public static java.util.List<es.vass.fichajes.model.Tarea> getTareas(
		int start, int end) {
		return getService().getTareas(start, end);
	}

	/**
	* Returns the number of tareas.
	*
	* @return the number of tareas
	*/
	public static int getTareasCount() {
		return getService().getTareasCount();
	}

	/**
	* Updates the tarea in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tarea the tarea
	* @return the tarea that was updated
	*/
	public static es.vass.fichajes.model.Tarea updateTarea(
		es.vass.fichajes.model.Tarea tarea) {
		return getService().updateTarea(tarea);
	}

	public static TareaLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TareaLocalService, TareaLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TareaLocalService.class);

		ServiceTracker<TareaLocalService, TareaLocalService> serviceTracker = new ServiceTracker<TareaLocalService, TareaLocalService>(bundle.getBundleContext(),
				TareaLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}