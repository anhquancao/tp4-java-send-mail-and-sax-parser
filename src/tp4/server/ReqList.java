package tp4.server;

import javax.mail.MessagingException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

/**
 * Created by caoquan on 2/28/17.
 */
public class ReqList {
    public void list(String name, String email) {
        NamingEnumeration names = Directory.list(name);
        String content = "";
        try {
            while (names.hasMore()) {
                content += names.next();
            }
            SendMail.send(content, email);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
