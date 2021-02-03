package com.demo.model.changeShifts.jobs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  
 * @Author  guijun
 * @Date 2020-04-26 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="dxj_jjb_sk_sh" )
public class CrushLime implements Serializable {

	private static final long serialVersionUID =  8047177340772524551L;

    @Column(name = "id" )
    private Integer id;
	/**
	 * 班组
	 */
   	@Column(name = "team" )
	private String team;

	/**
	 * 日期
	 */
   	@Column(name = "dete" )
	private String dete;

	/**
	 * 班次
	 */
   	@Column(name = "shift" )
	private String shift;

	/**
	 * 1#料罐接班高度
	 */
   	@Column(name = "pot1SuccessionLevel" )
	private Double pot1successionlevel;

	/**
	 * 1#料罐交班高度
	 */
   	@Column(name = "pot1ShiftLevel" )
	private Double pot1shiftlevel;

	/**
	 * 1#料罐送料车数
	 */
   	@Column(name = "cars1" )
	private Double cars1;

	/**
	 * 2#料罐接班高度
	 */
   	@Column(name = "pot2SuccessionLevel" )
	private Double pot2successionlevel;

	/**
	 * 2#料罐交班高度
	 */
   	@Column(name = "pot2ShiftLevel" )
	private Double pot2shiftlevel;

	/**
	 * 2#料罐送料车数
	 */
   	@Column(name = "cars2" )
	private Double cars2;

	/**
	 * 1#螺旋开机时间1
	 */
   	@Column(name = "feeder1Start1" )
	private String feeder1start1;

	/**
	 * 1#螺旋停机时间1
	 */
   	@Column(name = "feeder1End1" )
	private String feeder1end1;

	/**
	 * 1#螺旋转速（hz）1
	 */
   	@Column(name = "feeder1Speed1" )
	private Double feeder1speed1;

	/**
	 * 1#螺旋给水量（m³）1
	 */
   	@Column(name = "feeder1Water1" )
	private Double feeder1water1;

	/**
	 * 1#螺旋开机时间2
	 */
   	@Column(name = "feeder1Start2" )
	private String feeder1start2;

	/**
	 * 1#螺旋停机时间2
	 */
   	@Column(name = "feeder1End2" )
	private String feeder1end2;

	/**
	 * 1#螺旋转速（hz）2
	 */
   	@Column(name = "feeder1Speed2" )
	private Double feeder1speed2;

	/**
	 * 1#螺旋给水量（m³）2
	 */
   	@Column(name = "feeder1Water2" )
	private Double feeder1water2;

	/**
	 * 1#螺旋开机时间3
	 */
   	@Column(name = "feeder1Start3" )
	private String feeder1start3;

	/**
	 * 1#螺旋停机时间3
	 */
   	@Column(name = "feeder1End3" )
	private String feeder1end3;

	/**
	 * 1#螺旋转速（hz）3
	 */
   	@Column(name = "feeder1Speed3" )
	private Double feeder1speed3;

	/**
	 * 1#螺旋给水量（m³）3
	 */
   	@Column(name = "feeder1Water3" )
	private Double feeder1water3;

	/**
	 * 1#螺旋开机时间4
	 */
   	@Column(name = "feeder1Start4" )
	private String feeder1start4;

	/**
	 * 1#螺旋停机时间4
	 */
   	@Column(name = "feeder1End4" )
	private String feeder1end4;

	/**
	 * 1#螺旋转速（hz）4
	 */
   	@Column(name = "feeder1Speed4" )
	private Double feeder1speed4;

	/**
	 * 1#螺旋给水量（m³）4
	 */
   	@Column(name = "feeder1Water4" )
	private Double feeder1water4;

	/**
	 * 2#螺旋开机时间1
	 */
   	@Column(name = "feeder2Start1" )
	private String feeder2start1;

	/**
	 * 2#螺旋停机时间1
	 */
   	@Column(name = "feeder2End1" )
	private String feeder2end1;

	/**
	 * 2#螺旋转速（hz）1
	 */
   	@Column(name = "feeder2Speed1" )
	private Double feeder2speed1;

	/**
	 * 2#螺旋给水量（m³）1
	 */
   	@Column(name = "feeder2Water1" )
	private Double feeder2water1;

	/**
	 * 2#螺旋开机时间2
	 */
   	@Column(name = "feeder2Start2" )
	private String feeder2start2;

	/**
	 * 2#螺旋停机时间2
	 */
   	@Column(name = "feeder2End2" )
	private String feeder2end2;

	/**
	 * 2#螺旋转速（hz）2
	 */
   	@Column(name = "feeder2Speed2" )
	private Double feeder2speed2;

	/**
	 * 2#螺旋给水量（m³）2
	 */
   	@Column(name = "feeder2Water2" )
	private Double feeder2water2;

	/**
	 * 2#螺旋开机时间3
	 */
   	@Column(name = "feeder2Start3" )
	private String feeder2start3;

	/**
	 * 2#螺旋停机时间3
	 */
   	@Column(name = "feeder2End3" )
	private String feeder2end3;

	/**
	 * 2#螺旋转速（hz）3
	 */
   	@Column(name = "feeder2Speed3" )
	private Double feeder2speed3;

	/**
	 * 2#螺旋给水量（m³）3
	 */
   	@Column(name = "feeder2Water3" )
	private Double feeder2water3;

	/**
	 * 2#螺旋开机时间4
	 */
   	@Column(name = "feeder2Start4" )
	private String feeder2start4;

	/**
	 * 2#螺旋停机时间4
	 */
   	@Column(name = "feeder2End4" )
	private String feeder2end4;

	/**
	 * 2#螺旋转速（hz）4
	 */
   	@Column(name = "feeder2Speed4" )
	private Double feeder2speed4;

	/**
	 * 2#螺旋给水量（m³）4
	 */
   	@Column(name = "feeder2Water4" )
	private Double feeder2water4;

	/**
	 * 送尾矿库时间
	 */
   	@Column(name = "tailingPondTime" )
	private Double tailingpondtime;

	/**
	 * 1#石灰泵运行时间
	 */
   	@Column(name = "limePump1RunTime" )
	private Double limepump1runtime;

	/**
	 * 2#石灰泵运行时间
	 */
   	@Column(name = "limePump2RunTime" )
	private Double limepump2runtime;

	/**
	 * 3#石灰泵运行时间
	 */
   	@Column(name = "limePump3RunTime" )
	private Double limepump3runtime;

	/**
	 * 送污水调节池时间
	 */
   	@Column(name = "sewageRegulationTime" )
	private Double sewageregulationtime;

	/**
	 * 设备润滑点检情况
	 */
   	@Column(name = "equipmentLubrication" )
	private String equipmentlubrication;

	/**
	 * 机台卫生情况
	 */
   	@Column(name = "machineSanitation" )
	private String machinesanitation;

	/**
	 * 检查时间1
	 */
   	@Column(name = "checkTime1" )
	private String checktime1;

	/**
	 * 1#料罐检查结果1
	 */
   	@Column(name = "materialTank1Check1" )
	private String materialtank1check1;

	/**
	 * 2#料罐检查结果1
	 */
   	@Column(name = "materialTank2Check1" )
	private String materialtank2check1;

	/**
	 * 螺旋给料机检查结果1
	 */
   	@Column(name = "screwFeederCheck1" )
	private String screwfeedercheck1;

	/**
	 * 3m搅拌桶检查结果1
	 */
   	@Column(name = "mixingDrum3mCheck1" )
	private String mixingdrum3mcheck1;

	/**
	 * 4m搅拌桶检查结果1
	 */
   	@Column(name = "mixingDrum4mCheck1" )
	private String mixingdrum4mcheck1;

	/**
	 * 渣浆泵检查结果1
	 */
   	@Column(name = "pumpCheck1" )
	private String pumpcheck1;

	/**
	 * 电机检查结果1
	 */
   	@Column(name = "electricMachineryCheck1" )
	private String electricmachinerycheck1;

	/**
	 * 检查时间2
	 */
   	@Column(name = "checkTime2" )
	private String checktime2;

	/**
	 * 1#料罐检查结果2
	 */
   	@Column(name = "materialTank1Check2" )
	private String materialtank1check2;

	/**
	 * 2#料罐检查结果2
	 */
   	@Column(name = "materialTank2Check2" )
	private String materialtank2check2;

	/**
	 * 螺旋给料机检查结果2
	 */
   	@Column(name = "screwFeederCheck2" )
	private String screwfeedercheck2;

	/**
	 * 3m搅拌桶检查结果2
	 */
   	@Column(name = "mixingDrum3mCheck2" )
	private String mixingdrum3mcheck2;

	/**
	 * 4m搅拌桶检查结果2
	 */
   	@Column(name = "mixingDrum4mCheck2" )
	private String mixingdrum4mcheck2;

	/**
	 * 渣浆泵检查结果2
	 */
   	@Column(name = "pumpCheck2" )
	private String pumpcheck2;

	/**
	 * 电机检查结果2
	 */
   	@Column(name = "electricMachineryCheck2" )
	private String electricmachinerycheck2;

	/**
	 * 检查时间3
	 */
   	@Column(name = "checkTime3" )
	private String checktime3;

	/**
	 * 1#料罐检查结果3
	 */
   	@Column(name = "materialTank1Check3" )
	private String materialtank1check3;

	/**
	 * 2#料罐检查结果3
	 */
   	@Column(name = "materialTank2Check3" )
	private String materialtank2check3;

	/**
	 * 螺旋给料机检查结果3
	 */
   	@Column(name = "screwFeederCheck3" )
	private String screwfeedercheck3;

	/**
	 * 3m搅拌桶检查结果3
	 */
   	@Column(name = "mixingDrum3mCheck3" )
	private String mixingdrum3mcheck3;

	/**
	 * 4m搅拌桶检查结果3
	 */
   	@Column(name = "mixingDrum4mCheck3" )
	private String mixingdrum4mcheck3;

	/**
	 * 渣浆泵检查结果3
	 */
   	@Column(name = "pumpCheck3" )
	private String pumpcheck3;

	/**
	 * 电机检查结果3
	 */
   	@Column(name = "electricMachineryCheck3" )
	private String electricmachinerycheck3;

	/**
	 * 检查时间4
	 */
   	@Column(name = "checkTime4" )
	private String checktime4;

	/**
	 * 1#料罐检查结果4
	 */
   	@Column(name = "materialTank1Check4" )
	private String materialtank1check4;

	/**
	 * 2#料罐检查结果4
	 */
   	@Column(name = "materialTank2Check4" )
	private String materialtank2check4;

	/**
	 * 螺旋给料机检查结果4
	 */
   	@Column(name = "screwFeederCheck4" )
	private String screwfeedercheck4;

	/**
	 * 3m搅拌桶检查结果4
	 */
   	@Column(name = "mixingDrum3mCheck4" )
	private String mixingdrum3mcheck4;

	/**
	 * 4m搅拌桶检查结果4
	 */
   	@Column(name = "mixingDrum4mCheck4" )
	private String mixingdrum4mcheck4;

	/**
	 * 渣浆泵检查结果4
	 */
   	@Column(name = "pumpCheck4" )
	private String pumpcheck4;

	/**
	 * 电机检查结果4
	 */
   	@Column(name = "electricMachineryCheck4" )
	private String electricmachinerycheck4;

	/**
	 * 生产运行情况
	 */
   	@Column(name = "production" )
	private String production;

	/**
	 * 设备运转情况
	 */
   	@Column(name = "equipmentOperation" )
	private String equipmentoperation;

	/**
	 * 交班记录
	 */
   	@Column(name = "shiftRemark" )
	private String shiftremark;

	/**
	 * 接班记录
	 */
   	@Column(name = "successionremark" )
	private String successionremark;

	/**
	 * 交班人
	 */
   	@Column(name = "shiftName" )
	private String shiftname;

	/**
	 * 接班人
	 */
   	@Column(name = "successionName" )
	private String successionname;

	/**
	 * 交班状态
	 */
   	@Column(name = "shiftState" )
	private String shiftstate;

	/**
	 * 接班状态
	 */
   	@Column(name = "successionState" )
	private String successionstate;

	/**
	 * 交班时间
	 */
   	@Column(name = "shiftTime" )
	private String shifttime;

	/**
	 * 接班时间
	 */
   	@Column(name = "successionTime" )
	private String successiontime;

	/**
	 * 备用1
	 */
   	@Column(name = "param1" )
	private String param1;

	/**
	 * 备用2
	 */
   	@Column(name = "param2" )
	private String param2;

	/**
	 * 备用3
	 */
   	@Column(name = "param3" )
	private String param3;

	/**
	 * 备用4
	 */
   	@Column(name = "param4" )
	private String param4;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getDete() {
        return dete;
    }

    public void setDete(String dete) {
        this.dete = dete;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Double getPot1successionlevel() {
        return pot1successionlevel;
    }

    public void setPot1successionlevel(Double pot1successionlevel) {
        this.pot1successionlevel = pot1successionlevel;
    }

    public Double getPot1shiftlevel() {
        return pot1shiftlevel;
    }

    public void setPot1shiftlevel(Double pot1shiftlevel) {
        this.pot1shiftlevel = pot1shiftlevel;
    }

    public Double getCars1() {
        return cars1;
    }

    public void setCars1(Double cars1) {
        this.cars1 = cars1;
    }

    public Double getPot2successionlevel() {
        return pot2successionlevel;
    }

    public void setPot2successionlevel(Double pot2successionlevel) {
        this.pot2successionlevel = pot2successionlevel;
    }

    public Double getPot2shiftlevel() {
        return pot2shiftlevel;
    }

    public void setPot2shiftlevel(Double pot2shiftlevel) {
        this.pot2shiftlevel = pot2shiftlevel;
    }

    public Double getCars2() {
        return cars2;
    }

    public void setCars2(Double cars2) {
        this.cars2 = cars2;
    }

    public String getFeeder1start1() {
        return feeder1start1;
    }

    public void setFeeder1start1(String feeder1start1) {
        this.feeder1start1 = feeder1start1;
    }

    public String getFeeder1end1() {
        return feeder1end1;
    }

    public void setFeeder1end1(String feeder1end1) {
        this.feeder1end1 = feeder1end1;
    }

    public Double getFeeder1speed1() {
        return feeder1speed1;
    }

    public void setFeeder1speed1(Double feeder1speed1) {
        this.feeder1speed1 = feeder1speed1;
    }

    public Double getFeeder1water1() {
        return feeder1water1;
    }

    public void setFeeder1water1(Double feeder1water1) {
        this.feeder1water1 = feeder1water1;
    }

    public String getFeeder1start2() {
        return feeder1start2;
    }

    public void setFeeder1start2(String feeder1start2) {
        this.feeder1start2 = feeder1start2;
    }

    public String getFeeder1end2() {
        return feeder1end2;
    }

    public void setFeeder1end2(String feeder1end2) {
        this.feeder1end2 = feeder1end2;
    }

    public Double getFeeder1speed2() {
        return feeder1speed2;
    }

    public void setFeeder1speed2(Double feeder1speed2) {
        this.feeder1speed2 = feeder1speed2;
    }

    public Double getFeeder1water2() {
        return feeder1water2;
    }

    public void setFeeder1water2(Double feeder1water2) {
        this.feeder1water2 = feeder1water2;
    }

    public String getFeeder1start3() {
        return feeder1start3;
    }

    public void setFeeder1start3(String feeder1start3) {
        this.feeder1start3 = feeder1start3;
    }

    public String getFeeder1end3() {
        return feeder1end3;
    }

    public void setFeeder1end3(String feeder1end3) {
        this.feeder1end3 = feeder1end3;
    }

    public Double getFeeder1speed3() {
        return feeder1speed3;
    }

    public void setFeeder1speed3(Double feeder1speed3) {
        this.feeder1speed3 = feeder1speed3;
    }

    public Double getFeeder1water3() {
        return feeder1water3;
    }

    public void setFeeder1water3(Double feeder1water3) {
        this.feeder1water3 = feeder1water3;
    }

    public String getFeeder1start4() {
        return feeder1start4;
    }

    public void setFeeder1start4(String feeder1start4) {
        this.feeder1start4 = feeder1start4;
    }

    public String getFeeder1end4() {
        return feeder1end4;
    }

    public void setFeeder1end4(String feeder1end4) {
        this.feeder1end4 = feeder1end4;
    }

    public Double getFeeder1speed4() {
        return feeder1speed4;
    }

    public void setFeeder1speed4(Double feeder1speed4) {
        this.feeder1speed4 = feeder1speed4;
    }

    public Double getFeeder1water4() {
        return feeder1water4;
    }

    public void setFeeder1water4(Double feeder1water4) {
        this.feeder1water4 = feeder1water4;
    }

    public String getFeeder2start1() {
        return feeder2start1;
    }

    public void setFeeder2start1(String feeder2start1) {
        this.feeder2start1 = feeder2start1;
    }

    public String getFeeder2end1() {
        return feeder2end1;
    }

    public void setFeeder2end1(String feeder2end1) {
        this.feeder2end1 = feeder2end1;
    }

    public Double getFeeder2speed1() {
        return feeder2speed1;
    }

    public void setFeeder2speed1(Double feeder2speed1) {
        this.feeder2speed1 = feeder2speed1;
    }

    public Double getFeeder2water1() {
        return feeder2water1;
    }

    public void setFeeder2water1(Double feeder2water1) {
        this.feeder2water1 = feeder2water1;
    }

    public String getFeeder2start2() {
        return feeder2start2;
    }

    public void setFeeder2start2(String feeder2start2) {
        this.feeder2start2 = feeder2start2;
    }

    public String getFeeder2end2() {
        return feeder2end2;
    }

    public void setFeeder2end2(String feeder2end2) {
        this.feeder2end2 = feeder2end2;
    }

    public Double getFeeder2speed2() {
        return feeder2speed2;
    }

    public void setFeeder2speed2(Double feeder2speed2) {
        this.feeder2speed2 = feeder2speed2;
    }

    public Double getFeeder2water2() {
        return feeder2water2;
    }

    public void setFeeder2water2(Double feeder2water2) {
        this.feeder2water2 = feeder2water2;
    }

    public String getFeeder2start3() {
        return feeder2start3;
    }

    public void setFeeder2start3(String feeder2start3) {
        this.feeder2start3 = feeder2start3;
    }

    public String getFeeder2end3() {
        return feeder2end3;
    }

    public void setFeeder2end3(String feeder2end3) {
        this.feeder2end3 = feeder2end3;
    }

    public Double getFeeder2speed3() {
        return feeder2speed3;
    }

    public void setFeeder2speed3(Double feeder2speed3) {
        this.feeder2speed3 = feeder2speed3;
    }

    public Double getFeeder2water3() {
        return feeder2water3;
    }

    public void setFeeder2water3(Double feeder2water3) {
        this.feeder2water3 = feeder2water3;
    }

    public String getFeeder2start4() {
        return feeder2start4;
    }

    public void setFeeder2start4(String feeder2start4) {
        this.feeder2start4 = feeder2start4;
    }

    public String getFeeder2end4() {
        return feeder2end4;
    }

    public void setFeeder2end4(String feeder2end4) {
        this.feeder2end4 = feeder2end4;
    }

    public Double getFeeder2speed4() {
        return feeder2speed4;
    }

    public void setFeeder2speed4(Double feeder2speed4) {
        this.feeder2speed4 = feeder2speed4;
    }

    public Double getFeeder2water4() {
        return feeder2water4;
    }

    public void setFeeder2water4(Double feeder2water4) {
        this.feeder2water4 = feeder2water4;
    }

    public Double getTailingpondtime() {
        return tailingpondtime;
    }

    public void setTailingpondtime(Double tailingpondtime) {
        this.tailingpondtime = tailingpondtime;
    }

    public Double getLimepump1runtime() {
        return limepump1runtime;
    }

    public void setLimepump1runtime(Double limepump1runtime) {
        this.limepump1runtime = limepump1runtime;
    }

    public Double getLimepump2runtime() {
        return limepump2runtime;
    }

    public void setLimepump2runtime(Double limepump2runtime) {
        this.limepump2runtime = limepump2runtime;
    }

    public Double getLimepump3runtime() {
        return limepump3runtime;
    }

    public void setLimepump3runtime(Double limepump3runtime) {
        this.limepump3runtime = limepump3runtime;
    }

    public Double getSewageregulationtime() {
        return sewageregulationtime;
    }

    public void setSewageregulationtime(Double sewageregulationtime) {
        this.sewageregulationtime = sewageregulationtime;
    }

    public String getEquipmentlubrication() {
        return equipmentlubrication;
    }

    public void setEquipmentlubrication(String equipmentlubrication) {
        this.equipmentlubrication = equipmentlubrication;
    }

    public String getMachinesanitation() {
        return machinesanitation;
    }

    public void setMachinesanitation(String machinesanitation) {
        this.machinesanitation = machinesanitation;
    }

    public String getChecktime1() {
        return checktime1;
    }

    public void setChecktime1(String checktime1) {
        this.checktime1 = checktime1;
    }

    public String getMaterialtank1check1() {
        return materialtank1check1;
    }

    public void setMaterialtank1check1(String materialtank1check1) {
        this.materialtank1check1 = materialtank1check1;
    }

    public String getMaterialtank2check1() {
        return materialtank2check1;
    }

    public void setMaterialtank2check1(String materialtank2check1) {
        this.materialtank2check1 = materialtank2check1;
    }

    public String getScrewfeedercheck1() {
        return screwfeedercheck1;
    }

    public void setScrewfeedercheck1(String screwfeedercheck1) {
        this.screwfeedercheck1 = screwfeedercheck1;
    }

    public String getMixingdrum3mcheck1() {
        return mixingdrum3mcheck1;
    }

    public void setMixingdrum3mcheck1(String mixingdrum3mcheck1) {
        this.mixingdrum3mcheck1 = mixingdrum3mcheck1;
    }

    public String getMixingdrum4mcheck1() {
        return mixingdrum4mcheck1;
    }

    public void setMixingdrum4mcheck1(String mixingdrum4mcheck1) {
        this.mixingdrum4mcheck1 = mixingdrum4mcheck1;
    }

    public String getPumpcheck1() {
        return pumpcheck1;
    }

    public void setPumpcheck1(String pumpcheck1) {
        this.pumpcheck1 = pumpcheck1;
    }

    public String getElectricmachinerycheck1() {
        return electricmachinerycheck1;
    }

    public void setElectricmachinerycheck1(String electricmachinerycheck1) {
        this.electricmachinerycheck1 = electricmachinerycheck1;
    }

    public String getChecktime2() {
        return checktime2;
    }

    public void setChecktime2(String checktime2) {
        this.checktime2 = checktime2;
    }

    public String getMaterialtank1check2() {
        return materialtank1check2;
    }

    public void setMaterialtank1check2(String materialtank1check2) {
        this.materialtank1check2 = materialtank1check2;
    }

    public String getMaterialtank2check2() {
        return materialtank2check2;
    }

    public void setMaterialtank2check2(String materialtank2check2) {
        this.materialtank2check2 = materialtank2check2;
    }

    public String getScrewfeedercheck2() {
        return screwfeedercheck2;
    }

    public void setScrewfeedercheck2(String screwfeedercheck2) {
        this.screwfeedercheck2 = screwfeedercheck2;
    }

    public String getMixingdrum3mcheck2() {
        return mixingdrum3mcheck2;
    }

    public void setMixingdrum3mcheck2(String mixingdrum3mcheck2) {
        this.mixingdrum3mcheck2 = mixingdrum3mcheck2;
    }

    public String getMixingdrum4mcheck2() {
        return mixingdrum4mcheck2;
    }

    public void setMixingdrum4mcheck2(String mixingdrum4mcheck2) {
        this.mixingdrum4mcheck2 = mixingdrum4mcheck2;
    }

    public String getPumpcheck2() {
        return pumpcheck2;
    }

    public void setPumpcheck2(String pumpcheck2) {
        this.pumpcheck2 = pumpcheck2;
    }

    public String getElectricmachinerycheck2() {
        return electricmachinerycheck2;
    }

    public void setElectricmachinerycheck2(String electricmachinerycheck2) {
        this.electricmachinerycheck2 = electricmachinerycheck2;
    }

    public String getChecktime3() {
        return checktime3;
    }

    public void setChecktime3(String checktime3) {
        this.checktime3 = checktime3;
    }

    public String getMaterialtank1check3() {
        return materialtank1check3;
    }

    public void setMaterialtank1check3(String materialtank1check3) {
        this.materialtank1check3 = materialtank1check3;
    }

    public String getMaterialtank2check3() {
        return materialtank2check3;
    }

    public void setMaterialtank2check3(String materialtank2check3) {
        this.materialtank2check3 = materialtank2check3;
    }

    public String getScrewfeedercheck3() {
        return screwfeedercheck3;
    }

    public void setScrewfeedercheck3(String screwfeedercheck3) {
        this.screwfeedercheck3 = screwfeedercheck3;
    }

    public String getMixingdrum3mcheck3() {
        return mixingdrum3mcheck3;
    }

    public void setMixingdrum3mcheck3(String mixingdrum3mcheck3) {
        this.mixingdrum3mcheck3 = mixingdrum3mcheck3;
    }

    public String getMixingdrum4mcheck3() {
        return mixingdrum4mcheck3;
    }

    public void setMixingdrum4mcheck3(String mixingdrum4mcheck3) {
        this.mixingdrum4mcheck3 = mixingdrum4mcheck3;
    }

    public String getPumpcheck3() {
        return pumpcheck3;
    }

    public void setPumpcheck3(String pumpcheck3) {
        this.pumpcheck3 = pumpcheck3;
    }

    public String getElectricmachinerycheck3() {
        return electricmachinerycheck3;
    }

    public void setElectricmachinerycheck3(String electricmachinerycheck3) {
        this.electricmachinerycheck3 = electricmachinerycheck3;
    }

    public String getChecktime4() {
        return checktime4;
    }

    public void setChecktime4(String checktime4) {
        this.checktime4 = checktime4;
    }

    public String getMaterialtank1check4() {
        return materialtank1check4;
    }

    public void setMaterialtank1check4(String materialtank1check4) {
        this.materialtank1check4 = materialtank1check4;
    }

    public String getMaterialtank2check4() {
        return materialtank2check4;
    }

    public void setMaterialtank2check4(String materialtank2check4) {
        this.materialtank2check4 = materialtank2check4;
    }

    public String getScrewfeedercheck4() {
        return screwfeedercheck4;
    }

    public void setScrewfeedercheck4(String screwfeedercheck4) {
        this.screwfeedercheck4 = screwfeedercheck4;
    }

    public String getMixingdrum3mcheck4() {
        return mixingdrum3mcheck4;
    }

    public void setMixingdrum3mcheck4(String mixingdrum3mcheck4) {
        this.mixingdrum3mcheck4 = mixingdrum3mcheck4;
    }

    public String getMixingdrum4mcheck4() {
        return mixingdrum4mcheck4;
    }

    public void setMixingdrum4mcheck4(String mixingdrum4mcheck4) {
        this.mixingdrum4mcheck4 = mixingdrum4mcheck4;
    }

    public String getPumpcheck4() {
        return pumpcheck4;
    }

    public void setPumpcheck4(String pumpcheck4) {
        this.pumpcheck4 = pumpcheck4;
    }

    public String getElectricmachinerycheck4() {
        return electricmachinerycheck4;
    }

    public void setElectricmachinerycheck4(String electricmachinerycheck4) {
        this.electricmachinerycheck4 = electricmachinerycheck4;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getEquipmentoperation() {
        return equipmentoperation;
    }

    public void setEquipmentoperation(String equipmentoperation) {
        this.equipmentoperation = equipmentoperation;
    }

    public String getShiftremark() {
        return shiftremark;
    }

    public void setShiftremark(String shiftremark) {
        this.shiftremark = shiftremark;
    }

    public String getSuccessionremark() {
        return successionremark;
    }

    public void setSuccessionremark(String successionremark) {
        this.successionremark = successionremark;
    }

    public String getShiftname() {
        return shiftname;
    }

    public void setShiftname(String shiftname) {
        this.shiftname = shiftname;
    }

    public String getSuccessionname() {
        return successionname;
    }

    public void setSuccessionname(String successionname) {
        this.successionname = successionname;
    }

    public String getShiftstate() {
        return shiftstate;
    }

    public void setShiftstate(String shiftstate) {
        this.shiftstate = shiftstate;
    }

    public String getSuccessionstate() {
        return successionstate;
    }

    public void setSuccessionstate(String successionstate) {
        this.successionstate = successionstate;
    }

    public String getShifttime() {
        return shifttime;
    }

    public void setShifttime(String shifttime) {
        this.shifttime = shifttime;
    }

    public String getSuccessiontime() {
        return successiontime;
    }

    public void setSuccessiontime(String successiontime) {
        this.successiontime = successiontime;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3;
    }

    public String getParam4() {
        return param4;
    }

    public void setParam4(String param4) {
        this.param4 = param4;
    }
}
