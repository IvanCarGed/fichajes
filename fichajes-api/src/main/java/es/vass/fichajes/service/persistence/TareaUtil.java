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

import es.vass.fichajes.model.Tarea;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the tarea service. This utility wraps {@link es.vass.fichajes.service.persistence.impl.TareaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TareaPersistence
 * @see es.vass.fichajes.service.persistence.impl.TareaPersistenceImpl
 * @generated
 */
@ProviderType
public class TareaUtil {
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
	public static void clearCache(Tarea tarea) {
		getPersistence().clearCache(tarea);
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
	public static List<Tarea> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Tarea> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Tarea> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Tarea> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Tarea update(Tarea tarea) {
		return getPersistence().update(tarea);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Tarea update(Tarea tarea, ServiceContext serviceContext) {
		return getPersistence().update(tarea, serviceContext);
	}

	/**
	* Returns all the tareas where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching tareas
	*/
	public static List<Tarea> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

	/**
	* Returns a range of all the tareas where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of tareas
	* @param end the upper bound of the range of tareas (not inclusive)
	* @return the range of matching tareas
	*/
	public static List<Tarea> findByuserId(long userId, int start, int end) {
		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the tareas where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of tareas
	* @param end the upper bound of the range of tareas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tareas
	*/
	public static List<Tarea> findByuserId(long userId, int start, int end,
		OrderByComparator<Tarea> orderByComparator) {
		return getPersistence()
				   .findByuserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tareas where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of tareas
	* @param end the upper bound of the range of tareas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tareas
	*/
	public static List<Tarea> findByuserId(long userId, int start, int end,
		OrderByComparator<Tarea> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByuserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first tarea in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tarea
	* @throws NoSuchTareaException if a matching tarea could not be found
	*/
	public static Tarea findByuserId_First(long userId,
		OrderByComparator<Tarea> orderByComparator)
		throws es.vass.fichajes.exception.NoSuchTareaException {
		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first tarea in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tarea, or <code>null</code> if a matching tarea could not be found
	*/
	public static Tarea fetchByuserId_First(long userId,
		OrderByComparator<Tarea> orderByComparator) {
		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last tarea in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tarea
	* @throws NoSuchTareaException if a matching tarea could not be found
	*/
	public static Tarea findByuserId_Last(long userId,
		OrderByComparator<Tarea> orderByComparator)
		throws es.vass.fichajes.exception.NoSuchTareaException {
		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last tarea in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tarea, or <code>null</code> if a matching tarea could not be found
	*/
	public static Tarea fetchByuserId_Last(long userId,
		OrderByComparator<Tarea> orderByComparator) {
		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the tareas before and after the current tarea in the ordered set where userId = &#63;.
	*
	* @param tareaId the primary key of the current tarea
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tarea
	* @throws NoSuchTareaException if a tarea with the primary key could not be found
	*/
	public static Tarea[] findByuserId_PrevAndNext(long tareaId, long userId,
		OrderByComparator<Tarea> orderByComparator)
		throws es.vass.fichajes.exception.NoSuchTareaException {
		return getPersistence()
				   .findByuserId_PrevAndNext(tareaId, userId, orderByComparator);
	}

	/**
	* Removes all the tareas where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	* Returns the number of tareas where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching tareas
	*/
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	* Returns all the tareas where userName = &#63;.
	*
	* @param userName the user name
	* @return the matching tareas
	*/
	public static List<Tarea> findByuserName(String userName) {
		return getPersistence().findByuserName(userName);
	}

	/**
	* Returns a range of all the tareas where userName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userName the user name
	* @param start the lower bound of the range of tareas
	* @param end the upper bound of the range of tareas (not inclusive)
	* @return the range of matching tareas
	*/
	public static List<Tarea> findByuserName(String userName, int start, int end) {
		return getPersistence().findByuserName(userName, start, end);
	}

	/**
	* Returns an ordered range of all the tareas where userName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userName the user name
	* @param start the lower bound of the range of tareas
	* @param end the upper bound of the range of tareas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tareas
	*/
	public static List<Tarea> findByuserName(String userName, int start,
		int end, OrderByComparator<Tarea> orderByComparator) {
		return getPersistence()
				   .findByuserName(userName, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tareas where userName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userName the user name
	* @param start the lower bound of the range of tareas
	* @param end the upper bound of the range of tareas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tareas
	*/
	public static List<Tarea> findByuserName(String userName, int start,
		int end, OrderByComparator<Tarea> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByuserName(userName, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first tarea in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tarea
	* @throws NoSuchTareaException if a matching tarea could not be found
	*/
	public static Tarea findByuserName_First(String userName,
		OrderByComparator<Tarea> orderByComparator)
		throws es.vass.fichajes.exception.NoSuchTareaException {
		return getPersistence().findByuserName_First(userName, orderByComparator);
	}

	/**
	* Returns the first tarea in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tarea, or <code>null</code> if a matching tarea could not be found
	*/
	public static Tarea fetchByuserName_First(String userName,
		OrderByComparator<Tarea> orderByComparator) {
		return getPersistence()
				   .fetchByuserName_First(userName, orderByComparator);
	}

	/**
	* Returns the last tarea in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tarea
	* @throws NoSuchTareaException if a matching tarea could not be found
	*/
	public static Tarea findByuserName_Last(String userName,
		OrderByComparator<Tarea> orderByComparator)
		throws es.vass.fichajes.exception.NoSuchTareaException {
		return getPersistence().findByuserName_Last(userName, orderByComparator);
	}

	/**
	* Returns the last tarea in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tarea, or <code>null</code> if a matching tarea could not be found
	*/
	public static Tarea fetchByuserName_Last(String userName,
		OrderByComparator<Tarea> orderByComparator) {
		return getPersistence().fetchByuserName_Last(userName, orderByComparator);
	}

	/**
	* Returns the tareas before and after the current tarea in the ordered set where userName = &#63;.
	*
	* @param tareaId the primary key of the current tarea
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tarea
	* @throws NoSuchTareaException if a tarea with the primary key could not be found
	*/
	public static Tarea[] findByuserName_PrevAndNext(long tareaId,
		String userName, OrderByComparator<Tarea> orderByComparator)
		throws es.vass.fichajes.exception.NoSuchTareaException {
		return getPersistence()
				   .findByuserName_PrevAndNext(tareaId, userName,
			orderByComparator);
	}

	/**
	* Removes all the tareas where userName = &#63; from the database.
	*
	* @param userName the user name
	*/
	public static void removeByuserName(String userName) {
		getPersistence().removeByuserName(userName);
	}

	/**
	* Returns the number of tareas where userName = &#63;.
	*
	* @param userName the user name
	* @return the number of matching tareas
	*/
	public static int countByuserName(String userName) {
		return getPersistence().countByuserName(userName);
	}

	/**
	* Returns all the tareas where createDate = &#63;.
	*
	* @param createDate the create date
	* @return the matching tareas
	*/
	public static List<Tarea> findBycreateDate(Date createDate) {
		return getPersistence().findBycreateDate(createDate);
	}

	/**
	* Returns a range of all the tareas where createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createDate the create date
	* @param start the lower bound of the range of tareas
	* @param end the upper bound of the range of tareas (not inclusive)
	* @return the range of matching tareas
	*/
	public static List<Tarea> findBycreateDate(Date createDate, int start,
		int end) {
		return getPersistence().findBycreateDate(createDate, start, end);
	}

	/**
	* Returns an ordered range of all the tareas where createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createDate the create date
	* @param start the lower bound of the range of tareas
	* @param end the upper bound of the range of tareas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tareas
	*/
	public static List<Tarea> findBycreateDate(Date createDate, int start,
		int end, OrderByComparator<Tarea> orderByComparator) {
		return getPersistence()
				   .findBycreateDate(createDate, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tareas where createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createDate the create date
	* @param start the lower bound of the range of tareas
	* @param end the upper bound of the range of tareas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tareas
	*/
	public static List<Tarea> findBycreateDate(Date createDate, int start,
		int end, OrderByComparator<Tarea> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBycreateDate(createDate, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first tarea in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tarea
	* @throws NoSuchTareaException if a matching tarea could not be found
	*/
	public static Tarea findBycreateDate_First(Date createDate,
		OrderByComparator<Tarea> orderByComparator)
		throws es.vass.fichajes.exception.NoSuchTareaException {
		return getPersistence()
				   .findBycreateDate_First(createDate, orderByComparator);
	}

	/**
	* Returns the first tarea in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tarea, or <code>null</code> if a matching tarea could not be found
	*/
	public static Tarea fetchBycreateDate_First(Date createDate,
		OrderByComparator<Tarea> orderByComparator) {
		return getPersistence()
				   .fetchBycreateDate_First(createDate, orderByComparator);
	}

	/**
	* Returns the last tarea in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tarea
	* @throws NoSuchTareaException if a matching tarea could not be found
	*/
	public static Tarea findBycreateDate_Last(Date createDate,
		OrderByComparator<Tarea> orderByComparator)
		throws es.vass.fichajes.exception.NoSuchTareaException {
		return getPersistence()
				   .findBycreateDate_Last(createDate, orderByComparator);
	}

	/**
	* Returns the last tarea in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tarea, or <code>null</code> if a matching tarea could not be found
	*/
	public static Tarea fetchBycreateDate_Last(Date createDate,
		OrderByComparator<Tarea> orderByComparator) {
		return getPersistence()
				   .fetchBycreateDate_Last(createDate, orderByComparator);
	}

	/**
	* Returns the tareas before and after the current tarea in the ordered set where createDate = &#63;.
	*
	* @param tareaId the primary key of the current tarea
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tarea
	* @throws NoSuchTareaException if a tarea with the primary key could not be found
	*/
	public static Tarea[] findBycreateDate_PrevAndNext(long tareaId,
		Date createDate, OrderByComparator<Tarea> orderByComparator)
		throws es.vass.fichajes.exception.NoSuchTareaException {
		return getPersistence()
				   .findBycreateDate_PrevAndNext(tareaId, createDate,
			orderByComparator);
	}

	/**
	* Removes all the tareas where createDate = &#63; from the database.
	*
	* @param createDate the create date
	*/
	public static void removeBycreateDate(Date createDate) {
		getPersistence().removeBycreateDate(createDate);
	}

	/**
	* Returns the number of tareas where createDate = &#63;.
	*
	* @param createDate the create date
	* @return the number of matching tareas
	*/
	public static int countBycreateDate(Date createDate) {
		return getPersistence().countBycreateDate(createDate);
	}

	/**
	* Caches the tarea in the entity cache if it is enabled.
	*
	* @param tarea the tarea
	*/
	public static void cacheResult(Tarea tarea) {
		getPersistence().cacheResult(tarea);
	}

	/**
	* Caches the tareas in the entity cache if it is enabled.
	*
	* @param tareas the tareas
	*/
	public static void cacheResult(List<Tarea> tareas) {
		getPersistence().cacheResult(tareas);
	}

	/**
	* Creates a new tarea with the primary key. Does not add the tarea to the database.
	*
	* @param tareaId the primary key for the new tarea
	* @return the new tarea
	*/
	public static Tarea create(long tareaId) {
		return getPersistence().create(tareaId);
	}

	/**
	* Removes the tarea with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tareaId the primary key of the tarea
	* @return the tarea that was removed
	* @throws NoSuchTareaException if a tarea with the primary key could not be found
	*/
	public static Tarea remove(long tareaId)
		throws es.vass.fichajes.exception.NoSuchTareaException {
		return getPersistence().remove(tareaId);
	}

	public static Tarea updateImpl(Tarea tarea) {
		return getPersistence().updateImpl(tarea);
	}

	/**
	* Returns the tarea with the primary key or throws a {@link NoSuchTareaException} if it could not be found.
	*
	* @param tareaId the primary key of the tarea
	* @return the tarea
	* @throws NoSuchTareaException if a tarea with the primary key could not be found
	*/
	public static Tarea findByPrimaryKey(long tareaId)
		throws es.vass.fichajes.exception.NoSuchTareaException {
		return getPersistence().findByPrimaryKey(tareaId);
	}

	/**
	* Returns the tarea with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tareaId the primary key of the tarea
	* @return the tarea, or <code>null</code> if a tarea with the primary key could not be found
	*/
	public static Tarea fetchByPrimaryKey(long tareaId) {
		return getPersistence().fetchByPrimaryKey(tareaId);
	}

	public static java.util.Map<java.io.Serializable, Tarea> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the tareas.
	*
	* @return the tareas
	*/
	public static List<Tarea> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tareas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tareas
	* @param end the upper bound of the range of tareas (not inclusive)
	* @return the range of tareas
	*/
	public static List<Tarea> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tareas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tareas
	* @param end the upper bound of the range of tareas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tareas
	*/
	public static List<Tarea> findAll(int start, int end,
		OrderByComparator<Tarea> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tareas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TareaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tareas
	* @param end the upper bound of the range of tareas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tareas
	*/
	public static List<Tarea> findAll(int start, int end,
		OrderByComparator<Tarea> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tareas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tareas.
	*
	* @return the number of tareas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TareaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TareaPersistence, TareaPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TareaPersistence.class);

		ServiceTracker<TareaPersistence, TareaPersistence> serviceTracker = new ServiceTracker<TareaPersistence, TareaPersistence>(bundle.getBundleContext(),
				TareaPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}