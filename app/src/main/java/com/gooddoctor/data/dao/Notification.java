package com.gooddoctor.data.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table NOTIFICATION.
 */
public class Notification {

    private Long id;
    private String personName;
    private String medicineId;
    private String medicineName;
    private java.util.Date startDate;
    private Integer repeatCount;
    private Boolean notificationEnabled;

    public Notification() {
    }

    public Notification(Long id) {
        this.id = id;
    }

    public Notification(Long id, String personName, String medicineId, String medicineName, java.util.Date startDate, Integer repeatCount, Boolean notificationEnabled) {
        this.id = id;
        this.personName = personName;
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.startDate = startDate;
        this.repeatCount = repeatCount;
        this.notificationEnabled = notificationEnabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    public Integer getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(Integer repeatCount) {
        this.repeatCount = repeatCount;
    }

    public Boolean getNotificationEnabled() {
        return notificationEnabled;
    }

    public void setNotificationEnabled(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }

}
