package com.alyenc.cnaps.service;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.alyenc.cnaps.bean.BankBean;
import com.alyenc.cnaps.bean.BranchBankBean;
import com.alyenc.cnaps.bean.CityBean;
import com.alyenc.cnaps.bean.ProvinceBean;
import com.alyenc.cnaps.utils.UDID;

/**
 * 将数据持久化到数据库或者生成文件
 * Created by chenxiushen on 2017/1/11.
 */
public interface PersistentData {

	public void saveBankInfo(List<BankBean> params);
	
	public void saveProvinceInfo(List<ProvinceBean> params);
	
	public void saveCityInfo(List<CityBean> params);
	
	public void saveBranchBankInfo(List<BranchBankBean> params);
}
