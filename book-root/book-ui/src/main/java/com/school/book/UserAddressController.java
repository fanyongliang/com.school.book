package com.school.book;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.school.book.bean.UserAddressBean;
import com.school.book.bll.UserAddressBll;

/**
 * 用户收货地址管理
 */
@Controller
@RequestMapping("user")
public class UserAddressController {
	private UserAddressBll userAddressBll;
	/**
	 * 更新收货地址
	 */
	@RequestMapping("updateAddress")
	@ResponseBody
	public void updateAddress(UserAddressBean userAddressBean) {
		userAddressBll.updateAddress(userAddressBean);
	}
	/**
	 * 查找收货地址
	 */
	@RequestMapping("selectAddress")
	@ResponseBody
	public void selectAddress(Integer userCode, Model model) {
		List<UserAddressBean> addressList = userAddressBll.getAddress(userCode);
		model.addAttribute("addressList", addressList);
	}
	/**
	 * 删除收货地址
	 */
	@RequestMapping("deleteAddress")
	@ResponseBody
	public void deleteAddress(Integer code) {
		userAddressBll.deleteAddredd(code);
	}
	/**
	 * 增加收货地址
	 */
	@RequestMapping("addAddress")
	@ResponseBody
	public void addAddress(UserAddressBean userAddressBean) {
		userAddressBll.addAddress(userAddressBean); 
	}
}
