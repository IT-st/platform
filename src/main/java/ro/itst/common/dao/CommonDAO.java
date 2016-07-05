package ro.itst.common.dao;

import java.io.Serializable;
import java.util.Collection;

public interface CommonDAO<T extends Serializable, PK extends Serializable> extends AutoCloseable {
    /*T findById(String columnName, PK identifier) throws PersistenceException;*/

    T saveOrUpdate(T entity) throws PersistenceException;

    Collection<T> findAll() throws PersistenceException;

    void delete(T entity) throws PersistenceException;

    @Override
    void close();
}
