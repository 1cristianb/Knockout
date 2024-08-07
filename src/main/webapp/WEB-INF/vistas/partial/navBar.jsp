<nav class="sb-topnav navbar navbar-expand navbar-light bg-light justify-content-between" style="padding-bottom: 30px;padding-top: 30px;">
    <!-- Navbar Brand-->
    <div class="d-flex" style="align-items: center;">
        <img src="<c:url value="/images/logo.png" />" style="width: 8%; margin-left: 1%;">
        <a class="navbar-brand ps-3" href="home" style="width: 25%;">Knock Out!</a>
        <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!">
            <svg class="svg-inline--fa fa-bars" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="bars" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512" data-fa-i2svg="">
                <path fill="currentColor" d="M0 96C0 78.33 14.33 64 32 64H416C433.7 64 448 78.33 448 96C448 113.7 433.7 128 416 128H32C14.33 128 0 113.7 0 96zM0 256C0 238.3 14.33 224 32 224H416C433.7 224 448 238.3 448 256C448 273.7 433.7 288 416 288H32C14.33 288 0 273.7 0 256zM416 448H32C14.33 448 0 433.7 0 416C0 398.3 14.33 384 32 384H416C433.7 384 448 398.3 448 416C448 433.7 433.7 448 416 448z"></path>
            </svg>
        </button>
    </div>
    <!-- Sidebar Toggle-->
    <div class="d-flex" style="justify-content: end;">
        <div style="justify-content: center;display: flex;align-items: center;padding: 1% 40% 0% 0%;flex-direction: column">
            <span class="badge badge-pill badge-danger" style="color: white; background: red; width: 100%; font-size: medium">
                Nivel ${nivel.numero}
            </span>
            <progress max="${nivel.valorMax}" value="${nivel.valorActual}"></progress>
        </div>

        <img src="<c:url value="/images/dollar.png" />" style="width: 6%;display: flex;align-items: center;" class="p-2">
        <div style="justify-content: center;display: flex;align-items: center;padding: 2% 2% 0% 0%;">
            <p> ${billetera.monto} </p>
        </div>
        <!-- Navbar-->
        <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4" style="width: 9%;">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="<c:url value="/images/user_gamer.png" />" style="width: 66%;">
                </a>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown" style="margin: -9%;">
                    <li><a class="dropdown-item" href="miPerfil">Mi Perfil</a></li>
                    <li><a class="dropdown-item" href="irModificarPerfil">Modificar</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="logout">Cerrar sesion</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>