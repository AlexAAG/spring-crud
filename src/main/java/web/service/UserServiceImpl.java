package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.CarDao;
import web.dao.CarDaoImpl;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.Car;
import web.model.User;

import java.util.List;

@Component
public class UserServiceImpl implements UserService{

    UserDao userDao = new UserDaoImpl();

    @Autowired
    public UserServiceImpl(CarDao carDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUsers(Integer count) {
        return userDao.getUsers(count);
    }
}

