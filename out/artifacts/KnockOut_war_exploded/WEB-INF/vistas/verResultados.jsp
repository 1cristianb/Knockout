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
                            <h1 class="display-4 font-weight-bold">Resultados</h1>
                            <p class="font-italic text-muted mb-0">
                                --------------------------------
                            </p>
                        </header>

                        <c:if test="${not empty ganador}">
                            <div class="alert alert-success alert-dismissible fade show text-center" role="alert" style="width: 50%;margin-left: 25%;">
                                <span>
                                    <b>
                                        <div style="display: flex;justify-content: center;align-items: center;">
                                            <h3>${ganador}</h3>
                                            <img src="<c:url value="/images/winner.png" />" style="width: 13%;" class="p-2">
                                        </div>
                                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                    </b>
                                </span>
                            </div>
                        </c:if>

                        <c:if test="${not empty empate}">
                            <div class="alert alert-success alert-dismissible fade show text-center" role="alert" style="width: 50%;margin-left: 25%;">
                                <span>
                                    <b>
                                        <div style="display: flex;justify-content: center;align-items: center;">
                                            <h3>${empate}</h3>
                                            <img src="<c:url value="/images/idk.png" />" style="width: 13%;" class="p-2">
                                        </div>
                                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                    </b>
                                </span>
                            </div>
                        </c:if>

                        <c:if test="${not empty perdedor}">
                            <div class="alert alert-success alert-dismissible fade show text-center" role="alert" style="width: 50%;margin-left: 25%;">
                                <span>
                                    <b>
                                        <div style="display: flex;justify-content: center;align-items: center;">
                                            <h3>${perdedor}</h3>
                                            <img src="<c:url value="/images/sad.png" />" style="width: 13%;" class="p-2">
                                        </div>
                                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                    </b>
                                </span>
                            </div>
                        </c:if>

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
                            <div class="d-flex justify-content-evenly">
                                <div class="col-lg-3 col-md-6 mb-4 mb-lg-0 pb-5">
                                    <div class="card shadow-sm border-1 shadow-lg rounded">
                                        <div class="card-body p-0">
                                            <img src="<c:url value="/images/personajes/${p2.imagen}" />" class="w-100 card-img-top">
                                            <div class="p-4">
                                                <h5 class="mb-0 text-center">${p2.nombre}</h5>
                                                <br>

                                                <div style="display: flex; justify-content: space-between;" class="btn-group">
                                                    <div class="fondoP d-flex">
                                                        <img src="images/espadas.png" alt="" style="height: 50px;">
                                                        <h4>${p2.ataque}</h4>
                                                    </div>
                                                    <div class="fondoP d-flex">
                                                        <img src="images/escudo.png" alt="" style="height: 50px;">
                                                        <h4>${p2.defensa}</h4>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="d-flex colvs" style="flex-direction: column;justify-content: space-evenly;">
                                    <h3 style="margin-bottom: -279px;">Round 2</h3>
                                    <h3 style="margin-bottom: -516px;text-align: center;">${round2}</h3>
                                    <img src="<c:url value="/images/imgVs.png" />" style="height: 100px;transform: scale(1.7);" class="mt-5 vs">
                                </div>

                                <div class="col-lg-3 col-md-6 mb-4 mb-lg-0 pb-5">
                                    <div class="card shadow-sm border-1 shadow-lg rounded">
                                        <div class="card-body p-0">
                                            <img src="<c:url value="/images/personajes/${boot2.imagen}" />" class="w-100 card-img-top">
                                            <div class="p-4">
                                                <h5 class="mb-0 text-center">${boot2.nombre}</h5>
                                                <br>

                                                <div style="display: flex; justify-content: space-between;" class="btn-group">
                                                    <div class="fondoP d-flex">
                                                        <img src="images/espadas.png" alt="" style="height: 50px;">
                                                        <h4>${boot2.ataque}</h4>
                                                    </div>
                                                    <div class="fondoP d-flex">
                                                        <img src="images/escudo.png" alt="" style="height: 50px;">
                                                        <h4>${boot2.defensa}</h4>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <%--  ------------------------- --%>
                            <div class="d-flex justify-content-evenly">
                                <div class="col-lg-3 col-md-6 mb-4 mb-lg-0 pb-5">
                                    <div class="card shadow-sm border-1 shadow-lg rounded">
                                        <div class="card-body p-0">
                                            <img src="<c:url value="/images/personajes/${p3.imagen}" />" class="w-100 card-img-top">
                                            <div class="p-4">
                                                <h5 class="mb-0 text-center">${p3.nombre}</h5>
                                                <br>

                                                <div style="display: flex; justify-content: space-between;" class="btn-group">
                                                    <div class="fondoP d-flex">
                                                        <img src="images/espadas.png" alt="" style="height: 50px;">
                                                        <h4>${p3.ataque}</h4>
                                                    </div>
                                                    <div class="fondoP d-flex">
                                                        <img src="images/escudo.png" alt="" style="height: 50px;">
                                                        <h4>${p3.defensa}</h4>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="d-flex colvs" style="flex-direction: column;justify-content: space-evenly;">
                                    <h3 style="margin-bottom: -279px;">Round 3</h3>
                                    <h3 style="margin-bottom: -516px;text-align: center;">${round3}</h3>
                                    <img src="<c:url value="/images/imgVs.png" />" style="height: 100px;transform: scale(1.7);" class="mt-5 vs">
                                </div>

                                <div class="col-lg-3 col-md-6 mb-4 mb-lg-0 pb-5">
                                    <div class="card shadow-sm border-1 shadow-lg rounded">
                                        <div class="card-body p-0">
                                            <img src="<c:url value="/images/personajes/${boot3.imagen}" />" class="w-100 card-img-top">
                                            <div class="p-4">
                                                <h5 class="mb-0 text-center">${boot3.nombre}</h5>
                                                <br>

                                                <div style="display: flex; justify-content: space-between;" class="btn-group">
                                                    <div class="fondoP d-flex">
                                                        <img src="images/espadas.png" alt="" style="height: 50px;">
                                                        <h4>${boot3.ataque}</h4>
                                                    </div>
                                                    <div class="fondoP d-flex">
                                                        <img src="images/escudo.png" alt="" style="height: 50px;">
                                                        <h4>${boot3.defensa}</h4>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="d-flex justify-content-center">
                                <%--<button class="btn btn-primary w-75" Type="Submit"/>Ver resultados</button>--%>
                                <a href="Jugar" class="btn btn-success w-75" role="button">
                                    Volver a jugar
                                </a>
                            </div>
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
