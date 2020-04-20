package com.neu.finalpro.Dao;

import com.neu.finalpro.pojo.MainPagePojo;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import sun.applet.Main;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
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

            //Make judgement by its category to the right query
            if (category.equals("all")) {
                CriteriaBuilder builder = getSession().getCriteriaBuilder();
                CriteriaQuery<MainPagePojo> query = builder.createQuery(MainPagePojo.class);
                Root<MainPagePojo> root = query.from(MainPagePojo.class);
                query.select(root).where(builder.equal(root.get("name"), keyword));
                Query q = getSession().createQuery(query);
                resultList = q.getResultList();
            }
            else {
                CriteriaBuilder builder = getSession().getCriteriaBuilder();
                CriteriaQuery<MainPagePojo> query = builder.createQuery(MainPagePojo.class);
                Root<MainPagePojo> root = query.from(MainPagePojo.class);
                query.select(root).where(builder.and(builder.equal(root.get("name"), keyword), builder.equal(root.get("category"), category)));
                Query q = getSession().createQuery(query);
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
            //Using criteria to generate query
            CriteriaBuilder builder = getSession().getCriteriaBuilder();
            CriteriaQuery<MainPagePojo> query = builder.createQuery(MainPagePojo.class);
            Root<MainPagePojo> root = query.from(MainPagePojo.class);
            query.select(root).where(builder.equal(root.get("category"), category));
            Query<MainPagePojo> q = getSession().createQuery(query);
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
