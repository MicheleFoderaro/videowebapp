<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.videowebapp.dao.dto.UtenteDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Michele Foderaro
  Date: 18/12/2017
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Login
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form action="LoginServlet" method="POST" role="form">
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="text" name="email" id="email"
                                           class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input type="password" name="password" id="password"
                                           class="form-control">
                                </div>
                                <button type="submit" name="submit" class="btn btn-default">Invia</button>
                                <c:if test="${pageContext.request.method=='POST'}">
                                    <div class="form-group">
                                        <p class="has-error">Username o password sbagliati
                                        </p></div>
                                </c:if>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>