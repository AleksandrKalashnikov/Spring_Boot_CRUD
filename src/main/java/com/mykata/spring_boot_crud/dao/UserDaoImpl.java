package com.mykata.spring_boot_crud.dao;

import com.mykata.spring_boot_crud.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public User oneUser(long id) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(long id, User updateUser) {
        User oldUser = entityManager.find(User.class, updateUser.getId());
        oldUser.setName(updateUser.getName());
        oldUser.setLastname(updateUser.getLastname());
        oldUser.setAge(updateUser.getAge());
    }

    @Override
    public void deleteUser(long id) {
        User oldUser = entityManager.find(User.class, id);
        entityManager.remove(oldUser);
    }
}
