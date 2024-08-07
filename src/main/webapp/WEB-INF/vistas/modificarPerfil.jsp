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
  </head>
  <body class="sb-nav-fixed">
    <%@include file="partial/navBar.jsp"%>
    <%-- ------------------------ --%>
    <%-- ------------------------ --%>
    <div id="layoutSidenav">
      <%@include file="partial/sidebar.jsp"%>

      <div id="layoutSidenav_content">
        <main>
          <img src="<c:url value="/images/fondoMiPerfil.jpg" />" style="width: 100%" class="opacity-50">

          <div class="container pt-5" style="width: 36%; margin: -631px 0 0 358px;z-index: 100;position: absolute;">
            <div class="card text-center">
              <div class="card-header">
                Mi Perfil
              </div>
              <div class="card-body">
                <div class="row g-3 align-items-center" id="formulario" enctype="multipart/form-data">
                  <form action="modificarPerfil" method="post" class="row">
                    <div class="input-group p-2 d-flex align-items-center form-floating">
                      <input type="email" class="form-control" id="floatingEmailGrid" value="${usuario.email}" disabled>
                      <label for="floatingEmailGrid">Email</label>
                    </div>
                    <div class="input-group p-2 d-flex align-items-center form-floating">
                      <input type="password" class="form-control" name="passwordActual" placeholder="Password actual">
                      <label for="floatingNivelGrid">Password actual</label>
                    </div>
                    <div class="input-group p-2 d-flex align-items-center form-floating">
                      <input type="password" class="form-control" name="password" id="floatingNivelGrid" placeholder="Nueva password">
                      <label for="floatingNivelGrid">Nueva password</label>
                    </div>

                    <div class="p-2" >
                      <input type="submit" name="modificar" class="btn btn-primary w-100" value="Modificar">
                    </div>
                  </form>
                </div>
              </div>
            </div>
            <c:if test="${not empty error1}">
              <h4><span class="text-danger">${error1}</span></h4>
              <br>
            </c:if>
            <c:if test="${not empty error}">
              <h4><span class="text-danger">${error}</span></h4>
              <br>
            </c:if>
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
