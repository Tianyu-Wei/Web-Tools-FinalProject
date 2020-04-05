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
    public List<MainPagePojo> searchByName(@RequestParam("keyword") String keyword, @RequestParam("cate") String category, HttpServletRequest request, HttpServletResponse response) {
        SearchItemDao sid = new SearchItemDao();

        List<MainPagePojo> result = sid.searchItem(category, keyword);

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        HttpSession session = request.getSession(true);
        session.setAttribute("result", result);

        return result;
    }

}
