package com.xywy.drug.data.gson;

/**
 * Created by eWalk_iOS on 14-8-15.
 */
public class MedicineSimple {
    private String nameDrug;
    private String uuidDrug;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUuidDrug() {
        return uuidDrug;
    }

    public void setUuidDrug(String uuidDrug) {
        this.uuidDrug = uuidDrug;
    }

    public String getNameDrug() {
        return nameDrug;
    }

    public void setNameDrug(String nameDrug) {
        this.nameDrug = nameDrug;
    }

    private String price;
}
