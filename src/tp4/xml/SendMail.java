package tp4.xml;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


/**
 * Created by caoquan on 3/7/17.
 */
public class SendMail {
    public static void send(String content, String email) throws MessagingException {
        Properties props = System.getProperties();

        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "upn.univ-paris13.fr");

        Session session = Session.getInstance(props);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("info.master.galilee@univ-paris13.fr"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));

        message.setSubject("Directory Content");
        message.setText(content);

        Transport.send(message);
    }

}
