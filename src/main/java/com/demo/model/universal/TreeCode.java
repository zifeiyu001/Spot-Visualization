package com.demo.model.universal;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class TreeCode {

    private  String text;
    private String pid;
    private  String cid;
    private List nodes = new ArrayList();




    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public List getNodes() {
        return nodes;
    }

    public void setNodes(List nodes) {
        this.nodes = nodes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
