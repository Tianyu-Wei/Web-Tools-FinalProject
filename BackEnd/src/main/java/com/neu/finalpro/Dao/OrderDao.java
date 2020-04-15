package com.neu.finalpro.Dao;

import com.neu.finalpro.pojo.MainPagePojo;
import com.neu.finalpro.pojo.OrderPojo;
import com.neu.finalpro.pojo.UserAccountPojo;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderDao {
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

    public List getOrderDetail(String username) {
        try {

            beginTransaction();

            UserAccountDao uad = new UserAccountDao();
            UserAccountPojo uap = uad.getUserByName(username);

            Query q = getSession().createQuery("from OrderPojo where useraccountpojo =:uap");
            List<OrderPojo> result = q.getResultList();

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

//    public int createOrder(String username, List itemIDList) {
//        int result = 0;
//        try{
//            CrudItemDao cid = new CrudItemDao();
//            List<MainPagePojo> item = new ArrayList<>();
//            for(int i = 0; i < itemIDList.size(); i++) {
//                item.add(cid.getItemDetail((String)itemIDList.get(i)));
//            }
//            beginTransaction();
//            for (int j = 0; j < item.size(); j++){
//
//            }
//
//        }catch (HibernateException e){
//            e.printStackTrace();
//            rollback();
//        }
//        finally {
//            close();
//        }
//
//    }
}
