package net.rpi;

import net.rpi.task.MonitorTask;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App
{

    private static final Log logger = LogFactory.getLog(App.class);

    ClassPathXmlApplicationContext context;
    public void loadContext() {
        String filename = "applicationContext.xml";
        context = new ClassPathXmlApplicationContext(filename);
    }

    public static void main( String[] args ) throws IOException {
        logger.info("App started!!!");
        System.out.println( "Hello World!" );


        App app = new App();
        app.loadContext();
        new MonitorTask().start();

        logger.info("App end!!!");
    }

}
