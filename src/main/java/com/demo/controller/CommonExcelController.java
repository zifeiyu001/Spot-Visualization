package com.demo.controller;

import com.demo.model.interlocking.Interlocking;
import com.demo.model.process.grindingFloat.*;
import com.demo.model.universal.ConfigUser;
import com.demo.model.universal.CurrentDate;
import com.demo.service.IndexService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommonExcelController {
    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/downloadBB123")
    @ResponseBody
    public void excelConfig(HttpServletResponse response, HttpServletRequest request) throws IOException {

        //新建画布
        HSSFWorkbook workbook = new HSSFWorkbook();

        //获取当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMM");//设置日期格式
        String time = df.format(new Date());// new Date()为获取当前系统时间
//        获取参数
        String data = request.getParameter("data");
        String[] headers = data.split(",");
        String title = request.getParameter("title");
        String date = CurrentDate.getDate();
        if (title.equals("test")){
            title="选矿厂"+date+"检修计划安排表";
        }else {
            title=title+date+"检修计划安排表";
        }
        String deptName = request.getParameter("title");
//        sheet名称
        HSSFSheet sheet = workbook.createSheet(title);
        //设置要导出的文件的名字
        String fileName = title + ".xls";
        String userAgent = request.getHeader("user-agent").toLowerCase();
        //解决下载文件名乱码的问题
        if (userAgent.contains("msie") || userAgent.contains("like gecko")) {
            // win10 ie edge 浏览器 和其他系统的ie
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } else {
            fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
        }
//        HSSFCellStyle cellStyle = workbook.createCellStyle();

        /*一表头的样式*/
        HSSFCellStyle hcs2 = workbook.createCellStyle();
        //水平居中
        hcs2.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        hcs2.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置背景色
        hcs2.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        hcs2.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        hcs2.setBorderRight( BorderStyle.THIN);
        hcs2.setBorderLeft( BorderStyle.THIN);
        hcs2.setBorderBottom( BorderStyle.THIN);
        hcs2.setBorderTop( BorderStyle.THIN);

        /*二表头的样式*/
        HSSFCellStyle hcs = workbook.createCellStyle();
        //水平居中
        hcs.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        hcs.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置背景色
        hcs.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        hcs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        hcs.setBorderRight( BorderStyle.THIN);
        hcs.setBorderLeft( BorderStyle.THIN);
        hcs.setBorderBottom( BorderStyle.THIN);
        hcs.setBorderTop( BorderStyle.THIN);

        /*表格内容样式*/
        HSSFCellStyle hcsI = workbook.createCellStyle();
        //水平居中
        hcsI.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        hcsI.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置换行
        hcsI.setWrapText(true);
        hcsI.setBorderRight( BorderStyle.THIN);
        hcsI.setBorderLeft( BorderStyle.THIN);
        hcsI.setBorderBottom( BorderStyle.THIN);
        hcsI.setBorderTop( BorderStyle.THIN);


   /*     //excel表中第一行的表头*/
        HSSFRow row0 = sheet.createRow(0);
        HSSFCell cell1 = row0.createCell(0);
        cell1.setCellStyle(hcs2);
        cell1.setCellValue(title);

        HSSFFont font1 = workbook.createFont();
        font1.setFontHeightInPoints((short) 16); // 字体高度
        font1.setFontName("宋体"); // 字体
        HSSFFont font2 = workbook.createFont();
        font2.setFontHeightInPoints((short) 13); // 字体高度
        font2.setFontName("宋体"); // 字体
        HSSFFont font3 = workbook.createFont();
        font3.setFontHeightInPoints((short) 12); // 字体高度
        font3.setFontName("宋体"); // 字体

        HSSFRichTextString ts= new HSSFRichTextString(title);
        ts.applyFont(0,ts.length(),font1);
        cell1.setCellValue(ts);

        /*  excel表中第二行的表头*/
        HSSFRow row = sheet.createRow(1);
        //在excel表中添加表头
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            if (i == 1) {
                sheet.setColumnWidth(i, 20 * 150);
            } else {
                sheet.setColumnWidth(i, 20 * 250);
            }
            text.applyFont(0,text.length(),font2);
            cell.setCellStyle(hcs);
            cell.setCellValue(text);

        }

   /*     //新增数据行，并且设置单元格数据*/
        int rowNum = 2;
        List<Interlocking> Interlockings = indexService.getbcMonthlyAlarmListData(deptName);
            int num=1;
            for (Interlocking p : Interlockings) {  //行
                HSSFRow row1 = sheet.createRow(rowNum);
                for (int i = 0; i< headers.length; i++) {//列
                    HSSFCell cells = row1.createCell(i);
                    switch (i) {
                        case 1:

                            if (null != p.getDeptName()) {
                                cells.setCellValue(num);
                            } else {
                                cells.setCellValue("");
                            }
                            break;
                        case 0:

                            if (null != p.getDeptName()) {

                                cells.setCellValue(getDeptName(p.getDeptName()));
                            } else {
                                cells.setCellValue("");
                            }
                            break;
                        case 2:
                            if (null != p.getDevName()) {
                                cells.setCellValue(p.getDevName());
                            } else {
                                cells.setCellValue("");
                            }
                            break;
                        case 3:
                            if (null != p.getScPart()) {
                                cells.setCellValue(p.getScPart()+""+p.getScContent()+"(结果："+p.getResult()+"；备注："+p.getRemark()+";标准值："+p.getStdValue()+")");
                            } else {
                                cells.setCellValue("");
                            }
                            break;
                        case 7:
                            if (null != p.getDeptName()) {
                                cells.setCellValue(getManUser(p.getDeptName()));
                            } else {
                                cells.setCellValue("");
                            }
                            break;
                        case 8:
                            if (null != p.getScContent()) {
                                cells.setCellValue(p.getDealPerson());
                            } else {
                                cells.setCellValue("");
                            }
                            break;

                    }
                    cells.setCellStyle(hcsI);
                }
                rowNum++;
                num++;
            }


        CellRangeAddress region = new CellRangeAddress(0, 0, 0, 9);
        sheet.addMergedRegion(region);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());

    }
//    修改工段名称
    private String getDeptName(String dept){
        String depart="";
        switch (dept){
            case "碎矿生产" : depart="碎矿工段";break;
            case "碎矿设备" : depart="碎矿工段";break;
            case "磨浮生产" : depart="磨浮工段";break;
            case "磨浮设备" : depart="磨浮工段";break;
            case "精尾生产" : depart="精尾工段";break;
            case "精尾设备" : depart="精尾工段";break;
            case "电仪工段" : depart="电仪工段";break;
            default: depart=dept;
        }
        return depart;
    }
//获取工段管理人员
    private String getManUser(String dept){
        List<ConfigUser> configUsers = indexService.search_config_alarm_manage_exist();
        String user = "";
        for (int a=0;a<configUsers.size();a++){
            if (configUsers.get(a).getDeptName().indexOf(dept)!=-1){
                user=configUsers.get(a).getUser();
            }
        }
        return  user;
    }


}