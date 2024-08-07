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
</head>

<body class="sb-nav-fixed">
<%@include file="partial/navBar.jsp"%>
<%-- ------------------------ --%>
<%-- ------------------------ --%>
<div id="layoutSidenav">
    <%@include file="partial/sidebar.jsp"%>

    <div id="layoutSidenav_content">
        <main>
            <div>
                <div class="container position-absolute top-0 start-0" style="margin: 3% 0 0  18%">
                    <div class="container bcontent">
                        <h2>Comprar Monedas</h2>

                        <div class="row pb-5 mb-4">
                            <div class="col-lg-3 col-md-6 mb-4 mb-lg-0 pb-5">
                                <div class="card shadow-sm border-1 shadow-lg rounded">
                                    <img src="images/dollar.png" class="p-3">
                                    <div class="card-body p-3 text-center">
                                        <h5 class="card-title">500 Monedas</h5>
                                        <p class="card-text">Comprar 500 monedas a $1000.</p>
                                        <form action="pagoMonedas" method="post">
                                            <input type="hidden" name="montoElegido" value="500" >
                                            <button class="btn btn-success" Type="Submit"/>
                                                Comprar 500 monedas
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-6 mb-4 mb-lg-0 pb-5">
                                <div class="card shadow-sm border-1 shadow-lg rounded">
                                    <img src="images/dollar2.png" class="p-3">
                                    <div class="card-body p-3 text-center">
                                        <h5 class="card-title">1000 Monedas</h5>
                                        <p class="card-text">Comprar 1000 monedas a $1500.</p>
                                        <form action="pagoMonedas" method="post">
                                            <input type="hidden" name="montoElegido" value="1000" >
                                            <button class="btn btn-success" Type="Submit"/>
                                                Comprar 1000 monedas
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-6 mb-4 mb-lg-0 pb-5">
                                <div class="card shadow-sm border-1 shadow-lg rounded">
                                    <img src="images/dollar3.png" class="p-3">
                                    <div class="card-body p-3 text-center">
                                        <h5 class="card-title">2000 Monedas</h5>
                                        <p class="card-text">Comprar 2000 monedas a $2500.</p>
                                        <form action="pagoMonedas" method="post">
                                            <input type="hidden" name="montoElegido" value="2000" >
                                            <button class="btn btn-success" Type="Submit"/>
                                                Comprar 2000 monedas
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
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