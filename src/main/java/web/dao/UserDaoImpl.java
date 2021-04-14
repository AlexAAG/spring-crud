package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDaoImpl implements UserDao {

    @Override
    public List<User> getUsers(Integer count) {

        List<User> listUser = new ArrayList<>();

        listUser.add(new User(1, "Alex", "manager", 22));
        listUser.add(new User(2, "Petya", "topManager", 23));
        listUser.add(new User(3, "Vasya", "director", 24));

        if(count == null) {
            return listUser;
        } else {
            return listUser.stream().limit(count).collect(Collectors.toList());
        }
    }
}