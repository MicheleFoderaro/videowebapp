package com.videowebapp.control;

import com.videowebapp.dao.dto.FilmDTO;
import com.videowebapp.dao.dto.UtenteDTO;
import com.videowebapp.facade.FacadeImpl;
import javafx.application.Application;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@MultipartConfig
@WebServlet(name = "FormFilmServlet", urlPatterns = "/FormFilmServlet")
public class FormFilmServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FilmDTO f = new FilmDTO(FacadeImpl.getInstance().getGeneri());
        f.setTitle(request.getParameter("title"));
        String id = request.getParameter("genres");
        id = (id != null && !id.isEmpty()) ? id : "0";
        f.setId_genere(Integer.parseInt(id));
        String year = request.getParameter("anno");
        year = (year != null && !year.isEmpty()) ? year : "0";
        f.setYear(Integer.parseInt(year));
        f.setRegista(request.getParameter("regista"));
        f.setCast(request.getParameter("cast"));
        String durata = request.getParameter("durata");
        durata = (durata != null && !durata.isEmpty()) ? durata : "0";
        f.setDurata(Integer.parseInt(durata));
        f.setDescrizione(request.getParameter("descrizione"));
        //--FINE//
        final Part filePart = request.getPart("file");
        String fileName = scriviFile(filePart);
        List<String> errori = validate(f);
        if (errori.size() == 0) {
            int idFilm = Integer.parseInt(request.getParameter("id"));
            if (idFilm > 0) {
                f.setId(idFilm);
                if (fileName == null) {
                    f.setPathCopertina(FacadeImpl.getInstance().getFilm(idFilm).getPathCopertina());
                } else {
                    f.setPathCopertina(fileName);
                }
                FacadeImpl.getInstance().updateFilm(f);
                request.getRequestDispatcher("ListaProdottiServlet").forward(request, response);
            } else if (idFilm == 0) {
                f.setPathCopertina(fileName);
                FacadeImpl.getInstance().saveFilm(f);
                request.getRequestDispatcher("ListaProdottiServlet").forward(request, response);
            }
        } else {
            request.setAttribute("errors", errori);
            request.setAttribute("film", f);
            request.getRequestDispatcher("form.jsp").forward(request, response);
        }
    }

    private String scriviFile(Part filePart) {
        String path = getServletContext().getInitParameter("upload.location");
        final String fileName = getFileName(filePart);
        if (filePart.getSize() == 0) return null;
        try {
            try (OutputStream out = new FileOutputStream(new File(path + File.separator + fileName));
                 InputStream fileContent = filePart.getInputStream()) {
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = fileContent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("remove")) {
                int idFilm = Integer.parseInt(request.getParameter("film"));
                FacadeImpl.getInstance().deleteFilm(idFilm);
                request.getRequestDispatcher("ListaProdottiServlet").forward(request, response);
            } else if (action.equals("edit")) {
                int idFilm = Integer.parseInt(request.getParameter("film"));
                FilmDTO f = FacadeImpl.getInstance().getFilm(idFilm);
                request.setAttribute("film", f);
                request.getRequestDispatcher("form.jsp").forward(request, response);
            }
        } else {
            FilmDTO f = new FilmDTO(FacadeImpl.getInstance().getGeneri());
            request.setAttribute("film", f);
            request.getRequestDispatcher("form.jsp").forward(request, response);
        }
    }


    private List<String> validate(FilmDTO f) {
        List<String> errori = new ArrayList<>();
        if (f.getTitle() == null || f.getTitle().equals("")) {
            errori.add("Inserisci titolo");
        } else {
            if (f.getTitle().length() < 2) {
                errori.add("Titolo troppo corto");
            }
        }
        if (f.getYear() < 1900 || f.getYear() > 2017) {
            errori.add("Anno non valido");
        }
        if (f.getRegista() == null || f.getRegista().equals("")) {
            errori.add("Inserisci regista");
        } else {
            if (f.getRegista().length() < 2) {
                errori.add("Inserisci un nome valido di regista");
            }
        }
        if (f.getCast() == null || f.getCast().equals("")) {
            errori.add("Inserisci cast");
        } else {
            if (f.getCast().length() < 2) {
                errori.add("Inserisci un cast valido");
            }
        }
        if (f.getDurata() <= 0) {
            errori.add("Durata non valida");
        }
        return errori;
    }
}
