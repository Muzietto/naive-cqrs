/*
 * Project: naive-cqrs
 * Author: Marco Faustinelli - Muzietto (contacts@faustinelli.net)
 * Web: http://faustinelli.wordpress.com/, https://www.github.com/muzietto, http://faustinelli.net/
 * Version: 1.0
 * The GPL 3.0 License - Copyright (c) 2015-2016 - The naive-cqrs Project
 */

package net.faustinelli.cqrs.naive.db;

import org.hibernate.*;
import org.hibernate.classic.Session;
import org.hibernate.jdbc.Work;
import org.hibernate.stat.SessionStatistics;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Marco Faustinelli (Muzietto) on 4/26/2016.
 */
public interface DataAccess {
    static Session getSession() {
        return new Session() {
            @Override
            public Object saveOrUpdateCopy(Object o) throws HibernateException {
                return null;
            }

            @Override
            public Object saveOrUpdateCopy(Object o, Serializable serializable) throws HibernateException {
                return null;
            }

            @Override
            public Object saveOrUpdateCopy(String s, Object o) throws HibernateException {
                return null;
            }

            @Override
            public Object saveOrUpdateCopy(String s, Object o, Serializable serializable) throws HibernateException {
                return null;
            }

            @Override
            public List find(String s) throws HibernateException {
                return null;
            }

            @Override
            public List find(String s, Object o, Type type) throws HibernateException {
                return null;
            }

            @Override
            public List find(String s, Object[] objects, Type[] types) throws HibernateException {
                return null;
            }

            @Override
            public Iterator iterate(String s) throws HibernateException {
                return null;
            }

            @Override
            public Iterator iterate(String s, Object o, Type type) throws HibernateException {
                return null;
            }

            @Override
            public Iterator iterate(String s, Object[] objects, Type[] types) throws HibernateException {
                return null;
            }

            @Override
            public Collection filter(Object o, String s) throws HibernateException {
                return null;
            }

            @Override
            public Collection filter(Object o, String s, Object o1, Type type) throws HibernateException {
                return null;
            }

            @Override
            public Collection filter(Object o, String s, Object[] objects, Type[] types) throws HibernateException {
                return null;
            }

            @Override
            public int delete(String s) throws HibernateException {
                return 0;
            }

            @Override
            public int delete(String s, Object o, Type type) throws HibernateException {
                return 0;
            }

            @Override
            public int delete(String s, Object[] objects, Type[] types) throws HibernateException {
                return 0;
            }

            @Override
            public Query createSQLQuery(String s, String s1, Class aClass) {
                return null;
            }

            @Override
            public Query createSQLQuery(String s, String[] strings, Class[] classes) {
                return null;
            }

            @Override
            public void save(Object o, Serializable serializable) throws HibernateException {

            }

            @Override
            public void save(String s, Object o, Serializable serializable) throws HibernateException {

            }

            @Override
            public void update(Object o, Serializable serializable) throws HibernateException {

            }

            @Override
            public void update(String s, Object o, Serializable serializable) throws HibernateException {

            }

            @Override
            public EntityMode getEntityMode() {
                return null;
            }

            @Override
            public org.hibernate.Session getSession(EntityMode entityMode) {
                return null;
            }

            @Override
            public void flush() throws HibernateException {

            }

            @Override
            public void setFlushMode(FlushMode flushMode) {

            }

            @Override
            public FlushMode getFlushMode() {
                return null;
            }

            @Override
            public void setCacheMode(CacheMode cacheMode) {

            }

            @Override
            public CacheMode getCacheMode() {
                return null;
            }

            @Override
            public SessionFactory getSessionFactory() {
                return null;
            }

            @Override
            public Connection connection() throws HibernateException {
                return null;
            }

            @Override
            public Connection close() throws HibernateException {
                return null;
            }

            @Override
            public void cancelQuery() throws HibernateException {

            }

            @Override
            public boolean isOpen() {
                return false;
            }

            @Override
            public boolean isConnected() {
                return false;
            }

            @Override
            public boolean isDirty() throws HibernateException {
                return false;
            }

            @Override
            public boolean isDefaultReadOnly() {
                return false;
            }

            @Override
            public void setDefaultReadOnly(boolean b) {

            }

            @Override
            public Serializable getIdentifier(Object o) throws HibernateException {
                return null;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public void evict(Object o) throws HibernateException {

            }

            @Override
            public Object load(Class aClass, Serializable serializable, LockMode lockMode) throws HibernateException {
                return null;
            }

            @Override
            public Object load(Class aClass, Serializable serializable, LockOptions lockOptions) throws HibernateException {
                return null;
            }

            @Override
            public Object load(String s, Serializable serializable, LockMode lockMode) throws HibernateException {
                return null;
            }

            @Override
            public Object load(String s, Serializable serializable, LockOptions lockOptions) throws HibernateException {
                return null;
            }

            @Override
            public Object load(Class aClass, Serializable serializable) throws HibernateException {
                return null;
            }

            @Override
            public Object load(String s, Serializable serializable) throws HibernateException {
                return null;
            }

            @Override
            public void load(Object o, Serializable serializable) throws HibernateException {

            }

            @Override
            public void replicate(Object o, ReplicationMode replicationMode) throws HibernateException {

            }

            @Override
            public void replicate(String s, Object o, ReplicationMode replicationMode) throws HibernateException {

            }

            @Override
            public Serializable save(Object o) throws HibernateException {
                return null;
            }

            @Override
            public Serializable save(String s, Object o) throws HibernateException {
                return null;
            }

            @Override
            public void saveOrUpdate(Object o) throws HibernateException {

            }

            @Override
            public void saveOrUpdate(String s, Object o) throws HibernateException {

            }

            @Override
            public void update(Object o) throws HibernateException {

            }

            @Override
            public void update(String s, Object o) throws HibernateException {

            }

            @Override
            public Object merge(Object o) throws HibernateException {
                return null;
            }

            @Override
            public Object merge(String s, Object o) throws HibernateException {
                return null;
            }

            @Override
            public void persist(Object o) throws HibernateException {

            }

            @Override
            public void persist(String s, Object o) throws HibernateException {

            }

            @Override
            public void delete(Object o) throws HibernateException {

            }

            @Override
            public void delete(String s, Object o) throws HibernateException {

            }

            @Override
            public void lock(Object o, LockMode lockMode) throws HibernateException {

            }

            @Override
            public void lock(String s, Object o, LockMode lockMode) throws HibernateException {

            }

            @Override
            public LockRequest buildLockRequest(LockOptions lockOptions) {
                return null;
            }

            @Override
            public void refresh(Object o) throws HibernateException {

            }

            @Override
            public void refresh(Object o, LockMode lockMode) throws HibernateException {

            }

            @Override
            public void refresh(Object o, LockOptions lockOptions) throws HibernateException {

            }

            @Override
            public LockMode getCurrentLockMode(Object o) throws HibernateException {
                return null;
            }

            @Override
            public Transaction beginTransaction() throws HibernateException {
                return null;
            }

            @Override
            public Transaction getTransaction() {
                return null;
            }

            @Override
            public Criteria createCriteria(Class aClass) {
                return null;
            }

            @Override
            public Criteria createCriteria(Class aClass, String s) {
                return null;
            }

            @Override
            public Criteria createCriteria(String s) {
                return null;
            }

            @Override
            public Criteria createCriteria(String s, String s1) {
                return null;
            }

            @Override
            public Query createQuery(String s) throws HibernateException {
                return null;
            }

            @Override
            public SQLQuery createSQLQuery(String s) throws HibernateException {
                return null;
            }

            @Override
            public Query createFilter(Object o, String s) throws HibernateException {
                return null;
            }

            @Override
            public Query getNamedQuery(String s) throws HibernateException {
                return null;
            }

            @Override
            public void clear() {

            }

            @Override
            public Object get(Class aClass, Serializable serializable) throws HibernateException {
                return null;
            }

            @Override
            public Object get(Class aClass, Serializable serializable, LockMode lockMode) throws HibernateException {
                return null;
            }

            @Override
            public Object get(Class aClass, Serializable serializable, LockOptions lockOptions) throws HibernateException {
                return null;
            }

            @Override
            public Object get(String s, Serializable serializable) throws HibernateException {
                return null;
            }

            @Override
            public Object get(String s, Serializable serializable, LockMode lockMode) throws HibernateException {
                return null;
            }

            @Override
            public Object get(String s, Serializable serializable, LockOptions lockOptions) throws HibernateException {
                return null;
            }

            @Override
            public String getEntityName(Object o) throws HibernateException {
                return null;
            }

            @Override
            public Filter enableFilter(String s) {
                return null;
            }

            @Override
            public Filter getEnabledFilter(String s) {
                return null;
            }

            @Override
            public void disableFilter(String s) {

            }

            @Override
            public SessionStatistics getStatistics() {
                return null;
            }

            @Override
            public boolean isReadOnly(Object o) {
                return false;
            }

            @Override
            public void setReadOnly(Object o, boolean b) {

            }

            @Override
            public void doWork(Work work) throws HibernateException {

            }

            @Override
            public Connection disconnect() throws HibernateException {
                return null;
            }

            @Override
            public void reconnect() throws HibernateException {

            }

            @Override
            public void reconnect(Connection connection) throws HibernateException {

            }

            @Override
            public boolean isFetchProfileEnabled(String s) throws UnknownProfileException {
                return false;
            }

            @Override
            public void enableFetchProfile(String s) throws UnknownProfileException {

            }

            @Override
            public void disableFetchProfile(String s) throws UnknownProfileException {

            }

            @Override
            public TypeHelper getTypeHelper() {
                return null;
            }

            @Override
            public LobHelper getLobHelper() {
                return null;
            }
        };
    }
}
