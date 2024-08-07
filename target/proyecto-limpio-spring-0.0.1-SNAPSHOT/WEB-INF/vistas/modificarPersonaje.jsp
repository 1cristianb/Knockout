<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <ul class="navbar-nav ms-auto me-3 me-lg-4">
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
      <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
        <li><a class="dropdown-item" href="#!">Settings</a></li>
        <li><a class="dropdown-item" href="#!">Activity Log</a></li>
        <li><hr class="dropdown-divider" /></li>
        <li><a class="dropdown-item" href="logout">Logout</a></li>
      </ul>
    </li>
  </ul>
</nav>
<div id="layoutSidenav">
  <div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
      <div class="sb-sidenav-menu">
        <div class="nav">
          <div class="sb-sidenav-menu-heading">Administracion</div>
          <a class="nav-link" href="inicio">
            <div class="sb-nav-link-icon"><i class="fas fa-user"></i></div>
            Administrar usuarios
          </a>
          <a class="nav-link" href="personajes">
            <div class="sb-nav-link-icon"><i class="fas fa-user-robot"></i></div>
            Administrar personajes
          </a>
        </div>
      </div>
    </nav>
  </div>

  <div  id="layoutSidenav_content">
    <div class="container px-5">
      <header class="text-center mb-5">
        <h1 class="display-4 font-weight-bold">Personajes</h1>
      </header>

      <div class="row pb-5 mb-4">
        <c:forEach items="${personajes}" var="personaje">

          <div class="col-lg-3 col-md-6 mb-4 mb-lg-0 pb-5">
            <div class="card shadow-sm border-1 shadow-lg rounded">
              <div class="card-body p-0">
                <img src="<c:url value="/images/personajes/${personaje.imagen}" />" class="w-100 card-img-top">
                <div class="p-4">
                  <h5 class="mb-0 text-center">${personaje.nombre}</h5>
                  <h5 class="mb-0 text-center"> <img src="images/dollar.png" style="width: 45px;"> ${personaje.monto} </h5>

                  <br>
                  <div style="display: flex; justify-content: space-evenly;">
                    <div>
                      <button class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#card${personaje.id}">Editar</button>
                    </div>
                    <form action="eliminar" method="post" >
                      <input type="hidden"  name="id" value="${personaje.id}"/>
                      <button type="submit" class="btn btn-danger">Eliminar</button>
                    </form>
                    <!--<a href="eliminar?id=${personaje.id}" type="button" class="btn btn-danger">Eliminar</a>-->
                  </div>
                </div>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>

    <!-- Modal -->
    <c:forEach items="${personajes}" var="personaje">
    <div class="modal fade" id="card${personaje.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">${personaje.nombre}</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <label class="mb-2">Precio actual: ${personaje.monto}</label>
            <form action="modificar" method="post">
              <div class="form-group">
                <label>Nuevo precio</label>
                <input type="number" step="any" name="monto">
                <input type="hidden" name="id" value="${personaje.id}">
              </div>
              <button type="submit" class="btn btn-primary">Modificar</button>
            </form>
          </div>
        </div>
      </div>
    </div>
    </c:forEach>
  </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="js/homeDos.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="js/datatables-simple-demo.js"></script>
</body>
</html>