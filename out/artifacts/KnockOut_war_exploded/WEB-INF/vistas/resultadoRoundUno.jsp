<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/homeDos.css" rel="stylesheet" />
    <link href="css/miColeccion.css" rel="stylesheet" />
    <%--		<link href="<c:url value="/resources/css/homeDos.css"/>" rel="stylesheet" />--%>
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <%--        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>--%>
    <%--	Icono	--%>
    <link rel="icon" type="image/png" href="<c:url value="/images/logo.png"/>">
    <title>Knock Out!</title>
    <link rel="stylesheet" href="css/combate.css">

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

      @import url('https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css');

      .btn-primary:hover,
      .btn-primary:focus {
        background-color: #108d6f;
        border-color: #108d6f;
        box-shadow: none;
        outline: none;
      }

      .btn-primary {
        color: #fff;
        background-color: #007b5e;
        border-color: #007b5e;
      }

      section {
        padding: 60px 0;
      }

      section .section-title {
        text-align: center;
        color: #007b5e;
        margin-bottom: 50px;
        text-transform: uppercase;
      }

      #team .card {
        border: none;
        background: #ffffff;
      }

      .image-flip:hover .backside,
      .image-flip.hover .backside {
        -webkit-transform: rotateY(0deg);
        -moz-transform: rotateY(0deg);
        -o-transform: rotateY(0deg);
        -ms-transform: rotateY(0deg);
        transform: rotateY(0deg);
        border-radius: .25rem;
      }

      .image-flip:hover .frontside,
      .image-flip.hover .frontside {
        -webkit-transform: rotateY(180deg);
        -moz-transform: rotateY(180deg);
        -o-transform: rotateY(180deg);
        transform: rotateY(180deg);
      }

      .mainflip {
        -webkit-transition: 1s;
        -webkit-transform-style: preserve-3d;
        -ms-transition: 1s;
        -moz-transition: 1s;
        -moz-transform: perspective(1000px);
        -moz-transform-style: preserve-3d;
        -ms-transform-style: preserve-3d;
        transition: 1s;
        transform-style: preserve-3d;
        position: relative;
      }

      .frontside {
        position: relative;
        -webkit-transform: rotateY(0deg);
        -ms-transform: rotateY(0deg);
        z-index: 2;
        margin-bottom: 30px;
      }

      .backside {
        position: absolute;
        top: 0;
        left: 0;
        background: white;
        -webkit-transform: rotateY(-180deg);
        -moz-transform: rotateY(-180deg);
        -o-transform: rotateY(-180deg);
        -ms-transform: rotateY(-180deg);
        transform: rotateY(-180deg);
        -webkit-box-shadow: 5px 7px 9px -4px rgb(158, 158, 158);
        -moz-box-shadow: 5px 7px 9px -4px rgb(158, 158, 158);
        box-shadow: 5px 7px 9px -4px rgb(158, 158, 158);
      }

      .frontside,
      .backside {
        -webkit-backface-visibility: hidden;
        -moz-backface-visibility: hidden;
        -ms-backface-visibility: hidden;
        backface-visibility: hidden;
        -webkit-transition: 1s;
        -webkit-transform-style: preserve-3d;
        -moz-transition: 1s;
        -moz-transform-style: preserve-3d;
        -o-transition: 1s;
        -o-transform-style: preserve-3d;
        -ms-transition: 1s;
        -ms-transform-style: preserve-3d;
        transition: 1s;
        transform-style: preserve-3d;
      }

      .frontside .card,
      .backside .card {
        min-height: 312px;
      }

      .backside .card a {
        font-size: 18px;
        color: #007b5e !important;
      }

      .frontside .card .card-title,
      .backside .card .card-title {
        color: #007b5e !important;
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

            <div class="row pb-5 mb-4">
              <div class="d-flex justify-content-evenly">
                <div class="col-lg-3 col-md-6 mb-4 mb-lg-0 pb-5">
                  <div class="card shadow-sm border-1 shadow-lg rounded">
                    <div class="card-body p-0">
                      <img src="<c:url value="/images/personajes/${p1.imagen}" />" class="w-100 card-img-top">
                      <div class="p-4">
                        <h5 class="mb-0 text-center">${p1.nombre}</h5>
                        <br>

                        <div style="display: flex; justify-content: space-between;" class="btn-group">
                          <div class="fondoP d-flex">
                            <img src="images/espadas.png" alt="" style="height: 50px;">
                            <h4>${p1.ataque}</h4>
                          </div>
                          <div class="fondoP d-flex">
                            <img src="images/escudo.png" alt="" style="height: 50px;">
                            <h4>${p1.defensa}</h4>
                          </div>
                        </div>

                      </div>
                    </div>
                  </div>
                </div>

                <div class="d-flex colvs" style="flex-direction: column;justify-content: space-evenly;">
                  <h3 style="margin-bottom: -279px;">Round 1</h3>
                  <h3 style="margin-bottom: -516px;text-align: center;">${round1}</h3>
                  <img src="<c:url value="/images/imgVs.png" />" style="height: 100px;transform: scale(1.7);" class="mt-5 vs">
                </div>

                <div class="col-lg-3 col-md-6 mb-4 mb-lg-0 pb-5">
                  <div class="card shadow-sm border-1 shadow-lg rounded">
                    <div class="card-body p-0">
                      <img src="<c:url value="/images/personajes/${boot1.imagen}" />" class="w-100 card-img-top">
                      <div class="p-4">
                        <h5 class="mb-0 text-center">${boot1.nombre}</h5>
                        <br>

                        <div style="display: flex; justify-content: space-between;" class="btn-group">
                          <div class="fondoP d-flex">
                            <img src="images/espadas.png" alt="" style="height: 50px;">
                            <h4>${boot1.ataque}</h4>
                          </div>
                          <div class="fondoP d-flex">
                            <img src="images/escudo.png" alt="" style="height: 50px;">
                            <h4>${boot1.defensa}</h4>
                          </div>
                        </div>

                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <%--  ------------------------- --%>

              <section class="pt-5 pb-5 fondo1">
                <div class="container misCartas">
                  <div class="row pb-5 mb-4">
                    <div>
                      <h3 class="mb-3 pb-5 text-black text-center">Mis personajes,selecciona uno</h3>
                    </div>
                    <div class="d-flex justify-content-around">
                      <%--    SE RECORRE LA LISTA     --%>
                      <c:forEach items="${personajes}" var="personaje" >

                        <%--    POR CADA PERSONAJE SE CREA UNA TARJETA    --%>
                        <div class="col-xs-12 col-sm-6 col-md-4" style="width: 25%;">
                          <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                            <div class="mainflip">
                              <div class="frontside">
                                <div class="card">
                                  <div class="card-body text-center p-0" style="display: flex; align-items: center">
                                    <img class=" img-fluid" src="<c:url value="/images/personajes/${personaje.imagen}" />" alt="card image">
                                  </div>
                                </div>
                              </div>
                              <div class="backside">
                                <div class="card" style="height: 400px; width: 300px;">
                                  <div class="card-body text-center mt-4" style="display: inline-grid;align-content: space-between;">
                                    <h4 class="card-title">${personaje.nombre}</h4>
                                    <ul class="list-inline d-flex justify-content-evenly">
                                      <li class="list-inline-item pe-2">
                                        <img src="images/espadas.png" alt="" style="height: 50px;">
                                        <h4>${personaje.ataque}</h4>
                                      </li>
                                      <li class="list-inline-item">
                                        <img src="images/escudo.png" alt="" style="height: 50px;">
                                        <h4>${personaje.defensa}</h4>
                                      </li>
                                    </ul>
                                  </div>
                                </div>
                              </div>
                              <div class="d-flex justify-content-center">
                                <a href="seleccionPersonajeRoundDos?id=${personaje.id}" class="btn btn-primary" role="button" id="${personaje.id}">Seleccionar</a>
                              </div>
                            </div>
                          </div>
                        </div>
                      </c:forEach>
                    </div>
                  </div>
                </div>
              </section>

            </div>
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
