package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Billetera;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioBilletera;
import ar.edu.unlam.tallerweb1.servicios.ServicioMP;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import com.mercadopago.resources.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorComprarMonedas {

private ServicioUsuario servicioUsuario;

    private ServicioBilletera servicioBilletera;

    private ServicioMP servicioMP = new ServicioMP();

    @Autowired
    public ControladorComprarMonedas(ServicioUsuario servicioUsuario, ServicioBilletera servicioBilletera) {
        this.servicioUsuario = servicioUsuario;
        this.servicioBilletera = servicioBilletera;
    }

    @RequestMapping("/comprarMonedas")
    public ModelAndView irAComprarMonedas(HttpServletRequest request) {

        if(request.getSession().getAttribute("idUsuario") == null){
            return new ModelAndView("redirect:/login");
        }
        if(request.getSession().getAttribute("rol") == Rol.ADMIN){
            return new ModelAndView("redirect:/inicio");
        }
//      --------------------------------
//        ModelMap model = new ModelMap();
////      --------------------------------
//        List<Personaje> listaPersonajes = servicioPersonaje.listaDePersonajesEnVenta();
////      --------------------------------
//        model.put("personajes", listaPersonajes);
////      --------------------------------
//        return new ModelAndView("comprarPersonaje", model);

        return new ModelAndView("comprarMonedas");
    }

    @RequestMapping(value = "/pagoMonedas")
    public ModelAndView irAPagarMonedas(@RequestParam("montoElegido") String montoElegido,HttpServletRequest request){

        ModelMap model = new ModelMap();
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        String montoCantidad = montoElegido;

        //parsear el monto a double
        Double monto = Double.parseDouble(montoElegido);
        //agregar los porcentajes dependiendo del montoElegido
        Double montoConRecargo = servicioBilletera.agregarPorcentajes(monto);
        Preference preference = servicioMP.checkout(user, montoConRecargo);

        //agregarle al montoelegido el 25% de recargo
        montoElegido = String.valueOf(montoConRecargo);

        model.put("preference", preference);
        model.put("montoElegido", montoCantidad);
        model.put("precio", montoElegido);
        return new ModelAndView("pagoMonedas", model);

    }

    @RequestMapping(value = "/pagarMonedas", method = RequestMethod.GET)
    public ModelAndView pagarMonedas(@RequestParam("montoElegido") String montoElegido, @RequestParam(value = "payment_status") String estado, HttpServletRequest request) {
        ModelMap model = new ModelMap();
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        //parsear el monto a double
        Double monto = Double.parseDouble(montoElegido);

        if(estado.equals("approved")){
            Billetera billetera = servicioBilletera.traerDatosBilletera(user);
            billetera.setMonto((float) (billetera.getMonto() + monto));
            servicioBilletera.modificar(billetera);
            request.getSession().setAttribute("billetera", billetera);
            return new ModelAndView("redirect:/comprarMonedas", model);

        } else {
            model.put("mensaje", "No se han acreditado monedas a tu billetera");
        }

        return new ModelAndView("redirect:/comprarMonedas", model);
    }
    /*@RequestMapping("/validar-pago")
    public ModelAndView validarPago(@ModelAttribute("datosDePago") DatosDePago datosDePago, HttpServletRequest request) {

        // -- LLAMAMOS A AL ID DEL USUARIO QUE SE GUARDÓ EN LA SESION CON LA CLAVE QUE LE ASIGNAMOS --
        Integer idUSer = (Integer) request.getSession().getAttribute("idUsuario");
        // -- BUSCO AL USUARIO POR ID --
        Usuario usuario = servicioUsuario.buscarPorID(idUSer);
        // -- BUSCAR LA BILLETERA DEL USUARIO --
        Billetera billetera = servicioBilletera.traerDatosBilletera(usuario);

        //-- PASAMOS A FLOAT EL .getMontoElegido que estaba en String
        Float montoElegido = Float.parseFloat(datosDePago.getMontoElegido());

        Long nroTarjeta = datosDePago.getNumTarjeta();

        ModelMap model = new ModelMap();

        if(esValido(datosDePago.getNumTarjeta())){
            //-- SUMAMOS EL NUEVO MONTO AL MONTO QUE YA TENIA EL USUARIO
            Float nuevoMonto = billetera.getMonto() + montoElegido;

            //-- SETEAMOS EL NUEVO MONTO AL MONTO
            billetera.setMonto(nuevoMonto);

            //-- GUARDA LA MODIFICACION DEL MONTO DE LA BILLETERA
            servicioBilletera.modificar(billetera);
            request.getSession().setAttribute("billetera", billetera);

            return new ModelAndView("home");

        }
        else{
            String error = "Hay un error con el numero de la tarjeta";

            model.put("error",error);
            model.put("montoElegido", montoElegido);
        }

        return new ModelAndView("pagoMonedas",model);
    }
*/
    public static int getTamanio(long d){
        String num = d + "";
        return num.length();
    }
    public static long getPrefijo(long number, int k){
        if (getTamanio(number) > k) {
            String num = number + "";
            return Long.parseLong(num.substring(0, k));
        }
        return number;
    }
    public static boolean coincidirPrefijo(long number, int d){
        return getPrefijo(number, getTamanio(d)) == d;
    }
    public static int sumaDeImpares(long number){
        int sum = 0;
        String num = number + "";
        for (int i = getTamanio(number) - 1; i >= 0; i -= 2)
            sum += Integer.parseInt(num.charAt(i) + "");
        return sum;
    }
    public static int getDigito(int number){
        if (number < 9)
            return number;
        return number / 10 + number % 10;
    }
    public static int sumaDePares(long number){
        int sum = 0;
        String num = number + "";
        for (int i = getTamanio(number) - 2; i >= 0; i -= 2)
            sum += getDigito(Integer.parseInt(num.charAt(i) + "") * 2);
        return sum;
    }
    public static boolean esValido(long number){
        return (getTamanio(number) >= 13 &&
                getTamanio(number) <= 16) &&
                (coincidirPrefijo(number, 4) ||
                        coincidirPrefijo(number, 5) ||
                        coincidirPrefijo(number, 37) ||
                        coincidirPrefijo(number, 6)) &&
                ((sumaDePares(number) +
                        sumaDeImpares(number)) % 10 == 0);
    }



}
