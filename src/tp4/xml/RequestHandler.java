package tp4.xml;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * Created by caoquan on 3/7/17.
 */
class RequestHandler extends DefaultHandler {
    boolean bReqName = false;
    boolean bDir = false;
    boolean bMailAddress = false;

    private Data data;

    public RequestHandler() {
        data = new Data();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("ReqName")) {
            bReqName = true;
        } else if (qName.equalsIgnoreCase("Dir")) {
            bDir = true;
        } else if (qName.equalsIgnoreCase("MailAddress")) {
            bMailAddress = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("request")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        if (bReqName) {
            String reqName = new String(chars, start, length);
            System.out.println(reqName);
            data.command = reqName;
            bReqName = false;
        } else if (bDir) {
            String dir = new String(chars, start, length);
            System.out.println(dir);
            bDir = false;
            data.directory = dir;
        } else if (bMailAddress) {
            String mailAddress = new String(chars, start, length);
            System.out.println(mailAddress);
            bMailAddress = false;
            data.email = mailAddress;
        }
    }

    public Data getData() {
        return this.data;
    }
}
