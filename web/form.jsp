<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Michele Foderaro
  Date: 28/11/2017
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<c:set var="f" value="${pageContext.request.getAttribute('film')}"/>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Film nuovi?</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Aggiungi un nuovo film
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form action="FormFilmServlet?id=${f.id}" method="POST" role="form"
                                  enctype="multipart/form-data">
                                <div class="form-group">
                                    <label>Titolo</label>
                                    <input type="text" name="title" id="title" value="${f.title}" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Anno uscita film</label>
                                    <input type="text" pattern="\d*" min-length="4" max-length="4" name="anno" id="anno"
                                           value="${f.year}" class="form-control">
                                </div>
                                <div class="form-group">
                                    Copertina: <input type="file" value="${f.pathCopertina}" accept="image/*"
                                                      name="file"/>
                                </div>
                                <div class="form-group">
                                    <label>Regista</label>
                                    <input name="regista" id="regista" value="${f.regista}"
                                           class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Cast</label>
                                    <input name="cast" id="cast" value="${f.cast}"
                                           class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Durata</label>
                                    <input type="text" name="durata" id="durata" pattern="\d*" value="${f.durata}"
                                           class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Descrizione</label>
                                    <input name="descrizione" id="descrizione" value="${f.descrizione}"
                                           class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Genere</label>
                                    <select name="genres" class="form-control">
                                        <c:forEach items="${f.getGeneri().entrySet()}" var="entry">
                                        <c:if test="${f.getId_genere() == entry.getKey()}">
                                        <option value="${entry.getKey()}" selected> ${entry.getValue().getNome()}
                                            </c:if>
                                            <c:if test="${f.getId_genere() != entry.key}">
                                        <option value="${entry.getKey()}"> ${entry.getValue().getNome()}
                                            </c:if>
                                            </c:forEach>
                                    </select>
                                </div>
                                <button type="submit" name="submit" class="btn btn-default">Invia</button>
                                <c:if test="${pageContext.request.method=='POST'}">
                                    <c:forEach items="${requestScope['errors']}" var="errori">
                                        <c:forEach items="${errori}" var="e">
                                            <div class="form-group">
                                                <p class="has-error"> ${e}
                                                </p></div>
                                        </c:forEach>
                                    </c:forEach>
                                </c:if>
                            </form>
                        </div>
                        <!-- /.col-lg-6 (nested) -->
                        <!-- /.col-lg-6 (nested) -->
                    </div>
                    <!-- /.row (nested) -->
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
</div>