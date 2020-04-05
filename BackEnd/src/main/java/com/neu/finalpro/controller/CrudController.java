package com.neu.finalpro.controller;

import com.neu.finalpro.Dao.CrudItemDao;
import com.neu.finalpro.pojo.MainPagePojo;
import com.neu.finalpro.pojo.UserAccountPojo;
import org.hibernate.Session;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CrudController {

    //Add items controller
    @RequestMapping ("/add")
    public String addItem(@RequestParam("name") String name, @RequestParam("amount") String amount, @RequestParam("price") String price,
    @RequestParam("category") String category, @RequestParam("description") String description, @RequestParam("imgURL") String imgURL,
    @RequestParam("discount") String discount, HttpServletResponse response) {
        CrudItemDao cid = new CrudItemDao();
        double tmpprice = Double.parseDouble(price);
        int tmpamount = Integer.parseInt(amount);

       int result = cid.addItem(name, category, tmpamount, tmpprice, description, imgURL, discount);
       try {
           if (result == 1) {
               response.setStatus(200);
           } else {
               response.setStatus(400);
           }
       }catch (Exception e) {
           System.out.println("SomethingWrong!" + e);
           response.setStatus(403);
       }
       return "success";
    }

    //Delete items controller
    @RequestMapping (path = "/delete", method = RequestMethod.POST)
    public String deleteItem(@RequestParam("id") String id, HttpServletResponse response) {
        CrudItemDao cid = new CrudItemDao();
        long tmpID = Long.valueOf(id);

        int result = cid.deleteItem(tmpID);

        try {
            if (result == 1) {
                response.setStatus(200);
            } else {
                response.setStatus(400);
            }

        }catch (Exception e) {
            System.out.println("Something Wrong!" + e);
            response.setStatus(403);
        }
        return "success";
    }

    //Update items controller
    @RequestMapping (path = "/update", method = RequestMethod.POST)
    public String updateItem(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("amount") String amount, @RequestParam("price") String price,
                        @RequestParam("category") String category, @RequestParam("description") String description, @RequestParam("imgURL") String imgURL,
                        @RequestParam("discount") String discount, HttpServletResponse response) {
        CrudItemDao cid = new CrudItemDao();
        int result = 0;
        double tmpprice = Double.parseDouble(price);
        int tmpamount = Integer.parseInt(amount);

        try {

            result = cid.updateItem(Long.valueOf(id), name, category, tmpamount, tmpprice, description, imgURL, discount);
            if (result == 1) {
                response.setStatus(200);
            }else {
                response.setStatus(400);
            }

        }catch (Exception e) {
            System.out.println("Something Wrong!" + e);
            response.setStatus(403);
        }
        return "success";
    }

    //Random search items controller
    @RequestMapping (path = "/", method = RequestMethod.GET)
    public List<MainPagePojo> searchItem(HttpServletRequest request, HttpServletResponse response) {
        CrudItemDao cid = new CrudItemDao();
        List<MainPagePojo> result = cid.getShoppingDetailR();
        List<MainPagePojo> newresult = new ArrayList<>();

            for (int i = 0; i < result.size(); i++) {
                newresult.add(result.get(i));
            }
            response.setHeader("Content-Type", "application/json");
            response.setHeader("Accept", "application/json");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
            response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

            HttpSession session = request.getSession(true);
            session.setAttribute("result", newresult);

        return newresult;
    }

    @RequestMapping("/detail")
    public MainPagePojo getDetailByID(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {
        MainPagePojo mpp = new MainPagePojo();
        CrudItemDao cid = new CrudItemDao();
        StatusCodeSend scs = new StatusCodeSend();
        mpp = cid.getItemDetail(id);

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        if (!mpp.equals(null)) {
//            HttpSession session = request.getSession(true);
//            session.setAttribute("result", mpp);
            return mpp;
        }else {
            scs.BadRequestCode(request, response);
        }
        return null;
    }
}
