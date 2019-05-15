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

import es.vass.fichajes.exception.NoSuchTareaException;
import es.vass.fichajes.model.Tarea;

import java.util.Date;

/**
 * The persistence interface for the tarea service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see es.vass.fichajes.service.persistence.impl.TareaPersistenceImpl
 * @see TareaUtil
 * @generated
 */
@ProviderType
public interface TareaPersistence extends BasePersistence<Tarea> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TareaUtil} to access the tarea persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tareas where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching tareas
	*/
	public java.util.List<Tarea> findByuserId(long userId);

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
	public java.util.List<Tarea> findByuserId(long userId, int start, int end);

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
	public java.util.List<Tarea> findByuserId(long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator);

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
	public java.util.List<Tarea> findByuserId(long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first tarea in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tarea
	* @throws NoSuchTareaException if a matching tarea could not be found
	*/
	public Tarea findByuserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator)
		throws NoSuchTareaException;

	/**
	* Returns the first tarea in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tarea, or <code>null</code> if a matching tarea could not be found
	*/
	public Tarea fetchByuserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator);

	/**
	* Returns the last tarea in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tarea
	* @throws NoSuchTareaException if a matching tarea could not be found
	*/
	public Tarea findByuserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator)
		throws NoSuchTareaException;

	/**
	* Returns the last tarea in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tarea, or <code>null</code> if a matching tarea could not be found
	*/
	public Tarea fetchByuserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator);

	/**
	* Returns the tareas before and after the current tarea in the ordered set where userId = &#63;.
	*
	* @param tareaId the primary key of the current tarea
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tarea
	* @throws NoSuchTareaException if a tarea with the primary key could not be found
	*/
	public Tarea[] findByuserId_PrevAndNext(long tareaId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator)
		throws NoSuchTareaException;

	/**
	* Removes all the tareas where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByuserId(long userId);

	/**
	* Returns the number of tareas where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching tareas
	*/
	public int countByuserId(long userId);

	/**
	* Returns all the tareas where userName = &#63;.
	*
	* @param userName the user name
	* @return the matching tareas
	*/
	public java.util.List<Tarea> findByuserName(String userName);

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
	public java.util.List<Tarea> findByuserName(String userName, int start,
		int end);

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
	public java.util.List<Tarea> findByuserName(String userName, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator);

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
	public java.util.List<Tarea> findByuserName(String userName, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first tarea in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tarea
	* @throws NoSuchTareaException if a matching tarea could not be found
	*/
	public Tarea findByuserName_First(String userName,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator)
		throws NoSuchTareaException;

	/**
	* Returns the first tarea in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tarea, or <code>null</code> if a matching tarea could not be found
	*/
	public Tarea fetchByuserName_First(String userName,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator);

	/**
	* Returns the last tarea in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tarea
	* @throws NoSuchTareaException if a matching tarea could not be found
	*/
	public Tarea findByuserName_Last(String userName,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator)
		throws NoSuchTareaException;

	/**
	* Returns the last tarea in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tarea, or <code>null</code> if a matching tarea could not be found
	*/
	public Tarea fetchByuserName_Last(String userName,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator);

	/**
	* Returns the tareas before and after the current tarea in the ordered set where userName = &#63;.
	*
	* @param tareaId the primary key of the current tarea
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tarea
	* @throws NoSuchTareaException if a tarea with the primary key could not be found
	*/
	public Tarea[] findByuserName_PrevAndNext(long tareaId, String userName,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator)
		throws NoSuchTareaException;

	/**
	* Removes all the tareas where userName = &#63; from the database.
	*
	* @param userName the user name
	*/
	public void removeByuserName(String userName);

	/**
	* Returns the number of tareas where userName = &#63;.
	*
	* @param userName the user name
	* @return the number of matching tareas
	*/
	public int countByuserName(String userName);

	/**
	* Returns all the tareas where createDate = &#63;.
	*
	* @param createDate the create date
	* @return the matching tareas
	*/
	public java.util.List<Tarea> findBycreateDate(Date createDate);

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
	public java.util.List<Tarea> findBycreateDate(Date createDate, int start,
		int end);

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
	public java.util.List<Tarea> findBycreateDate(Date createDate, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator);

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
	public java.util.List<Tarea> findBycreateDate(Date createDate, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first tarea in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tarea
	* @throws NoSuchTareaException if a matching tarea could not be found
	*/
	public Tarea findBycreateDate_First(Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator)
		throws NoSuchTareaException;

	/**
	* Returns the first tarea in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tarea, or <code>null</code> if a matching tarea could not be found
	*/
	public Tarea fetchBycreateDate_First(Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator);

	/**
	* Returns the last tarea in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tarea
	* @throws NoSuchTareaException if a matching tarea could not be found
	*/
	public Tarea findBycreateDate_Last(Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator)
		throws NoSuchTareaException;

	/**
	* Returns the last tarea in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tarea, or <code>null</code> if a matching tarea could not be found
	*/
	public Tarea fetchBycreateDate_Last(Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator);

	/**
	* Returns the tareas before and after the current tarea in the ordered set where createDate = &#63;.
	*
	* @param tareaId the primary key of the current tarea
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tarea
	* @throws NoSuchTareaException if a tarea with the primary key could not be found
	*/
	public Tarea[] findBycreateDate_PrevAndNext(long tareaId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator)
		throws NoSuchTareaException;

	/**
	* Removes all the tareas where createDate = &#63; from the database.
	*
	* @param createDate the create date
	*/
	public void removeBycreateDate(Date createDate);

	/**
	* Returns the number of tareas where createDate = &#63;.
	*
	* @param createDate the create date
	* @return the number of matching tareas
	*/
	public int countBycreateDate(Date createDate);

	/**
	* Caches the tarea in the entity cache if it is enabled.
	*
	* @param tarea the tarea
	*/
	public void cacheResult(Tarea tarea);

	/**
	* Caches the tareas in the entity cache if it is enabled.
	*
	* @param tareas the tareas
	*/
	public void cacheResult(java.util.List<Tarea> tareas);

	/**
	* Creates a new tarea with the primary key. Does not add the tarea to the database.
	*
	* @param tareaId the primary key for the new tarea
	* @return the new tarea
	*/
	public Tarea create(long tareaId);

	/**
	* Removes the tarea with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tareaId the primary key of the tarea
	* @return the tarea that was removed
	* @throws NoSuchTareaException if a tarea with the primary key could not be found
	*/
	public Tarea remove(long tareaId) throws NoSuchTareaException;

	public Tarea updateImpl(Tarea tarea);

	/**
	* Returns the tarea with the primary key or throws a {@link NoSuchTareaException} if it could not be found.
	*
	* @param tareaId the primary key of the tarea
	* @return the tarea
	* @throws NoSuchTareaException if a tarea with the primary key could not be found
	*/
	public Tarea findByPrimaryKey(long tareaId) throws NoSuchTareaException;

	/**
	* Returns the tarea with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tareaId the primary key of the tarea
	* @return the tarea, or <code>null</code> if a tarea with the primary key could not be found
	*/
	public Tarea fetchByPrimaryKey(long tareaId);

	@Override
	public java.util.Map<java.io.Serializable, Tarea> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the tareas.
	*
	* @return the tareas
	*/
	public java.util.List<Tarea> findAll();

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
	public java.util.List<Tarea> findAll(int start, int end);

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
	public java.util.List<Tarea> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator);

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
	public java.util.List<Tarea> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tarea> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tareas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of tareas.
	*
	* @return the number of tareas
	*/
	public int countAll();
}