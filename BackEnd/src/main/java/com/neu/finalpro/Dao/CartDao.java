package com.neu.finalpro.Dao;

import com.neu.finalpro.pojo.CartPojo;
import com.neu.finalpro.pojo.MainPagePojo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

public class CartDao {
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

    public int addCart(String username, int itemId, double itemTotal, int quantity){
        int result = 0;
        CartPojo cp = new CartPojo();
        cp.setName(username);
        cp.setItemID(itemId);
        cp.setAmount(quantity);
        cp.setTotal(itemTotal*quantity);

        try {
            beginTransaction();
            getSession().save(cp);
            commit();
            result = 1;
        }catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        }finally {
            close();
        }
        return result;
    }

    public List<MainPagePojo> getCartItem(String username){
        CartPojo cp = new CartPojo();
        try{
            beginTransaction();
            Query q = getSession().createQuery("from CartPojo where name =:username");
            q.setString("username", username);
            List<CartPojo> cartPojoList = q.getResultList();
            List<MainPagePojo> mainPagePojoList = new ArrayList<>();
            for (int i = 0; i < cartPojoList.size(); i++){
                cp = cartPojoList.get(i);
                long itemid = cp.getItemID();
                Query qu = getSession().createQuery("from MainPagePojo where id =:itemid");
                qu.setLong("itemid", itemid);
                mainPagePojoList.add((MainPagePojo) qu.uniqueResult());
            }
            return mainPagePojoList;

        }catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        }
        finally {
            close();
        }
        return null;
    }

    public int deleteCartItem(int itemId, String username) {
        int result = 0;
        try {
            beginTransaction();
            Query q = getSession().createQuery("from CartPojo where itemID =:itemId and name =:username");
            q.setInteger("itemId", itemId);
            q.setString("username", username);
            CartPojo cp = (CartPojo) q.uniqueResult();
            getSession().delete(cp);
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
