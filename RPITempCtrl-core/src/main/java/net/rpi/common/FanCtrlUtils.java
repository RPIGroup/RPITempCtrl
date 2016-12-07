package net.rpi.common;

import com.pi4j.io.gpio.*;

/**
 * Created by maobaolong on 2016/12/7.
 * 散热风扇控制方法
 */
public class FanCtrlUtils {


    private static final GpioController gpio = GpioFactory.getInstance();
    private static GpioPinDigitalOutput gpio_00 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "" , PinState.LOW);

    /**
    * 打开散热风扇
    * */
    public static void open(){
        gpio_00.high();
    }
    /**
    * 关闭散热风扇
    * */
    public static void close(){
        gpio_00.low();
    }
}
