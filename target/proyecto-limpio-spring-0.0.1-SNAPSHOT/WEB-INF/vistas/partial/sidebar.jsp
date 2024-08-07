<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">
                <%-- ------------------------ --%>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseVuelos" aria-expanded="false" aria-controls="collapseVuelos">
                    <div>
                        <%--  ESPACIO VACIO POR DISEÑO   --%>
                    </div>
                </a>
                <%-- ------------------------ --%>
                <a class="nav-link " href="miColeccion">
                    Mi Colecci&oacute;n
                </a>
                <%-- ------------------------ --%>
                <a class="nav-link " href="Jugar">
                    Jugar
                </a>
                <%-- ------------------------ --%>
                    <%-- ------------------------ --%>
                    <a class="nav-link " href="inicioTrivia">
                        Trivia
                    </a>
                    <%-- ------------------------ --%>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseTripulacion" aria-expanded="false" aria-controls="collapseTripulacion">
                    Comprar
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseTripulacion" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="comprarPersonaje">Personajes</a>
                        <a class="nav-link" href="comprarMonedas">Monedas</a>
                    </nav>
                </div>
                <%-- ------------------------ --%>
                <a class="nav-link " href="seleccionJugadorIntercambio">
                        Intercambio
                </a>
                <%-- ------------------------ --%>
                    <a class="nav-link " href="Marvel">
                        Acerca de Marvel
                    </a>
                <%-- ------------------------ --%>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseComics" aria-expanded="false" aria-controls="collapseComics">
                    Comics
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseComics" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="descargarComicMarvel">Marvel</a>
<%--                        <a class="nav-link" href="descargarComicDC">DC</a>--%>
                    </nav>
                </div>
                <%-- ------------------------ --%>
            </div>
        </div>
        <div class="sb-sidenav-footer">
            <div class="small">Logueado como:</div>
            <span class="fw-bold">${usuario.userName}</span>
        </div>
    </nav>
</div>