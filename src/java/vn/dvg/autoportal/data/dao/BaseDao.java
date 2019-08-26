package vn.dvg.autoportal.data.dao;


import vn.dvg.autoportal.data.dto.BaseEntity;

public interface BaseDao<T extends BaseEntity<TId>, TId> {
    T getById(TId id);
    void add(T entity);
    void update(T entity);
    void delete(T entity);
}
