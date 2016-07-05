package ro.itst.user.dao;

import org.springframework.stereotype.Repository;
import ro.itst.common.dao.CommonDAOImpl;
import ro.itst.common.dao.PersistenceException;
import ro.itst.user.model.User;

/**
 * Created by spacvalentin on 21.06.2016.
 */
@Repository
class UserDaoImpl extends CommonDAOImpl<User, Long> implements UserDao {

    private static final String PK = "userId";

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User findById(Long identifier) throws PersistenceException {
        return super.findById(PK, identifier);
    }
}
