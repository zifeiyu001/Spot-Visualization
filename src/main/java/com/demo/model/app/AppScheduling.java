package com.demo.model.app;

import java.util.Date;

/**

 */
public class AppScheduling {

    private Date dTime;
    private String teamName;
    private String teamId;
    private String teamOrder;



    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamOrder() {
        return teamOrder;
    }

    public void setTeamOrder(String teamOrder) {
        this.teamOrder = teamOrder;
    }

    public Date getdTime() {
        return dTime;
    }

    public void setdTime(Date dTime) {
        this.dTime = dTime;
    }
}
