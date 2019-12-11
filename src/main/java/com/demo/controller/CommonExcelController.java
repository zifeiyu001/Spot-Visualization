//package com.demo.controller;
//
//import com.demo.model.process.grindingFloat.*;
//import com.demo.service.IndexService;
//import org.apache.poi.hssf.usermodel.*;
//import org.apache.poi.ss.formula.functions.T;
//import org.apache.poi.ss.usermodel.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.net.URLEncoder;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//@Controller
//public class CommonExcelController {
//    @Autowired
//    private IndexService indexService;
//    @GetMapping("/spot/download/mf")
//    public void excelConfig(HttpServletResponse response , HttpServletRequest request) throws IOException {
//        //新建画布
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        //获取当前时间
//        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
//        String time = df.format(new Date());// new Date()为获取当前系统时间
//        //获取发送的类型
//        String type = request.getParameter("type");
//        //获取发送的参数
//        String data = request.getParameter("data");
//        String[] headers = data.split(",");
//        String title = request.getParameter("title");
//        String process = request.getParameter("process");
//        String period = request.getParameter("period");
//        //sheet名称
//        HSSFSheet sheet = workbook.createSheet(process);
//        //设置要导出的文件的名字
//        String fileName = process+title + time + ".xls";
//        String userAgent = request.getHeader("user-agent").toLowerCase();
//        //解决下载文件名乱码的问题
//        if (userAgent.contains("msie") || userAgent.contains("like gecko")) {
//            // win10 ie edge 浏览器 和其他系统的ie
//            fileName = URLEncoder.encode(fileName, "UTF-8");
//        } else {
//            fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
//        }
//
//        /*表头的样式*/
//        HSSFCellStyle hcs = workbook.createCellStyle();
//        //水平居中
//        hcs.setAlignment(HorizontalAlignment.CENTER);
//        //垂直居中
//        hcs.setVerticalAlignment(VerticalAlignment.CENTER);
//        //设置背景色
//        hcs.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
//        hcs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        /*表格内容样式*/
//        HSSFCellStyle hcsI = workbook.createCellStyle();
//        //水平居中
//        hcsI.setAlignment(HorizontalAlignment.CENTER);
//        //垂直居中
//        hcsI.setVerticalAlignment(VerticalAlignment.CENTER);
//        //设置换行
//        hcsI.setWrapText(true);
//
//        //headers表示excel表中第一行的表头
//        HSSFRow row = sheet.createRow(0);
//        //在excel表中添加表头
//        for (int i = 0; i < headers.length; i++) {
//            HSSFCell cell = row.createCell(i);
//            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
//            if (i == 0) {
//                sheet.setColumnWidth(i, 20 * 200);
//            } else {
//                sheet.setColumnWidth(i, 20 * 200);
//            }
//            cell.setCellStyle(hcs);
//            cell.setCellValue(text);
//        }
//
//        //新增数据行，并且设置单元格数据
//        int rowNum = 1;
//        //磨浮生产
//        if(type.equals("mf-sc")) {
//            List<MF2Production> mf2Productions = indexService.MF_2_PRODUCTION_LIST(period);
//            //在表中存放查询到的数据放入对应的列
//            for (MF2Production p : mf2Productions) {  //行
//                HSSFRow row1 = sheet.createRow(rowNum);
//                for (int i = 0; i< data.length(); i++) {//列
//                    HSSFCell cells = row1.createCell(i);
//                    switch (i) {
//                        case 0:
//                            if (null != p.getEquip()) {
//                                cells.setCellValue(p.getEquip());
//                            } else {
//                                cells.setCellValue("");
//                            }
//                            break;
//                        case 1:
//                            if (null != p.getRunTime()) {
//                                cells.setCellValue(p.getRunTime());
//                            } else {
//                                cells.setCellValue("");
//                            }
//                            break;
//                    }
//                    cells.setCellStyle(hcsI);
//                }
//                rowNum++;
//            }
//        }
//        //磨浮消耗
//        if(type.equals("mf-xh")) {
//            List<MF2Consumption> mf2Consumptions = indexService.MF_2_CONSUMPTION_LIST(period);
//            //在表中存放查询到的数据放入对应的列
//            for (MF2Consumption p : mf2Consumptions) {  //行
//                HSSFRow row1 = sheet.createRow(rowNum);
//                for (int i = 0; i< data.length(); i++) {//列
//                    HSSFCell cells = row1.createCell(i);
//                    switch (i) {
//                        case 0:
//                            if (null != p.getCategory()) {
//                                cells.setCellValue(p.getCategory());
//                            } else {
//                                cells.setCellValue("");
//                            }
//                            break;
//                        case 1:
//                            if (null != p.getValue()) {
//                                cells.setCellValue(p.getValue());
//                            } else {
//                                cells.setCellValue("");
//                            }
//                            break;
//                    }
//                    cells.setCellStyle(hcsI);
//                }
//                rowNum++;
//            }
//        }
//        //点巡检日、周、月统计报表
//        if(type.equals("spot-period")) {
//            List<MF3Spot> mf3Spots = indexService.MF_3_SPOT_LIST(period);
//            //在表中存放查询到的数据放入对应的列
//            for (MF3Spot p : mf3Spots) {  //行
//                HSSFRow row1 = sheet.createRow(rowNum);
//                for (int i = 0; i< data.length(); i++) {//列
//                    HSSFCell cells = row1.createCell(i);
//                    switch (i) {
//                        case 0:
//                            if (null != p.getEquip()) {
//                                cells.setCellValue(p.getEquip());
//                            } else {
//                                cells.setCellValue("");
//                            }
//                            break;
//                        case 1:
//                            if (null != p.getFini()) {
//                                cells.setCellValue(p.getFini());
//                            } else {
//                                cells.setCellValue("");
//                            }
//                            break;
//                        case 2:
//                            if (null != p.getUndone()) {
//                                cells.setCellValue(p.getUndone());
//                            } else {
//                                cells.setCellValue("");
//                            }
//                            break;
//                        case 3:
//                            if (null != p.getAlarm()) {
//                                cells.setCellValue(p.getAlarm());
//                            } else {
//                                cells.setCellValue("");
//                            }
//                            break;
//                        case 4:
//                            if (null != p.getDanger()) {
//                                cells.setCellValue(p.getDanger());
//                            } else {
//                                cells.setCellValue("");
//                            }
//                            break;
//                    }
//                    cells.setCellStyle(hcsI);
//                }
//                rowNum++;
//            }
//        }
//        //点巡检报警日、周、月统计报表
//        if(type.equals("spot-alarm")) {
//            List<MF3Repeat> mf3Repeats = indexService.MF_3_REPEAT_LIST(period);
//            //在表中存放查询到的数据放入对应的列
//            for (MF3Repeat p : mf3Repeats) {  //行
//                HSSFRow row1 = sheet.createRow(rowNum);
//                for (int i = 0; i< data.length(); i++) {//列
//                    HSSFCell cells = row1.createCell(i);
//                    switch (i) {
//                        case 0:
//                            if (null != p.getEquip()) {
//                                cells.setCellValue(p.getEquip());
//                            } else {
//                                cells.setCellValue("");
//                            }
//                            break;
//                        case 1:
//                            if (null != p.getTotal()) {
//                                cells.setCellValue(p.getTotal());
//                            } else {
//                                cells.setCellValue("");
//                            }
//                            break;
//                        case 2:
//                            if (null != p.getRepeatTime()) {
//                                cells.setCellValue(p.getRepeatTime());
//                            } else {
//                                cells.setCellValue("");
//                            }
//                            break;
//                    }
//                    cells.setCellStyle(hcsI);
//                }
//                rowNum++;
//            }
//        }
//        //点巡检重要设备日、周、月统计报表
//        if(type.equals("spot-important")) {
//            List<MF3Spot> mf3Important = indexService.MF_3_IMPORTANT_LIST(period);
//            //在表中存放查询到的数据放入对应的列
//            for (MF3Spot p : mf3Important) {  //行
//                HSSFRow row1 = sheet.createRow(rowNum);
//                for (int i = 0; i< data.length(); i++) {//列
//                    HSSFCell cells = row1.createCell(i);
//                    switch (i) {
//                        case 0:
//                            if (null != p.getEquip()) {
//                                cells.setCellValue(p.getEquip());
//                            } else {
//                                cells.setCellValue("");
//                            }
//                            break;
//                        case 1:
//                            if (null != p.getFini()) {
//                                cells.setCellValue(p.getFini());
//                            } else {
//                                cells.setCellValue("");
//                            }
//                            break;
//                        case 2:
//                            if (null != p.getUndone()) {
//                                cells.setCellValue(p.getUndone());
//                            } else {
//                                cells.setCellValue("");
//                            }
//                            break;
//                        case 3:
//                            if (null != p.getAlarm()) {
//                                cells.setCellValue(p.getAlarm());
//                            } else {
//                                cells.setCellValue("");
//                            }
//                            break;
//                        case 4:
//                            if (null != p.getDanger()) {
//                                cells.setCellValue(p.getDanger());
//                            } else {
//                                cells.setCellValue("");
//                            }
//                            break;
//                    }
//                    cells.setCellStyle(hcsI);
//                }
//                rowNum++;
//            }
//        }
//        response.setContentType("application/octet-stream");
//        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
//        response.flushBuffer();
//        workbook.write(response.getOutputStream());
//    }
//
//}