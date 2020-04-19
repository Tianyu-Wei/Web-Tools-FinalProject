package com.neu.finalpro.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(filterName = "SearchFilter", urlPatterns = "/api/searchname")
public class SearchFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String keyword = servletRequest.getParameter("keyword");
        String filterKeyword = null;
        System.out.println(keyword);

        try {
            filterKeyword = keyword.replaceAll("[^a-zA-Z0-9]", "");

            System.out.println("M here!" + filterKeyword);
            HttpServletRequest httprequest = (HttpServletRequest) servletRequest;
            HttpSession session = httprequest.getSession(true);

            session.setAttribute("filterkeyword", filterKeyword);
//            httprequest.setAttribute("filterkeyword", filterKeyword);
            filterChain.doFilter(servletRequest, servletResponse);

        }catch (Exception e) {
            System.out.println("Something Wrong!" + e);
        }
    }
}
