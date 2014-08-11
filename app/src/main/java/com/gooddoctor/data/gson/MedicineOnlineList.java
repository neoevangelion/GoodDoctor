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
public class MedicineOnlineList {
    private int mPages;
    private List<Medicine> mMedicines;

    public MedicineOnlineList() {
        mMedicines = new ArrayList<Medicine>();
    }

    public int getPages() {
        return mPages;
    }

    public void setPages(int mPages) {
        this.mPages = mPages;
    }

    public List<Medicine> getMedicines() {
        return mMedicines;
    }

    public void setMedicines(List<Medicine> mMedicines) {
        this.mMedicines = mMedicines;
    }

    public static MedicineOnlineList fromJson(JSONObject json) {
        try {
            MedicineOnlineList list = new MedicineOnlineList();

            list.mPages = json.getInt(ProtocolConst.MEDICINE_PAGES);
            JSONArray array = json.getJSONArray(ProtocolConst.MEDICINE_LIST);
            for (int i = 0; i < array.length(); ++i) {
                try {
                    JSONObject medicineObj = array.getJSONObject(i);

                    Medicine medicine = new Medicine();
                    medicine.setName(medicineObj.getString(ProtocolConst.MEDICINE_DRUG_NAME));
                    medicine.setCommonName(medicineObj.getString(ProtocolConst.MEDICINE_COMMON_NAME));
                    medicine.setMedicineId(medicineObj.getString(ProtocolConst.MEDICINE_ID));
                    medicine.setEfficacy(medicineObj.getString(ProtocolConst.MEDICINE_EFFICACY));
                    medicine.setImageUrl(medicineObj.getString(ProtocolConst.MEDICINE_IMAGE_URL));
                    medicine.setCompanyName(medicineObj.getString(ProtocolConst.MEDICINE_COMPANY_NAME));
                    medicine.setPrice(medicineObj.getString(ProtocolConst.MEDICINE_PRICE));
                    medicine.setType(medicineObj.getInt(ProtocolConst.MEDICINE_TYPE));
                    medicine.setAttribute(medicineObj.getInt(ProtocolConst.MEDICINE_ATTRIBUTE));

                    list.mMedicines.add(medicine);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
