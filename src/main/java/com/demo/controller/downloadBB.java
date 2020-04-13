//package com.demo.controller;
//
//import com.demo.service.IndexService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class downloadBB {
//    // 首页
//    @Autowired
//    private IndexService indexService;
//
//    @RequestMapping(value = "/downloadBB" ,method = RequestMethod.GET)
//    public @ResponseBody
//    String downloadBB(HttpServletRequest request) {
////        logger.info("into JiLiangController downloadBB()");
//        String contextPath = request.getContextPath();
//        //获取session中存储的用户和权值,如果用户名为空,则返回失败
//        HttpSession session = request.getSession();
////        Object userId = session.getAttribute(SysInfo.USER_ID);
//
//        //权限
////        String cj = request.getParameter("cj");
//        //报表种类
//        String treeNames = request.getParameter("treeNames");
//        //日时间
//        String dayTime = request.getParameter("dayTime");
//        //月时间
//        String monthTime = request.getParameter("monthTime");
//        //年时间
//        String yearTime = request.getParameter("yearTime");
//
//        Map<String, Object> menu = indexService.downloadBB(userId, cj, contextPath, treeNames, dayTime, monthTime, yearTime);
//        String jsonString = JSON.toJSONString(menu);
//        logger.info("downloadBB() info==" + jsonString);
//        return jsonString;
//    }
//}