package vn.dvg.autoportal.data.dao.impl;

import lombok.val;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import vn.dvg.autoportal.data.dao.BaseDao;
import vn.dvg.autoportal.data.dto.BaseEntity;
import vn.dvg.autoportal.infrastructure.HibernateUtils;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BaseDaoImpl<T extends BaseEntity<TId>, TId> implements BaseDao<T, TId> {
    final Class<T> typeParameterClass;

    public BaseDaoImpl(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    @Override
    public T getById(TId id) {
        val entity = getEntityManager().find(typeParameterClass, id);
        return entity;
    }

    @Override
    public void add(T entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    @Override
    public void delete(T entity) {
        getEntityManager().remove(entity);
    }

    public static <T> List<T> Query(String statement, Map<String, Object> parameters, Class<T> clazz) throws SQLException, IllegalAccessException {
        Query<T> query = prepareQuery(statement, parameters);
        query.setResultTransformer(Transformers.aliasToBean(clazz));
        List<T> result = query.list();
        return result;
    }

    private static <T> Query<T> prepareQuery(String statement, Map<String, Object> parameters) throws SQLException {
        val session = getConnectionSession();
        Query<T> query = session.createSQLQuery(statement);

        if(parameters != null)
            for (val parameterKey : parameters.keySet()) {
                query.setParameter(parameterKey, parameters.get(parameterKey));
            }
        return query;
    }

    public static int Execute(String statement, Map<String, Object> parameters) throws Exception{
        val session = getConnectionSession();


        val transaction = session.beginTransaction();
        val query = session.createSQLQuery(statement);

        if(parameters != null)
            for (val parameterKey : parameters.keySet()) {
                query.setParameter(parameterKey, parameters.get(parameterKey));
            }

        int executeResult = query.executeUpdate();

        transaction.commit();

        session.getEntityManagerFactory().createEntityManager();

        return executeResult;
    }

    private static Session getConnectionSession() throws SQLException {
//        val connection = DbConnectionManager.getConnection();
//        val sessionFactory = HibernateUtils.getSessionFactory();
//        sessionFactory.withOptions().connection(connection);
//
//        val session = sessionFactory.openSession();
//        return session;

        val sessionFactory = HibernateUtils.getSessionFactory();
        val session = sessionFactory.openSession();
        return session;
    }

    private SessionFactory getSessionFactory(){
        val sessionFactory = HibernateUtils.getSessionFactory();
        return sessionFactory;
    }
    private EntityManager getEntityManager(){
        val sessionFactory = getSessionFactory();
        val session = sessionFactory.openSession();
        val entityManager = session.getEntityManagerFactory().createEntityManager();
        return entityManager;
    }
}
