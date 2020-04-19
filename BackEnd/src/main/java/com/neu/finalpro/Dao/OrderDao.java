package com.neu.finalpro.Dao;

import com.neu.finalpro.pojo.MainPagePojo;
import com.neu.finalpro.pojo.OrderPojo;
import com.neu.finalpro.pojo.UserAccountPojo;
import com.sun.org.apache.xpath.internal.operations.Or;
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

    public List<MainPagePojo> getOrderAll(String username) {
        OrderPojo od = new OrderPojo();
        try{
            beginTransaction();
            Query q = getSession().createQuery("from OrderPojo where username =:username");
            q.setString("username", username);
            List<OrderPojo> orderPojoList = q.getResultList();
            List<MainPagePojo> mainPagePojoList = new ArrayList<>();
            for (int i = 0; i < orderPojoList.size(); i++){
                od = orderPojoList.get(i);
                int itemid = od.getItemID();
                Query qu = getSession().createQuery("from MainPagePojo where id =:id");
                qu.setInteger("id", itemid);
                mainPagePojoList.add((MainPagePojo)qu.uniqueResult());
            }
            return mainPagePojoList;

        }catch (HibernateException e){
            e.printStackTrace();
            rollback();
        }finally {
            close();
        }
        return null;
    }

    public List<OrderPojo> getOrderList(String username) {
        try{
        beginTransaction();
        Query q = getSession().createQuery("from OrderPojo where username =:username");
        q.setString("username", username);
        List<OrderPojo> orderPojo = q.getResultList();
        return orderPojo;
    }catch (HibernateException e){
        e.printStackTrace();
        rollback();
    }finally {
        close();
    }
        return null;
    }

    public OrderPojo getOrderDetail(int orderNum){
        try{
            beginTransaction();
            Query q = getSession().createQuery("from OrderPojo where orderNum =:orderNum");
            q.setInteger("orderNum", orderNum);
            OrderPojo orderPojo = (OrderPojo) q.uniqueResult();
            return orderPojo;
        }catch (HibernateException e){
            e.printStackTrace();
            rollback();
        }finally {
            close();
        }
        return null;
    }

    public int addOrder(String username, int itemID, int amount, String orderstatus){
        int result = 0;
        try{
            beginTransaction();
            OrderPojo op = new OrderPojo();
            op.setUsername(username);
            op.setItemID(itemID);
            op.setAmount(amount);
            op.setOrderstatus(orderstatus);

            getSession().save(op);
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

    public int pendingReturnOrder(int orderNum) {
        int result = 0;
        try{
            beginTransaction();
            Query q = getSession().createQuery("from OrderPojo where orderNum=:orderNum");
            q.setInteger("orderNum", orderNum);
            OrderPojo orderPojo = (OrderPojo) q.uniqueResult();
            orderPojo.setOrderstatus("pending");
            getSession().save(orderPojo);
            commit();
            result = 1;
        }catch (HibernateException e){
            e.printStackTrace();
            rollback();
        }finally {
            close();
        }
        return result;
    }

    public List<OrderPojo> getNormalOrder(){
        try{
            beginTransaction();
            Query q = getSession().createQuery("from OrderPojo where orderstatus =:status");
            q.setString("status", "recieve");
            List<OrderPojo> result = q.getResultList();
            return result;

        }catch (HibernateException e){
            e.printStackTrace();
            rollback();
        }
        finally{
            close();
        }
        return null;
    }

    public List<OrderPojo> getReturnOrder(){
        try{
            beginTransaction();
            Query q = getSession().createQuery("from OrderPojo where orderstatus =:status");
            q.setString("status", "pending");
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

    public int setStatus(int orderNum, String status){
        int result = 0;
        try{
            beginTransaction();
            Query q = getSession().createQuery("from OrderPojo where orderNum =:ordernum");
            q.setInteger("ordernum", orderNum);
            OrderPojo op = (OrderPojo) q.uniqueResult();
            op.setOrderstatus(status);
            getSession().save(op);
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
