package ar.edu.unlam.tallerweb1.servicios;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service("servicioMail")
@Transactional
public class ServicioMailImpl implements ServicioMail {

    private RepositorioUsuario repoUsuario;

    @Autowired
    public ServicioMailImpl(RepositorioUsuario repoUsuario){
        this.repoUsuario = repoUsuario;
    }

    @Override
    public void enviarMailRegistro(String email){
        String asunto = "Confirme su email";
        String mensaje = "<h2>¡Gracias por registrarte!</h2>\n"
                +"<p>----------------------------------</p>\n"
                +"<h4>Su cuenta fue creadad pero debe confirmar su email en el siguiente link</h4><br>"
                +"<a href='http://localhost:8080/KnockOut_war_exploded/validar-mail?email="+email+"'>VERIFICAR EMAIL</a>\n"
                +"<p>Confirmar tu dirección de correo electrónico nos ayuda a mantener la seguiradad de tu cuenta.</p><br>"
                +"<p>Verifica si esta es la dirección correcta: "+email+"</p><br> <br>"
                +"<p>Si crees que esto es un error y no tenes la intencion de registrarte a nuestra pagina, podes ignorar este mensaje y nada mas sucedera</p><br>";

        enviarMail(mensaje, asunto, email);
    }

    @Override
    public void verificarMail(String email) {
        Usuario usuario = repoUsuario.buscarUsuarioPorEmail(email);

        if(usuario == null){
            throw new RuntimeException();
        }

        usuario.setActivo(true);
    }

    public void enviarMail(String mensaje, String asunto, String email) {
        //----Crear un mail y crear el password---
        String username = "knockouttaller2022";
        String password = "xyvhnmcvodtsgbar";


        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.user", username);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.mail.sender", username+"@gmail.com");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        try{
            Session session = Session.getDefaultInstance(props);
            MimeMessage msj = new MimeMessage(session);
            msj.setFrom(new InternetAddress(username));
            msj.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            msj.setSubject(asunto);
            msj.setContent(mensaje, "text/html");
            Transport t = session.getTransport("smtp");
            t.connect("smtp.gmail.com",username, password);
            t.sendMessage(msj, msj.getAllRecipients());
            t.close();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
