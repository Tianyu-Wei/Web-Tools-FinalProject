package com.neu.finalpro.Dao;

import com.neu.finalpro.pojo.Authorities;
import com.neu.finalpro.pojo.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class UserDetailDaoImp implements UserDetailDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findUserByUsername(String username) {
        return sessionFactory.getCurrentSession().get(User.class, username);
    }

    public int addUser(String username, String password, String role){
        int result = 0;
        try {
            User user = new User();
            Authorities authorities = new Authorities();
            Set<Authorities> tmpSet = new HashSet<>();
            user.setUsername(username);
            user.setPassword(password);
            if (role.equals("user")) {
                authorities.setAuthority("ROLE_USER");
            }else if (role.equals("admin")){
                authorities.setAuthority("ROLE_ADMIN");
            }
            authorities.setUser(user);
            tmpSet.add(authorities);
            user.setAuthorities(tmpSet);

            sessionFactory.getCurrentSession().save(user);
            sessionFactory.getCurrentSession().save(authorities);
            result = 1;
        }catch (Exception e) {
            e.printStackTrace();
        }
        sessionFactory.close();
        return result;
    }
}
