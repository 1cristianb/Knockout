<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/homeDos.css" rel="stylesheet" />
    <link href="css/miColeccion.css" rel="stylesheet" />
    <%--		<link href="<c:url value="/resources/css/homeDos.css"/>" rel="stylesheet" />--%>
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>--%>
    <%--	Icono	--%>
    <link rel="icon" type="image/png" href="<c:url value="/images/logo.png"/>">
    <title>Knock Out!</title>

    <style>
        .card{
            border-radius: 4px;
            background: #fff;
            box-shadow: 0 6px 10px rgba(0,0,0,.08), 0 0 6px rgba(0,0,0,.05);
            transition: .3s transform cubic-bezier(.155,1.105,.295,1.12),.3s box-shadow,.3s -webkit-transform cubic-bezier(.155,1.105,.295,1.12);
            cursor: pointer;
        }

        .card:hover{
            transform: scale(1.05);
            box-shadow: 0 10px 20px rgba(0,0,0,.12), 0 4px 8px rgba(0,0,0,.06);
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
                <!-- -->
                <header class="text-center mb-5">
                    <h1 class="display-4 font-weight-bold">Mi Colecci&oacute;n</h1>
                    <p class="font-italic text-muted mb-0">
                        Ac&aacute; vas a poder ver todos los personajes que ten&eacute;s en tu colecci&oacute;n.
                    </p>
                </header>

                <div class="row pb-5 mb-4">
                <%--    SE RECORRE LA LISTA     --%>
                    <c:forEach items="${personajes}" var="personaje">
                        <c:if test="${personaje.intercambiable==false}">


                    <%--    POR CADA PERSONAJE SE CREA UNA TARJETA    --%>
                        <div class="col-lg-3 col-md-6 mb-4 mb-lg-0 pb-5">
                            <div class="card shadow-sm border-1 shadow-lg rounded">
                                <div class="card-body p-0">
                                    <img src="<c:url value="/images/personajes/${personaje.imagen}" />" class="w-100 card-img-top">
                                    <div class="p-4">
                                        <h5 class="mb-0 text-center">${personaje.nombre}</h5>
                                        <br>
                                        <div style="display: flex; justify-content: space-evenly;">
                                            <a href="verMasPersonaje?id=${personaje.id} " class="btn btn-success" role="button">Ver más</a>
                                            <a href="aIntercambiar?id=${personaje.id}"  style="display: flex;flex-direction: column;justify-content: center;"><i class="fa-solid fa-arrows-rotate"></i></a>
                                            <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#card${personaje.id}">Vender</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:if>
                    </c:forEach>
                </div>
                <h1 class="display-4 font-weight-bold text-center">Intercambio</h1>
                <p class="font-italic text-muted mb-0 text-center mb-5">
                    Ac&aacute; vas a poder ver todos los personajes que ten&eacute;s para intercambiar.
                </p>
                <div class="row pb-5 mb-4">
                    <c:forEach items="${personajes}" var="personaje">
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
                                                <a href="verMasPersonaje?id=${personaje.id} " class="btn btn-success" role="button">Ver más</a>
                                                <a href="aColeccion?id=${personaje.id}"  style="display: flex;flex-direction: column;justify-content: center;"><i class="fa-solid fa-arrows-rotate"></i></a>
                                                <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#card${personaje.id}">Vender</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>

            </div>

            <%--   MODAL     --%>
            <c:forEach items="${personajes}" var="personaje">
            <div id="card${personaje.id}" class="modal fade" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title text-center">Confirmaci&oacute;n de venta</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>
                            <div class="modal-body">
                                <p class="text-center">Seguro que queres vender a ${personaje.nombre}?</p>
                                <div class="d-flex justify-content-center">
                                    <img src="<c:url value="/images/dollar.png" />"style="width: 12%;" class="pe-2">
                                    <p style="margin-bottom: 0px;margin-top: 16px;">
                                            ${String.format("%.2f",personaje.monto - (personaje.monto * 0.2))}
                                    </p>
                                </div>
                            </div>
                            <div class="modal-footer d-flex justify-content-around">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                <a href="venderPersonaje?id=${personaje.id}" role="button" class="btn btn-danger">Vender</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>


        </main>
    </div>
</div>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="js/homeDos.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
</body>
</html>
