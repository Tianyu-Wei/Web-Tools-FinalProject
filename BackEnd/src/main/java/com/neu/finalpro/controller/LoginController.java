package com.neu.finalpro.controller;

import com.neu.finalpro.Dao.AccountDao;
import com.neu.finalpro.pojo.UserAccountPojo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserAccountPojo UserLogin(@CookieValue(value = "auth", defaultValue = "no") String authcookie, @RequestParam("username") String username, @RequestParam("password") String password,
                                    HttpServletRequest request, HttpServletResponse response) {
        StatusCodeSend scs = new StatusCodeSend();
        AccountDao ad = new AccountDao();
        UserAccountPojo uap = ad.getAccount(username);
        String resultpassword = uap.getPassword();
        String resultusername = uap.getUsername();
        if (!uap.equals(null)) {
            if (username.equals(resultusername) && password.equals(resultpassword)) {
                response.setHeader("Content-Type", "application/json");
                response.setHeader("Accept", "application/json");
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
                response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");
                Cookie c = new Cookie("auth", "success");
                c.setMaxAge(7200);
                response.addCookie(c);

                return uap;
            } else {
                scs.ForbiddenCode(request, response);
                Cookie c = new Cookie("auth", "no");
                response.addCookie(c);
            }
        } else {
            scs.BadRequestCode(request, response);
            Cookie c= new Cookie("auth", "no");
            response.addCookie(c);
        }
        return null;
    }

    private String getJWTToken(String username) {
        
    }
}
