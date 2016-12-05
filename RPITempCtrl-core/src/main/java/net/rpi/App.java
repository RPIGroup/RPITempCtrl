package net.rpi;

import com.pi4j.io.gpio.*;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final GpioController gpio = GpioFactory.getInstance();

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        GpioPinDigitalOutput myLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "" , PinState.LOW);
        try {
            myLed.high();
            Thread.sleep(500);
            myLed.low();
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
