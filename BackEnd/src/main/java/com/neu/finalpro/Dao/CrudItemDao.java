package com.neu.finalpro.Dao;

import com.neu.finalpro.pojo.MainPagePojo;

import com.sun.corba.se.spi.activation.ServerAlreadyRegisteredHelper;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class CrudItemDao {
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

    public boolean isNumeric (String input) {
        if (input == null) {
            return false;
        }
        try {
            double test = Double.parseDouble(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List getShoppingDetailR() {
        try {

            beginTransaction();

            String query = "from MainPagePojo";
            Query q = getSession().createQuery(query);
            List<MainPagePojo> result = q.getResultList();

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

    public MainPagePojo getItemDetail(String id) {
        SearchItemDao sid = new SearchItemDao();
        MainPagePojo mpp = new MainPagePojo();
        try {

            beginTransaction();
            Query q = getSession().createQuery("from MainPagePojo where id =:id");
            q.setLong("id", Long.valueOf(id));
            mpp = (MainPagePojo) q.uniqueResult();
            return mpp;

        }catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        }
        finally {
            close();
        }
        return null;
    }

    public int addItem(String name, String category, int amount, double price, String description, String imgURL, String discount) {
        int result = 0;
        try {

            MainPagePojo mpp = new MainPagePojo();
            mpp.setName(name);
            mpp.setCategory(category);
            mpp.setAmount(amount);
            mpp.setPrice(price);
            mpp.setDescription(description);
            mpp.setImgURL(imgURL);
            mpp.setDiscount(discount);

            beginTransaction();
            getSession().save(mpp);
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

    public int updateItem(long id, String name, String category, int amount, double price, String desciption,
                          String imgURL, String discount) {
        int result = 0;
        try {

            MainPagePojo mpp = new MainPagePojo();
            beginTransaction();
            Query q = getSession().createQuery("from MainPagePojo where id= :id");
            q.setLong("id", id);
            mpp = (MainPagePojo) q.uniqueResult();
            mpp.setName(name);
            mpp.setCategory(category);
            mpp.setAmount(amount);
            mpp.setPrice(price);
            mpp.setDescription(desciption);
            mpp.setImgURL(imgURL);
            mpp.setDiscount(discount);
            getSession().save(mpp);
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

    public int deleteItem(long id) {
        int result = 0;
        try {

            beginTransaction();
            Query q = getSession().createQuery("from MainPagePojo where id = :id");
            q.setLong("id", id);
            MainPagePojo mpp = (MainPagePojo) q.uniqueResult();
            getSession().delete(mpp);
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

}
