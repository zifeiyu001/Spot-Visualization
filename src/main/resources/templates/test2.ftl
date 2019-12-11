<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh" lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk" />
    <title>SyntaxHighlighter Build Test Page</title>
    <script type="text/javascript" src="/plugins/shCore.js"></script>
    <!-- 下面 pre 中 brush 是 java，这里就要导入 shBrushJava 的 js 文件 -->
    <!-- scripts 目录下还有很多的 shBrushXxxx.js 文件 -->
    <#--<script type="text/javascript" src="scripts/shBrushJava.js"></script>-->
    <script type="text/javascript" src="/plugins/jQuery/jquery-3.2.1.js"></script>
    <link type="text/css" rel="stylesheet" href="/plugins/_template.css"/>
    <link type="text/css" rel="stylesheet" href="/plugins/SyntaxHighlighter.css"/>
    <!-- 这里使用 eclipse 外观，styles 目录下还有很多的外观 -->
    <#--<link type="text/css" rel="stylesheet" href="styles/shThemeEclipse.css"/>-->
    <script type="text/javascript">
        SyntaxHighlighter.config.clipboardSwf = 'scripts/clipboard.swf';
        SyntaxHighlighter.all();
    </script>
</head>

<style type="text/css">
    /** 改一下字号大小，否则格式化后的代码会很大 */
    .syntaxhighlighter div { font-size:12px !important; }
</style>

<body >
<p>代码高亮测试</p>

<pre class="brush: java;">
//    将工段数据变为json格式
    @RequestMapping(value = "/pc/getDeptToJson", method = RequestMethod.GET)
    @ResponseBody
    public   List<TreeCode>  gettestUser() {
        List<TreeCode> dept_test_list = indexService.get_dept_test_list();
        return  getChild("parentid",dept_test_list);
    }
    private List<TreeCode> getChild(String id,List<TreeCode> rootTree) {
        ArrayList<TreeCode> childList = new ArrayList<>();
        for (TreeCode node:rootTree){
            if(id.equals(node.getPid())){
                childList.add(node);
            }
        }
        for(TreeCode tree:childList){
            tree.setNodes(getChild(tree.getCid(),rootTree));
        }
        if(childList ==null || childList.isEmpty()){
            return  null;
        }
        return childList;
    }

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

</pre>
</html>