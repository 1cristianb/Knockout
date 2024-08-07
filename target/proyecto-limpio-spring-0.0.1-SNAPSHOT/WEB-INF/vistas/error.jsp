<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="css/homeDos.css" rel="stylesheet" />
        <link href="css/miColeccion.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <%--	Icono	--%>
        <link rel="icon" type="image/png" href="<c:url value="/images/logo.png"/>">
        <title>Knock Out!</title>
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
                            <h1 class="display-4 font-weight-bold">Selecci&oacute;n de Personajes</h1>
                            <p class="font-italic text-muted mb-0">
                                Debe seleccionar <b>tres</b> personajes para poder jugar.
                            </p>
                        </header>

                        <c:if test="${not empty error}">
                            <div class="alert alert-danger alert-dismissible fade show text-center" role="alert" style="width: 50%; margin-left: 24%;">
                                <span>${error}</span>
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        </c:if>

                        <div class="text-center mb-5">
                            <a href="Jugar" class="btn btn-success" role="button">Intentar de nuevo</a>
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