package com.alyenc.cnaps.controller;

import com.alibaba.fastjson.JSON;
import com.alyenc.cnaps.bean.BankBean;
import com.alyenc.cnaps.bean.BranchBankBean;
import com.alyenc.cnaps.bean.CityBean;
import com.alyenc.cnaps.bean.ProvinceBean;
import com.alyenc.cnaps.service.RequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@RequestMapping(value="/getBanks")
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
	@ResponseBody
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
	@ResponseBody
	public String getCityList(@RequestParam("provinceCode") String provinceCode){
		System.out.println(provinceCode);
		List<CityBean> city = requestData.readAllCity(provinceCode);
		String json = JSON.toJSONString(city);
		System.out.println(json);
		return json;
	}
	
	/**
	 * 页面获取支行信息列表
	 * 
	 * @return 
	 * @author alyenc@outlook.com
	 *	       2017年2月8日 下午4:24:22
	 */
	@RequestMapping(value="/getBranchBanks")
	@ResponseBody
	public String getBranchBankList(@RequestParam("bankCode") String bankCode,
			@RequestParam("cityCode") String cityCode){
		System.out.println(cityCode);
		List<BranchBankBean> branchBank = requestData.readBranchBank(bankCode, cityCode);
		String json = JSON.toJSONString(branchBank);
//		Map<String,Object> result = new HashMap<String,Object>();
//		result.put("current", 1);
//		result.put("rowCount", branchBank.size());
//		result.put("rows", json);
//		result.put("total", branchBank.size());
//		System.out.println(JSON.toJSONString(result));
		System.out.println(json);
		return json;
	}
}