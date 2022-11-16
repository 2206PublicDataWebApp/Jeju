package com.jeju.security.sqlInjection;

import com.jeju.member.controller.AdminMemberController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

  private static final Logger logger = LoggerFactory.getLogger(SqlInjectionFilter.class);

      public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();

        String url = request.getServletPath();
        try {
          logger.info("## url: \t" + url);
        } catch (Exception e) {
          logger.info("error : " + e);
        }

        chain.doFilter(req, res);
      }

      public void destroy() {
      }
}
