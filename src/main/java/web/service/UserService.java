package web.service;

import web.model.Car;
import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers(Integer count);
}
