package tp4.xml;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by caoquan on 3/7/17.
 */
public class Directory {
    public static NamingEnumeration list(String name) {
        Properties props = new Properties();

        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
        props.put(Context.PROVIDER_URL, "file:/");

        NamingEnumeration ne = null;

        try {
            Context ctx = new InitialContext(props);
            ne = ctx.list(name);

            while (ne.hasMore()) {
                System.out.println(ne.next());
            }
            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return ne;
    }

}
