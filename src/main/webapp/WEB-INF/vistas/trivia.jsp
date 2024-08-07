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
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.0/dist/sweetalert2.all.min.js"></script>
    <style>
        main {
            background: #63a05f;
            padding: 0;
            margin: 0;
            text-align: center;
            font-family: calibri;
            font-size: 120%;
            transition: all 0.3s;
        }

        .contenedor {
            width: 98vw;
            height: 97vh;
            display: inline-flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        .encabezado {
            position: relative;
            background: white;
            min-width: 300px;
            width: 70%;
            max-width: 600px;
            padding: 10px;
        }

        .categoria {
            opacity: 0.3;
            text-align: left;
        }

        .pregunta {
            padding: 10px;
        }

        .imagen {
            object-fit: cover;
            height: 0px;
            width: 0px;
        }

        .btn {
            background: white;
            width: 60%;
            max-width: 550px;
            padding: 10px;
            margin: 5px;
            cursor: pointer;
        }

        .btn:hover {
            transform: scale(1.05);
        }

        .numero{
            position: absolute;
            opacity:0.3;
            top: 10px;
            right: 10px;
        }

        .puntaje{
            padding:10px;
            color:white;
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
            <div class="contenedor">
                <div class="puntaje" id="puntaje"></div>
                <div class="encabezado">
                    <div class="categoria" id="categoria">
                    </div>
                    <div class="numero" id="numero"></div>
                    <div class="pregunta" id="pregunta">
                    </div>
                    <img src="#" class="imagen" id="imagen">
                </div>
                <div class="btn" id="btn1" onclick="oprimir_btn(0)"></div>
                <div class="btn" id="btn2" onclick="oprimir_btn(1)"></div>
                <div class="btn" id="btn3" onclick="oprimir_btn(2)"></div>
                <div class="btn" id="btn4" onclick="oprimir_btn(3)"></div>
                <script src="js/index.js"></script>
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
