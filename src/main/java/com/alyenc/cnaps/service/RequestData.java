package com.alyenc.cnaps.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.alyenc.cnaps.bean.BankBean;
import com.alyenc.cnaps.bean.BranchBankBean;
import com.alyenc.cnaps.bean.CityBean;
import com.alyenc.cnaps.bean.ProvinceBean;


/**
 * 请求数据 Created by chenxiushen on 2017/1/11.
 */
public interface RequestData {

	public JSONObject reuqestUrls(String url , Map<String,String> params) throws MalformedURLException, IOException;
	
	public List<BankBean> readAllBanks();

	public List<ProvinceBean> readAllProvince();

	public List<CityBean> readAllCity(String pProvinceCode);
	
	public List<BranchBankBean> readBranchBank(String pBankCode, String pCityCode);

	/**
	 * 请求全量数据，并保存到数据库
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 * @author alyenc@outlook.com
	 *	       2017年2月8日 下午4:09:19
	 */
	public void doRequestAll() throws IOException, InterruptedException ;
	
}
