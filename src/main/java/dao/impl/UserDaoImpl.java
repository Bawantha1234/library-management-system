package dao.impl;


import dao.custom.UserDao;
import dao.util.SessionDao;
import etntity.User;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

import static dao.util.SessionDao.executeTransaction;


public class UserDaoImpl implements UserDao {

    @Override
    public void save(User entity) throws SQLException {
        executeTransaction(session -> session.save(entity));
    }

    @Override
    public void update(User entity) throws SQLException {
         SessionDao.<Void>executeTransaction(session -> {
             session.update(entity);
             return null;
         });

    }

    @Override
    public void delete(int id) throws SQLException {
        User user = getbyId(id);
        SessionDao.<Void>executeTransaction(session ->{
                session.delete(user);
                return null;
        });

    }

    @Override
    public List<User> loadAll() throws SQLException {
        return executeTransaction(session -> {
            Query query = session.createQuery("from User");
            return query.getResultList();
        });

    }

    @Override
    public User get( String data) throws SQLException {

        return executeTransaction(session -> {
           Query query = session.createQuery("from User where email=:email");
            query.setParameter("email", data);
          List<User> users= query.getResultList();
          for (User user : users){
              return user;
          }
            System.out.println("ok");
          return null;
        });
    }


    @Override
    public User getbyId(int id) throws SQLException {
        return executeTransaction(session -> session.get(User.class,id));
    }

    @Override
    public long getUserCount() throws SQLException {
        return executeTransaction(session -> {
            Long userCount =(Long) session.createQuery("select count(*) from User ").getSingleResult();
            return userCount;
        });
    }
}