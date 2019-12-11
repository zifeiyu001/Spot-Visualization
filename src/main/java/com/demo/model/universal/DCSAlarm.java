package com.demo.model.universal;

import com.demo.model.app.AppDCS;

import java.util.List;

public class DCSAlarm {
    public static List<AppDCS> getAlarm(List<AppDCS> param){
        for (int a=0;a<param.size();a++){
            Double limit_h =  param.get(a).getLimit_H();
            Double limit_hh = param.get(a).getLimit_HH();
            Double limit_l = param.get(a).getLimit_L();
            Double limit_ll = param.get(a).getLimit_LL();
            Double docValue = param.get(a).getDocValue();  // 数据
            AppDCS appDCS = param.get(a);
            Integer alarm_mode = appDCS.getAlarm_Mode(); // 返回报警类型  1：超上限报警  2：超下限报警  3：区间外报警  4：区间内报警
            String alarm_status="0";
//           报警模式不为空时，通过模式数值分类判断
            if (alarm_mode!=null) {
 //            报警模式为超上限报警
                if (alarm_mode == 1) {
                    if (limit_h !=null&& limit_hh !=null){ // 都不为空
                        if (docValue > limit_h) {
                            alarm_status="1";
                            if (docValue > limit_hh) { alarm_status="2"; }
                        } else if (docValue > limit_hh) { alarm_status="2";
                        } else { alarm_status="0"; }
                    }
                    else if (limit_h !=null && limit_hh ==null){ // 上上限 为空
                        if (docValue>limit_h){ alarm_status="1";
                        }else { alarm_status="0"; }
                    }
                    else if (limit_h==null&&limit_hh !=null){    // 上限 为空
                        if (docValue>limit_hh){ alarm_status="2";
                        }else { alarm_status="0"; }
                    }
                    else { alarm_status="0"; }

                }
//            报警模式为超下限报警
                else if (alarm_mode == 2) {
                    if (limit_l !=null&& limit_ll !=null){   // 都不为空
                        if (docValue < limit_l) {
                            alarm_status="1";
                            if (docValue < limit_ll) {
                                alarm_status="2";
                            }
                        } else if (docValue < limit_ll) {
                            alarm_status="2";
                        } else {
                            alarm_status="0";
                        }
                    }
                    else if (limit_l !=null && limit_ll ==null){ // 下下限为空
                        if (docValue<limit_l){
                            alarm_status="1";
                        }else {
                            alarm_status="0";
                        }
                    }
                    else if (limit_l==null&&limit_ll !=null){  // 下限为空
                        if (docValue<limit_ll){
                            alarm_status="2";
                        }else {
                            alarm_status="0";
                        }
                    }
                    else { alarm_status="0"; }

                }
//                区间外报警
                else if (alarm_mode == 3) {
                    if(limit_h !=null && limit_l!=null && limit_hh==null &&limit_ll==null){ //  上上 、下下 限为空
                        if (docValue < limit_l || docValue > limit_h) {
                            alarm_status="1";}
                        else {alarm_status="0";}
                    }
                    else if(limit_h ==null && limit_l==null && limit_hh!=null &&limit_ll!=null){ // 上、下 限为空
                        if (docValue < limit_ll || docValue > limit_hh) {
                            alarm_status="2";}
                        else {alarm_status="0";}
                    }
                    else if(limit_h !=null && limit_l!=null && limit_hh!=null &&limit_ll!=null){ // 都不为空
                        if (docValue < limit_l || docValue > limit_h) {
                            alarm_status="1";
                            if(docValue < limit_ll || docValue > limit_hh){
                                alarm_status="2";
                            }
                        }
                        else if(docValue < limit_ll || docValue > limit_hh){
                            alarm_status="2";
                        } else {alarm_status="0";}
                    }
                    else {alarm_status="0";}//其他情况

                }
//                区间内报警
                else  if (alarm_mode == 4) {
                    if(limit_h !=null & limit_l!=null && limit_hh==null &&limit_ll==null){ //上上 、下下 限为空
                        if (docValue > limit_l && docValue < limit_h) {
                            alarm_status="2";}
                        else {alarm_status="0";}
                    }
                    else if(limit_h ==null & limit_l==null && limit_hh!=null &&limit_ll!=null){ // 上、下限为空
                        if (docValue > limit_ll && docValue < limit_hh) {
                            alarm_status="1";}
                        else {alarm_status="0";}
                    }
                    else if(limit_h !=null & limit_l!=null && limit_hh!=null &&limit_ll!=null){ // 都不为空
                        if (docValue > limit_ll && docValue < limit_hh) {
                            alarm_status="1";
                            if(docValue > limit_l && docValue < limit_h){
                                alarm_status="2";
                            }
                        } else {alarm_status="0";}
                    }
                    else {alarm_status="0";}
                }
//                其他情况
                else {
                    alarm_status="0";
                }
            }
//            报警模式空时，没有设置报警定值
            else{
                appDCS.setAlarm_code("0");
            }
            appDCS.setAlarm_code(alarm_status);
//            System.out.println(alarm_mode+"====="+limit_h+"====="+limit_hh+"===="+limit_l+"===="+limit_ll+"===="+param.get(a).getDocValue()+"===="+appDCS.getAlarm_code());
        }
        return  param;
    }
}
