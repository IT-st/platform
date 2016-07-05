package ro.itst.user.service;

import org.springframework.stereotype.Service;
import ro.itst.common.dao.PersistenceException;
import ro.itst.user.dao.UserDao;
import ro.itst.user.model.User;

import javax.annotation.Resource;

/**
 * Created by spacvalentin on 20.06.2016.
 */
@Service
class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public User getUser() {
        try {
            return userDao.findById(1L);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return null;
    }
}
