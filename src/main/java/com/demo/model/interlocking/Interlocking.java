package com.demo.model.interlocking;

/**

 */
public class Interlocking {
//结果上传时间
    private  String uploadResultTime;
//多次报警结束时间
    private  String uploadResultTimeEnd;
//    工段
    private String  deptName;
//    线路
    private String routeName;
//    区域
    private String zoneName;
//    设备
    private String  devName;
//    部位
    private String  scPart;
//    内容
    private String scContent;
//    结果
    private String result;
//    点检人
    private String userName;
//    标准值
    private String stdValue;
//    报警级别
    private String altpid;
//    点检备注
    private String remark;
//    点检责任人
    private  String personLiable;
//    任务结束时间
    private String taskEndTime;
//    任务开始时间
    private String taskStartTime;
//    处理责任人
    private  String dealPerson;
//    处理人
    private  String dealUser;
//    处理人
    private  String dealDate;
//    处理备注
    private  String  deal_remark;
//    报警处理标签
    private String alarmFlag;
//报警类别
    private  String abnormalHandleType;
//    点检结果id
    private  String resultId;
//    报警类型修改人
    private  String abnormalHandleUser;
//    报警类别（管理人员填写）
    private  String abnormalHandleAdminType;
//    处理工段
    private  String abnormalHandleDealDepart;
//    班组
    private  String team;
//    报警次数
    private  String alarm_times;
//    报警ID
    private  String alarmId;
//    合并后对应报警ID
    private  String pid;
//    是否为报警清单
    private  String monthly_alarm_list;
//    是否合并
    private  String alarm_merge;

//    是否延期
    private  String alarm_deal_delay;
//    延期备注
    private  String alarm_deal_delay_remark;

    public String getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(String alarmId) {
        this.alarmId = alarmId;
    }


    public String getDealData() {
        return dealData;
    }

    public void setDealData(String dealData) {
        this.dealData = dealData;
    }

    //    是否处理
    private  String dealData;
//    权限
    private  String permission;


    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }



    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getScPart() {
        return scPart;
    }

    public void setScPart(String scPart) {
        this.scPart = scPart;
    }

    public String getScContent() {
        return scContent;
    }

    public void setScContent(String scContent) {
        this.scContent = scContent;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getUploadResultTime() {
        return uploadResultTime;
    }

    public void setUploadResultTime(String uploadResultTime) {
        this.uploadResultTime = uploadResultTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStdValue() {
        return stdValue;
    }

    public void setStdValue(String stdValue) {
        this.stdValue = stdValue;
    }

    public String getAltpid() {
        return altpid;
    }

    public void setAltpid(String altpid) {
        this.altpid = altpid;
    }

    public String getAlarmFlag() {
        return alarmFlag;
    }

    public void setAlarmFlag(String alarmFlag) {
        this.alarmFlag = alarmFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPersonLiable() {
        return personLiable;
    }

    public void setPersonLiable(String personLiable) {
        this.personLiable = personLiable;
    }

    public String getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(String taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    public String getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(String taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public String getDealPerson() {
        return dealPerson;
    }

    public void setDealPerson(String dealPerson) {
        this.dealPerson = dealPerson;
    }

    public String getDealUser() {
        return dealUser;
    }

    public void setDealUser(String dealUser) {
        this.dealUser = dealUser;
    }

    public String getDeal_remark() {
        return deal_remark;
    }

    public void setDeal_remark(String deal_remark) {
        this.deal_remark = deal_remark;
    }

    public String getAbnormalHandleType() {
        return abnormalHandleType;
    }

    public void setAbnormalHandleType(String abnormalHandleType) {
        this.abnormalHandleType = abnormalHandleType;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getAbnormalHandleUser() {
        return abnormalHandleUser;
    }

    public void setAbnormalHandleUser(String abnormalHandleUser) {
        this.abnormalHandleUser = abnormalHandleUser;
    }

    public String getAbnormalHandleAdminType() {
        return abnormalHandleAdminType;
    }

    public void setAbnormalHandleAdminType(String abnormalHandleAdminType) {
        this.abnormalHandleAdminType = abnormalHandleAdminType;
    }

    public String getAbnormalHandleDealDepart() {
        return abnormalHandleDealDepart;
    }

    public void setAbnormalHandleDealDepart(String abnormalHandleDealDepart) {
        this.abnormalHandleDealDepart = abnormalHandleDealDepart;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getMonthly_alarm_list() {
        return monthly_alarm_list;
    }

    public void setMonthly_alarm_list(String monthly_alarm_list) {
        this.monthly_alarm_list = monthly_alarm_list;
    }

    public String getAlarm_times() {
        return alarm_times;
    }

    public void setAlarm_times(String alarm_times) {
        this.alarm_times = alarm_times;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getAlarm_merge() {
        return alarm_merge;
    }

    public void setAlarm_merge(String alarm_merge) {
        this.alarm_merge = alarm_merge;
    }

    public String getAlarm_deal_delay() {
        return alarm_deal_delay;
    }

    public void setAlarm_deal_delay(String alarm_deal_delay) {
        this.alarm_deal_delay = alarm_deal_delay;
    }

    public String getAlarm_deal_delay_remark() {
        return alarm_deal_delay_remark;
    }

    public void setAlarm_deal_delay_remark(String alarm_deal_delay_remark) {
        this.alarm_deal_delay_remark = alarm_deal_delay_remark;
    }

    public String getUploadResultTimeEnd() {
        return uploadResultTimeEnd;
    }

    public void setUploadResultTimeEnd(String uploadResultTimeEnd) {
        this.uploadResultTimeEnd = uploadResultTimeEnd;
    }

    public String getDealDate() {
        return dealDate;
    }

    public void setDealDate(String dealDate) {
        this.dealDate = dealDate;
    }
}
