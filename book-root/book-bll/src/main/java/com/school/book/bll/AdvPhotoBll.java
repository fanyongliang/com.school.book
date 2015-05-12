package com.school.book.bll;

import java.util.List;

import com.school.book.bean.AdvPhotoBean;
import com.school.book.dao.AdvPhotoDAO;


/**
 * 首页滚动广告管理类
 */
public class AdvPhotoBll {
	AdvPhotoDAO advPhotoDAO = new AdvPhotoDAO();
	/**
	 * 查询所有广告信息
	 * 
	 * @param
	 * @return
	 */
	public List<AdvPhotoBean> selectAllAdvPhoto() {
		return advPhotoDAO.selectAllAdvPhoto();
	}
	
	/**
	 * 修改广告
	 * 
	 * @param
	 * @return
	 */
	public void updateAdvPhoto(AdvPhotoBean advPhotoBean) {
		advPhotoDAO.updateAdvPhoto(advPhotoBean);
	}
	
	/**
	 * 新增广告
	 * @param advPhotoBean
	 */
	public void addAdvPhoto(AdvPhotoBean advPhotoBean) {
		advPhotoDAO.addAdvPhoto(advPhotoBean);
	}
	/**
	 * 删除广告
	 * @param advPhotoBean
	 */
	public void deleteAdvPhoto(Integer code) {
		advPhotoDAO.deleteAdvPhoto(code);
	}
}
