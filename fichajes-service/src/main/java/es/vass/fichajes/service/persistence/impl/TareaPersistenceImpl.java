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

package es.vass.fichajes.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import es.vass.fichajes.exception.NoSuchTareaException;
import es.vass.fichajes.model.Tarea;
import es.vass.fichajes.model.impl.TareaImpl;
import es.vass.fichajes.model.impl.TareaModelImpl;
import es.vass.fichajes.service.persistence.TareaPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the tarea service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TareaPersistence
 * @see es.vass.fichajes.service.persistence.TareaUtil
 * @generated
 */
@ProviderType
public class TareaPersistenceImpl extends BasePersistenceImpl<Tarea>
	implements TareaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TareaUtil} to access the tarea persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TareaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TareaModelImpl.ENTITY_CACHE_ENABLED,
			TareaModelImpl.FINDER_CACHE_ENABLED, TareaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TareaModelImpl.ENTITY_CACHE_ENABLED,
			TareaModelImpl.FINDER_CACHE_ENABLED, TareaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TareaModelImpl.ENTITY_CACHE_ENABLED,
			TareaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(TareaModelImpl.ENTITY_CACHE_ENABLED,
			TareaModelImpl.FINDER_CACHE_ENABLED, TareaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(TareaModelImpl.ENTITY_CACHE_ENABLED,
			TareaModelImpl.FINDER_CACHE_ENABLED, TareaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] { Long.class.getName() },
			TareaModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(TareaModelImpl.ENTITY_CACHE_ENABLED,
			TareaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tareas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching tareas
	 */
	@Override
	public List<Tarea> findByuserId(long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Tarea> findByuserId(long userId, int start, int end) {
		return findByuserId(userId, start, end, null);
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
	@Override
	public List<Tarea> findByuserId(long userId, int start, int end,
		OrderByComparator<Tarea> orderByComparator) {
		return findByuserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<Tarea> findByuserId(long userId, int start, int end,
		OrderByComparator<Tarea> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<Tarea> list = null;

		if (retrieveFromCache) {
			list = (List<Tarea>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Tarea tarea : list) {
					if ((userId != tarea.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TAREA_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TareaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Tarea>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Tarea>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first tarea in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tarea
	 * @throws NoSuchTareaException if a matching tarea could not be found
	 */
	@Override
	public Tarea findByuserId_First(long userId,
		OrderByComparator<Tarea> orderByComparator) throws NoSuchTareaException {
		Tarea tarea = fetchByuserId_First(userId, orderByComparator);

		if (tarea != null) {
			return tarea;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchTareaException(msg.toString());
	}

	/**
	 * Returns the first tarea in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tarea, or <code>null</code> if a matching tarea could not be found
	 */
	@Override
	public Tarea fetchByuserId_First(long userId,
		OrderByComparator<Tarea> orderByComparator) {
		List<Tarea> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tarea in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tarea
	 * @throws NoSuchTareaException if a matching tarea could not be found
	 */
	@Override
	public Tarea findByuserId_Last(long userId,
		OrderByComparator<Tarea> orderByComparator) throws NoSuchTareaException {
		Tarea tarea = fetchByuserId_Last(userId, orderByComparator);

		if (tarea != null) {
			return tarea;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchTareaException(msg.toString());
	}

	/**
	 * Returns the last tarea in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tarea, or <code>null</code> if a matching tarea could not be found
	 */
	@Override
	public Tarea fetchByuserId_Last(long userId,
		OrderByComparator<Tarea> orderByComparator) {
		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<Tarea> list = findByuserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Tarea[] findByuserId_PrevAndNext(long tareaId, long userId,
		OrderByComparator<Tarea> orderByComparator) throws NoSuchTareaException {
		Tarea tarea = findByPrimaryKey(tareaId);

		Session session = null;

		try {
			session = openSession();

			Tarea[] array = new TareaImpl[3];

			array[0] = getByuserId_PrevAndNext(session, tarea, userId,
					orderByComparator, true);

			array[1] = tarea;

			array[2] = getByuserId_PrevAndNext(session, tarea, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Tarea getByuserId_PrevAndNext(Session session, Tarea tarea,
		long userId, OrderByComparator<Tarea> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAREA_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TareaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tarea);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Tarea> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tareas where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(long userId) {
		for (Tarea tarea : findByuserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(tarea);
		}
	}

	/**
	 * Returns the number of tareas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching tareas
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAREA_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "tarea.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERNAME = new FinderPath(TareaModelImpl.ENTITY_CACHE_ENABLED,
			TareaModelImpl.FINDER_CACHE_ENABLED, TareaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERNAME =
		new FinderPath(TareaModelImpl.ENTITY_CACHE_ENABLED,
			TareaModelImpl.FINDER_CACHE_ENABLED, TareaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserName",
			new String[] { String.class.getName() },
			TareaModelImpl.USERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERNAME = new FinderPath(TareaModelImpl.ENTITY_CACHE_ENABLED,
			TareaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the tareas where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching tareas
	 */
	@Override
	public List<Tarea> findByuserName(String userName) {
		return findByuserName(userName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Tarea> findByuserName(String userName, int start, int end) {
		return findByuserName(userName, start, end, null);
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
	@Override
	public List<Tarea> findByuserName(String userName, int start, int end,
		OrderByComparator<Tarea> orderByComparator) {
		return findByuserName(userName, start, end, orderByComparator, true);
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
	@Override
	public List<Tarea> findByuserName(String userName, int start, int end,
		OrderByComparator<Tarea> orderByComparator, boolean retrieveFromCache) {
		userName = Objects.toString(userName, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERNAME;
			finderArgs = new Object[] { userName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERNAME;
			finderArgs = new Object[] { userName, start, end, orderByComparator };
		}

		List<Tarea> list = null;

		if (retrieveFromCache) {
			list = (List<Tarea>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Tarea tarea : list) {
					if (!userName.equals(tarea.getUserName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TAREA_WHERE);

			boolean bindUserName = false;

			if (userName.isEmpty()) {
				query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
			}
			else {
				bindUserName = true;

				query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TareaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserName) {
					qPos.add(userName);
				}

				if (!pagination) {
					list = (List<Tarea>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Tarea>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first tarea in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tarea
	 * @throws NoSuchTareaException if a matching tarea could not be found
	 */
	@Override
	public Tarea findByuserName_First(String userName,
		OrderByComparator<Tarea> orderByComparator) throws NoSuchTareaException {
		Tarea tarea = fetchByuserName_First(userName, orderByComparator);

		if (tarea != null) {
			return tarea;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userName=");
		msg.append(userName);

		msg.append("}");

		throw new NoSuchTareaException(msg.toString());
	}

	/**
	 * Returns the first tarea in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tarea, or <code>null</code> if a matching tarea could not be found
	 */
	@Override
	public Tarea fetchByuserName_First(String userName,
		OrderByComparator<Tarea> orderByComparator) {
		List<Tarea> list = findByuserName(userName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tarea in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tarea
	 * @throws NoSuchTareaException if a matching tarea could not be found
	 */
	@Override
	public Tarea findByuserName_Last(String userName,
		OrderByComparator<Tarea> orderByComparator) throws NoSuchTareaException {
		Tarea tarea = fetchByuserName_Last(userName, orderByComparator);

		if (tarea != null) {
			return tarea;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userName=");
		msg.append(userName);

		msg.append("}");

		throw new NoSuchTareaException(msg.toString());
	}

	/**
	 * Returns the last tarea in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tarea, or <code>null</code> if a matching tarea could not be found
	 */
	@Override
	public Tarea fetchByuserName_Last(String userName,
		OrderByComparator<Tarea> orderByComparator) {
		int count = countByuserName(userName);

		if (count == 0) {
			return null;
		}

		List<Tarea> list = findByuserName(userName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Tarea[] findByuserName_PrevAndNext(long tareaId, String userName,
		OrderByComparator<Tarea> orderByComparator) throws NoSuchTareaException {
		userName = Objects.toString(userName, "");

		Tarea tarea = findByPrimaryKey(tareaId);

		Session session = null;

		try {
			session = openSession();

			Tarea[] array = new TareaImpl[3];

			array[0] = getByuserName_PrevAndNext(session, tarea, userName,
					orderByComparator, true);

			array[1] = tarea;

			array[2] = getByuserName_PrevAndNext(session, tarea, userName,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Tarea getByuserName_PrevAndNext(Session session, Tarea tarea,
		String userName, OrderByComparator<Tarea> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAREA_WHERE);

		boolean bindUserName = false;

		if (userName.isEmpty()) {
			query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
		}
		else {
			bindUserName = true;

			query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TareaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUserName) {
			qPos.add(userName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tarea);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Tarea> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tareas where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	@Override
	public void removeByuserName(String userName) {
		for (Tarea tarea : findByuserName(userName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(tarea);
		}
	}

	/**
	 * Returns the number of tareas where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching tareas
	 */
	@Override
	public int countByuserName(String userName) {
		userName = Objects.toString(userName, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERNAME;

		Object[] finderArgs = new Object[] { userName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAREA_WHERE);

			boolean bindUserName = false;

			if (userName.isEmpty()) {
				query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
			}
			else {
				bindUserName = true;

				query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserName) {
					qPos.add(userName);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERNAME_USERNAME_1 = "tarea.userName IS NULL";
	private static final String _FINDER_COLUMN_USERNAME_USERNAME_2 = "tarea.userName = ?";
	private static final String _FINDER_COLUMN_USERNAME_USERNAME_3 = "(tarea.userName IS NULL OR tarea.userName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDATE =
		new FinderPath(TareaModelImpl.ENTITY_CACHE_ENABLED,
			TareaModelImpl.FINDER_CACHE_ENABLED, TareaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycreateDate",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE =
		new FinderPath(TareaModelImpl.ENTITY_CACHE_ENABLED,
			TareaModelImpl.FINDER_CACHE_ENABLED, TareaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycreateDate",
			new String[] { Date.class.getName() },
			TareaModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDATE = new FinderPath(TareaModelImpl.ENTITY_CACHE_ENABLED,
			TareaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycreateDate",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the tareas where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @return the matching tareas
	 */
	@Override
	public List<Tarea> findBycreateDate(Date createDate) {
		return findBycreateDate(createDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Tarea> findBycreateDate(Date createDate, int start, int end) {
		return findBycreateDate(createDate, start, end, null);
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
	@Override
	public List<Tarea> findBycreateDate(Date createDate, int start, int end,
		OrderByComparator<Tarea> orderByComparator) {
		return findBycreateDate(createDate, start, end, orderByComparator, true);
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
	@Override
	public List<Tarea> findBycreateDate(Date createDate, int start, int end,
		OrderByComparator<Tarea> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE;
			finderArgs = new Object[] { _getTime(createDate) };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDATE;
			finderArgs = new Object[] {
					_getTime(createDate),
					
					start, end, orderByComparator
				};
		}

		List<Tarea> list = null;

		if (retrieveFromCache) {
			list = (List<Tarea>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Tarea tarea : list) {
					if (!Objects.equals(createDate, tarea.getCreateDate())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TAREA_WHERE);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TareaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
				}

				if (!pagination) {
					list = (List<Tarea>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Tarea>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first tarea in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tarea
	 * @throws NoSuchTareaException if a matching tarea could not be found
	 */
	@Override
	public Tarea findBycreateDate_First(Date createDate,
		OrderByComparator<Tarea> orderByComparator) throws NoSuchTareaException {
		Tarea tarea = fetchBycreateDate_First(createDate, orderByComparator);

		if (tarea != null) {
			return tarea;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createDate=");
		msg.append(createDate);

		msg.append("}");

		throw new NoSuchTareaException(msg.toString());
	}

	/**
	 * Returns the first tarea in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tarea, or <code>null</code> if a matching tarea could not be found
	 */
	@Override
	public Tarea fetchBycreateDate_First(Date createDate,
		OrderByComparator<Tarea> orderByComparator) {
		List<Tarea> list = findBycreateDate(createDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tarea in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tarea
	 * @throws NoSuchTareaException if a matching tarea could not be found
	 */
	@Override
	public Tarea findBycreateDate_Last(Date createDate,
		OrderByComparator<Tarea> orderByComparator) throws NoSuchTareaException {
		Tarea tarea = fetchBycreateDate_Last(createDate, orderByComparator);

		if (tarea != null) {
			return tarea;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createDate=");
		msg.append(createDate);

		msg.append("}");

		throw new NoSuchTareaException(msg.toString());
	}

	/**
	 * Returns the last tarea in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tarea, or <code>null</code> if a matching tarea could not be found
	 */
	@Override
	public Tarea fetchBycreateDate_Last(Date createDate,
		OrderByComparator<Tarea> orderByComparator) {
		int count = countBycreateDate(createDate);

		if (count == 0) {
			return null;
		}

		List<Tarea> list = findBycreateDate(createDate, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Tarea[] findBycreateDate_PrevAndNext(long tareaId, Date createDate,
		OrderByComparator<Tarea> orderByComparator) throws NoSuchTareaException {
		Tarea tarea = findByPrimaryKey(tareaId);

		Session session = null;

		try {
			session = openSession();

			Tarea[] array = new TareaImpl[3];

			array[0] = getBycreateDate_PrevAndNext(session, tarea, createDate,
					orderByComparator, true);

			array[1] = tarea;

			array[2] = getBycreateDate_PrevAndNext(session, tarea, createDate,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Tarea getBycreateDate_PrevAndNext(Session session, Tarea tarea,
		Date createDate, OrderByComparator<Tarea> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAREA_WHERE);

		boolean bindCreateDate = false;

		if (createDate == null) {
			query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_1);
		}
		else {
			bindCreateDate = true;

			query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TareaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCreateDate) {
			qPos.add(new Timestamp(createDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tarea);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Tarea> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tareas where createDate = &#63; from the database.
	 *
	 * @param createDate the create date
	 */
	@Override
	public void removeBycreateDate(Date createDate) {
		for (Tarea tarea : findBycreateDate(createDate, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(tarea);
		}
	}

	/**
	 * Returns the number of tareas where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @return the number of matching tareas
	 */
	@Override
	public int countBycreateDate(Date createDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATEDATE;

		Object[] finderArgs = new Object[] { _getTime(createDate) };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAREA_WHERE);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CREATEDATE_CREATEDATE_1 = "tarea.createDate IS NULL";
	private static final String _FINDER_COLUMN_CREATEDATE_CREATEDATE_2 = "tarea.createDate = ?";

	public TareaPersistenceImpl() {
		setModelClass(Tarea.class);
	}

	/**
	 * Caches the tarea in the entity cache if it is enabled.
	 *
	 * @param tarea the tarea
	 */
	@Override
	public void cacheResult(Tarea tarea) {
		entityCache.putResult(TareaModelImpl.ENTITY_CACHE_ENABLED,
			TareaImpl.class, tarea.getPrimaryKey(), tarea);

		tarea.resetOriginalValues();
	}

	/**
	 * Caches the tareas in the entity cache if it is enabled.
	 *
	 * @param tareas the tareas
	 */
	@Override
	public void cacheResult(List<Tarea> tareas) {
		for (Tarea tarea : tareas) {
			if (entityCache.getResult(TareaModelImpl.ENTITY_CACHE_ENABLED,
						TareaImpl.class, tarea.getPrimaryKey()) == null) {
				cacheResult(tarea);
			}
			else {
				tarea.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tareas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TareaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tarea.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Tarea tarea) {
		entityCache.removeResult(TareaModelImpl.ENTITY_CACHE_ENABLED,
			TareaImpl.class, tarea.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Tarea> tareas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Tarea tarea : tareas) {
			entityCache.removeResult(TareaModelImpl.ENTITY_CACHE_ENABLED,
				TareaImpl.class, tarea.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tarea with the primary key. Does not add the tarea to the database.
	 *
	 * @param tareaId the primary key for the new tarea
	 * @return the new tarea
	 */
	@Override
	public Tarea create(long tareaId) {
		Tarea tarea = new TareaImpl();

		tarea.setNew(true);
		tarea.setPrimaryKey(tareaId);

		return tarea;
	}

	/**
	 * Removes the tarea with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tareaId the primary key of the tarea
	 * @return the tarea that was removed
	 * @throws NoSuchTareaException if a tarea with the primary key could not be found
	 */
	@Override
	public Tarea remove(long tareaId) throws NoSuchTareaException {
		return remove((Serializable)tareaId);
	}

	/**
	 * Removes the tarea with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tarea
	 * @return the tarea that was removed
	 * @throws NoSuchTareaException if a tarea with the primary key could not be found
	 */
	@Override
	public Tarea remove(Serializable primaryKey) throws NoSuchTareaException {
		Session session = null;

		try {
			session = openSession();

			Tarea tarea = (Tarea)session.get(TareaImpl.class, primaryKey);

			if (tarea == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTareaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tarea);
		}
		catch (NoSuchTareaException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Tarea removeImpl(Tarea tarea) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tarea)) {
				tarea = (Tarea)session.get(TareaImpl.class,
						tarea.getPrimaryKeyObj());
			}

			if (tarea != null) {
				session.delete(tarea);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tarea != null) {
			clearCache(tarea);
		}

		return tarea;
	}

	@Override
	public Tarea updateImpl(Tarea tarea) {
		boolean isNew = tarea.isNew();

		if (!(tarea instanceof TareaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(tarea.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(tarea);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in tarea proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Tarea implementation " +
				tarea.getClass());
		}

		TareaModelImpl tareaModelImpl = (TareaModelImpl)tarea;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (tarea.getCreateDate() == null)) {
			if (serviceContext == null) {
				tarea.setCreateDate(now);
			}
			else {
				tarea.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!tareaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				tarea.setModifiedDate(now);
			}
			else {
				tarea.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (tarea.isNew()) {
				session.save(tarea);

				tarea.setNew(false);
			}
			else {
				tarea = (Tarea)session.merge(tarea);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TareaModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { tareaModelImpl.getUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
				args);

			args = new Object[] { tareaModelImpl.getUserName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERNAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERNAME,
				args);

			args = new Object[] { tareaModelImpl.getCreateDate() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATEDATE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((tareaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { tareaModelImpl.getOriginalUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { tareaModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((tareaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tareaModelImpl.getOriginalUserName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERNAME,
					args);

				args = new Object[] { tareaModelImpl.getUserName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERNAME,
					args);
			}

			if ((tareaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tareaModelImpl.getOriginalCreateDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATEDATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE,
					args);

				args = new Object[] { tareaModelImpl.getCreateDate() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATEDATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE,
					args);
			}
		}

		entityCache.putResult(TareaModelImpl.ENTITY_CACHE_ENABLED,
			TareaImpl.class, tarea.getPrimaryKey(), tarea, false);

		tarea.resetOriginalValues();

		return tarea;
	}

	/**
	 * Returns the tarea with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tarea
	 * @return the tarea
	 * @throws NoSuchTareaException if a tarea with the primary key could not be found
	 */
	@Override
	public Tarea findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTareaException {
		Tarea tarea = fetchByPrimaryKey(primaryKey);

		if (tarea == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTareaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tarea;
	}

	/**
	 * Returns the tarea with the primary key or throws a {@link NoSuchTareaException} if it could not be found.
	 *
	 * @param tareaId the primary key of the tarea
	 * @return the tarea
	 * @throws NoSuchTareaException if a tarea with the primary key could not be found
	 */
	@Override
	public Tarea findByPrimaryKey(long tareaId) throws NoSuchTareaException {
		return findByPrimaryKey((Serializable)tareaId);
	}

	/**
	 * Returns the tarea with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tarea
	 * @return the tarea, or <code>null</code> if a tarea with the primary key could not be found
	 */
	@Override
	public Tarea fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TareaModelImpl.ENTITY_CACHE_ENABLED,
				TareaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Tarea tarea = (Tarea)serializable;

		if (tarea == null) {
			Session session = null;

			try {
				session = openSession();

				tarea = (Tarea)session.get(TareaImpl.class, primaryKey);

				if (tarea != null) {
					cacheResult(tarea);
				}
				else {
					entityCache.putResult(TareaModelImpl.ENTITY_CACHE_ENABLED,
						TareaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TareaModelImpl.ENTITY_CACHE_ENABLED,
					TareaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tarea;
	}

	/**
	 * Returns the tarea with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tareaId the primary key of the tarea
	 * @return the tarea, or <code>null</code> if a tarea with the primary key could not be found
	 */
	@Override
	public Tarea fetchByPrimaryKey(long tareaId) {
		return fetchByPrimaryKey((Serializable)tareaId);
	}

	@Override
	public Map<Serializable, Tarea> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Tarea> map = new HashMap<Serializable, Tarea>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Tarea tarea = fetchByPrimaryKey(primaryKey);

			if (tarea != null) {
				map.put(primaryKey, tarea);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TareaModelImpl.ENTITY_CACHE_ENABLED,
					TareaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Tarea)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TAREA_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Tarea tarea : (List<Tarea>)q.list()) {
				map.put(tarea.getPrimaryKeyObj(), tarea);

				cacheResult(tarea);

				uncachedPrimaryKeys.remove(tarea.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TareaModelImpl.ENTITY_CACHE_ENABLED,
					TareaImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the tareas.
	 *
	 * @return the tareas
	 */
	@Override
	public List<Tarea> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Tarea> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Tarea> findAll(int start, int end,
		OrderByComparator<Tarea> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Tarea> findAll(int start, int end,
		OrderByComparator<Tarea> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Tarea> list = null;

		if (retrieveFromCache) {
			list = (List<Tarea>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TAREA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAREA;

				if (pagination) {
					sql = sql.concat(TareaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Tarea>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Tarea>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the tareas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Tarea tarea : findAll()) {
			remove(tarea);
		}
	}

	/**
	 * Returns the number of tareas.
	 *
	 * @return the number of tareas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TAREA);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TareaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tarea persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TareaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_TAREA = "SELECT tarea FROM Tarea tarea";
	private static final String _SQL_SELECT_TAREA_WHERE_PKS_IN = "SELECT tarea FROM Tarea tarea WHERE tareaId IN (";
	private static final String _SQL_SELECT_TAREA_WHERE = "SELECT tarea FROM Tarea tarea WHERE ";
	private static final String _SQL_COUNT_TAREA = "SELECT COUNT(tarea) FROM Tarea tarea";
	private static final String _SQL_COUNT_TAREA_WHERE = "SELECT COUNT(tarea) FROM Tarea tarea WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tarea.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Tarea exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Tarea exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TareaPersistenceImpl.class);
}