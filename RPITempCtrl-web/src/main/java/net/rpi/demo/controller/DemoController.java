package net.rpi.demo.controller;

import net.rpi.entity.SystemInfoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录 <br>
 * <p>
 * Copyright: Copyright (c) 2016年8月23日 下午3:48:53
 * <p>
 * Company: 京东
 * <p>
 * 
 * @author wuxiaochun@jd.com
 * @version 1.0.0
 */
@Controller
@RequestMapping("/")
public class DemoController {

	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}
//txt html  htm
	@RequestMapping("/index.html")
	public String index(ModelMap map) {
//		SystemInfoUtils.refresh();
		SystemInfoEntity systemInfoEntity = new SystemInfoEntity();//SystemInfoUtils.getDefault();
		systemInfoEntity.setTemperature(4512);
		map.put("systemInfoEntity",systemInfoEntity);
		return "index";
	}

}
