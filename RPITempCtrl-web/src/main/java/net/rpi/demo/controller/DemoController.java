package net.rpi.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class DemoController {

	@RequestMapping("/hello")
	@ResponseBody
	public String index() {
		return "Hello World";
	}

	@RequestMapping("/index")
	public String index(ModelMap map) {
		return "index";
	}

}
