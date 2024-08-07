<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/homeDos.css" rel="stylesheet" />
    <link href="css/miColeccion.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>

    <link rel="icon" type="image/png" href="<c:url value="/images/logo.png"/>">
    <title>Knock Out!</title>

    <style>
       .cuadro{
           width: 80%;
           margin: auto;
           margin-top: 7rem;
       }

    </style>
</head>
<body class="sb-nav-fixed">
<%@include file="partial/navBar.jsp"%>
<%-- ------------------------ --%>
<%-- ------------------------ --%>
<div id="layoutSidenav">
    <%@include file="partial/sidebar.jsp"%>

    <div id="layoutSidenav_content">
        <main>
            <c:if test="${not empty puntaje && puntaje!=0}">
                <div class="alert alert-success cuadro text-center" role="alert" style="padding: 50px">
                    Se ha sumado :<img src="<c:url value="/images/dollar.png" />" style="width: 5%" class="p-2"> ${puntaje} a su cuenta
                </div>
            </c:if>
            <c:if test="${not empty puntaje && puntaje==0}">
                <div class="alert alert-danger cuadro text-center" role="alert" style="padding: 50px">
                    No tuviste respuestas correctas
                </div>
                <div class="d-flex mt-5" style="justify-content: center">
                    <a href="Trivia" type="button" class="btn btn-danger">Volver a Jugar</a>
                </div>
            </c:if>
        </main>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="js/homeDos.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
</body>
</html>
