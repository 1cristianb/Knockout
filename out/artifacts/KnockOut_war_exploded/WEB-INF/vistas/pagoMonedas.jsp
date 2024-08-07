<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <%--	Bootstrap	--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <%--	Icono	--%>
    <link rel="icon" type="image/png" href="<c:url value="/images/logo.png"/>">
    <title>Knock Out!</title>
    <style>
      input[type=number]::-webkit-inner-spin-button,
      input[type=number]::-webkit-outer-spin-button {
        -webkit-appearance: none;
        margin: 0;
      }

      body{
        background-color: darkslategrey;
      }

      .menu-side-listado{
        width:100%;
        margin-left:auto;
        margin-right:auto;
      }

      .menu-side-listado ul li{
        text-decoration:none;
        list-style:none;
        display:grid;
        grid-template-columns: 50% 50%;
        grid-template-rows: 50% 50%;
        font-family: Krub;
        font-size: 16px;
        font-weight: normal;
        font-style: normal;
        font-stretch: normal;
        line-height: 2.44;
        letter-spacing: normal;
        color: #002f58;
      }

    </style>
  </head>
  <body>
    <section class="container-fluid w-100 d-flex justify-content-center align-items-center">
      <div class="d-flex justify-content-center d-flex flex-row mt-4 botones">
        <div class="row justify-content-center align-items-center" style="width: 40%;">
          <div class="col-auto bg-light p-5 rounded-3 shadow-lg">
            <div class="d-flex align-items-center">
              <img src="<c:url value="/images/logo_pago.png" />" style="width: 14%; margin-right: 4%;">
              <h3 class="form-signin-heading" style="margin-left: 32px">
                Resumen de pago
              </h3>
            </div>
            <hr class="colorgraph">

            <div class="menu-side-listado">
              <ul>
                <li><span>Cantidad:</span><span style="text-align:right; padding-right:15px">${montoElegido}</span></li>
              </ul>
            </div>

            <div class="d-flex flex-column justify-content-end align-items-end">
              <hr class="colorgraph" style="width: 35%">

              <div style="width: 50%">
                <p style="font-size: 13px;text-align: right">Total a Pagar: $${precio}</p>
              </div>
            </div>

            <div class="d-flex flex-row w-100 m-auto pt-3 justify-content-center align-items-center">
              <img src="<c:url value="/images/mercado-pago.png" />" style="width: 10%;height: 15%;">
              <p class="form-signin-heading" style="margin-left: 8px; color:#676a72; font-size: 11px;padding-top: 1rem; width: 80%">
                MercadoPago permite a los clientes de cualquier entidad financiera argentina abonar impuestos, servicios y otras obligaciones.
              </p>
            </div>
            <div class="d-flex flex-row w-100 m-auto gap-5 pt-5 justify-content-center">
              <a class="btn btn-danger btn-sm pt-2" style="padding-left: .8rem;padding-right: .8rem" href="comprarMonedas">Cancelar</a>
              <form action="pagarMonedas" method="get" class="d-inline">
                <input type="hidden" name="montoElegido" value="${montoElegido}">
                <script
                        src="https://www.mercadopago.com.ar/integrations/v1/web-payment-checkout.js"
                        data-preference-id="${preference.id}"/>
                >
                </script>
              </form>
            </div>
            <br>

            <c:if test="${not empty error}">
              <h4><span>${error}</span></h4>
              <br>
            </c:if>
            ${msg}
          </div>
        </div>
      </div>
    </section>

  </body>
</html>