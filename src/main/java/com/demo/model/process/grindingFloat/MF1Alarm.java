package com.demo.model.process.grindingFloat;

/**

 */
public class MF1Alarm {
    private Integer id;
    private String workshop;
    private String spot;
    private String value;
    private String level;
    private String time;
    private String standard;

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public String getSpot() {
        return spot;
    }

    public void setSpot(String spot) {
        this.spot  = spot;
    }

    public String getValue() { return value; }

    public void setValue(String value) { this.value = value; }


    public String getLevel() { return level; }

    public void setLevel(String level) { this.level = level; }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
