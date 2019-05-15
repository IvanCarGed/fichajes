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
 * Provides the local service utility for TipoTarea. This utility wraps
 * {@link es.vass.fichajes.service.impl.TipoTareaLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TipoTareaLocalService
 * @see es.vass.fichajes.service.base.TipoTareaLocalServiceBaseImpl
 * @see es.vass.fichajes.service.impl.TipoTareaLocalServiceImpl
 * @generated
 */
@ProviderType
public class TipoTareaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link es.vass.fichajes.service.impl.TipoTareaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the tipo tarea to the database. Also notifies the appropriate model listeners.
	*
	* @param tipoTarea the tipo tarea
	* @return the tipo tarea that was added
	*/
	public static es.vass.fichajes.model.TipoTarea addTipoTarea(
		es.vass.fichajes.model.TipoTarea tipoTarea) {
		return getService().addTipoTarea(tipoTarea);
	}

	/**
	* Creates a new tipo tarea with the primary key. Does not add the tipo tarea to the database.
	*
	* @param tipoTareaId the primary key for the new tipo tarea
	* @return the new tipo tarea
	*/
	public static es.vass.fichajes.model.TipoTarea createTipoTarea(
		long tipoTareaId) {
		return getService().createTipoTarea(tipoTareaId);
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
	* Deletes the tipo tarea with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tipoTareaId the primary key of the tipo tarea
	* @return the tipo tarea that was removed
	* @throws PortalException if a tipo tarea with the primary key could not be found
	*/
	public static es.vass.fichajes.model.TipoTarea deleteTipoTarea(
		long tipoTareaId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTipoTarea(tipoTareaId);
	}

	/**
	* Deletes the tipo tarea from the database. Also notifies the appropriate model listeners.
	*
	* @param tipoTarea the tipo tarea
	* @return the tipo tarea that was removed
	*/
	public static es.vass.fichajes.model.TipoTarea deleteTipoTarea(
		es.vass.fichajes.model.TipoTarea tipoTarea) {
		return getService().deleteTipoTarea(tipoTarea);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link es.vass.fichajes.model.impl.TipoTareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link es.vass.fichajes.model.impl.TipoTareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static es.vass.fichajes.model.TipoTarea fetchTipoTarea(
		long tipoTareaId) {
		return getService().fetchTipoTarea(tipoTareaId);
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
	* Returns the tipo tarea with the primary key.
	*
	* @param tipoTareaId the primary key of the tipo tarea
	* @return the tipo tarea
	* @throws PortalException if a tipo tarea with the primary key could not be found
	*/
	public static es.vass.fichajes.model.TipoTarea getTipoTarea(
		long tipoTareaId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTipoTarea(tipoTareaId);
	}

	/**
	* Returns a range of all the tipo tareas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link es.vass.fichajes.model.impl.TipoTareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo tareas
	* @param end the upper bound of the range of tipo tareas (not inclusive)
	* @return the range of tipo tareas
	*/
	public static java.util.List<es.vass.fichajes.model.TipoTarea> getTipoTareas(
		int start, int end) {
		return getService().getTipoTareas(start, end);
	}

	/**
	* Returns the number of tipo tareas.
	*
	* @return the number of tipo tareas
	*/
	public static int getTipoTareasCount() {
		return getService().getTipoTareasCount();
	}

	/**
	* Updates the tipo tarea in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipoTarea the tipo tarea
	* @return the tipo tarea that was updated
	*/
	public static es.vass.fichajes.model.TipoTarea updateTipoTarea(
		es.vass.fichajes.model.TipoTarea tipoTarea) {
		return getService().updateTipoTarea(tipoTarea);
	}

	public static TipoTareaLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TipoTareaLocalService, TipoTareaLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TipoTareaLocalService.class);

		ServiceTracker<TipoTareaLocalService, TipoTareaLocalService> serviceTracker =
			new ServiceTracker<TipoTareaLocalService, TipoTareaLocalService>(bundle.getBundleContext(),
				TipoTareaLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}