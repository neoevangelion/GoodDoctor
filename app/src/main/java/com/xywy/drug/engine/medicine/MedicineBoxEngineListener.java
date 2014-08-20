package com.xywy.drug.engine.medicine;

import com.xywy.drug.data.gson.MedicineBox;

import java.util.List;

/**
 * Created by eWalk_iOS on 14-8-20.
 */
public interface MedicineBoxEngineListener {
    public void handleRemoteMedicineBoxResult(boolean result, List<MedicineBox> data);
}
