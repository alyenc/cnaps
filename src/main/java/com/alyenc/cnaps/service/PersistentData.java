package com.alyenc.cnaps.service;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.alyenc.cnaps.bean.BankBean;
import com.alyenc.cnaps.utils.UDID;

/**
 * 将数据持久化到数据库或者生成文件
 * Created by chenxiushen on 2017/1/11.
 */
public class PersistentData extends JdbcDaoSupport{

	public void saveBankInfo(List<BankBean> params){
		for(BankBean items : params){
			this.getJdbcTemplate().update("INSERT INTO bank VALUES (?,?,?)",   
	                new Object[]{UDID.getUDID(),items.getBankCode(),items.getBankName()}); 
		}  
	}
}
