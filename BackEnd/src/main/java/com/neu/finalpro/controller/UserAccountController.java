package com.neu.finalpro.controller;

import com.neu.finalpro.Dao.UserAccountDao;
import com.neu.finalpro.pojo.UserAccountPojo;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class UserAccountController {

    @GetMapping("/getuser")
    public UserAccountPojo getUserInfo(@RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response) {
        UserAccountDao uad = new UserAccountDao();
        UserAccountPojo uap = new UserAccountPojo();

        try {

            response.setHeader("Content-Type", "application/json");
            response.setHeader("Accept", "application/json");
            response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
            response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");
            uap = uad.getUserByName(username);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return uap;
    }

    @PostMapping("/getuserlist")
    public List<UserAccountPojo> getUserList(HttpServletResponse response){
        UserAccountDao uad = new UserAccountDao();
        List<UserAccountPojo> resultlist = uad.getUserDetails();

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        return resultlist;
    }

    @PostMapping("/login")
    public UserAccountPojo login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {

        UserAccountDao uad = new UserAccountDao();
        UserAccountPojo uap = new UserAccountPojo();
        StatusCodeSend scs = new StatusCodeSend();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        uap = uad.getUserByName(username);

        if (bCryptPasswordEncoder.matches(password, uap.getPassword())){

            Cookie cookie = new Cookie("auth", "Yes");
            Cookie cookie1 = new Cookie("id", uap.getUsername());
            cookie.setMaxAge(200);
            response.addCookie(cookie);
            response.addCookie(cookie1);
            int result = uad.Userlogin(username);

            response.setHeader("Content-Type", "application/json");
            response.setHeader("Accept", "application/json");
            response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
            response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");
            response.setHeader("auth", "Yes");
            response.setHeader("username", username);

            return uap;
        }else {
            scs.ForbiddenCode(request, response);
        }
        return null;
    }

    @PostMapping("/logout")
    public String logout(@RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response) {

        Cookie cookie = new Cookie("auth", "No");
        Cookie cookie1 = new Cookie("id", "No");
        response.addCookie(cookie);
        response.addCookie(cookie1);
        UserAccountDao uad = new UserAccountDao();
        uad.Userlogout(username);

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        response.setStatus(200);

        return "success";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email,
                         @RequestParam("recovemail") String recovemail, @RequestParam("phone") String phone, @RequestParam("role") String role, HttpServletRequest request, HttpServletResponse response) throws EmailException {

        int result = 0;
        UserAccountDao uad = new UserAccountDao();
        EmailController ec = new EmailController();

        result = uad.addUser(username, password, email, recovemail, phone, role);

        if (result == 1) {

            response.setStatus(200);

            response.setHeader("Content-Type", "application/json");
            response.setHeader("Accept", "application/json");
            response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
            response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

            ec.SignupSuccess(username, email);

            return "success";
        }

        response.setStatus(403);
        return "error";
    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    public void updateUser(@RequestParam("oldusername") String oldusername, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email,
                           @RequestParam("recovemail") String recovemail, @RequestParam("phone") String phone, HttpServletRequest request, HttpServletResponse response) throws EmailException {
        UserAccountDao uad = new UserAccountDao();
        EmailController ec = new EmailController();

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        int result = uad.updateUser(oldusername, username, password, email, recovemail, phone);
        if (result == 1){
            ec.UserUpdateSuccess(username);
            response.setStatus(200);
        }else{
            response.setStatus(403);
        }
    }

    @PostMapping("/deleteuser")
    public String deleteUser(@RequestParam("id") String id, HttpServletResponse response){
        UserAccountDao uad = new UserAccountDao();
        EmailController ec = new EmailController();
        UserAccountPojo uap = new UserAccountPojo();

        try {
            uad.deleteItem(Integer.parseInt(id));
            uap = uad.getUserById(id);
            ec.UserDeleteSuccess(uap.getUsername());

            response.setHeader("Content-Type", "application/json");
            response.setHeader("Accept", "application/json");
            response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
            response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

            return "success";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error";
    }
}
