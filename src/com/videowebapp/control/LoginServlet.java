package com.videowebapp.control;

import com.videowebapp.dao.dto.UtenteDTO;
import com.videowebapp.facade.FacadeImpl;
import com.videowebapp.model.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteDTO utenteDTO = new UtenteDTO();
        utenteDTO.setEmail(request.getParameter("email"));
        utenteDTO.setPassword(request.getParameter("password"));
        UtenteDTO presenteDB = checkLogin(utenteDTO);
        if (presenteDB!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("utenteDB", presenteDB);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            request.setAttribute("utente", utenteDTO);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("action");
        if (s==null) {
            UtenteDTO utenteDTO = new UtenteDTO();
            request.setAttribute("utente", utenteDTO);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.getSession().invalidate();
            response.sendRedirect("home.jsp");
        }
    }

    private UtenteDTO checkLogin(UtenteDTO utenteDTO) {
        List<UtenteDTO> utenti = FacadeImpl.getInstance().getUtenti();
        String email = utenteDTO.getEmail();
        String password = utenteDTO.getPassword();
        for (UtenteDTO u : utenti) {
            if (email.toLowerCase().equals(u.getEmail()) && password.equals(u.getPassword())) {
                return u;
            }
        }
        return null;
    }
}
