package com.gooddoctor.data.gson;

import com.gooddoctor.engine.constant.ProtocolConst;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eWalk_iOS on 14-8-8.
 */
public class MedicineResultData {

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
