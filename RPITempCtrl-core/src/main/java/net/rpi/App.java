package net.rpi;

import net.rpi.task.MonitorTask;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App
{

    private static final Logger logger = Logger.getLogger(App.class);


    public static void main( String[] args ) throws IOException {
        logger.info("App started!!!");
        System.out.println( "Hello World!" );



        new MonitorTask().start();

        logger.info("App end!!!");
    }

}
