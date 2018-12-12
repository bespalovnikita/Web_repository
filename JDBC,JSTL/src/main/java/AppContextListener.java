import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class AppContextListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    public AppContextListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Servlet Context is initialized(when the Web application is deployed).");
    }

    public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("Servlet Context is undeployed or Application Server shuts down.");
    }

    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session is created.");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session is destroyed.");
    }

    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println("Attribute is added to a session");
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        System.out.println("Attribute is removed from a session");
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        System.out.println("Attribute is replaced in a session");
    }

}
