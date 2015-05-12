package com.school.book;

/*------------------------------------------------------------------------- 
 * 作者：
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 管理员主页
 -------------------------------------------------------------------------*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminIndexController {
	/**
	 * 创建logger控制台日志显示对象
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(AdminIndexController.class);

	/**
	 * 管理员主页
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public String index(Model model) {
		logger.info("欢迎进入管理员主页！");
		return "admin/welcome";
	}

}
