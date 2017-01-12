package com.alyenc.cnaps.bean;

public class ProvinceBean {

	private String provinceCode;
	private String provinceName;
	
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
	@Override
	public String toString() {
		return "ProvinceBean [provinceCode=" + provinceCode + ", provinceName=" + provinceName + "]";
	}
	
}

