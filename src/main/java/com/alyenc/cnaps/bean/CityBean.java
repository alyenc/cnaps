package com.alyenc.cnaps.bean;

public class CityBean {

	private String cityCode;
	private String cityName;
	private String provinceCode;
	
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	@Override
	public String toString() {
		return "CityBean [cityCode=" + cityCode + ", cityName=" + cityName + ", provinceCode=" + provinceCode + "]";
	}
	
}

