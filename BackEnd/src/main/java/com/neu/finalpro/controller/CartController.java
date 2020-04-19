package com.neu.finalpro.controller;

import com.neu.finalpro.Dao.CartDao;
import com.neu.finalpro.Dao.CrudItemDao;
import com.neu.finalpro.pojo.CartPojo;
import com.neu.finalpro.pojo.MainPagePojo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CartController {

    @RequestMapping(path = "/getcart", method = RequestMethod.POST)
    public List<MainPagePojo> getCart(@RequestParam("username") String username, HttpServletResponse response) {
        CartDao cd = new CartDao();
        List<MainPagePojo> cp = cd.getCartItem(username);

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        return cp;
    }

    @RequestMapping(path = "/deletecart", method = RequestMethod.POST)
    public String deleteCart(@RequestParam("id") String itemid, @RequestParam("username") String username, HttpServletResponse response) {
        CartDao cd = new CartDao();
        int cp = cd.deleteCartItem(Integer.parseInt(itemid), username);

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        return "success";

    }

    @RequestMapping(path = "/addcart", method = RequestMethod.POST)
    public String getCart(@RequestParam("username") String username, @RequestParam("id") String itemId, @RequestParam("quantity") String quantity, HttpServletResponse response) {
        CrudItemDao cid = new CrudItemDao();
        MainPagePojo mpp = cid.getItemDetail(itemId);
        CartDao cd = new CartDao();
        double itemTotal = mpp.getPrice() * Integer.parseInt(quantity);
        cd.addCart(username, Integer.parseInt(itemId), itemTotal, Integer.parseInt(quantity));

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        return "success";

    }

}
