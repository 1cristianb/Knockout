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
		<img src="<c:url value="/images/fondo_login.gif" />" style="width: 100%">

		<section class="container-fluid w-100 d-flex justify-content-center align-items-center home" style="margin: -714px 0 310px 0;">
			<div class="d-flex justify-content-center d-flex flex-row mt-4 botones">
				<div class="row justify-content-center align-items-center" style="width: 56%;">
					<div class="col-auto bg-light p-5 rounded-3 shadow-lg">
						<div class="d-flex align-items-center">
							<img src="<c:url value="/images/logo.png" />" style="width: 14%; margin-right: 4%;">
							<h3 class="form-signin-heading">
								Bienvenido a Knock Out!
							</h3>
						</div>
						<hr class="colorgraph">

						<form:form action="validar-login" method="POST" modelAttribute="datosLogin">
							<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
							<div class="input-group p-2 d-flex align-items-center">
								<form:input path="email" id="email" type="credencial" class="form-control" placeholder="ejemplo@email.com"/>
							</div>
							<div class="input-group p-2 d-flex align-items-center">
								<form:input path="password" type="password" id="password" class="form-control" placeholder="**********"/>
							</div>
							<br>
							<button class="btn btn-primary w-100" Type="Submit"/>Login</button>
						</form:form>
						<br>

						<%--Bloque que es visible si el elemento error no esta vacio	--%>
						<c:if test="${not empty error}">
							<h4><span>${error}</span></h4>
							<br>
						</c:if>
						<c:if test="${not empty disabled}">
							<h4><span>${error}</span></h4>
							<br>
							<p>Haciendo click en el siguiente boton, se enviara una notificacion al administrador del
								sitio para que lo pueda volver a habilitar</p>
							<form:form action="guardar-peticion" method="post">
								<input type="hidden" name="email" value="${user.email}"/>
								<input type="submit" value="Enviar"/>
							</form:form>
						</c:if>
						<c:if test="${not empty NotificacionEnviada}">
							<div class="notify">
								<p>${NotificacionEnviada}</p>
								<p>Recuerde que esto puede demorar hasta 24hs.</p>
							</div>
						</c:if>
						${msg}
					</div>
				</div>
			</div>
		</section>

		<a href="registro" class="btn btn-success position-absolute top-0 end-0" role="button" aria-pressed="true" style="margin: 2% 6% 0 0;">
			Registrarme
		</a>

		<%@include file="partial/footer.jsp"%>
	</body>
</html>