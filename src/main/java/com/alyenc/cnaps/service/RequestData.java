package com.alyenc.cnaps.service;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alyenc.cnaps.bean.BankBean;
import com.alyenc.cnaps.bean.CityBean;
import com.alyenc.cnaps.bean.ProvinceBean;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.sun.xml.internal.ws.util.StringUtils;

/**
 * 请求数据 Created by chenxiushen on 2017/1/11.
 */
public class RequestData {
	private static List<BankBean> bankList = new ArrayList<BankBean>();
	private static List<ProvinceBean> provinceList = new ArrayList<ProvinceBean>();
	private static List<CityBean> cityList = new ArrayList<CityBean>();
	
	public static JSONObject reuqestUrls(String url , Map<String,String> params) throws MalformedURLException, IOException {
		InputStream inputStream = new URL(url).openStream(); 
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
		StringBuilder response = new StringBuilder();
		String str = null;
        while ((str = bufferedReader.readLine()) != null) {
	    	response.append(str);
	    }
	    System.out.println(response);
	    JSONObject json = JSONObject.parseObject(response.toString());
	    return json;
	}

	private static void readAllBanks(){
		String url = "http://www.zybank.com.cn/zyb/queryallbank.do";
		Map<String,String> params = new HashMap<String,String>();
		try {
			JSONObject bankJson = reuqestUrls(url , params);
			JSONArray bankArray = (JSONArray) bankJson.get("bankSiteList");
			for(Object item : bankArray){
				JSONObject itemObj = (JSONObject) item;
				String bankCode = ((Integer) itemObj.get("bankId")).toString();
				String bankName = (String) itemObj.get("bankName");
				BankBean bankBean = new BankBean();
				bankBean.setBankCode(bankCode);
				bankBean.setBankName(bankName);
				bankList.add(bankBean);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(bankList);
	}

	private static void readAllProvince() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		String url = "http://www.zybank.com.cn/zyb/queryprovince.do";
		Map<String,String> params = new HashMap<String,String>();
		JSONObject provinceJson = reuqestUrls(url , params);
	}

	private static void readAllCity() {
		
	    
	}
	
	private static void readAllBeanchBank() {
		
	    
	}

	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		readAllBanks();
	}

}
