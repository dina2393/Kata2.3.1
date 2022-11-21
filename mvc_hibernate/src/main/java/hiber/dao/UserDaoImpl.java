package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


//    @Override
//    public List<User> getAllUsers() {
//        Session session = entityManager.unwrap(Session.class);
//        List<User> allUsers = session.createQuery("from User", User.class).getResultList();
//        return allUsers;
//    }


    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = entityManager.createQuery("from User", User.class).getResultList();
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(long id) {
        Query<User> query = (Query<User>) entityManager.createQuery("delete from User u where id =:userId");
        query.setParameter("userId",id);
        query.executeUpdate();

    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);

    }

//    @Override
//    public void saveUser(User user) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(user);
//    }

//    @Override
//    public User getUser(long id) {
//        Session session = entityManager.unwrap(Session.class);
//        User user = session.get(User.class, id);
//        return user;
//    }

//    @Override
//    public void deleteUser(long id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<User> query = session.createQuery("delete from User u where id =:userId");
//        query.setParameter("userId", id);
//        query.executeUpdate();
//    }

}
