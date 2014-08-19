package com.xywy.drug.data.gson;

import java.util.List;

/**
 * Created by eWalk_iOS on 14-8-8.
 */
public class MedicineList {

    private int pages;
    private List<Medicine> list;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<Medicine> getList() {
        return list;
    }

    public void setList(List<Medicine> list) {
        this.list = list;
    }
}
