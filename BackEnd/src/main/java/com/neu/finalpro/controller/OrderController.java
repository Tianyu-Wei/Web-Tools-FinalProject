package com.neu.finalpro.controller;

import com.neu.finalpro.pojo.OrderPojo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    public List<OrderPojo> getOrderDetail(HttpServletRequest request, HttpServletResponse response) {
return null;
    }
}
