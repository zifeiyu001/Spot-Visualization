package com.demo.model.equip;

/**

 */
public class SpotStatistics {

    private String equip;
    private String section;
    private  Integer checked;
    private  Integer unchecked;
    private  Integer alarm;
    private  Integer danger;
    private  Integer plan;
    private  Integer reality;
    private Integer complete;
    private Integer normal;
    private Integer incomplete;


    public Integer getComplete() {
        return complete;
    }

    public void setComplete(Integer complete) {
        this.complete = complete;
    }

    public Integer getNormal() {
        return normal;
    }

    public void setNormal(Integer normal) {
        this.normal = normal;
    }

    public Integer getIncomplete() {
        return incomplete;
    }

    public void setIncomplete(Integer incomplete) {
        this.incomplete = incomplete;
    }




    public Integer getPlan() {
        return plan;
    }

    public void setPlan(Integer plan) {
        this.plan = plan;
    }

    public Integer getReality() {
        return reality;
    }

    public void setReality(Integer reality) {
        this.reality = reality;
    }

    public String getEquip() { return equip; }

    public void setEquip(String equip) { this.equip = equip; }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Integer getAlarm() {
        return alarm;
    }

    public void setAlarm(Integer alarm) {
        this.alarm = alarm;
    }

    public Integer getDanger() {
        return danger;
    }

    public void setDanger(Integer danger) {
        this.danger = danger;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public Integer getUnchecked() {
        return unchecked;
    }

    public void setUnchecked(Integer unchecked) {
        this.unchecked = unchecked;
    }
}
