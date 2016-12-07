package net.rpi.task;


import net.rpi.common.FanCtrlUtils;
import net.rpi.common.SystemInfoUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by mbl on 16-12-6.
 */

public class MonitorTask extends Thread{
    private static final Log logger = LogFactory.getLog(MonitorTask.class);
    boolean isCancel = false;

    @Override
    public void run(){
        while(!isCancel){
            int temp = SystemInfoUtils.getTemperature();
            try {
                if(temp>6000){
                    logger.info("Fan open! temp = "+temp);
                    FanCtrlUtils.open();
                }else if(temp <5000){
                    logger.info("Fan close! temp = "+temp);
                    FanCtrlUtils.close();
                }
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
