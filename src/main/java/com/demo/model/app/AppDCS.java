package com.demo.model.app;

/**

 */
public class AppDCS {

    private  String DataTime;
    private  String variable;
    private  double DocValue;
   private  String description;
   private String unit;

   private  String alarm_code;  // 报警状态
   private Double Limit_H;   //上限
    private Double Limit_HH;// 上上限
    private Double Limit_L;//下限
    private Double Limit_LL;//下下限
    private Integer Alarm_Mode;  // 报警模式



    public String getDataTime() {
        return DataTime;
    }

    public void setDataTime(String dataTime) {
        DataTime = dataTime;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getDocValue() {
        return DocValue;
    }

    public void setDocValue(double docValue) {
        DocValue = docValue;
    }

    public String getAlarm_code() {
        return alarm_code;
    }

    public void setAlarm_code(String alarm_code) {
        this.alarm_code = alarm_code;
    }


    public Double getLimit_H() {
        return Limit_H;
    }

    public void setLimit_H(Double limit_H) {
        Limit_H = limit_H;
    }

    public Double getLimit_HH() {
        return Limit_HH;
    }

    public void setLimit_HH(Double limit_HH) {
        Limit_HH = limit_HH;
    }

    public Double getLimit_L() {
        return Limit_L;
    }

    public void setLimit_L(Double limit_L) {
        Limit_L = limit_L;
    }

    public Double getLimit_LL() {
        return Limit_LL;
    }

    public void setLimit_LL(Double limit_LL) {
        Limit_LL = limit_LL;
    }

    public Integer getAlarm_Mode() {
        return Alarm_Mode;
    }

    public void setAlarm_Mode(Integer alarm_Mode) {
        Alarm_Mode = alarm_Mode;
    }
}
