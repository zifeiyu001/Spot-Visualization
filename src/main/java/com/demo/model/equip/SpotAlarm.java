package com.demo.model.equip;

import java.util.Date;

/**

 */
public class SpotAlarm {
    private String standard;
    private String workshop;
    private Date  time;
    private String section;
    private String equip;
    private String spot;
    private String value;
    private String level;
    private  String part;
    private String dateTime;
    private String devName;
    private String content;
    private String result;
    private String id;
    private String name;
    private String flag;
    private String remark;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public String getWorkshop() { return workshop; }

    public void setWorkshop(String workshop) { this.workshop = workshop; }

    public String getPart() { return part; }

    public void setPart(String part) { this.part = part; }

    public String getEquip() { return equip; }

    public void setEquip(String equip) { this.equip = equip; }

    public String getStandard() { return standard; }

    public void setStandard(String standard) { this.standard = standard; }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSpot() {
        return spot;
    }

    public void setSpot(String spot) {
        this.spot = spot;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
