package com.alyenc.cnaps.serviceimpl;

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
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alyenc.cnaps.bean.BankBean;
import com.alyenc.cnaps.bean.BranchBankBean;
import com.alyenc.cnaps.bean.CityBean;
import com.alyenc.cnaps.bean.ProvinceBean;
import com.alyenc.cnaps.dao.PersistentDataImpl;
import com.alyenc.cnaps.service.RequestData;

/**
 * 请求数据 Created by chenxiushen on 2017/1/11.
 */
@Service("requestData")
public class RequestDataImpl implements RequestData{
	
	@Autowired
	private static PersistentDataImpl persistentData;
	
	
	public PersistentDataImpl getPersistentData() {
		return persistentData;
	}

	public void setPersistentData(PersistentDataImpl persistentData) {
		this.persistentData = persistentData;
	}

	public JSONObject reuqestUrls(String url , Map<String,String> params) throws MalformedURLException, IOException {
        Set<String> keySet = params.keySet();
        StringBuffer paramsStr = new StringBuffer();
        int i = 0;
        for(String key : keySet){
            i = i + 1;
            String value = params.get(key);
            paramsStr.append(key);
            paramsStr.append("=");
            paramsStr.append(value);
            if(i < keySet.size()){
                paramsStr.append("&");
            }
        }
        
        PrintWriter out = null;
        BufferedReader inputStream = null;
        URL realUrl = new URL(url);
        URLConnection conn = realUrl.openConnection();
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        out = new PrintWriter(conn.getOutputStream());
        out.print(paramsStr);
        out.flush();
        inputStream = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
        StringBuffer response = new StringBuffer();
        String line;
        while ((line = inputStream.readLine()) != null) {
            response.append(line);
        }
        JSONObject json = new JSONObject();
        if(response.toString().substring(0,1).equals("{")){
            json = JSONObject.parseObject(response.toString());
        } else if(response.toString().substring(0,1).equals("[")){
            json.put("result",JSONArray.parseArray(response.toString()));
        }
	    return json;
	}

	public List<BankBean> readAllBanks(){
		List<BankBean> bankList = new ArrayList<BankBean>();
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
		return bankList;
	}

	public List<ProvinceBean> readAllProvince() {
		List<ProvinceBean> provinceList = new ArrayList<ProvinceBean>();
		String url = "http://www.zybank.com.cn/zyb/queryprovince.do";
		Map<String,String> params = new HashMap<String,String>();
		try {
			JSONObject provinceJson = reuqestUrls(url , params);
			JSONArray provinceArray = (JSONArray) provinceJson.get("list");
			for(Object item : provinceArray){
				JSONObject itemObj = (JSONObject) item;
				String provinceCode = ((Integer) itemObj.get("provinceCode")).toString();
				String provinceName = (String) itemObj.get("provinceName");
				ProvinceBean provinceBean = new ProvinceBean();
				provinceBean.setProvinceCode(provinceCode);
				provinceBean.setProvinceName(provinceName);
				provinceList.add(provinceBean);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return provinceList;
	}

	public List<CityBean> readAllCity(String pProvinceCode) {
		List<CityBean> cityList = new ArrayList<CityBean>();
        String url = "http://www.zybank.com.cn/zyb/queryCityByProvinceId";
        Map<String,String> params = new HashMap<String,String>();
        params.put("provinceCode",pProvinceCode);

        try {
            JSONObject cityJson = reuqestUrls(url , params);
            JSONArray cityArray = (JSONArray) cityJson.get("cityList");
            for(Object item : cityArray){
                JSONObject itemObj = (JSONObject) item;
                String cityCode = ((Integer) itemObj.get("cityCode")).toString();
                String cityName = (String) itemObj.get("cityName");
                String provinceCode = ((Integer) itemObj.get("provinceCode")).toString();
                CityBean cityBean = new CityBean();
                cityBean.setCityCode(cityCode);
                cityBean.setCityName(cityName);
                cityBean.setProvinceCode(provinceCode);
                cityList.add(cityBean);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityList;
	}
	
	public List<BranchBankBean> readBranchBank(String pBankCode, String pCityCode) {
		List<BranchBankBean> branchBankList = new ArrayList<BranchBankBean>();
        String url = "http://www.zybank.com.cn/zyb/queryallrtgsnode.do";
        Map<String,String> params = new HashMap<String,String>();
        params.put("cityCode",pCityCode);
        params.put("clsCode",pBankCode);

        try {
            JSONObject branchBankJson = reuqestUrls(url , params);
            JSONArray branchBankArray = (JSONArray) branchBankJson.get("result");
            for(Object item : branchBankArray){
                JSONObject itemObj = (JSONObject) item;
                String branchBankCode = ((Long) itemObj.get("bankCode")).toString();
                String branchBankName = (String) itemObj.get("lName");
                String cityCode = ((Integer) itemObj.get("cityCode")).toString();
                String branchBankAddress= (String) itemObj.get("addr");;
                String branchBankTelephone= (String) itemObj.get("tel");;
                String bankCode = (String) itemObj.get("clsCode");;
                BranchBankBean branchBankBean = new BranchBankBean();
                branchBankBean.setCityCode(cityCode);
                branchBankBean.setBankCode(bankCode);
                branchBankBean.setBranchBankAddress(branchBankAddress);
                branchBankBean.setBranchBankCode(branchBankCode);
                branchBankBean.setBranchBankName(branchBankName);
                branchBankBean.setBranchBankTelephone(branchBankTelephone);
                branchBankList.add(branchBankBean);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return branchBankList;
	}

	/**
	 * 请求全量数据，并保存到数据库
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 * @author alyenc@outlook.com
	 *	       2017年2月8日 下午4:09:19
	 */
	public void doRequestAll() throws  IOException, InterruptedException {
		List<BankBean> bankList = new ArrayList<BankBean>();
		List<ProvinceBean> provinceList = new ArrayList<ProvinceBean>();
		List<CityBean> cityList = new ArrayList<CityBean>();
		List<BranchBankBean> branchBankList = new ArrayList<BranchBankBean>();

		bankList = readAllBanks();    //查询所有的银行列表
		provinceList = readAllProvince();    //查询省份列表
        //根据省份查询城市列表
        if(provinceList.size() != 0){
            for(ProvinceBean item : provinceList){
            	cityList.addAll(readAllCity(item.getProvinceCode()));
                Thread.sleep(10);
            }
        }

        //根据城市和银行查询支行列表
        if(bankList.size() != 0 && cityList.size() != 0){
            for(BankBean bank : bankList){
            	for(CityBean city : cityList){
            		branchBankList.addAll(readBranchBank(bank.getBankCode(), city.getCityCode()));
                	System.out.println(bank.getBankCode() + "," + city.getCityCode());
                    Thread.sleep(100);
                }
            }
        }
        
        //保存数据到数据库
        persistentData.saveBankInfo(bankList);
        persistentData.saveProvinceInfo(provinceList);
        persistentData.saveCityInfo(cityList);
        persistentData.saveBranchBankInfo(branchBankList);
	}
}
