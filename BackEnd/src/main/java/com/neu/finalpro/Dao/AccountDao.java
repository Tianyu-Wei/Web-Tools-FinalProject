package com.neu.finalpro.Dao;

import com.neu.finalpro.pojo.UserAccountPojo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.security.core.userdetails.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class AccountDao {
    private static final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private Session session = null;

    public Session getSession(){
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

    public UserAccountPojo findByToken(String token) {
        try {
            UserAccountPojo uap = new UserAccountPojo();
            beginTransaction();
            String query = "from UserAccountPojo where token = '<token>'";
            query.replace("<token>", token);
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

    public int updateToken(long id, String token) {
        int result = 0;
        try {
            UserAccountPojo uap = new UserAccountPojo();
            beginTransaction();
            Query q = getSession().createQuery("from UserAccountPojo where id =:id");
            q.setLong("id", id);
            uap = (UserAccountPojo) q.uniqueResult();
            uap.setToken(token);
            getSession().save(uap);
            commit();

        }catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        }
        finally {
            close();
        }
        return result;
    }

    public int addAccount(String name, String password, String email, String recovemail, String phone) {
        int result = 0;
        try {

            UserAccountPojo uap = new UserAccountPojo();
            uap.setUsername(name);
            uap.setPassword(password);
            uap.setEmail(email);
            uap.setRecovemail(recovemail);
            uap.setPhone(phone);

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

    public int deleteAccount(long id) {
        int result = 0;
        try {

            beginTransaction();
            Query q = getSession().createQuery("from UserAccountPojo where id =:id");
            q.setLong("id", id);
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

    public int updateAccount(long id, String name, String password, String email, String recovemail, String phone) {
        int result = 0;
        try {
            UserAccountPojo uap = new UserAccountPojo();
            beginTransaction();
            Query q = getSession().createQuery("from UserAccountPojo where id =:id");
            q.setLong("id", id);
            uap = (UserAccountPojo) q.uniqueResult();
            uap.setUsername(name);
            uap.setEmail(email);
            uap.setRecovemail(recovemail);
            uap.setPassword(password);
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

    public UserAccountPojo getAccount (String username) {
        try {

            beginTransaction();
            String query = "from UserAccountPojo where username = '<username>'";
            query = query.replace("<username>", username);
            Query q = getSession().createQuery(query);
            UserAccountPojo uap = (UserAccountPojo) q.uniqueResult();

            return uap;

        }catch (HibernateException e) {
            UserAccountPojo uap = null;
            rollback();
            return uap;
        }
        finally {
            close();
        }
    }

    public List<UserAccountPojo> getAccountList() {
        try{
            beginTransaction();
            Query q = getSession().createQuery("from UserAccountPojo");
            List<UserAccountPojo> resultlist = q.getResultList();

            return resultlist;
        }catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        }
        finally {
            close();
        }
        return null;
    }
}
