package com.videowebapp.control;

import com.videowebapp.dao.FactoryDAO;
import com.videowebapp.dao.dto.FilmDTO;
import com.videowebapp.facade.FacadeImpl;
import com.videowebapp.model.Database;
import com.videowebapp.model.Film;
import com.videowebapp.model.Genere;
import com.videowebapp.utility.Comparators;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "ListaProdottiServlet", urlPatterns = "/ListaProdottiServlet")
public class ListaProdottiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<FilmDTO> films = FacadeImpl.getInstance().getFilms();
        String typeOrder = request.getParameter("sorting");
        String remember = request.getParameter("ricorda");
        String typeOrderCookies = "";
        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("ricordaOrdinamento"))
                    typeOrderCookies = cookies[i].getValue();
            }
        }
        if (typeOrder!=null) {
            if (typeOrder.equals("A-Z")) {
                Collections.sort(films, new Comparators.ComparatorTitle());
            } else if (typeOrder.equals("year")) {
                Collections.sort(films, new Comparators.ComparatorYear());
            }
            if(remember!=null) {
                Cookie cookie = new Cookie("ricordaOrdinamento", typeOrder);
                response.addCookie(cookie);
            }
        } else if (!typeOrderCookies.equals("")) {
            if (typeOrderCookies.equals("A-Z")) {
                Collections.sort(films, new Comparators.ComparatorTitle());
                request.setAttribute("checkbox", "true");
            } else if (typeOrderCookies.equals("year")) {
                Collections.sort(films, new Comparators.ComparatorYear());
                request.setAttribute("checkbox", "true");
            }
        }
        request.setAttribute("films", films);
        request.getRequestDispatcher("lista.jsp").forward(request, response);
    }
}
