package com.gooddoctor.data.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table DBDISEASE.
 */
public class DBDisease {

    private Long id;
    private String diseaseId;
    private String name;
    private String pinyin;
    private Integer productNum;

    public DBDisease() {
    }

    public DBDisease(Long id) {
        this.id = id;
    }

    public DBDisease(Long id, String diseaseId, String name, String pinyin, Integer productNum) {
        this.id = id;
        this.diseaseId = diseaseId;
        this.name = name;
        this.pinyin = pinyin;
        this.productNum = productNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(String diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

}