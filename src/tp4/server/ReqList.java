package tp4.server;

import javax.naming.NamingEnumeration;

/**
 * Created by caoquan on 2/28/17.
 */
public class ReqList {
    public void list(String name, String email) {
        NamingEnumeration names = Directory.list(name);
    }
}
