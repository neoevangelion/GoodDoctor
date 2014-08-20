package com.xywy.drug.engine.medicine;

import com.xywy.drug.data.dao.DBMedicineBox;
import com.xywy.drug.data.gson.Medicine;
import com.xywy.drug.data.gson.MedicineBox;

import java.util.ArrayList;
import java.util.List;

public class MedicineBoxMapping {
    public static DBMedicineBox fromRemote(MedicineBox remote) {
        DBMedicineBox local = new DBMedicineBox();
        return local;
    }

    public static MedicineBox fromLocal(DBMedicineBox local) {
        MedicineBox remote = new MedicineBox();
        return remote;
    }

    public static List<DBMedicineBox> fromRemote(List<MedicineBox> remote) {
        List<DBMedicineBox> list = new ArrayList<DBMedicineBox>();
        return list;
    }

    public static List<MedicineBox> fromLocal(List<DBMedicineBox> local) {
        List<MedicineBox> list = new ArrayList<MedicineBox>();
        return list;
    }
}
