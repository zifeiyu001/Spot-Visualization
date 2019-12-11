package com.demo.model.process.grindingFloat;

/**

 */
public class MF1DefectStatistics {
    private Integer id;
    private String workshop;
    private String name;
    private String value;
    private String Level;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    private String  num;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name  = name;
    }

    public String getValue() { return value; }

    public void setValue(String value) { this.value = value; }


    public String getLevel() { return Level; }

    public void setLevel(String level) { Level = level; }
}
