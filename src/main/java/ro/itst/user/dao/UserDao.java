package ro.itst.user.dao;

import ro.itst.common.dao.PersistenceException;
import ro.itst.user.model.User;

/**
 * Created by spacvalentin on 21.06.2016.
 */
public interface UserDao {
    User findById(Long identifier) throws PersistenceException;
}
