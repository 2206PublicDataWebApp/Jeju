package com.jeju.security.sqlInjection;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SqlInjectionFilter implements  Filter{
    public void init(FilterConfig filterConfig) throws ServletException {
      }

      public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();

        String url = request.getServletPath();
        try {
            System.out.println("## url: \t" + url);
        } catch (Exception e) {
            System.out.println("error : " + e);
        }

        chain.doFilter(req, res);
      }

      public void destroy() {
      }
}
