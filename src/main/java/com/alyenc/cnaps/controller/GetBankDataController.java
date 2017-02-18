package com.alyenc.cnaps.controller;

import com.alibaba.fastjson.JSON;
import com.alyenc.cnaps.bean.BankBean;
import com.alyenc.cnaps.bean.ProvinceBean;
import com.alyenc.cnaps.service.RequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 页面Controller
 * Package : com.alyenc.cnaps.controller
 * 
 * @author alyenc@outlook.com
 *		   2017年2月8日 下午4:21:09
 *
 */
@Controller
public class GetBankDataController {

	@Autowired
	private RequestData requestData;
	
	/**
	 * 页面获取银行列表
	 * 
	 * @return 
	 * @author alyenc@outlook.com
	 *	       2017年2月8日 下午4:23:08
	 */
	@RequestMapping(value="/getBanks",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getBankList(){
		List<BankBean> banks = requestData.readAllBanks();
		String json = JSON.toJSONString(banks);
		return json;
		
	}
	
	/**
	 * 页面获取省份列表
	 * 
	 * @return 
	 * @author alyenc@outlook.com
	 *	       2017年2月8日 下午4:23:38
	 */
	@RequestMapping(value="/getProvinces")
	public String getProvinceList(){
		List<ProvinceBean> banks = requestData.readAllProvince();
		String json = JSON.toJSONString(banks);
		return json;
	}
	
	/**
	 * 页面获取城市列表
	 * 
	 * @return 
	 * @author alyenc@outlook.com
	 *	       2017年2月8日 下午4:24:01
	 */
	@RequestMapping(value="/getCitys")
	public String getCityList(){
		return null;
		
	}
	
	/**
	 * 页面获取支行信息列表
	 * 
	 * @return 
	 * @author alyenc@outlook.com
	 *	       2017年2月8日 下午4:24:22
	 */
	@RequestMapping(value="/getBranchBanks")
	public String getBranchBankList(){
		return null;
		
	}
}

