package net.rpi.common;

import net.rpi.entity.SystemInfoEntity;

import java.lang.management.ManagementFactory;

/**
 * Created by maobaolong on 2016/12/7.
 * 获取系统信息
 */
public class SystemInfoUtils {
    private static final String TEMP_FILE_PATH = "/sys/class/thermal/thermal_zone0/temp";
    private static SystemInfoEntity DEFAULT = new SystemInfoEntity();
    /**
     * 获取温度
     * */
    public static int getTemperature(){
        String content = FileUtils.readLine(TEMP_FILE_PATH);
        return Integer.parseInt(content);
    }

    public static int getPid(){
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String pid = name.split("@")[0];
        return Integer.valueOf(pid);
    }
    public static SystemInfoEntity getDefault(){
        return DEFAULT;
    }
    public static void refresh(){
        DEFAULT.setTemperature(getTemperature());
        DEFAULT.setPid(getPid());
    }
}
