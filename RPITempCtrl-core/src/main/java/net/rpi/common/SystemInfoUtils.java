package net.rpi.common;

import net.rpi.entity.SystemInfoEntity;

/**
 * Created by maobaolong on 2016/12/7.
 * 获取系统信息
 */
public class SystemInfoUtils {
    private static SystemInfoEntity DEFAULT = new SystemInfoEntity();
    /**
     * 获取温度
     * */
    public static int getTemperature(){
        String content = FileUtils.readFile("/sys/class/thermal/thermal_zone0/temp");
        return Integer.parseInt(content);
    }

    public static SystemInfoEntity getDefault(){
        return DEFAULT;
    }
    public void refresh(){
        DEFAULT.setTemperature(getTemperature());
    }
}
