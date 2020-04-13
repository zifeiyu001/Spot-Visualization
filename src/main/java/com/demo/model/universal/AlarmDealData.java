package com.demo.model.universal;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;

/**

 */
public class AlarmDealData {

    private  String result_id; //点检id
    private  String dev_code; //设备编码
    private  String service_start_date; //维修开始时间
    private  String service_end_date; //维修结束时间
    private  double service_hours; //维修小时数
    private  String dev_name; //设备名称
    private  String dev_model; //规格型号
    private  String dev_dept; //工段
    private  String dev_category ;//设备类别
    private  String service_unit_type ; //维修单位类型
    private  String service_unit; //维修单位
    private  String alarm_type; //报警类型
    private  String alarm_name; //点检人
    private  String alarm_time; //点检时间
    private  String alarm_content; //报警内容
    private  String service_name; //维修人员
    private  String service_content;//维修内容
    private  String service_alarm_name ;//处理人
    private  String service_alarm_time ; //处理时间
    private  String service_spare_parts; //备件
    private  String service_remarks;//备注
    private  String service_id;   //维修单ID
    private  String service_acceptor; //验收人

    private  String dev_part; //设备部位
    private  String dev_content; //设备内容
    private  String dev_result; //设备结果
    private  String dev_remark; //设备备注
    private  String dev_depart; //设备部门（原始）



    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }


    public String getResult_id() {
        return result_id;
    }

    public void setResult_id(String result_id) {
        this.result_id = result_id;
    }

    public String getDev_code() {
        return dev_code;
    }

    public void setDev_code(String dev_code) {
        this.dev_code = dev_code;
    }

    public double getService_hours() {
        return service_hours;
    }

    public void setService_hours(double service_hours) {
        this.service_hours = service_hours;
    }

    public String getDev_name() {
        return dev_name;
    }

    public void setDev_name(String dev_name) {
        this.dev_name = dev_name;
    }

    public String getDev_model() {
        return dev_model;
    }

    public void setDev_model(String dev_model) {
        this.dev_model = dev_model;
    }

    public String getDev_dept() {
        return dev_dept;
    }

    public void setDev_dept(String dev_dept) {
        this.dev_dept = dev_dept;
    }

    public String getDev_category() {
        return dev_category;
    }

    public void setDev_category(String dev_category) {
        this.dev_category = dev_category;
    }



    public String getService_unit() {
        return service_unit;
    }

    public void setService_unit(String service_unit) {
        this.service_unit = service_unit;
    }



    public String getAlarm_name() {
        return alarm_name;
    }

    public void setAlarm_name(String alarm_name) {
        this.alarm_name = alarm_name;
    }

    public String getAlarm_time() {
        return alarm_time;
    }

    public void setAlarm_time(String alarm_time) {
        this.alarm_time = alarm_time;
    }

    public String getAlarm_content() {
        return alarm_content;
    }

    public void setAlarm_content(String alarm_content) {
        this.alarm_content = alarm_content;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_content() {
        return service_content;
    }

    public void setService_content(String service_content) {
        this.service_content = service_content;
    }

    public String getService_alarm_name() {
        return service_alarm_name;
    }

    public void setService_alarm_name(String service_alarm_name) {
        this.service_alarm_name = service_alarm_name;
    }

    public String getService_alarm_time() {
        return service_alarm_time;
    }

    public void setService_alarm_time(String service_alarm_time) {
        this.service_alarm_time = service_alarm_time;
    }

    public String getService_spare_parts() {
        return service_spare_parts;
    }

    public void setService_spare_parts(String service_spare_parts) {
        this.service_spare_parts = service_spare_parts;
    }

    public String getService_remarks() {
        return service_remarks;
    }

    public void setService_remarks(String service_remarks) {
        this.service_remarks = service_remarks;
    }

    public String getService_unit_type() {
        return service_unit_type;
    }

    public void setService_unit_type(String service_unit_type) {
        this.service_unit_type = service_unit_type;
    }

    public String getAlarm_type() {
        return alarm_type;
    }

    public void setAlarm_type(String alarm_type) {
        this.alarm_type = alarm_type;
    }

    public String getService_start_date() {
        return service_start_date;
    }

    public void setService_start_date(String service_start_date) {
        this.service_start_date = service_start_date;
    }

    public String getService_end_date() {
        return service_end_date;
    }

    public void setService_end_date(String service_end_date) {
        this.service_end_date = service_end_date;
    }

    public String getService_acceptor() {
        return service_acceptor;
    }

    public void setService_acceptor(String service_acceptor) {
        this.service_acceptor = service_acceptor;
    }

    public String getDev_part() {
        return dev_part;
    }

    public void setDev_part(String dev_part) {
        this.dev_part = dev_part;
    }

    public String getDev_content() {
        return dev_content;
    }

    public void setDev_content(String dev_content) {
        this.dev_content = dev_content;
    }

    public String getDev_result() {
        return dev_result;
    }

    public void setDev_result(String dev_result) {
        this.dev_result = dev_result;
    }

    public String getDev_remark() {
        return dev_remark;
    }

    public void setDev_remark(String dev_remark) {
        this.dev_remark = dev_remark;
    }

    public String getDev_depart() {
        return dev_depart;
    }

    public void setDev_depart(String dev_depart) {
        this.dev_depart = dev_depart;
    }
}
