<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/homeDos.css" rel="stylesheet" />
    <script src="https://kit.fontawesome.com/b7aa95e782.js" crossorigin="anonymous"></script>
    <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″ />
    <title>Knock Out!</title>
</head>
<body class="sb-nav-fixed">
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <img src="<c:url value="/images/logo.png" />" style="width: 3%; margin-left: 1%;">
    <a class="navbar-brand ps-3">Knock Out!</a>
    <!-- Sidebar Toggle-->
    <!-- <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>-->
    <div class="d-flex justify-content-end w-100">
        <img href="#" id="news" class="btn" src="<c:url value="/images/notificar.png" />" style="width: 4.5%; filter:invert(0.7)">
        <button id="numbers" data-badge="${notificaciones.size()}"></button>
    </div>
    <div style="display:none" class="alert_list">
        <ul class="unstyled px-0">
            <c:if test="${empty notificaciones}">
                 <p class="text-center alert_li">Aún no hay notificaciones</p>
            </c:if>
            <c:forEach var="notificacion" items="${notificaciones}">
                <div class="border rounded-3 px-2 py-2 mb-2">
                    <p><span class="fw-bold">Asunto: </span>${notificacion.asunto}</p>
                    <p>${notificacion.mensaje}</p>
                </div>
            </c:forEach>
            <!--<li data-alert_id="3" class="alert_li"><a href="#">Messaggio di notifica un po più lungo del normale</a> <br /><a href="#" class="turn_off_alert">turn off</a><div class="clearfix"></div></li>
        --></ul>
    </div>

    <ul class="navbar-nav ms-auto me-3 me-lg-4">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                <li><hr class="dropdown-divider" /></li>
                <li><a class="dropdown-item" href="logout">Cerrar sesión</a></li>
            </ul>
        </li>
    </ul>

</nav>
<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Administración</div>
                    <a class="nav-link" href="inicio">
                        <div class="sb-nav-link-icon"><i class="fas fa-user"></i></div>
                        Administrar usuarios
                    </a>
                    <a class="nav-link" href="administracionPersonaje">
                        <div class="sb-nav-link-icon"><i class="fas fa-user-robot"></i></div>
                        Administrar personajes
                    </a>
                </div>
            </div>
        </nav>
    </div>

<div  id="layoutSidenav_content">
    <div class="container px-5">

    <h1  style="font-weight: 300" class="mt-4 mb-4">Control de usuarios</h1>
    <div class="row mb-4">
            <div class="col">
            <div class="card mb-3" style="width: 20rem;">
                <div class="card-header">
                    Ranking <i class="fas fa-medal"></i>
                </div>
                <table class="table"style="margin-bottom:0">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Jugador</th>
                        <th scope="col">Nivel</th>
                    </tr>
                    <c:if test="${empty max}">
                        <p class="card-text text-center"
                           style="position: absolute;
                           top: 100%;
                           width: 100%;
                           border: 1px solid rgba(0,0,0,0.125);
                           border-top: none;"
                        >No hay usuarios registrados</p>
                    </c:if>
                    <c:set var="i" value="1"/>
                    <c:forEach var="maximos" items="${max}">
                        <tr>
                            <td><img width="115%" src="images/medalla_${i}.png"></td>
                            <td>${maximos.email}</td>
                            <td class="text-center">${maximos.nivel.numero}</td>
                        </tr>
                        <c:set var="i" value="${i+1}"/>
                        </c:forEach>
                </table>
            </div>
            </div>

            <div class="col">
            <div class="card mb-3" style="max-width: 18rem;">
                <div class="card-header">Jugador con máximo nivel <i class="fas fa-crown"></i> </div>
                <div class="card-body">
                    <c:if test="${empty maximo}">
                        <p class="card-text text-center">No hay usuarios registrados</p>
                    </c:if>
                    <c:if test="${!empty maximo}">
                        <h5 class="card-text text-center">${maximo.email}</h5>
                        <h5 class="card-text text-center">Nivel: ${maximo.nivel.numero}</h5>
                    </c:if>
                </div>
            </div>
            </div>

        <div class="col">
            <div class="card mb-3" style="max-width: 18rem;">
                <div class="card-header">Jugador con más cartas <i class="fas fa-crown"></i> </div>
                <div class="card-body">
                    <c:if test="${empty coleccion}">
                        <p class="card-text text-center">No hay usuarios registrados</p>
                    </c:if>
                    <c:if test="${!empty coleccion}">
                        <h5 class="card-text text-center">${coleccion.usuario.email}</h5>
                        <h5 class="card-text text-center">Total cartas: ${coleccion.personajes.size()}</h5>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
        <h1>${fecha}</h1>

        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                Datos usuarios
            </div>
            <div class="card-body">
                <table id="datatablesSimple" class="table" style="width: 80%">
                    <tr>
                        <th scope="col">Email</th>
                        <th scope="col" class="text-center">Activo</th>
                        <th scope="col" class="text-center">Nivel</th>
                        <th scope="col" class="text-center">Ultima conexion</th>
                        <th scope="col" class="text-center">Activar/Desactivar</th>
                    </tr>
                    <c:forEach var="usuario" items="${usuarios}">
                        <tr>
                            <td>${usuario.email}</td>
                            <td class="text-center">${usuario.habilitado}</td>
                            <td class="text-center">${usuario.nivel.numero}</td>
                            <c:if test="${empty usuario.ultimaConexion}">
                                <td class="text-center">Aún no inicio sesión</td>
                            </c:if>
                            <c:if  test="${!empty usuario.ultimaConexion}">
                                <td class="text-center"><fmt:formatDate value="${usuario.ultimaConexion}" pattern="dd/MM/yyyy HH:mm" /></td>
                            </c:if>
                            <td class="text-center">
                                <c:if test="${usuario.habilitado == false}">
                                    <a href="cambio-estado?id=${usuario.id}" class="text-decoration-none btn btn-success">Activar</a>
                                </c:if>
                                <c:if test="${usuario.habilitado == true}">
                                    <a  href="cambio-estado?id=${usuario.id}" class="text-decoration-none btn btn-danger">Desactivar</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <c:if test="${empty usuarios}">
                            <td></td>
                            <td>No existen usuarios</td>
                            <td></td>
                        </c:if>
                    </tr>
                </table>
                </div>
            </div>
        </div>
    </div>
</div>



<!--agregar cdn de jquery-->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="js/homeDos.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="js/datatables-simple-demo.js"></script>
<script src="js/notification.js"></script>

</body>
</html>