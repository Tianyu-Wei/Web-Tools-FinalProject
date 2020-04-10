package com.neu.finalpro.controller;

import com.neu.finalpro.Dao.UserAccountDao;
import com.neu.finalpro.pojo.UserAccountPojo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserAccountController {

    @GetMapping("/getuser")
    public UserAccountPojo getUserInfo(@RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response) {
        UserAccountDao uad = new UserAccountDao();
        UserAccountPojo uap = new UserAccountPojo();

        try {
            uap = uad.getUserByName(username);
            response.setHeader("Content-Type", "application/json");
            response.setHeader("Accept", "application/json");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
            response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");
        }catch (Exception e) {
            e.printStackTrace();
        }

        return uap;
    }

    @GetMapping("/signup")
    public String signUp(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email,
                         @RequestParam("recovemail") String recovemail, @RequestParam("phone") String phone, @RequestParam("role") String role, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(username);
        System.out.println(password);

        int result = 0;
        UserAccountDao uad = new UserAccountDao();

        result = uad.addUser(username, password, email, recovemail, phone, role);

        if (result == 1) {
            return "success";
        }
        return "error";
    }
}
