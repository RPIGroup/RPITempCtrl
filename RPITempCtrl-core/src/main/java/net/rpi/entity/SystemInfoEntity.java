package net.rpi.entity;

/**
 * Created by maobaolong on 2016/12/6.
 */
public class SystemInfoEntity {
    /*温度*/
    private int temperature ;
    private int pid;
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
