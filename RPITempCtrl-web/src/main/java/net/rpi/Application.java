package net.rpi;

import net.rpi.common.FileUtils;
import net.rpi.common.SystemInfoUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 程序入口 <br>
 * <p>
 * Copyright: Copyright (c) 2016年8月23日 下午3:46:38
 * <p>
 * Company: 京东
 * <p>
 * 
 * @author wuxiaochun@jd.com
 * @version 1.0.0
 */
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		int pid = SystemInfoUtils.getPid();
		FileUtils.createFile("./pid",String.valueOf(pid));
		SpringApplication.run(Application.class, args);
	}

}
