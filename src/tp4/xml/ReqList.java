package tp4.xml;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.mail.MessagingException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by caoquan on 2/28/17.
 */
public class ReqList {
    public void list(String data) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            RequestHandler handler = new RequestHandler();
            InputSource source = new InputSource(new StringReader(data));
            saxParser.parse(source, handler);
            Data parsedData = handler.getData();
            if (parsedData.command.equalsIgnoreCase("LIST")) {
                NamingEnumeration names = Directory.list(parsedData.directory);
                String content = "";
                while (names.hasMore()) {

                    content += names.next();
                }
                System.out.println(content);
                SendMail.send(content, parsedData.email);
            } else {
                System.out.println("wrong command");
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }
}
