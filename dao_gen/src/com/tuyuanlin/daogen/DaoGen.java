package com.tuyuanlin.daogen;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.DaoGenerator;

/**
 * Created by eWalk_iOS on 14-8-8.
 */
public class DaoGen {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.gooddoctor.data");
        Entity disease = schema.addEntity("Disease");

        disease.addIdProperty().autoincrement();
        disease.addStringProperty("diseaseId");
        disease.addStringProperty("name");
        disease.addStringProperty("pinyin");
        disease.addIntProperty("productNum");

        Entity medicine = schema.addEntity("Medicine");

        medicine.addIdProperty().autoincrement();
        medicine.addStringProperty("medicineId");
        medicine.addStringProperty("name");
        medicine.addStringProperty("commonName");
        medicine.addStringProperty("efficacy");
        medicine.addStringProperty("imageUrl");
        medicine.addStringProperty("companyName");
        medicine.addStringProperty("price");
        medicine.addIntProperty("type");
        medicine.addIntProperty("attribute");

        new DaoGenerator().generateAll(schema, "../app/src/main/java/");

    }
}
