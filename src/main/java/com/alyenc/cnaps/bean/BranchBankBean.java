package com.alyenc.cnaps.bean;

public class BranchBankBean {

    private String cityCode;
    private String branchBankCode;
    private String branchBankName;
    private String branchBankAddress;
    private String branchBankTelephone;
    private String bankCode;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getBranchBankCode() {
        return branchBankCode;
    }

    public void setBranchBankCode(String branchBankCode) {
        this.branchBankCode = branchBankCode;
    }

    public String getBranchBankName() {
        return branchBankName;
    }

    public void setBranchBankName(String branchBankName) {
        this.branchBankName = branchBankName;
    }

    public String getBranchBankAddress() {
        return branchBankAddress;
    }

    public void setBranchBankAddress(String branchBankAddress) {
        this.branchBankAddress = branchBankAddress;
    }

    public String getBranchBankTelephone() {
        return branchBankTelephone;
    }

    public void setBranchBankTelephone(String branchBankTelephone) {
        this.branchBankTelephone = branchBankTelephone;
    }

    @Override
    public String toString() {
        return "BranchBankBean{" +
                "cityCode='" + cityCode + '\'' +
                ", branchBankCode='" + branchBankCode + '\'' +
                ", branchBankName='" + branchBankName + '\'' +
                ", branchBankAddress='" + branchBankAddress + '\'' +
                ", branchBankTelephone='" + branchBankTelephone + '\'' +
                '}';
    }
}

