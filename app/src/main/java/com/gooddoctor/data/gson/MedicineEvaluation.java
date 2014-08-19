package com.gooddoctor.data.gson;

import java.util.List;

/**
 * Created by Administrator on 2014/8/16.
 */
public class MedicineEvaluation {
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getPjnum() {
        return pjnum;
    }

    public void setPjnum(int pjnum) {
        this.pjnum = pjnum;
    }

    public List<MedicineEvaluationRate> getRate() {
        return rate;
    }

    public void setRate(List<MedicineEvaluationRate> rate) {
        this.rate = rate;
    }

    public List<MedicineEvaluationCommend> getCommend() {
        return commend;
    }

    public void setCommend(List<MedicineEvaluationCommend> commend) {
        this.commend = commend;
    }

    private int pjnum;
    private List<MedicineEvaluationRate> rate;
    private List<MedicineEvaluationCommend> commend;
}
