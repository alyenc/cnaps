package com.alyenc.cnaps.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
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
	public void readAllBanks();

	public void readAllProvince();

	public void readAllCity(String pProvinceCode);
	
	public void readBranchBank(String pBankCode, String pCityCode);

	/**
	 * 请求全量数据，并保存到数据库
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 * @author alyenc@outlook.com
	 *	       2017年2月8日 下午4:09:19
	 */
	public static void doRequestAll() throws  IOException, InterruptedException ;
	
}
