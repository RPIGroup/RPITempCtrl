package net.rpi.controller;

import net.rpi.common.SystemInfoUtils;
import net.rpi.entity.SystemInfoEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wuxiaochun on 2016/12/30.
 */
@Controller
@RequestMapping("/rpitempctrl/app/")
public class WebIoPiController {

    @RequestMapping("/list.jsp")
    public String list(ModelMap map) {
        return "/app/list";
    }



    @ResponseBody
    @RequestMapping("/gpioInfoDetail ajax")
    public String gpioInfoDetail(ModelMap map) {
        String json = "{\"I2C\": 0, \"GPIO\": {\"0\": {\"value\": 1, \"function\": \"IN\"}, \"1\": {\"value\": 1, \"function\": \"IN\"}, \"2\": {\"value\": 1, \"function\": \"IN\"}, \"3\": {\"value\": 1, \"function\": \"IN\"}, \"4\": {\"value\": 1, \"function\": \"IN\"}, \"5\": {\"value\": 1, \"function\": \"IN\"}, \"6\": {\"value\": 1, \"function\": \"IN\"}, \"7\": {\"value\": 1, \"function\": \"IN\"}, \"8\": {\"value\": 1, \"function\": \"IN\"}, \"9\": {\"value\": 0, \"function\": \"IN\"}, \"10\": {\"value\": 1, \"function\": \"IN\"}, \"11\": {\"value\": 0, \"function\": \"IN\"}, \"12\": {\"value\": 0, \"function\": \"IN\"}, \"13\": {\"value\": 0, \"function\": \"IN\"}, \"14\": {\"value\": 1, \"function\": \"IN\"}, \"15\": {\"value\": 1, \"function\": \"IN\"}, \"16\": {\"value\": 0, \"function\": \"OUT\"}, \"17\": {\"value\": 0, \"function\": \"IN\"}, \"18\": {\"value\": 1, \"function\": \"IN\"}, \"19\": {\"value\": 0, \"function\": \"IN\"}, \"20\": {\"value\": 0, \"function\": \"IN\"}, \"21\": {\"value\": 0, \"function\": \"IN\"}, \"22\": {\"value\": 0, \"function\": \"IN\"}, \"23\": {\"value\": 1, \"function\": \"IN\"}, \"24\": {\"value\": 0, \"function\": \"IN\"}, \"25\": {\"value\": 0, \"function\": \"IN\"}, \"26\": {\"value\": 0, \"function\": \"IN\"}, \"27\": {\"value\": 0, \"function\": \"IN\"}, \"28\": {\"value\": 0, \"function\": \"IN\"}, \"29\": {\"value\": 1, \"function\": \"IN\"}, \"30\": {\"value\": 0, \"function\": \"IN\"}, \"31\": {\"value\": 0, \"function\": \"IN\"}, \"32\": {\"value\": 1, \"function\": \"ALT3\"}, \"33\": {\"value\": 1, \"function\": \"ALT3\"}, \"34\": {\"value\": 0, \"function\": \"ALT3\"}, \"35\": {\"value\": 1, \"function\": \"ALT3\"}, \"36\": {\"value\": 1, \"function\": \"ALT3\"}, \"37\": {\"value\": 1, \"function\": \"ALT3\"}, \"38\": {\"value\": 1, \"function\": \"ALT3\"}, \"39\": {\"value\": 1, \"function\": \"ALT3\"}, \"40\": {\"value\": 0, \"function\": \"ALT0\"}, \"41\": {\"value\": 1, \"function\": \"ALT0\"}, \"42\": {\"value\": 1, \"function\": \"ALT0\"}, \"43\": {\"value\": 0, \"function\": \"ALT0\"}, \"44\": {\"value\": 1, \"function\": \"IN\"}, \"45\": {\"value\": 1, \"function\": \"IN\"}, \"46\": {\"value\": 1, \"function\": \"ALT0\"}, \"47\": {\"value\": 1, \"function\": \"ALT0\"}, \"48\": {\"value\": 0, \"function\": \"ALT0\"}, \"49\": {\"value\": 1, \"function\": \"ALT0\"}, \"50\": {\"value\": 1, \"function\": \"ALT0\"}, \"51\": {\"value\": 1, \"function\": \"ALT0\"}, \"52\": {\"value\": 1, \"function\": \"ALT0\"}, \"53\": {\"value\": 1, \"function\": \"ALT0\"}}, \"UART\": 1, \"ONEWIRE\": 0, \"SPI\": 0}";
        return json;
    }

    @ResponseBody
    @RequestMapping("/gpioInfo.ajax")
    public String gpioInfo(ModelMap map) {
        String json = "[\"V33\", \"V50\", 2, \"V50\", 3, \"GND\", 4, 14, \"GND\", 15, 17, 18, 27, \"GND\", 22, 23, \"V33\", 24, 10, \"GND\", 9, 25, 11, 8, \"GND\", 7, \"DNC\", \"DNC\", 5, \"GND\", 6, 12, 13, \"GND\", 19, 16, 26, 20, \"GND\", 21]";
        return json;
    }
    @ResponseBody
    @RequestMapping("/version.ajax")
    public String version(ModelMap map) {
        String json = "WebIOPi/0.7.1/Python3.4";
        return json;
    }

    @ResponseBody
    @RequestMapping("/GPIO/{gpio}/function/{inout}")
    public String gpio(ModelMap map, @PathVariable("gpio") String gpio,@PathVariable("inout") String inout) {
        String json="OUT";
        if(StringUtils.equals(inout,"OUT")){
            json = "IN";
        }
        return json;
    }

}
