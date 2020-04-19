package com.neu.finalpro.Dao;

import com.neu.finalpro.pojo.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserAccountDao {

    private static final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private Session session = null;

    public Session getSession() {
        if (session == null || !session.isOpen()) {
            session = sf.openSession();
        }
        return session;
    }

    public void beginTransaction() {
        getSession().beginTransaction();
    }

    public void commit() {
        getSession().getTransaction().commit();
    }

    public void rollback() {
        getSession().getTransaction().rollback();
    }

    public void close() {
        getSession().close();
    }

    public List<UserAccountPojo> getUserDetails() {
        try {

            beginTransaction();

            String query = "from UserAccountPojo";
            Query q = getSession().createQuery(query);
            List<UserAccountPojo> result = q.getResultList();

            return result;

        }catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        }
        finally {
            close();
        }
        return null;
    }

    public UserAccountPojo getUserById(String id) {
        UserAccountPojo uap = new UserAccountPojo();
        try {

            beginTransaction();
            Query q = getSession().createQuery("from UserAccountPojo where id =:id");
            q.setInteger("id", Integer.parseInt(id));
            uap = (UserAccountPojo) q.uniqueResult();
            return uap;

        }catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        }
        finally {
            close();
        }
        return null;
    }

    public UserAccountPojo getUserByName(String username) {
        UserAccountPojo uap = new UserAccountPojo();
        try {

            beginTransaction();
            String query = "from UserAccountPojo where username = '<username>'";
            query = query.replace("<username>", username);
            Query q = getSession().createQuery(query);
            uap = (UserAccountPojo) q.uniqueResult();
            return uap;

        }catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        }
        finally {
            close();
        }
        return null;
    }

    public int addUser(String username, String password, String email, String recovemail, String phone, String role) {
        int result = 0;
        try {

            UserAccountPojo uap = new UserAccountPojo();
            String encriptedPassword = new BCryptPasswordEncoder().encode(password);
            uap.setUsername(username);
            uap.setPassword(encriptedPassword);
            uap.setEmail(email);
            uap.setRecovemail(recovemail);
            uap.setPhone(phone);
            uap.setRole(role);
            uap.setAuth("No");

            beginTransaction();
            getSession().save(uap);
            commit();
            result = 1;

        }catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        }
        finally {
            close();
        }
        return result;
    }

    public int updateUser(String oldusername, String username, String password, String email, String recovemail, String phone) {
        int result = 0;
        try {

            UserAccountPojo uap = new UserAccountPojo();
            beginTransaction();
            Query q = getSession().createQuery("from UserAccountPojo where username= :username");
            q.setString("username", oldusername);
            String encodedPassword = new BCryptPasswordEncoder().encode(password);
            uap = (UserAccountPojo) q.uniqueResult();
            uap.setUsername(username);
            uap.setPassword(encodedPassword);
            uap.setEmail(email);
            uap.setRecovemail(recovemail);
            uap.setPhone(phone);
            getSession().save(uap);
            commit();
            result = 1;

        }catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        }
        finally {
            close();
        }

        return result;
    }

    public int deleteItem(int id) {
        int result = 0;
        try {

            beginTransaction();
            Query q = getSession().createQuery("from UserAccountPojo where id = :id");
            q.setInteger("id", id);
            UserAccountPojo uap = (UserAccountPojo) q.uniqueResult();
            getSession().delete(uap);
            commit();
            result = 1;

        }catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        }
        finally {
            close();
        }
        return result;
    }

    public int Userlogin(String username){
        int result = 0;
        try{
            UserAccountPojo uap = new UserAccountPojo();
            beginTransaction();
            Query q = getSession().createQuery("from UserAccountPojo where username= :username");
            q.setString("username", username);
            uap = (UserAccountPojo) q.uniqueResult();
            uap.setAuth("Yes");
            getSession().save(uap);
            commit();
            result = 1;
        }catch (HibernateException e){
            e.printStackTrace();
            rollback();
        }
        finally {
         close();
        }
        return result;
    }

    public int Userlogout(String username){
        int result = 0;
        try{
            UserAccountPojo uap = new UserAccountPojo();
            beginTransaction();
            Query q = getSession().createQuery("from UserAccountPojo where username= :username");
            q.setString("username", username);
            uap = (UserAccountPojo) q.uniqueResult();
            uap.setAuth("No");
            getSession().save(uap);
            commit();
            result = 1;
        }catch (HibernateException e){
            e.printStackTrace();
            rollback();
        }
        finally {
            close();
        }
        return result;
    }
}
