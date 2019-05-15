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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import es.vass.fichajes.exception.NoSuchTipoTareaException;
import es.vass.fichajes.model.TipoTarea;
import es.vass.fichajes.model.impl.TipoTareaImpl;
import es.vass.fichajes.model.impl.TipoTareaModelImpl;
import es.vass.fichajes.service.persistence.TipoTareaPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the tipo tarea service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipoTareaPersistence
 * @see es.vass.fichajes.service.persistence.TipoTareaUtil
 * @generated
 */
@ProviderType
public class TipoTareaPersistenceImpl extends BasePersistenceImpl<TipoTarea>
	implements TipoTareaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TipoTareaUtil} to access the tipo tarea persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TipoTareaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TipoTareaModelImpl.ENTITY_CACHE_ENABLED,
			TipoTareaModelImpl.FINDER_CACHE_ENABLED, TipoTareaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TipoTareaModelImpl.ENTITY_CACHE_ENABLED,
			TipoTareaModelImpl.FINDER_CACHE_ENABLED, TipoTareaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TipoTareaModelImpl.ENTITY_CACHE_ENABLED,
			TipoTareaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TIPOTAREAID =
		new FinderPath(TipoTareaModelImpl.ENTITY_CACHE_ENABLED,
			TipoTareaModelImpl.FINDER_CACHE_ENABLED, TipoTareaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytipoTareaId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIPOTAREAID =
		new FinderPath(TipoTareaModelImpl.ENTITY_CACHE_ENABLED,
			TipoTareaModelImpl.FINDER_CACHE_ENABLED, TipoTareaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytipoTareaId",
			new String[] { Long.class.getName() },
			TipoTareaModelImpl.TIPOTAREAID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TIPOTAREAID = new FinderPath(TipoTareaModelImpl.ENTITY_CACHE_ENABLED,
			TipoTareaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytipoTareaId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tipo tareas where tipoTareaId = &#63;.
	 *
	 * @param tipoTareaId the tipo tarea ID
	 * @return the matching tipo tareas
	 */
	@Override
	public List<TipoTarea> findBytipoTareaId(long tipoTareaId) {
		return findBytipoTareaId(tipoTareaId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<TipoTarea> findBytipoTareaId(long tipoTareaId, int start,
		int end) {
		return findBytipoTareaId(tipoTareaId, start, end, null);
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
	@Override
	public List<TipoTarea> findBytipoTareaId(long tipoTareaId, int start,
		int end, OrderByComparator<TipoTarea> orderByComparator) {
		return findBytipoTareaId(tipoTareaId, start, end, orderByComparator,
			true);
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
	@Override
	public List<TipoTarea> findBytipoTareaId(long tipoTareaId, int start,
		int end, OrderByComparator<TipoTarea> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIPOTAREAID;
			finderArgs = new Object[] { tipoTareaId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TIPOTAREAID;
			finderArgs = new Object[] { tipoTareaId, start, end, orderByComparator };
		}

		List<TipoTarea> list = null;

		if (retrieveFromCache) {
			list = (List<TipoTarea>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TipoTarea tipoTarea : list) {
					if ((tipoTareaId != tipoTarea.getTipoTareaId())) {
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

			query.append(_SQL_SELECT_TIPOTAREA_WHERE);

			query.append(_FINDER_COLUMN_TIPOTAREAID_TIPOTAREAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TipoTareaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tipoTareaId);

				if (!pagination) {
					list = (List<TipoTarea>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TipoTarea>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first tipo tarea in the ordered set where tipoTareaId = &#63;.
	 *
	 * @param tipoTareaId the tipo tarea ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo tarea
	 * @throws NoSuchTipoTareaException if a matching tipo tarea could not be found
	 */
	@Override
	public TipoTarea findBytipoTareaId_First(long tipoTareaId,
		OrderByComparator<TipoTarea> orderByComparator)
		throws NoSuchTipoTareaException {
		TipoTarea tipoTarea = fetchBytipoTareaId_First(tipoTareaId,
				orderByComparator);

		if (tipoTarea != null) {
			return tipoTarea;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipoTareaId=");
		msg.append(tipoTareaId);

		msg.append("}");

		throw new NoSuchTipoTareaException(msg.toString());
	}

	/**
	 * Returns the first tipo tarea in the ordered set where tipoTareaId = &#63;.
	 *
	 * @param tipoTareaId the tipo tarea ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipo tarea, or <code>null</code> if a matching tipo tarea could not be found
	 */
	@Override
	public TipoTarea fetchBytipoTareaId_First(long tipoTareaId,
		OrderByComparator<TipoTarea> orderByComparator) {
		List<TipoTarea> list = findBytipoTareaId(tipoTareaId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tipo tarea in the ordered set where tipoTareaId = &#63;.
	 *
	 * @param tipoTareaId the tipo tarea ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo tarea
	 * @throws NoSuchTipoTareaException if a matching tipo tarea could not be found
	 */
	@Override
	public TipoTarea findBytipoTareaId_Last(long tipoTareaId,
		OrderByComparator<TipoTarea> orderByComparator)
		throws NoSuchTipoTareaException {
		TipoTarea tipoTarea = fetchBytipoTareaId_Last(tipoTareaId,
				orderByComparator);

		if (tipoTarea != null) {
			return tipoTarea;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipoTareaId=");
		msg.append(tipoTareaId);

		msg.append("}");

		throw new NoSuchTipoTareaException(msg.toString());
	}

	/**
	 * Returns the last tipo tarea in the ordered set where tipoTareaId = &#63;.
	 *
	 * @param tipoTareaId the tipo tarea ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipo tarea, or <code>null</code> if a matching tipo tarea could not be found
	 */
	@Override
	public TipoTarea fetchBytipoTareaId_Last(long tipoTareaId,
		OrderByComparator<TipoTarea> orderByComparator) {
		int count = countBytipoTareaId(tipoTareaId);

		if (count == 0) {
			return null;
		}

		List<TipoTarea> list = findBytipoTareaId(tipoTareaId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the tipo tareas where tipoTareaId = &#63; from the database.
	 *
	 * @param tipoTareaId the tipo tarea ID
	 */
	@Override
	public void removeBytipoTareaId(long tipoTareaId) {
		for (TipoTarea tipoTarea : findBytipoTareaId(tipoTareaId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tipoTarea);
		}
	}

	/**
	 * Returns the number of tipo tareas where tipoTareaId = &#63;.
	 *
	 * @param tipoTareaId the tipo tarea ID
	 * @return the number of matching tipo tareas
	 */
	@Override
	public int countBytipoTareaId(long tipoTareaId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TIPOTAREAID;

		Object[] finderArgs = new Object[] { tipoTareaId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TIPOTAREA_WHERE);

			query.append(_FINDER_COLUMN_TIPOTAREAID_TIPOTAREAID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tipoTareaId);

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

	private static final String _FINDER_COLUMN_TIPOTAREAID_TIPOTAREAID_2 = "tipoTarea.tipoTareaId = ?";

	public TipoTareaPersistenceImpl() {
		setModelClass(TipoTarea.class);
	}

	/**
	 * Caches the tipo tarea in the entity cache if it is enabled.
	 *
	 * @param tipoTarea the tipo tarea
	 */
	@Override
	public void cacheResult(TipoTarea tipoTarea) {
		entityCache.putResult(TipoTareaModelImpl.ENTITY_CACHE_ENABLED,
			TipoTareaImpl.class, tipoTarea.getPrimaryKey(), tipoTarea);

		tipoTarea.resetOriginalValues();
	}

	/**
	 * Caches the tipo tareas in the entity cache if it is enabled.
	 *
	 * @param tipoTareas the tipo tareas
	 */
	@Override
	public void cacheResult(List<TipoTarea> tipoTareas) {
		for (TipoTarea tipoTarea : tipoTareas) {
			if (entityCache.getResult(TipoTareaModelImpl.ENTITY_CACHE_ENABLED,
						TipoTareaImpl.class, tipoTarea.getPrimaryKey()) == null) {
				cacheResult(tipoTarea);
			}
			else {
				tipoTarea.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tipo tareas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TipoTareaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tipo tarea.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TipoTarea tipoTarea) {
		entityCache.removeResult(TipoTareaModelImpl.ENTITY_CACHE_ENABLED,
			TipoTareaImpl.class, tipoTarea.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TipoTarea> tipoTareas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TipoTarea tipoTarea : tipoTareas) {
			entityCache.removeResult(TipoTareaModelImpl.ENTITY_CACHE_ENABLED,
				TipoTareaImpl.class, tipoTarea.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tipo tarea with the primary key. Does not add the tipo tarea to the database.
	 *
	 * @param tipoTareaId the primary key for the new tipo tarea
	 * @return the new tipo tarea
	 */
	@Override
	public TipoTarea create(long tipoTareaId) {
		TipoTarea tipoTarea = new TipoTareaImpl();

		tipoTarea.setNew(true);
		tipoTarea.setPrimaryKey(tipoTareaId);

		return tipoTarea;
	}

	/**
	 * Removes the tipo tarea with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tipoTareaId the primary key of the tipo tarea
	 * @return the tipo tarea that was removed
	 * @throws NoSuchTipoTareaException if a tipo tarea with the primary key could not be found
	 */
	@Override
	public TipoTarea remove(long tipoTareaId) throws NoSuchTipoTareaException {
		return remove((Serializable)tipoTareaId);
	}

	/**
	 * Removes the tipo tarea with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tipo tarea
	 * @return the tipo tarea that was removed
	 * @throws NoSuchTipoTareaException if a tipo tarea with the primary key could not be found
	 */
	@Override
	public TipoTarea remove(Serializable primaryKey)
		throws NoSuchTipoTareaException {
		Session session = null;

		try {
			session = openSession();

			TipoTarea tipoTarea = (TipoTarea)session.get(TipoTareaImpl.class,
					primaryKey);

			if (tipoTarea == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTipoTareaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tipoTarea);
		}
		catch (NoSuchTipoTareaException nsee) {
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
	protected TipoTarea removeImpl(TipoTarea tipoTarea) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tipoTarea)) {
				tipoTarea = (TipoTarea)session.get(TipoTareaImpl.class,
						tipoTarea.getPrimaryKeyObj());
			}

			if (tipoTarea != null) {
				session.delete(tipoTarea);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tipoTarea != null) {
			clearCache(tipoTarea);
		}

		return tipoTarea;
	}

	@Override
	public TipoTarea updateImpl(TipoTarea tipoTarea) {
		boolean isNew = tipoTarea.isNew();

		if (!(tipoTarea instanceof TipoTareaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(tipoTarea.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(tipoTarea);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in tipoTarea proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TipoTarea implementation " +
				tipoTarea.getClass());
		}

		TipoTareaModelImpl tipoTareaModelImpl = (TipoTareaModelImpl)tipoTarea;

		Session session = null;

		try {
			session = openSession();

			if (tipoTarea.isNew()) {
				session.save(tipoTarea);

				tipoTarea.setNew(false);
			}
			else {
				tipoTarea = (TipoTarea)session.merge(tipoTarea);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TipoTareaModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { tipoTareaModelImpl.getTipoTareaId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TIPOTAREAID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIPOTAREAID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((tipoTareaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIPOTAREAID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tipoTareaModelImpl.getOriginalTipoTareaId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TIPOTAREAID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIPOTAREAID,
					args);

				args = new Object[] { tipoTareaModelImpl.getTipoTareaId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TIPOTAREAID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIPOTAREAID,
					args);
			}
		}

		entityCache.putResult(TipoTareaModelImpl.ENTITY_CACHE_ENABLED,
			TipoTareaImpl.class, tipoTarea.getPrimaryKey(), tipoTarea, false);

		tipoTarea.resetOriginalValues();

		return tipoTarea;
	}

	/**
	 * Returns the tipo tarea with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipo tarea
	 * @return the tipo tarea
	 * @throws NoSuchTipoTareaException if a tipo tarea with the primary key could not be found
	 */
	@Override
	public TipoTarea findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTipoTareaException {
		TipoTarea tipoTarea = fetchByPrimaryKey(primaryKey);

		if (tipoTarea == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTipoTareaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tipoTarea;
	}

	/**
	 * Returns the tipo tarea with the primary key or throws a {@link NoSuchTipoTareaException} if it could not be found.
	 *
	 * @param tipoTareaId the primary key of the tipo tarea
	 * @return the tipo tarea
	 * @throws NoSuchTipoTareaException if a tipo tarea with the primary key could not be found
	 */
	@Override
	public TipoTarea findByPrimaryKey(long tipoTareaId)
		throws NoSuchTipoTareaException {
		return findByPrimaryKey((Serializable)tipoTareaId);
	}

	/**
	 * Returns the tipo tarea with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipo tarea
	 * @return the tipo tarea, or <code>null</code> if a tipo tarea with the primary key could not be found
	 */
	@Override
	public TipoTarea fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TipoTareaModelImpl.ENTITY_CACHE_ENABLED,
				TipoTareaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TipoTarea tipoTarea = (TipoTarea)serializable;

		if (tipoTarea == null) {
			Session session = null;

			try {
				session = openSession();

				tipoTarea = (TipoTarea)session.get(TipoTareaImpl.class,
						primaryKey);

				if (tipoTarea != null) {
					cacheResult(tipoTarea);
				}
				else {
					entityCache.putResult(TipoTareaModelImpl.ENTITY_CACHE_ENABLED,
						TipoTareaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TipoTareaModelImpl.ENTITY_CACHE_ENABLED,
					TipoTareaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tipoTarea;
	}

	/**
	 * Returns the tipo tarea with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tipoTareaId the primary key of the tipo tarea
	 * @return the tipo tarea, or <code>null</code> if a tipo tarea with the primary key could not be found
	 */
	@Override
	public TipoTarea fetchByPrimaryKey(long tipoTareaId) {
		return fetchByPrimaryKey((Serializable)tipoTareaId);
	}

	@Override
	public Map<Serializable, TipoTarea> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TipoTarea> map = new HashMap<Serializable, TipoTarea>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TipoTarea tipoTarea = fetchByPrimaryKey(primaryKey);

			if (tipoTarea != null) {
				map.put(primaryKey, tipoTarea);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TipoTareaModelImpl.ENTITY_CACHE_ENABLED,
					TipoTareaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TipoTarea)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TIPOTAREA_WHERE_PKS_IN);

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

			for (TipoTarea tipoTarea : (List<TipoTarea>)q.list()) {
				map.put(tipoTarea.getPrimaryKeyObj(), tipoTarea);

				cacheResult(tipoTarea);

				uncachedPrimaryKeys.remove(tipoTarea.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TipoTareaModelImpl.ENTITY_CACHE_ENABLED,
					TipoTareaImpl.class, primaryKey, nullModel);
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
	 * Returns all the tipo tareas.
	 *
	 * @return the tipo tareas
	 */
	@Override
	public List<TipoTarea> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TipoTarea> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TipoTarea> findAll(int start, int end,
		OrderByComparator<TipoTarea> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<TipoTarea> findAll(int start, int end,
		OrderByComparator<TipoTarea> orderByComparator,
		boolean retrieveFromCache) {
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

		List<TipoTarea> list = null;

		if (retrieveFromCache) {
			list = (List<TipoTarea>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TIPOTAREA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIPOTAREA;

				if (pagination) {
					sql = sql.concat(TipoTareaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TipoTarea>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TipoTarea>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the tipo tareas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TipoTarea tipoTarea : findAll()) {
			remove(tipoTarea);
		}
	}

	/**
	 * Returns the number of tipo tareas.
	 *
	 * @return the number of tipo tareas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIPOTAREA);

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
		return TipoTareaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tipo tarea persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TipoTareaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TIPOTAREA = "SELECT tipoTarea FROM TipoTarea tipoTarea";
	private static final String _SQL_SELECT_TIPOTAREA_WHERE_PKS_IN = "SELECT tipoTarea FROM TipoTarea tipoTarea WHERE tipoTareaId IN (";
	private static final String _SQL_SELECT_TIPOTAREA_WHERE = "SELECT tipoTarea FROM TipoTarea tipoTarea WHERE ";
	private static final String _SQL_COUNT_TIPOTAREA = "SELECT COUNT(tipoTarea) FROM TipoTarea tipoTarea";
	private static final String _SQL_COUNT_TIPOTAREA_WHERE = "SELECT COUNT(tipoTarea) FROM TipoTarea tipoTarea WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tipoTarea.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TipoTarea exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TipoTarea exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TipoTareaPersistenceImpl.class);
}