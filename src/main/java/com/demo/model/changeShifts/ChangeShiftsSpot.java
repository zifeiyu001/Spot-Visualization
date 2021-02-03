package com.demo.model.changeShifts;
/*
* @Param total总数
* @Param checked 已检
* @Param unchecked 未检
* @Param alarm 报警
* @Param normal 正常
* */

public class ChangeShiftsSpot {
    private String  devName;
    private  String  sc_part;
    private  String sc_content;
    private String result;
    private int altpid;

    private int total;
    private int normal;
    private int alarm;
    private int checked;
    private int unchecked;

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getSc_part() {
        return sc_part;
    }

    public void setSc_part(String sc_part) {
        this.sc_part = sc_part;
    }

    public String getSc_content() {
        return sc_content;
    }

    public void setSc_content(String sc_content) {
        this.sc_content = sc_content;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getAltpid() {
        return altpid;
    }

    public void setAltpid(int altpid) {
        this.altpid = altpid;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

    public int getAlarm() {
        return alarm;
    }

    public void setAlarm(int alarm) {
        this.alarm = alarm;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public int getUnchecked() {
        return unchecked;
    }

    public void setUnchecked(int unchecked) {
        this.unchecked = unchecked;
    }

}
