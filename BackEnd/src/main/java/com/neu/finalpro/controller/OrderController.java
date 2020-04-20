package com.neu.finalpro.controller;

import com.neu.finalpro.Dao.CartDao;
import com.neu.finalpro.Dao.CrudItemDao;
import com.neu.finalpro.Dao.OrderDao;
import com.neu.finalpro.pojo.MainPagePojo;
import com.neu.finalpro.pojo.OrderListPojo;
import com.neu.finalpro.pojo.OrderPojo;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.hibernate.criterion.Order;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @RequestMapping(path = "/addorder", method = RequestMethod.POST)
    public String addOrder(@RequestParam("username") String username, @RequestParam("id") String id, @RequestParam("amount") String amount, HttpServletResponse response) throws EmailException {
        OrderDao od = new OrderDao();
        od.addOrder(username, Integer.parseInt(id), Integer.parseInt(amount), "recieve");

        EmailController ec = new EmailController();
        ec.orderSuccess(username);

        CartDao cd = new CartDao();
        cd.deleteCartItem(Integer.parseInt(id), username);

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        return "success";
    }

    @RequestMapping(path = "/getorder", method = RequestMethod.POST)
    public List<OrderListPojo> getOrder(@RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response) {
        OrderDao od = new OrderDao();
        List<MainPagePojo> itemresult = od.getOrderAll(username);
        List<OrderPojo> orderresult = od.getOrderList(username);
        List<OrderListPojo> result = new ArrayList<>();

        for (int i = 0; i < itemresult.size(); i++) {
            OrderListPojo olp = new OrderListPojo();
            olp.setName(itemresult.get(i).getName());
            olp.setAmount(orderresult.get(i).getAmount());
            olp.setOrderNum(orderresult.get(i).getOrderNum());
            olp.setPrice(itemresult.get(i).getPrice() * orderresult.get(i).getAmount());
            olp.setOrderstatus(orderresult.get(i).getOrderstatus());
            olp.setImgURL(itemresult.get(i).getImgURL());
            olp.setId(itemresult.get(i).getId());
            result.add(olp);
        }

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        return result;
    }

    @RequestMapping(path = "/getorderdetail", method = RequestMethod.POST)
    public OrderPojo getOrderDetail(@RequestParam("id") String orderNum, HttpServletResponse response){
        OrderDao od = new OrderDao();
        OrderPojo result = od.getOrderDetail(Integer.parseInt(orderNum));

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        return result;
    }

    @RequestMapping(path = "/getorderlist", method = RequestMethod.POST)
    public List<OrderPojo> getOrderList(@RequestParam("username") String username, HttpServletResponse response) {
        OrderDao od = new OrderDao();
        List<OrderPojo> result = od.getOrderList(username);
        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        return result;
    }

    @RequestMapping(path = "/getnormalorder", method = RequestMethod.POST)
    public List<OrderListPojo> getNormalOrder(@RequestParam("username") String username, HttpServletResponse response) {
        OrderDao od = new OrderDao();
        CrudItemDao cid = new CrudItemDao();
        MainPagePojo mainPagePojo = null;
        OrderListPojo orderListPojo = null;
        List<OrderPojo> result = od.getNormalOrder();
        List<MainPagePojo> mainPagePojoList = new ArrayList<>();
        List<OrderListPojo> orderListPojos = new ArrayList<>();

        for (int j = 0; j < result.size(); j++){
            mainPagePojo = new MainPagePojo();
            mainPagePojo = cid.getItemDetail(String.valueOf(result.get(j).getItemID()));
            mainPagePojoList.add(mainPagePojo);
        }

        for (int i = 0; i < mainPagePojoList.size(); i++){
            orderListPojo = new OrderListPojo();
            orderListPojo.setUsername(result.get(i).getUsername());
            orderListPojo.setId(mainPagePojoList.get(i).getId());
            orderListPojo.setName(mainPagePojoList.get(i).getName());
            orderListPojo.setOrderNum(result.get(i).getOrderNum());
            orderListPojo.setAmount(result.get(i).getAmount());
            orderListPojo.setImgURL(mainPagePojoList.get(i).getImgURL());
            orderListPojo.setPrice(mainPagePojoList.get(i).getPrice() * result.get(i).getAmount());
            orderListPojo.setOrderstatus(result.get(i).getOrderstatus());
            orderListPojos.add(orderListPojo);
        }

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        return orderListPojos;
    }

    @RequestMapping(path = "/getreturnorder", method = RequestMethod.POST)
    public List<OrderListPojo> getReturnOrder(@RequestParam("username") String username, HttpServletResponse response) {
        OrderDao od = new OrderDao();
        CrudItemDao cid = new CrudItemDao();
        MainPagePojo mainPagePojo = null;
        OrderListPojo orderListPojo = null;
        List<OrderPojo> result = od.getReturnOrder();
        List<MainPagePojo> mainPagePojoList = new ArrayList<>();
        List<OrderListPojo> orderListPojos = new ArrayList<>();

        for (int j = 0; j < result.size(); j++){
            mainPagePojo = new MainPagePojo();
            mainPagePojo = cid.getItemDetail(String.valueOf(result.get(j).getItemID()));
            mainPagePojoList.add(mainPagePojo);
        }

        for (int i = 0; i < mainPagePojoList.size(); i++){
            orderListPojo = new OrderListPojo();
            orderListPojo.setUsername(result.get(i).getUsername());
            orderListPojo.setId(mainPagePojoList.get(i).getId());
            orderListPojo.setName(mainPagePojoList.get(i).getName());
            orderListPojo.setOrderNum(result.get(i).getOrderNum());
            orderListPojo.setAmount(result.get(i).getAmount());
            orderListPojo.setImgURL(mainPagePojoList.get(i).getImgURL());
            orderListPojo.setPrice(mainPagePojoList.get(i).getPrice() * result.get(i).getAmount());
            orderListPojo.setOrderstatus(result.get(i).getOrderstatus());
            orderListPojos.add(orderListPojo);
        }

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        return orderListPojos;
    }

    @RequestMapping(path = "/returnorder", method = RequestMethod.POST)
    public int returnOrder(@RequestParam("ordernum") String orderNum, @RequestParam("username") String username, HttpServletResponse response) throws EmailException {
        OrderDao od = new OrderDao();
        int result = od.pendingReturnOrder(Integer.parseInt(orderNum));

        EmailController ec = new EmailController();
        ec.orderReturnRecieved(username, orderNum);

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        return result;
    }

    @RequestMapping(path = "/approvereturn", method = RequestMethod.POST)
    public int approveReturn(@RequestParam("ordernum") String orderNum, @RequestParam("username") String username, HttpServletResponse response) throws EmailException {
        OrderDao od = new OrderDao();
        int result = od.setStatus(Integer.parseInt(orderNum), "returnY");

        EmailController ec = new EmailController();
        ec.orderReturnSuccess(username, orderNum);

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        return result;
    }

    @PostMapping("/rejectreturn")
    public int rejectReturn(@RequestParam("ordernum") String orderNum, @RequestParam("username") String username, HttpServletResponse response) throws EmailException {
        OrderDao od = new OrderDao();
        int result = od.setStatus(Integer.parseInt(orderNum), "returnR");

        EmailController ec = new EmailController();
        ec.orderReturnFailed(username, orderNum);

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        return result;
    }

    @PostMapping("/shiporder")
    public int shipOrder(@RequestParam("ordernum") String orderNum, @RequestParam("username") String username, @RequestParam("label") String label, HttpServletResponse response) throws EmailException {
        OrderDao od = new OrderDao();
        int result = od.setStatus(Integer.parseInt(orderNum), label);

        EmailController ec = new EmailController();
        ec.orderShipped(username, orderNum);

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        return result;
    }

    @PostMapping("/cancelorder")
    public int cancelOrder(@RequestParam("ordernum") String orderNum, @RequestParam("username") String username, HttpServletResponse response) throws EmailException {
        OrderDao od = new OrderDao();
        int result = od.setStatus(Integer.parseInt(orderNum), "cancel");

        EmailController ec = new EmailController();
        ec.orderCanceled(username, orderNum);

        response.setHeader("Content-Type", "application/json");
        response.setHeader("Accept", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methoods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");

        return result;
    }
}
