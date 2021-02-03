package com.demo.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/app/login1")
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("======");
//        int code = 200;
//
//        String streamIn = inputStreamToString(new BufferedInputStream(request.getInputStream()));
//        System.out.println(streamIn);
//        JSONObject object = JSONObject.fromObject(streamIn);
//        object.put("userJSON",streamIn );
//        JSONObject userInfo = JSONObject.fromObject(object.getString("userJSON"));
//        String name=userInfo.getString("name");
//        String password=userInfo.getString("password");
//        String phone=userInfo.getString("phone");
//        System.out.println(name+"  "+password+"     "+phone);
//        response.setContentType("text/html;charset=utf-8"); // 设置响应报文的编码格式
//
//      PrintWriter out = response.getWriter();
//      out.write("成功");
//		out.close();
        PrintWriter out = response.getWriter();
//        String json=JSON.toJSONString(code);
//        out.println(json);
        out.flush();
        out.close();
    }
    public String inputStreamToString(InputStream inputStream) throws IOException {
        int len = 0;
        byte[] butter = new byte[1024];
        StringBuffer stringBuffer = new StringBuffer();
        while ((len = inputStream.read(butter)) != -1) {
            String s = new String(butter, 0, len, "UTF-8");
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }
}

