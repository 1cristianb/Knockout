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
					<div>
						<div class="container position-absolute top-0 start-0" style="margin: 3% 0 0  18%; width: 30%;">
<%--							<h1 class="mt-4">Bienvenidos a Knock Out!</h1>--%>
							<h1>
								<span class="badge badge-secondary" style="background-color: white;color: black;">
									Bienvenidos a Knock Out!
								</span>
							</h1>
						</div>

						<img src="<c:url value="/images/img1.webp" />" style="width: 100%">

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
