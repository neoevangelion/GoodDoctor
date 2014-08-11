package com.tuyuanlin.daogen;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.DaoGenerator;

/**
 * Created by eWalk_iOS on 14-8-8.
 */
public class DaoGen {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.gooddoctor.data.dao");

        Entity disease = schema.addEntity("Disease");
        disease.addIdProperty().autoincrement();
        disease.addStringProperty("diseaseId");
        disease.addStringProperty("name");
        disease.addStringProperty("pinyin");
        disease.addIntProperty("productNum");

        Entity boxedMedicine = schema.addEntity("BoxedMedicine");
        boxedMedicine.addIdProperty().autoincrement();
        boxedMedicine.addStringProperty("medicineId");
        boxedMedicine.addStringProperty("medicineName");
        boxedMedicine.addStringProperty("companyName");

        Entity medicineBox = schema.addEntity("MedicineBox");
        medicineBox.addIdProperty().autoincrement();
        medicineBox.addStringProperty("personName");
        medicineBox.addStringProperty("personImage");
        medicineBox.addIntProperty("personGender");
        medicineBox.addIntProperty("personAge");
        medicineBox.addStringProperty("medicines");

        Entity notification = schema.addEntity("Notification");
        notification.addIdProperty().autoincrement();
        notification.addStringProperty("personName");
        notification.addStringProperty("medicineId");
        notification.addStringProperty("medicineName");
        notification.addDateProperty("startDate");
        notification.addIntProperty("repeatCount");
        notification.addBooleanProperty("notificationEnabled");

        new DaoGenerator().generateAll(schema, "../app/src/main/java/");

    }
}
