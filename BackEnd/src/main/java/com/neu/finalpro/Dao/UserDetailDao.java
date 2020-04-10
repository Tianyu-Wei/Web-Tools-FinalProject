package com.neu.finalpro.Dao;

import com.neu.finalpro.pojo.User;

public interface UserDetailDao {
    User findUserByUsername(String username);
}
