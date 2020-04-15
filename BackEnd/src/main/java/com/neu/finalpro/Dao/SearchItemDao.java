package com.neu.finalpro.Dao;

import com.neu.finalpro.pojo.MainPagePojo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

//Search function to get items by name
public class SearchItemDao {
    private static final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private Session session = null;

    //Initialize hibernate session
    public Session getSession() {
        if (session == null || !session.isOpen()) {
            session = sf.openSession();
        }
        return session;
    }

    public void beginTransaction() {
        getSession().beginTransaction();
    }

    public void rollback() {
        getSession().getTransaction().rollback();
    }

    public void close() {
        getSession().close();
    }

    //searchItem by name and category
    public List<MainPagePojo> searchItem(String category, String keyword) {
        List<MainPagePojo> resultList = new ArrayList<>(); //Store result as list

        try {

            beginTransaction();
            String allquery = "from MainPagePojo where name = '<keyword>'";
            String indivquery = "from MainPagePojo where name = '<keyword>' and category = '<cate>'";

            //Make judgement by its category to the right HQL query
            if (category.equals("all")) {
                String newnewquery = allquery.replace("<keyword>", keyword);
                Query q = getSession().createQuery(newnewquery);
                resultList = q.getResultList();
            }
            else {
                String newquery = indivquery.replace("<keyword>", keyword);
                String newnewquery = newquery.replace("<cate>", category);
                Query q = getSession().createQuery(newnewquery);
                resultList = q.getResultList();
            }

        }catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        }
        finally {
            close();
        }
        return resultList;
    }

    public List<MainPagePojo> categoryItem(String category) {
        List<MainPagePojo> resultList = new ArrayList<>(); //Store result as list

        try {

            beginTransaction();
            String allquery = "from MainPagePojo where category = '<cate>'";

            //Make judgement by its category to the right HQL query
                String newquery = allquery.replace("<cate>", category);
                Query q = getSession().createQuery(newquery);
                resultList = q.getResultList();

        }catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        }
        finally {
            close();
        }
        return resultList;
    }
}
