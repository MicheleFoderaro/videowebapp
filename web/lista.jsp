<%--
Created by IntelliJ IDEA.
User: Michele Foderaro
Date: 28/11/2017
Time: 10:22
To change this template use File | Settings | File Templates.--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"> Film presenti ${requestScope['films'].size()} </h1>
            <form action="<c:url value="ListaProdottiServlet"/>" method="POST" role="form">
                <select name="sorting" class="form-control">
                    <option value="A-Z"  ${param.sorting.equals("A-Z") ? "selected" : ""}> A-Z</option>
                    <option value="year" ${param.sorting.equals("year")? "selected" : ""}>Year</option>
                </select>
                <div id="settings">
                    <input type="checkbox" id="ricorda" value="ricorda" name="ricorda">
                    <label for="ricorda">Ricorda</label>
                    <button type="submit" name="submit" id="ricordaButton" class="btn btn-default">Ordina</button>
                </div>
            </form>
        </div>
        <!-- /.col-lg-12 -->
    </div>

    <div class="row">
        <c:forEach items="${films}" var="f">
            <div class="col-lg-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                            ${f.title}
                    </div>
                    <div class="panel-body">
                        <c:if test="${not empty f.pathCopertina}">
                            <c:set var="path" value="${initParam['read.location']}/${f.pathCopertina}"/>
                        </c:if>
                        <c:if test="${empty f.pathCopertina}">
                            <c:set var="path" value="${initParam['read.location']}/default.jpg"/>
                        </c:if>
                        <img src="${path}" height="80" width="180" onclick="window.open(this.src)">
                    </div>
                    <div class="panel-footer">
                        Genere: ${f.generi.get(f.id_genere).nome} <br>
                        Cast: ${f.cast}, ${f.year} <br>
                        Regia di ${f.regista} <br>
                        Durata: ${f.durata} minuti <br>
                            ${f.descrizione} <br>
                        <a ${sessionScope['utenteDB'].ruolo!=1 ? "hidden" : ""} href="<c:url value="/FormFilmServlet?action=remove&film=${f.id}"/>">
                        <i class="fa fa-trash-o"  ${sessionScope['utenteDB'].ruolo !=1 ? "hidden" : ""}
                           aria-hidden="true"> </i> </a>
                        <a ${sessionScope['utenteDB'].ruolo!=1 ? "hidden" : ""} href="<c:url value="/FormFilmServlet?action=edit&film=${f.id}"/>">
                        <i class="fa fa-pencil"  ${sessionScope['utenteDB'].ruolo !=1 ? "hidden" : ""}
                           aria-hidden="true"> </i> </a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<script src="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.0/js/dataTables.responsive.js"></script>
