<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/homeDos.css" rel="stylesheet" />
    <%--		<link href="<c:url value="/resources/css/homeDos.css"/>" rel="stylesheet" />--%>
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <%--	Icono	--%>
    <link rel="icon" type="image/png" href="<c:url value="/images/logo.png"/>">
    <title>Knock Out!</title>

    <style>
        .bcontent {
            margin-top: 10px;
        }
    </style>
    <style>

        #layoutSidenav_content {
            background-image:url( "<c:url value="/images/fondoIntercambio.jpg" />");
            background-repeat: no-repeat;
        }

    </style>
    <link rel="stylesheet" href="css/combate.css">
</head>

<body class="sb-nav-fixed">
<%@include file="partial/navBar.jsp"%>
<%-- ------------------------ --%>
<%-- ------------------------ --%>
<div id="layoutSidenav">
    <%@include file="partial/sidebar.jsp"%>

    <div id="layoutSidenav_content">
        <main>
            <section class="fondo">
                <c:if test="${empty exito}">


                <!--boton volver atras -->
                <a href="javascript:history.back()"> <img src="images/atras.png" class="mt-3" style="height: 50px;margin-left: 10px"> </a>
                <header class="text-center mb-5">
                    <h1 class="display-4 font-weight-bold mt-3">Intercambio</h1>
                </header>
                <div class="duelo mt-5 d-flex" style="justify-content: space-around">
                    <div class="cartaDuelo">
                        <div class="bordeI">

                            <img src="<c:url value="/images/personajes/${miPersonaje.imagen}" />" alt="">
                        </div>
                        <div class="text-white text-center nombreI">
                            <h4>${miPersonaje.nombre}</h4>
                        </div>
                    </div>

                    <div class="d-flex colvs" style="flex-direction: column;justify-content: inherit;">
                        <img src="images/intercambio.png" style="height: 150px;" class="mt-5 vs">
                        <a href="intercambio?idMio=${miPersonaje.id}&idOtro=${otroPersonaje.id} " class="btn btn-primary mb-5" role="button">Solicitar intercambio</a>
                    </div>

                    <div class="cartaIa">
                        <div class="bordeI">
                            <img src="<c:url value="/images/personajes/${otroPersonaje.imagen}" />" alt="">
                        </div>
                        <div class="text-white text-center nombreI">
                            <h4>${otroPersonaje.nombre}</h4>
                        </div>
                    </div>
                </div>
                </c:if>
                <c:if test="${not empty exito}">
                    <div class="alert alert-success text-center" style="padding: 25px;margin-top: 20rem">${exito}</div>
                </c:if>
            </section>
        </main>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="js/homeDos.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
</body>

