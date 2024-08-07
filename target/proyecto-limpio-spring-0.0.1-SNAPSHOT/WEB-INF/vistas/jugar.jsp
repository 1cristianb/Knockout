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
                            <h1 class="display-4 font-weight-bold">A jugar!</h1>
                            <p class="font-italic text-muted mb-0">
                                --------------------------------
                            </p>
                        </header>

                        <form action="verResultados" method="get">
                            <div class="row pb-5 mb-4">
                                <div class="d-flex justify-content-evenly">
                                    <div class="col-lg-3 col-md-6 mb-4 mb-lg-0 pb-5">
                                        <div class="card shadow-sm border-1 shadow-lg rounded">
                                            <div class="card-body p-0">
                                                <img src="<c:url value="/images/personajes/${per1.imagen}" />" class="w-100 card-img-top">
                                                <div class="p-4">
                                                    <h5 class="mb-0 text-center">${per1.nombre}</h5>
                                                    <br>

                                                    <div style="display: flex; justify-content: space-between;" class="btn-group">
                                                        <div class="fondoP d-flex">
                                                            <img src="images/espadas.png" alt="" style="height: 50px;">
                                                            <h4>${per1.ataque}</h4>
                                                        </div>
                                                        <div class="fondoP d-flex">
                                                            <img src="images/escudo.png" alt="" style="height: 50px;">
                                                            <h4>${per1.defensa}</h4>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="d-flex colvs" style="flex-direction: column;justify-content: inherit;">
                                        <h3 style="margin-bottom: -279px;">Round 1</h3>
                                        <img src="<c:url value="/images/imgVs.png" />" style="height: 100px;transform: scale(1.7);" class="mt-5 vs">
                                    </div>

                                    <div class="col-lg-3 col-md-6 mb-4 mb-lg-0 pb-5">
                                        <div class="card shadow-sm border-1 shadow-lg rounded">
                                            <div class="card-body p-0">
                                                <img src="<c:url value="/images/personajes/${personajeBootUno.imagen}" />" class="w-100 card-img-top">
                                                <div class="p-4">
                                                    <h5 class="mb-0 text-center">${personajeBootUno.nombre}</h5>
                                                    <br>

                                                    <div style="display: flex; justify-content: space-between;" class="btn-group">
                                                        <div class="fondoP d-flex">
                                                            <img src="images/espadas.png" alt="" style="height: 50px;">
                                                            <h4>${personajeBootUno.ataque}</h4>
                                                        </div>
                                                        <div class="fondoP d-flex">
                                                            <img src="images/escudo.png" alt="" style="height: 50px;">
                                                            <h4>${personajeBootUno.defensa}</h4>
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
                                                <img src="<c:url value="/images/personajes/${per2.imagen}" />" class="w-100 card-img-top">
                                                <div class="p-4">
                                                    <h5 class="mb-0 text-center">${per2.nombre}</h5>
                                                    <br>

                                                    <div style="display: flex; justify-content: space-between;" class="btn-group">
                                                        <div class="fondoP d-flex">
                                                            <img src="images/espadas.png" alt="" style="height: 50px;">
                                                            <h4>${per2.ataque}</h4>
                                                        </div>
                                                        <div class="fondoP d-flex">
                                                            <img src="images/escudo.png" alt="" style="height: 50px;">
                                                            <h4>${per2.defensa}</h4>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="d-flex colvs" style="flex-direction: column;justify-content: inherit;">
                                        <h3 style="margin-bottom: -279px;">Round 2</h3>
                                        <img src="<c:url value="/images/imgVs.png" />" style="height: 100px;transform: scale(1.7);" class="mt-5 vs">
                                    </div>

                                    <div class="col-lg-3 col-md-6 mb-4 mb-lg-0 pb-5">
                                        <div class="card shadow-sm border-1 shadow-lg rounded">
                                            <div class="card-body p-0">
                                                <img src="<c:url value="/images/personajes/${personajeBootDos.imagen}" />" class="w-100 card-img-top">
                                                <div class="p-4">
                                                    <h5 class="mb-0 text-center">${personajeBootDos.nombre}</h5>
                                                    <br>

                                                    <div style="display: flex; justify-content: space-between;" class="btn-group">
                                                        <div class="fondoP d-flex">
                                                            <img src="images/espadas.png" alt="" style="height: 50px;">
                                                            <h4>${personajeBootDos.ataque}</h4>
                                                        </div>
                                                        <div class="fondoP d-flex">
                                                            <img src="images/escudo.png" alt="" style="height: 50px;">
                                                            <h4>${personajeBootDos.defensa}</h4>
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
                                                <img src="<c:url value="/images/personajes/${per3.imagen}" />" class="w-100 card-img-top">
                                                <div class="p-4">
                                                    <h5 class="mb-0 text-center">${per3.nombre}</h5>
                                                    <br>

                                                    <div style="display: flex; justify-content: space-between;" class="btn-group">
                                                        <div class="fondoP d-flex">
                                                            <img src="images/espadas.png" alt="" style="height: 50px;">
                                                            <h4>${per3.ataque}</h4>
                                                        </div>
                                                        <div class="fondoP d-flex">
                                                            <img src="images/escudo.png" alt="" style="height: 50px;">
                                                            <h4>${per3.defensa}</h4>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="d-flex colvs" style="flex-direction: column;justify-content: inherit;">
                                        <h3 style="margin-bottom: -279px;">Round 3</h3>
                                        <img src="<c:url value="/images/imgVs.png" />" style="height: 100px;transform: scale(1.7);" class="mt-5 vs">
                                    </div>

                                    <div class="col-lg-3 col-md-6 mb-4 mb-lg-0 pb-5">
                                        <div class="card shadow-sm border-1 shadow-lg rounded">
                                            <div class="card-body p-0">
                                                <img src="<c:url value="/images/personajes/${personajeBootTres.imagen}" />" class="w-100 card-img-top">
                                                <div class="p-4">
                                                    <h5 class="mb-0 text-center">${personajeBootTres.nombre}</h5>
                                                    <br>

                                                    <div style="display: flex; justify-content: space-between;" class="btn-group">
                                                        <div class="fondoP d-flex">
                                                            <img src="images/espadas.png" alt="" style="height: 50px;">
                                                            <h4>${personajeBootTres.ataque}</h4>
                                                        </div>
                                                        <div class="fondoP d-flex">
                                                            <img src="images/escudo.png" alt="" style="height: 50px;">
                                                            <h4>${personajeBootTres.defensa}</h4>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <%--    valores de ataque y defensa de los personajes elegidos  --%>
                                <input name="personajeUno"  value="${per1.id}" type="hidden">
                                <input name="personajeDos"  value="${per2.id}" type="hidden">
                                <input name="personajeTres" value="${per3.id}" type="hidden">

                                <%--    valores de ataque y defensa de los personajes boot  --%>
                                <input name="personajeBootUno"  value="${personajeBootUno.id}" type="hidden">
                                <input name="personajeBootDos"  value="${personajeBootDos.id}" type="hidden">
                                <input name="personajeBootTres" value="${personajeBootTres.id}" type="hidden">

                                <div class="d-flex justify-content-center" href="verResultados">
                                    <button class="btn btn-primary w-75" Type="Submit"/>Ver resultados</button>
                                </div>
                            </div>
                        </form>
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
