package com.school.book;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.school.book.bean.UserFeedbackBean;
import com.school.book.bll.UserFeedbackBll;

/**
 * 用户反馈管理
 */
@Controller
@RequestMapping("feedback")
public class UserFeedbackController {
	private UserFeedbackBll userFeedbackBll;
	/**
	 * 增加反馈
	 */
	@RequestMapping("user/add")
	@ResponseBody
	public void add(UserFeedbackBean userFeedbackBean) {
		userFeedbackBll.insertFeedback(userFeedbackBean);
	}
	/**
	 * 查看反馈
	 */
	@RequestMapping("admin/selcet")
	@ResponseBody
	public void selcet(Model model) {
		List<UserFeedbackBean> feedbackList = userFeedbackBll.selectFeedback();
		model.addAttribute("feedbackList", feedbackList);
	}
}
