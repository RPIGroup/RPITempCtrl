package net.rpi.task;


import com.pi4j.io.gpio.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created by mbl on 16-12-6.
 */
@Service
public class MonitorTask extends Thread{
    private static final Log logger = LogFactory.getLog(MonitorTask.class);
    boolean isCancel = false;
    private static final GpioController gpio = GpioFactory.getInstance();
    GpioPinDigitalOutput gpio_00 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "" , PinState.LOW);

    @Override
    public void run(){
        while(!isCancel){
            File cpuTempFile = new File("/sys/class/thermal/thermal_zone0/temp");
            BufferedInputStream bis= null;
            try {
                bis = new BufferedInputStream(new FileInputStream(cpuTempFile));
                DataInputStream in = new DataInputStream(bis);
                int temp = in.readInt();
                bis.close();
                System.out.print(temp);

                if(temp>6000){
                    gpio_00.high();
                }else if(temp <5000){
                    gpio_00.low();
                }
                Thread.sleep(5000);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
