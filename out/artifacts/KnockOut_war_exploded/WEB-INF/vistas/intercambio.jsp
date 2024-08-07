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
                <!--boton volver atras -->
                <a href="javascript:history.back()"> <img src="images/atras.png" class="mt-3" style="height: 50px;margin-left: 10px"> </a>
                <header class="text-center mb-5">
                    <h1 class="display-4 font-weight-bold mt-3">Intercambio</h1>
                </header>
                    <c:if test="${not empty jugadores}">
                    <table class="table table-dark" style="width: 70%;margin: auto">
                        <thead>
                        <tr>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellido</th>
                            <th scope="col">Nombre Usuario</th>
                            <th scope="col"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${jugadores}" var="jugador">
                        <tr>
                            <td>${jugador.nombre}</td>
                            <td>${jugador.apellido}</td>
                            <td>${jugador.userName}</td>
                            <td><a href="jugadorIntercambio?id=${jugador.id} " class="btn btn-primary" role="button">Seleccionar</a></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    </c:if>

                <c:if test="${not empty titulo && not empty intercambiables}">
                <div class="row pb-5 mb-4" style="width: 70%;margin: auto">
                    <%--   PERSONAJES A INTERCAMBIAR(OTRO JUGADOR)   --%>
                    <h2>${titulo}</h2>
                    <c:forEach items="${intercambiables}" var="personaje">
                        <c:if test="${personaje.intercambiable==true}">


                            <%--    POR CADA PERSONAJE SE CREA UNA TARJETA    --%>
                            <div class="col-lg-3 col-md-6 mb-4 mb-lg-0 pb-5">
                                <div class="card shadow-sm border-1 shadow-lg rounded">
                                    <div class="card-body p-0">
                                        <img src="<c:url value="/images/personajes/${personaje.imagen}" />" class="w-100 card-img-top">
                                        <div class="p-4">
                                            <h5 class="mb-0 text-center">${personaje.nombre}</h5>
                                            <br>
                                            <div style="display: flex; justify-content: space-evenly;">
                                                <a href="miIntercambio?id=${personaje.id} " class="btn btn-success" role="button">Seleccionar</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                </c:if>
                <c:if test="${not empty titulo2}">
                    <div class="row pb-5 mb-4" style="width: 70%;margin: auto">
                            <%--  MIS PERSONAJES  --%>
                        <h2>${titulo2}</h2>
                        <c:forEach items="${misPersonajes}" var="personaje">
                            <c:if test="${personaje.intercambiable==true}">


                                <%--    POR CADA PERSONAJE SE CREA UNA TARJETA    --%>
                                <div class="col-lg-3 col-md-6 mb-4 mb-lg-0 pb-5">
                                    <div class="card shadow-sm border-1 shadow-lg rounded">
                                        <div class="card-body p-0">
                                            <img src="<c:url value="/images/personajes/${personaje.imagen}" />" class="w-100 card-img-top">
                                            <div class="p-4">
                                                <h5 class="mb-0 text-center">${personaje.nombre}</h5>
                                                <br>
                                                <div style="display: flex; justify-content: space-evenly;">
                                                    <a href="intercambioPersonajes?id=${personaje.id} " class="btn btn-success" role="button">Seleccionar</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
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
