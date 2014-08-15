package com.gooddoctor.data.gson;

import java.util.List;

/**
 * Created by eWalk_iOS on 14-8-15.
 */
public class MedicineDetail {
    private String attribute;
    private String type;
    private String image;
    private String image_m;
    private String image_b;
    private String nameDrug;
    private String approvedsymbol;
    private String nameCommon;
    private String nameCompany;
    private String specification;
    private String efficacy;
    private String useage;
    private String taboo;
    private String reaction;
    private String attentions;
    private String woman;
    private String oldman;
    private String children;
    private String druginteration;
    private String expertremand;
    private List<MedicineSimple> elselist;

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_m() {
        return image_m;
    }

    public void setImage_m(String image_m) {
        this.image_m = image_m;
    }

    public String getImage_b() {
        return image_b;
    }

    public void setImage_b(String image_b) {
        this.image_b = image_b;
    }

    public String getNameDrug() {
        return nameDrug;
    }

    public void setNameDrug(String nameDrug) {
        this.nameDrug = nameDrug;
    }

    public String getApprovedsymbol() {
        return approvedsymbol;
    }

    public void setApprovedsymbol(String approvedsymbol) {
        this.approvedsymbol = approvedsymbol;
    }

    public String getNameCommon() {
        return nameCommon;
    }

    public void setNameCommon(String nameCommon) {
        this.nameCommon = nameCommon;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getEfficacy() {
        return efficacy;
    }

    public void setEfficacy(String efficacy) {
        this.efficacy = efficacy;
    }

    public String getUseage() {
        return useage;
    }

    public void setUseage(String useage) {
        this.useage = useage;
    }

    public String getTaboo() {
        return taboo;
    }

    public void setTaboo(String taboo) {
        this.taboo = taboo;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public String getAttentions() {
        return attentions;
    }

    public void setAttentions(String attentions) {
        this.attentions = attentions;
    }

    public String getWoman() {
        return woman;
    }

    public void setWoman(String woman) {
        this.woman = woman;
    }

    public String getOldman() {
        return oldman;
    }

    public void setOldman(String oldman) {
        this.oldman = oldman;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getDruginteration() {
        return druginteration;
    }

    public void setDruginteration(String druginteration) {
        this.druginteration = druginteration;
    }

    public String getExpertremand() {
        return expertremand;
    }

    public void setExpertremand(String expertremand) {
        this.expertremand = expertremand;
    }

    public List<MedicineSimple> getElselist() {
        return elselist;
    }

    public void setElselist(List<MedicineSimple> elselist) {
        this.elselist = elselist;
    }
}
