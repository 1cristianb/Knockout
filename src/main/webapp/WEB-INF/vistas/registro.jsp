<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%--	CSS		--%>
        <%--		<link href="<c:url value="/css/index.css" />">--%>
        <%--	Bootstrap	--%>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <%--	Icono	--%>
        <link rel="icon" type="image/png" href="<c:url value="/images/logo.png"/>">
        <title>Knock Out!</title>
    </head>
    <body>
        <img src="<c:url value="/images/fondo_registro.webp" />" style="width: 100%">

        <section class="container-fluid w-100 d-flex justify-content-center align-items-center home" style="margin: -716px 0 -112px 0;">
            <div class="d-flex justify-content-center d-flex flex-row mt-4 botones">
                <div class="row justify-content-center align-items-center" style="width: 45%;">
                    <div class="col-auto bg-light p-5 rounded-3 shadow-lg">
                        <div class="d-flex align-items-center">
                            <img src="<c:url value="/images/logo.png" />" style="width: 14%; margin-right: 4%;">
                            <h3 class="form-signin-heading">
                                Registrarme en Knock Out!
                            </h3>
                        </div>
                        <hr class="colorgraph">

                        <form action="registrarUsuario" method="post" modelAttribute="usuario" class="row">
                            <div class="input-group p-2 d-flex align-items-center col">
                                <input class="form-control" type="text" placeholder="Nombre" name="nombre">
                            </div>
                            <div class="input-group p-2 d-flex align-items-center col">
                                <input class="form-control" type="text" placeholder="Apellido" name="apellido">
                            </div>
                            <div class="input-group p-2 d-flex align-items-center">
                                <input class="form-control" type="text" placeholder="Nombre de Usuario" name="userName">
                            </div>
                            <div class="input-group p-2 d-flex align-items-center">
                                <input class="form-control" type="text" placeholder="Email" name="email">
                            </div>
                            <div class="input-group p-2 d-flex align-items-center">
                                <input class="form-control" type="password" placeholder="Password" name="password">
                            </div>
                            <br>
                            <button type="submit" class="btn btn-primary w-100">Registrarme</button>
                        </form>
                        <br>

                        <%--Bloque que es visible si el elemento error no esta vacio	--%>
                        <c:if test="${not empty error}">
                            <h4><span>${error}</span></h4>
                            <br>
                        </c:if>
                        ${msg}
                    </div>
                </div>
            </div>
        </section>

        <a href="login" class="btn btn-success position-absolute top-0 end-0" role="button" aria-pressed="true" style="margin: 2% 6% 0 0;">
            Iniciar Sesi&oacute;n
        </a>

        <%@include file="partial/footer.jsp"%>
    </body>
</html>