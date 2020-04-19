package com.neu.finalpro.controller;

import com.neu.finalpro.Dao.SearchItemDao;
import com.neu.finalpro.pojo.MainPagePojo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.applet.Main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class SearchNameController {

    @RequestMapping(path = "/searchname", method = RequestMethod.GET)
    public List<MainPagePojo> searchByName(@RequestParam("cate") String category, HttpServletRequest request, HttpServletResponse response) {
        SearchItemDao sid = new SearchItemDao();
        HttpSession session = request.getSession(true);
        String keyword = (String) session.getAttribute("filterkeyword");
        List<MainPagePojo> result = sid.searchItem(category, keyword);

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        return result;
    }

    @RequestMapping(path = "/category", method = RequestMethod.GET)
    public List<MainPagePojo> getCategory(@RequestParam("cate") String category, HttpServletResponse response) {
        SearchItemDao sid = new SearchItemDao();
        List<MainPagePojo> result = sid.categoryItem(category);

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        return result;
    }

}
