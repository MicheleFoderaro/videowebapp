package com.videowebapp.filter;

import com.videowebapp.dao.dto.UtenteDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "SessionFilter", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class SessionFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if (request.getSession().getAttribute("utenteDB") == null && request.getServletPath().equals("/home.jsp")) {

        } else if (request.getSession().getAttribute("utenteDB") == null && !request.getServletPath().equals("/LoginServlet")) {
            response.sendRedirect("LoginServlet");
            return;
        } else if (request.getSession().getAttribute("utenteDB") != null && request.getServletPath().equals("/FormFilmServlet")) {
            UtenteDTO u = (UtenteDTO) request.getSession().getAttribute("utenteDB");
            if (u.getRuolo() == 2) {
                request.getRequestDispatcher("denied.jsp").forward(request, response);
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
