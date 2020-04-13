package com.demo.controller;

import com.demo.model.interlocking.Interlocking;
import com.demo.model.process.grindingFloat.*;
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

//        sheet名称
        HSSFSheet sheet = workbook.createSheet(title);
        //设置要导出的文件的名字
        String fileName = title+time + ".xls";
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


   /*     //headers表示excel表中第一行的表头*/
        HSSFRow row0 = sheet.createRow(0);
        HSSFCell cell1 = row0.createCell(0);
        cell1.setCellStyle(hcs2);
        cell1.setCellValue(title);
     /*   //headers表示excel表中第二行的表头*/
        HSSFRow row = sheet.createRow(1);
        //在excel表中添加表头
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            if (i == 0) {
                sheet.setColumnWidth(i, 20 * 200);
            } else {
                sheet.setColumnWidth(i, 20 * 200);
            }
            cell.setCellStyle(hcs);
            cell.setCellValue(text);
        }

   /*     //新增数据行，并且设置单元格数据*/
        int rowNum = 2;

        List<Interlocking> Interlockings = indexService.getbcMonthlyAlarmListData("精尾设备");
            for (Interlocking p : Interlockings) {  //行
                HSSFRow row1 = sheet.createRow(rowNum);
                for (int i = 0; i< data.length(); i++) {//列
                    HSSFCell cells = row1.createCell(i);
                    switch (i) {
                        case 0:

                            if (null != p.getDeptName()) {
                                cells.setCellValue(p.getDeptName());
                            } else {
                                cells.setCellValue("");
                            }
                            break;
                        case 1:
                            if (null != p.getDevName()) {
                                cells.setCellValue(p.getDevName());
                            } else {
                                cells.setCellValue("");
                            }
                            break;
                        case 2:
                            if (null != p.getScPart()) {
                                cells.setCellValue(p.getScPart());
                            } else {
                                cells.setCellValue("");
                            }
                            break;
                        case 3:
                            if (null != p.getScContent()) {
                                cells.setCellValue(p.getScContent());
                            } else {
                                cells.setCellValue("");
                            }
                            break;
                        case 4:
                            if (null != p.getUploadResultTime()) {
                                cells.setCellValue(p.getUploadResultTime());
                            } else {
                                cells.setCellValue("");
                            }
                            break;
                        case 5:
                            if (null != p.getAlarm_times()) {
                                cells.setCellValue(p.getAlarm_times());
                            } else {
                                cells.setCellValue("");
                            }
                            break;
                        case 6:
                            if (null != p.getDealPerson()) {
                                cells.setCellValue(p.getDealPerson());
                            } else {
                                cells.setCellValue("");
                            }
                            break;
                    }
                    cells.setCellStyle(hcsI);
                }
                rowNum++;
            }


        CellRangeAddress region = new CellRangeAddress(0, 0, 0, 6);
        sheet.addMergedRegion(region);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());

    }

}