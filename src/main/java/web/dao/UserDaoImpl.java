package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import web.model.Car;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        System.out.println("Пользователь добавлен: "+user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        System.out.println("Пользователь обновлен: "+user);
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));

        if(user != null) {
            session.delete(user);
        }
        System.out.println("Пользователь удален: "+user);
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        System.out.println("Пользователь выбран: "+user);

        return user;
    }


    @Override
    //Generic. действительно будет legal во время выполнения.
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("From User").list();

        for(User user : userList) {
            System.out.println("Список пользователей: "+user);
        }


        return userList;
    }


    //del
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
    //<del
}