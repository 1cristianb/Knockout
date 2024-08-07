
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/homeDos.css" rel="stylesheet" />
    <link href="css/miColeccion.css" rel="stylesheet" />
    <%--		<link href="<c:url value="/resources/css/homeDos.css"/>" rel="stylesheet" />--%>
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <%--	Icono	--%>
    <link rel="icon" type="image/png" href="<c:url value="/images/logo.png"/>">
    <title>Knock Out!</title>
    <%--	Icono bootstrap	--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />

    <link href="css/verMas.css" rel="stylesheet" >
    <style>
        .ficha{
            background-color: #d1caca;
            border: 1px solid;
            border-radius: 30px;
            padding: 10px;
            box-shadow: 13px 13px 21px -3px rgba(0,0,0,0.7);
            -webkit-box-shadow: 13px 13px 21px -3px rgba(0,0,0,0.7);
            -moz-box-shadow: 13px 13px 21px -3px rgba(0,0,0,0.7);
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

            <div class="container py-3">
                <!--boton volver atras -->
                <a href="javascript:history.back()"> <img src="images/atras.png" style="height: 50px"> </a>
                <section class="py-5 text-center">
                    <div class="container px-4 px-lg-5 my-5">
                        <div class="row gx-4 gx-lg-5 align-items-center ficha">
                            <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="<c:url value="/images/personajes/${personaje.imagen}" />" alt="..." style="border-radius: 10px"/></div>
                            <div class="col-md-6">
                                <h1 class="display-5 fw-bolder">${personaje.nombre}</h1>
                                <div class="fs-5 mb-5 d-flex justify-content-center align-items-center">
                                    <img src="<c:url value="/images/dollar.png" />"style="width: 12%;" class="p-2">
                                    <span>${personaje.monto}</span>
                                </div>
                                <p class="lead" style="font-weight: 600">${personaje.descripcion}</p>
                                <h2 class="text-center m-5" style="font-weight: 400">Caracteristicas</h2>
                                <div class="container">
                                    <div class="row">
                                        <div class="col text-center">
                                            <img src="<c:url value="/images/espadas.png" />"style="height: 72px;">
                                            <h4 style="font-weight: 400">${personaje.ataque}</h4>
                                        </div>
                                        <div class="col text-center">
                                            <img src="<c:url value="/images/escudo.png" />"style="height: 72px;">
                                            <h4 style="font-weight: 400">${personaje.defensa}</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </main>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="js/homeDos.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
</body>
</html>

