package com.neu.finalpro.controller;

import com.neu.finalpro.Dao.AccountDao;
import com.neu.finalpro.pojo.UserAccountPojo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/login")
public class AccountController {

    @RequestMapping("/add")
    public String addAccount(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("email") String email, @RequestParam("recovemail") String recovemail,
    @RequestParam("phone") String phone, HttpServletRequest request, HttpServletResponse response) {
        AccountDao ad = new AccountDao();
        StatusCodeSend scs = new StatusCodeSend();
        int result = ad.addAccount(name, password, email, recovemail, phone);

        try {
            if (result == 1) {
                scs.SuccessCode(request, response);
            } else {
                scs.BadRequestCode(request, response);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        return "success";
    }

    @RequestMapping("/delete")
    public String deleteAccount(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {
        AccountDao ad = new AccountDao();
        StatusCodeSend scs = new StatusCodeSend();
        int result = ad.deleteAccount(Long.valueOf(id));
        String status = null;

        if (result == 1) {
            scs.SuccessCode(request, response);
            status = "success";
        }else {
            scs.BadRequestCode(request, response);
            status = "error";
        }

        return status;
    }

    @RequestMapping("/update")
    public String updateAccount(@RequestParam("id") String id, @RequestParam("username") String name, @RequestParam("password") String password, @RequestParam("email") String email,
                                @RequestParam("recovemail") String recovemail, @RequestParam("phone") String phone, HttpServletRequest request, HttpServletResponse response) {
        AccountDao ad = new AccountDao();
        StatusCodeSend scs = new StatusCodeSend();
        String status = null;

        int result = ad.updateAccount(Long.valueOf(id), name, password, email, recovemail, phone);

        if (result == 1){
            scs.SuccessCode(request, response);
            status = "success";
        }else {
            scs.BadRequestCode(request, response);
            status = "error";
        }
        return status;
    }

    @RequestMapping("/getuser")
    public UserAccountPojo getUser(@RequestParam("name") String username, HttpServletRequest request, HttpServletResponse response) {
        AccountDao ad = new AccountDao();
        UserAccountPojo uap = new UserAccountPojo();
        StatusCodeSend scs = new StatusCodeSend();

        uap = ad.getAccount(username);

        if (uap.equals(null)) {
            scs.BadRequestCode(request, response);
        }
        return uap;
    }

    @RequestMapping("/getuserlist")
    public List<UserAccountPojo> getUserList(HttpServletRequest request, HttpServletResponse response) {
        AccountDao ad = new AccountDao();
        StatusCodeSend scs = new StatusCodeSend();
        List<UserAccountPojo> result = ad.getAccountList();

        if (result.equals(null)) {
            scs.BadRequestCode(request, response);
        }
        return result;
    }
}
