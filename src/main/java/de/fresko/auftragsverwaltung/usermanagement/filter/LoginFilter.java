/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fresko.auftragsverwaltung.usermanagement.filter;

import de.fresko.auftragsverwaltung.usermanagement.controller.LoginController;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/*"})
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        LoginController lc = (LoginController) ((HttpServletRequest) request).getSession(true).getAttribute("loginController");
        boolean userNotLoggedIn = (lc == null || lc.getUser() == null);

        String requestResource = ((HttpServletRequest) request).getRequestURI().toLowerCase();
        boolean loginPage = requestResource.contains("login") 
                || requestResource.contains(".js")
                || requestResource.contains(".css");

        if (userNotLoggedIn && !loginPage) { //user not logged in, redirect to login page
            ((HttpServletResponse) response).sendRedirect("login.xhtml");
            return;
        }

        chain.doFilter(request, response);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
