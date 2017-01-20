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
public class PersistentData extends JdbcDaoSupport{

	public void saveBankInfo(List<BankBean> params){
		for(BankBean items : params){
			this.getJdbcTemplate().update("REPLACE INTO bank VALUES (?,?,?)",   
	                new Object[]{UDID.getUDID(),items.getBankCode(),items.getBankName()}); 
		}  
	}
	
	public void saveProvinceInfo(List<ProvinceBean> params){
		for(ProvinceBean items : params){
			this.getJdbcTemplate().update("REPLACE INTO province VALUES (?,?,?)",   
	                new Object[]{UDID.getUDID(),items.getProvinceCode(),items.getProvinceName()}); 
		}  
	}
	
	public void saveCityInfo(List<CityBean> params){
		for(CityBean items : params){
			this.getJdbcTemplate().update("REPLACE INTO city VALUES (?,?,?,?)",   
	                new Object[]{UDID.getUDID(),items.getCityCode(),items.getCityName(),items.getProvinceCode()}); 
		}  
	}
	
	public void saveBranchBankInfo(List<BranchBankBean> params){
		for(BranchBankBean items : params){
			this.getJdbcTemplate().update("REPLACE INTO branchbank VALUES (?,?,?,?,?,?,?)",   
	                new Object[]{UDID.getUDID(),items.getBranchBankCode(),
	                		items.getBranchBankName(),items.getBankCode(),
	                		items.getCityCode(),items.getBranchBankTelephone(),
	                		items.getBranchBankAddress()}); 
		}  
	}
}
