package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Identification;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.Payer;


public class ServicioMP {

    public Preference checkout(Usuario usuario, Double precio){
        Preference preferencia = new Preference();
        try{
            MercadoPago.SDK.setAccessToken("TEST-2469283720580225-101111-9fbc77407935615f68e876d23c7ead37-143730174");
            Preference p = new Preference();
            Item item = new Item();
            item.setTitle("Comprar monedas").setQuantity(1).setUnitPrice(precio.floatValue());
            p.appendItem(item);
            Payer payer = new Payer();
            payer.setEmail(usuario.getEmail());
            p.setPayer(payer);
            p.setBinaryMode(true);
            preferencia = p.save();
        }catch (MPException e){
            System.out.println("Exeception MP\n");
            e.printStackTrace();
        }

        return preferencia;
    }
}
