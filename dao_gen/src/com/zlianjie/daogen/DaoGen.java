package com.zlianjie.daogen;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.DaoGenerator;

/**
 * Created by eWalk_iOS on 14-8-8.
 */
public class DaoGen {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.xywy.drug.data.dao");

        Entity boxedMedicine = schema.addEntity("DBBoxedMedicine");
        boxedMedicine.addIdProperty().autoincrement();
        boxedMedicine.addStringProperty("medicineId");
        boxedMedicine.addStringProperty("medicineName");
        boxedMedicine.addStringProperty("companyName");

        Entity medicineBox = schema.addEntity("DBMedicineBox");
        medicineBox.addIdProperty().autoincrement();
        medicineBox.addStringProperty("name");
        medicineBox.addStringProperty("medicineIds");
        medicineBox.addStringProperty("syncId");
        medicineBox.addStringProperty("owner");

        Entity notification = schema.addEntity("DBNotification");
        notification.addIdProperty().autoincrement();
        notification.addStringProperty("medicineId");
        notification.addStringProperty("medicineName");
        notification.addIntProperty("duration");
        notification.addIntProperty("repeatPerDay");
        notification.addStringProperty("timePoints");
        notification.addStringProperty("syncId");
        notification.addStringProperty("owner");
        notification.addBooleanProperty("notificationEnabled");

        Entity searchHistory = schema.addEntity("DBSearchHistory");
        searchHistory.addIdProperty().autoincrement();
        searchHistory.addStringProperty("keyword");
        searchHistory.addIntProperty("searchType");
        searchHistory.addStringProperty("owner");
        searchHistory.addStringProperty("syncId");



        new DaoGenerator().generateAll(schema, "../app/src/main/java/");

    }
}
