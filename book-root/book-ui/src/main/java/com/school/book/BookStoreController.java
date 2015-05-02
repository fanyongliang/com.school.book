package com.school.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school.book.bll.SelectBookBLL;
/**
 * 商城首页控制器
 */
@Controller
@RequestMapping("index")
public class BookStoreController {
	private SelectBookBLL selectBookBLL = new SelectBookBLL();
	
	@RequestMapping("/")
	public String index(Model model) {
		for(int i=0;i<=2;i++){
			model.addAttribute("i", selectBookBLL.getByIs(i));
		}	
		return "index";
	}
}
