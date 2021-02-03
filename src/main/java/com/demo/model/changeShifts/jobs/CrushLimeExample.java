package com.demo.model.changeShifts.jobs;

import java.util.ArrayList;
import java.util.List;

public class CrushLimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CrushLimeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTeamIsNull() {
            addCriterion("team is null");
            return (Criteria) this;
        }

        public Criteria andTeamIsNotNull() {
            addCriterion("team is not null");
            return (Criteria) this;
        }

        public Criteria andTeamEqualTo(String value) {
            addCriterion("team =", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotEqualTo(String value) {
            addCriterion("team <>", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamGreaterThan(String value) {
            addCriterion("team >", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamGreaterThanOrEqualTo(String value) {
            addCriterion("team >=", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamLessThan(String value) {
            addCriterion("team <", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamLessThanOrEqualTo(String value) {
            addCriterion("team <=", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamLike(String value) {
            addCriterion("team like", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotLike(String value) {
            addCriterion("team not like", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamIn(List<String> values) {
            addCriterion("team in", values, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotIn(List<String> values) {
            addCriterion("team not in", values, "team");
            return (Criteria) this;
        }

        public Criteria andTeamBetween(String value1, String value2) {
            addCriterion("team between", value1, value2, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotBetween(String value1, String value2) {
            addCriterion("team not between", value1, value2, "team");
            return (Criteria) this;
        }

        public Criteria andDeteIsNull() {
            addCriterion("dete is null");
            return (Criteria) this;
        }

        public Criteria andDeteIsNotNull() {
            addCriterion("dete is not null");
            return (Criteria) this;
        }

        public Criteria andDeteEqualTo(String value) {
            addCriterion("dete =", value, "dete");
            return (Criteria) this;
        }

        public Criteria andDeteNotEqualTo(String value) {
            addCriterion("dete <>", value, "dete");
            return (Criteria) this;
        }

        public Criteria andDeteGreaterThan(String value) {
            addCriterion("dete >", value, "dete");
            return (Criteria) this;
        }

        public Criteria andDeteGreaterThanOrEqualTo(String value) {
            addCriterion("dete >=", value, "dete");
            return (Criteria) this;
        }

        public Criteria andDeteLessThan(String value) {
            addCriterion("dete <", value, "dete");
            return (Criteria) this;
        }

        public Criteria andDeteLessThanOrEqualTo(String value) {
            addCriterion("dete <=", value, "dete");
            return (Criteria) this;
        }

        public Criteria andDeteLike(String value) {
            addCriterion("dete like", value, "dete");
            return (Criteria) this;
        }

        public Criteria andDeteNotLike(String value) {
            addCriterion("dete not like", value, "dete");
            return (Criteria) this;
        }

        public Criteria andDeteIn(List<String> values) {
            addCriterion("dete in", values, "dete");
            return (Criteria) this;
        }

        public Criteria andDeteNotIn(List<String> values) {
            addCriterion("dete not in", values, "dete");
            return (Criteria) this;
        }

        public Criteria andDeteBetween(String value1, String value2) {
            addCriterion("dete between", value1, value2, "dete");
            return (Criteria) this;
        }

        public Criteria andDeteNotBetween(String value1, String value2) {
            addCriterion("dete not between", value1, value2, "dete");
            return (Criteria) this;
        }

        public Criteria andShiftIsNull() {
            addCriterion("shift is null");
            return (Criteria) this;
        }

        public Criteria andShiftIsNotNull() {
            addCriterion("shift is not null");
            return (Criteria) this;
        }

        public Criteria andShiftEqualTo(String value) {
            addCriterion("shift =", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftNotEqualTo(String value) {
            addCriterion("shift <>", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftGreaterThan(String value) {
            addCriterion("shift >", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftGreaterThanOrEqualTo(String value) {
            addCriterion("shift >=", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftLessThan(String value) {
            addCriterion("shift <", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftLessThanOrEqualTo(String value) {
            addCriterion("shift <=", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftLike(String value) {
            addCriterion("shift like", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftNotLike(String value) {
            addCriterion("shift not like", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftIn(List<String> values) {
            addCriterion("shift in", values, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftNotIn(List<String> values) {
            addCriterion("shift not in", values, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftBetween(String value1, String value2) {
            addCriterion("shift between", value1, value2, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftNotBetween(String value1, String value2) {
            addCriterion("shift not between", value1, value2, "shift");
            return (Criteria) this;
        }

        public Criteria andPot1successionlevelIsNull() {
            addCriterion("pot1SuccessionLevel is null");
            return (Criteria) this;
        }

        public Criteria andPot1successionlevelIsNotNull() {
            addCriterion("pot1SuccessionLevel is not null");
            return (Criteria) this;
        }

        public Criteria andPot1successionlevelEqualTo(Double value) {
            addCriterion("pot1SuccessionLevel =", value, "pot1successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot1successionlevelNotEqualTo(Double value) {
            addCriterion("pot1SuccessionLevel <>", value, "pot1successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot1successionlevelGreaterThan(Double value) {
            addCriterion("pot1SuccessionLevel >", value, "pot1successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot1successionlevelGreaterThanOrEqualTo(Double value) {
            addCriterion("pot1SuccessionLevel >=", value, "pot1successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot1successionlevelLessThan(Double value) {
            addCriterion("pot1SuccessionLevel <", value, "pot1successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot1successionlevelLessThanOrEqualTo(Double value) {
            addCriterion("pot1SuccessionLevel <=", value, "pot1successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot1successionlevelIn(List<Double> values) {
            addCriterion("pot1SuccessionLevel in", values, "pot1successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot1successionlevelNotIn(List<Double> values) {
            addCriterion("pot1SuccessionLevel not in", values, "pot1successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot1successionlevelBetween(Double value1, Double value2) {
            addCriterion("pot1SuccessionLevel between", value1, value2, "pot1successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot1successionlevelNotBetween(Double value1, Double value2) {
            addCriterion("pot1SuccessionLevel not between", value1, value2, "pot1successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot1shiftlevelIsNull() {
            addCriterion("pot1ShiftLevel is null");
            return (Criteria) this;
        }

        public Criteria andPot1shiftlevelIsNotNull() {
            addCriterion("pot1ShiftLevel is not null");
            return (Criteria) this;
        }

        public Criteria andPot1shiftlevelEqualTo(Double value) {
            addCriterion("pot1ShiftLevel =", value, "pot1shiftlevel");
            return (Criteria) this;
        }

        public Criteria andPot1shiftlevelNotEqualTo(Double value) {
            addCriterion("pot1ShiftLevel <>", value, "pot1shiftlevel");
            return (Criteria) this;
        }

        public Criteria andPot1shiftlevelGreaterThan(Double value) {
            addCriterion("pot1ShiftLevel >", value, "pot1shiftlevel");
            return (Criteria) this;
        }

        public Criteria andPot1shiftlevelGreaterThanOrEqualTo(Double value) {
            addCriterion("pot1ShiftLevel >=", value, "pot1shiftlevel");
            return (Criteria) this;
        }

        public Criteria andPot1shiftlevelLessThan(Double value) {
            addCriterion("pot1ShiftLevel <", value, "pot1shiftlevel");
            return (Criteria) this;
        }

        public Criteria andPot1shiftlevelLessThanOrEqualTo(Double value) {
            addCriterion("pot1ShiftLevel <=", value, "pot1shiftlevel");
            return (Criteria) this;
        }

        public Criteria andPot1shiftlevelIn(List<Double> values) {
            addCriterion("pot1ShiftLevel in", values, "pot1shiftlevel");
            return (Criteria) this;
        }

        public Criteria andPot1shiftlevelNotIn(List<Double> values) {
            addCriterion("pot1ShiftLevel not in", values, "pot1shiftlevel");
            return (Criteria) this;
        }

        public Criteria andPot1shiftlevelBetween(Double value1, Double value2) {
            addCriterion("pot1ShiftLevel between", value1, value2, "pot1shiftlevel");
            return (Criteria) this;
        }

        public Criteria andPot1shiftlevelNotBetween(Double value1, Double value2) {
            addCriterion("pot1ShiftLevel not between", value1, value2, "pot1shiftlevel");
            return (Criteria) this;
        }

        public Criteria andCars1IsNull() {
            addCriterion("cars1 is null");
            return (Criteria) this;
        }

        public Criteria andCars1IsNotNull() {
            addCriterion("cars1 is not null");
            return (Criteria) this;
        }

        public Criteria andCars1EqualTo(Double value) {
            addCriterion("cars1 =", value, "cars1");
            return (Criteria) this;
        }

        public Criteria andCars1NotEqualTo(Double value) {
            addCriterion("cars1 <>", value, "cars1");
            return (Criteria) this;
        }

        public Criteria andCars1GreaterThan(Double value) {
            addCriterion("cars1 >", value, "cars1");
            return (Criteria) this;
        }

        public Criteria andCars1GreaterThanOrEqualTo(Double value) {
            addCriterion("cars1 >=", value, "cars1");
            return (Criteria) this;
        }

        public Criteria andCars1LessThan(Double value) {
            addCriterion("cars1 <", value, "cars1");
            return (Criteria) this;
        }

        public Criteria andCars1LessThanOrEqualTo(Double value) {
            addCriterion("cars1 <=", value, "cars1");
            return (Criteria) this;
        }

        public Criteria andCars1In(List<Double> values) {
            addCriterion("cars1 in", values, "cars1");
            return (Criteria) this;
        }

        public Criteria andCars1NotIn(List<Double> values) {
            addCriterion("cars1 not in", values, "cars1");
            return (Criteria) this;
        }

        public Criteria andCars1Between(Double value1, Double value2) {
            addCriterion("cars1 between", value1, value2, "cars1");
            return (Criteria) this;
        }

        public Criteria andCars1NotBetween(Double value1, Double value2) {
            addCriterion("cars1 not between", value1, value2, "cars1");
            return (Criteria) this;
        }

        public Criteria andPot2successionlevelIsNull() {
            addCriterion("pot2SuccessionLevel is null");
            return (Criteria) this;
        }

        public Criteria andPot2successionlevelIsNotNull() {
            addCriterion("pot2SuccessionLevel is not null");
            return (Criteria) this;
        }

        public Criteria andPot2successionlevelEqualTo(Double value) {
            addCriterion("pot2SuccessionLevel =", value, "pot2successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot2successionlevelNotEqualTo(Double value) {
            addCriterion("pot2SuccessionLevel <>", value, "pot2successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot2successionlevelGreaterThan(Double value) {
            addCriterion("pot2SuccessionLevel >", value, "pot2successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot2successionlevelGreaterThanOrEqualTo(Double value) {
            addCriterion("pot2SuccessionLevel >=", value, "pot2successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot2successionlevelLessThan(Double value) {
            addCriterion("pot2SuccessionLevel <", value, "pot2successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot2successionlevelLessThanOrEqualTo(Double value) {
            addCriterion("pot2SuccessionLevel <=", value, "pot2successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot2successionlevelIn(List<Double> values) {
            addCriterion("pot2SuccessionLevel in", values, "pot2successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot2successionlevelNotIn(List<Double> values) {
            addCriterion("pot2SuccessionLevel not in", values, "pot2successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot2successionlevelBetween(Double value1, Double value2) {
            addCriterion("pot2SuccessionLevel between", value1, value2, "pot2successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot2successionlevelNotBetween(Double value1, Double value2) {
            addCriterion("pot2SuccessionLevel not between", value1, value2, "pot2successionlevel");
            return (Criteria) this;
        }

        public Criteria andPot2shiftlevelIsNull() {
            addCriterion("pot2ShiftLevel is null");
            return (Criteria) this;
        }

        public Criteria andPot2shiftlevelIsNotNull() {
            addCriterion("pot2ShiftLevel is not null");
            return (Criteria) this;
        }

        public Criteria andPot2shiftlevelEqualTo(Double value) {
            addCriterion("pot2ShiftLevel =", value, "pot2shiftlevel");
            return (Criteria) this;
        }

        public Criteria andPot2shiftlevelNotEqualTo(Double value) {
            addCriterion("pot2ShiftLevel <>", value, "pot2shiftlevel");
            return (Criteria) this;
        }

        public Criteria andPot2shiftlevelGreaterThan(Double value) {
            addCriterion("pot2ShiftLevel >", value, "pot2shiftlevel");
            return (Criteria) this;
        }

        public Criteria andPot2shiftlevelGreaterThanOrEqualTo(Double value) {
            addCriterion("pot2ShiftLevel >=", value, "pot2shiftlevel");
            return (Criteria) this;
        }

        public Criteria andPot2shiftlevelLessThan(Double value) {
            addCriterion("pot2ShiftLevel <", value, "pot2shiftlevel");
            return (Criteria) this;
        }

        public Criteria andPot2shiftlevelLessThanOrEqualTo(Double value) {
            addCriterion("pot2ShiftLevel <=", value, "pot2shiftlevel");
            return (Criteria) this;
        }

        public Criteria andPot2shiftlevelIn(List<Double> values) {
            addCriterion("pot2ShiftLevel in", values, "pot2shiftlevel");
            return (Criteria) this;
        }

        public Criteria andPot2shiftlevelNotIn(List<Double> values) {
            addCriterion("pot2ShiftLevel not in", values, "pot2shiftlevel");
            return (Criteria) this;
        }

        public Criteria andPot2shiftlevelBetween(Double value1, Double value2) {
            addCriterion("pot2ShiftLevel between", value1, value2, "pot2shiftlevel");
            return (Criteria) this;
        }

        public Criteria andPot2shiftlevelNotBetween(Double value1, Double value2) {
            addCriterion("pot2ShiftLevel not between", value1, value2, "pot2shiftlevel");
            return (Criteria) this;
        }

        public Criteria andCars2IsNull() {
            addCriterion("cars2 is null");
            return (Criteria) this;
        }

        public Criteria andCars2IsNotNull() {
            addCriterion("cars2 is not null");
            return (Criteria) this;
        }

        public Criteria andCars2EqualTo(Double value) {
            addCriterion("cars2 =", value, "cars2");
            return (Criteria) this;
        }

        public Criteria andCars2NotEqualTo(Double value) {
            addCriterion("cars2 <>", value, "cars2");
            return (Criteria) this;
        }

        public Criteria andCars2GreaterThan(Double value) {
            addCriterion("cars2 >", value, "cars2");
            return (Criteria) this;
        }

        public Criteria andCars2GreaterThanOrEqualTo(Double value) {
            addCriterion("cars2 >=", value, "cars2");
            return (Criteria) this;
        }

        public Criteria andCars2LessThan(Double value) {
            addCriterion("cars2 <", value, "cars2");
            return (Criteria) this;
        }

        public Criteria andCars2LessThanOrEqualTo(Double value) {
            addCriterion("cars2 <=", value, "cars2");
            return (Criteria) this;
        }

        public Criteria andCars2In(List<Double> values) {
            addCriterion("cars2 in", values, "cars2");
            return (Criteria) this;
        }

        public Criteria andCars2NotIn(List<Double> values) {
            addCriterion("cars2 not in", values, "cars2");
            return (Criteria) this;
        }

        public Criteria andCars2Between(Double value1, Double value2) {
            addCriterion("cars2 between", value1, value2, "cars2");
            return (Criteria) this;
        }

        public Criteria andCars2NotBetween(Double value1, Double value2) {
            addCriterion("cars2 not between", value1, value2, "cars2");
            return (Criteria) this;
        }

        public Criteria andFeeder1start1IsNull() {
            addCriterion("feeder1Start1 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder1start1IsNotNull() {
            addCriterion("feeder1Start1 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder1start1EqualTo(String value) {
            addCriterion("feeder1Start1 =", value, "feeder1start1");
            return (Criteria) this;
        }

        public Criteria andFeeder1start1NotEqualTo(String value) {
            addCriterion("feeder1Start1 <>", value, "feeder1start1");
            return (Criteria) this;
        }

        public Criteria andFeeder1start1GreaterThan(String value) {
            addCriterion("feeder1Start1 >", value, "feeder1start1");
            return (Criteria) this;
        }

        public Criteria andFeeder1start1GreaterThanOrEqualTo(String value) {
            addCriterion("feeder1Start1 >=", value, "feeder1start1");
            return (Criteria) this;
        }

        public Criteria andFeeder1start1LessThan(String value) {
            addCriterion("feeder1Start1 <", value, "feeder1start1");
            return (Criteria) this;
        }

        public Criteria andFeeder1start1LessThanOrEqualTo(String value) {
            addCriterion("feeder1Start1 <=", value, "feeder1start1");
            return (Criteria) this;
        }

        public Criteria andFeeder1start1Like(String value) {
            addCriterion("feeder1Start1 like", value, "feeder1start1");
            return (Criteria) this;
        }

        public Criteria andFeeder1start1NotLike(String value) {
            addCriterion("feeder1Start1 not like", value, "feeder1start1");
            return (Criteria) this;
        }

        public Criteria andFeeder1start1In(List<String> values) {
            addCriterion("feeder1Start1 in", values, "feeder1start1");
            return (Criteria) this;
        }

        public Criteria andFeeder1start1NotIn(List<String> values) {
            addCriterion("feeder1Start1 not in", values, "feeder1start1");
            return (Criteria) this;
        }

        public Criteria andFeeder1start1Between(String value1, String value2) {
            addCriterion("feeder1Start1 between", value1, value2, "feeder1start1");
            return (Criteria) this;
        }

        public Criteria andFeeder1start1NotBetween(String value1, String value2) {
            addCriterion("feeder1Start1 not between", value1, value2, "feeder1start1");
            return (Criteria) this;
        }

        public Criteria andFeeder1end1IsNull() {
            addCriterion("feeder1End1 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder1end1IsNotNull() {
            addCriterion("feeder1End1 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder1end1EqualTo(String value) {
            addCriterion("feeder1End1 =", value, "feeder1end1");
            return (Criteria) this;
        }

        public Criteria andFeeder1end1NotEqualTo(String value) {
            addCriterion("feeder1End1 <>", value, "feeder1end1");
            return (Criteria) this;
        }

        public Criteria andFeeder1end1GreaterThan(String value) {
            addCriterion("feeder1End1 >", value, "feeder1end1");
            return (Criteria) this;
        }

        public Criteria andFeeder1end1GreaterThanOrEqualTo(String value) {
            addCriterion("feeder1End1 >=", value, "feeder1end1");
            return (Criteria) this;
        }

        public Criteria andFeeder1end1LessThan(String value) {
            addCriterion("feeder1End1 <", value, "feeder1end1");
            return (Criteria) this;
        }

        public Criteria andFeeder1end1LessThanOrEqualTo(String value) {
            addCriterion("feeder1End1 <=", value, "feeder1end1");
            return (Criteria) this;
        }

        public Criteria andFeeder1end1Like(String value) {
            addCriterion("feeder1End1 like", value, "feeder1end1");
            return (Criteria) this;
        }

        public Criteria andFeeder1end1NotLike(String value) {
            addCriterion("feeder1End1 not like", value, "feeder1end1");
            return (Criteria) this;
        }

        public Criteria andFeeder1end1In(List<String> values) {
            addCriterion("feeder1End1 in", values, "feeder1end1");
            return (Criteria) this;
        }

        public Criteria andFeeder1end1NotIn(List<String> values) {
            addCriterion("feeder1End1 not in", values, "feeder1end1");
            return (Criteria) this;
        }

        public Criteria andFeeder1end1Between(String value1, String value2) {
            addCriterion("feeder1End1 between", value1, value2, "feeder1end1");
            return (Criteria) this;
        }

        public Criteria andFeeder1end1NotBetween(String value1, String value2) {
            addCriterion("feeder1End1 not between", value1, value2, "feeder1end1");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed1IsNull() {
            addCriterion("feeder1Speed1 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed1IsNotNull() {
            addCriterion("feeder1Speed1 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed1EqualTo(Double value) {
            addCriterion("feeder1Speed1 =", value, "feeder1speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed1NotEqualTo(Double value) {
            addCriterion("feeder1Speed1 <>", value, "feeder1speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed1GreaterThan(Double value) {
            addCriterion("feeder1Speed1 >", value, "feeder1speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed1GreaterThanOrEqualTo(Double value) {
            addCriterion("feeder1Speed1 >=", value, "feeder1speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed1LessThan(Double value) {
            addCriterion("feeder1Speed1 <", value, "feeder1speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed1LessThanOrEqualTo(Double value) {
            addCriterion("feeder1Speed1 <=", value, "feeder1speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed1In(List<Double> values) {
            addCriterion("feeder1Speed1 in", values, "feeder1speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed1NotIn(List<Double> values) {
            addCriterion("feeder1Speed1 not in", values, "feeder1speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed1Between(Double value1, Double value2) {
            addCriterion("feeder1Speed1 between", value1, value2, "feeder1speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed1NotBetween(Double value1, Double value2) {
            addCriterion("feeder1Speed1 not between", value1, value2, "feeder1speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder1water1IsNull() {
            addCriterion("feeder1Water1 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder1water1IsNotNull() {
            addCriterion("feeder1Water1 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder1water1EqualTo(Double value) {
            addCriterion("feeder1Water1 =", value, "feeder1water1");
            return (Criteria) this;
        }

        public Criteria andFeeder1water1NotEqualTo(Double value) {
            addCriterion("feeder1Water1 <>", value, "feeder1water1");
            return (Criteria) this;
        }

        public Criteria andFeeder1water1GreaterThan(Double value) {
            addCriterion("feeder1Water1 >", value, "feeder1water1");
            return (Criteria) this;
        }

        public Criteria andFeeder1water1GreaterThanOrEqualTo(Double value) {
            addCriterion("feeder1Water1 >=", value, "feeder1water1");
            return (Criteria) this;
        }

        public Criteria andFeeder1water1LessThan(Double value) {
            addCriterion("feeder1Water1 <", value, "feeder1water1");
            return (Criteria) this;
        }

        public Criteria andFeeder1water1LessThanOrEqualTo(Double value) {
            addCriterion("feeder1Water1 <=", value, "feeder1water1");
            return (Criteria) this;
        }

        public Criteria andFeeder1water1In(List<Double> values) {
            addCriterion("feeder1Water1 in", values, "feeder1water1");
            return (Criteria) this;
        }

        public Criteria andFeeder1water1NotIn(List<Double> values) {
            addCriterion("feeder1Water1 not in", values, "feeder1water1");
            return (Criteria) this;
        }

        public Criteria andFeeder1water1Between(Double value1, Double value2) {
            addCriterion("feeder1Water1 between", value1, value2, "feeder1water1");
            return (Criteria) this;
        }

        public Criteria andFeeder1water1NotBetween(Double value1, Double value2) {
            addCriterion("feeder1Water1 not between", value1, value2, "feeder1water1");
            return (Criteria) this;
        }

        public Criteria andFeeder1start2IsNull() {
            addCriterion("feeder1Start2 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder1start2IsNotNull() {
            addCriterion("feeder1Start2 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder1start2EqualTo(String value) {
            addCriterion("feeder1Start2 =", value, "feeder1start2");
            return (Criteria) this;
        }

        public Criteria andFeeder1start2NotEqualTo(String value) {
            addCriterion("feeder1Start2 <>", value, "feeder1start2");
            return (Criteria) this;
        }

        public Criteria andFeeder1start2GreaterThan(String value) {
            addCriterion("feeder1Start2 >", value, "feeder1start2");
            return (Criteria) this;
        }

        public Criteria andFeeder1start2GreaterThanOrEqualTo(String value) {
            addCriterion("feeder1Start2 >=", value, "feeder1start2");
            return (Criteria) this;
        }

        public Criteria andFeeder1start2LessThan(String value) {
            addCriterion("feeder1Start2 <", value, "feeder1start2");
            return (Criteria) this;
        }

        public Criteria andFeeder1start2LessThanOrEqualTo(String value) {
            addCriterion("feeder1Start2 <=", value, "feeder1start2");
            return (Criteria) this;
        }

        public Criteria andFeeder1start2Like(String value) {
            addCriterion("feeder1Start2 like", value, "feeder1start2");
            return (Criteria) this;
        }

        public Criteria andFeeder1start2NotLike(String value) {
            addCriterion("feeder1Start2 not like", value, "feeder1start2");
            return (Criteria) this;
        }

        public Criteria andFeeder1start2In(List<String> values) {
            addCriterion("feeder1Start2 in", values, "feeder1start2");
            return (Criteria) this;
        }

        public Criteria andFeeder1start2NotIn(List<String> values) {
            addCriterion("feeder1Start2 not in", values, "feeder1start2");
            return (Criteria) this;
        }

        public Criteria andFeeder1start2Between(String value1, String value2) {
            addCriterion("feeder1Start2 between", value1, value2, "feeder1start2");
            return (Criteria) this;
        }

        public Criteria andFeeder1start2NotBetween(String value1, String value2) {
            addCriterion("feeder1Start2 not between", value1, value2, "feeder1start2");
            return (Criteria) this;
        }

        public Criteria andFeeder1end2IsNull() {
            addCriterion("feeder1End2 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder1end2IsNotNull() {
            addCriterion("feeder1End2 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder1end2EqualTo(String value) {
            addCriterion("feeder1End2 =", value, "feeder1end2");
            return (Criteria) this;
        }

        public Criteria andFeeder1end2NotEqualTo(String value) {
            addCriterion("feeder1End2 <>", value, "feeder1end2");
            return (Criteria) this;
        }

        public Criteria andFeeder1end2GreaterThan(String value) {
            addCriterion("feeder1End2 >", value, "feeder1end2");
            return (Criteria) this;
        }

        public Criteria andFeeder1end2GreaterThanOrEqualTo(String value) {
            addCriterion("feeder1End2 >=", value, "feeder1end2");
            return (Criteria) this;
        }

        public Criteria andFeeder1end2LessThan(String value) {
            addCriterion("feeder1End2 <", value, "feeder1end2");
            return (Criteria) this;
        }

        public Criteria andFeeder1end2LessThanOrEqualTo(String value) {
            addCriterion("feeder1End2 <=", value, "feeder1end2");
            return (Criteria) this;
        }

        public Criteria andFeeder1end2Like(String value) {
            addCriterion("feeder1End2 like", value, "feeder1end2");
            return (Criteria) this;
        }

        public Criteria andFeeder1end2NotLike(String value) {
            addCriterion("feeder1End2 not like", value, "feeder1end2");
            return (Criteria) this;
        }

        public Criteria andFeeder1end2In(List<String> values) {
            addCriterion("feeder1End2 in", values, "feeder1end2");
            return (Criteria) this;
        }

        public Criteria andFeeder1end2NotIn(List<String> values) {
            addCriterion("feeder1End2 not in", values, "feeder1end2");
            return (Criteria) this;
        }

        public Criteria andFeeder1end2Between(String value1, String value2) {
            addCriterion("feeder1End2 between", value1, value2, "feeder1end2");
            return (Criteria) this;
        }

        public Criteria andFeeder1end2NotBetween(String value1, String value2) {
            addCriterion("feeder1End2 not between", value1, value2, "feeder1end2");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed2IsNull() {
            addCriterion("feeder1Speed2 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed2IsNotNull() {
            addCriterion("feeder1Speed2 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed2EqualTo(Double value) {
            addCriterion("feeder1Speed2 =", value, "feeder1speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed2NotEqualTo(Double value) {
            addCriterion("feeder1Speed2 <>", value, "feeder1speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed2GreaterThan(Double value) {
            addCriterion("feeder1Speed2 >", value, "feeder1speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed2GreaterThanOrEqualTo(Double value) {
            addCriterion("feeder1Speed2 >=", value, "feeder1speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed2LessThan(Double value) {
            addCriterion("feeder1Speed2 <", value, "feeder1speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed2LessThanOrEqualTo(Double value) {
            addCriterion("feeder1Speed2 <=", value, "feeder1speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed2In(List<Double> values) {
            addCriterion("feeder1Speed2 in", values, "feeder1speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed2NotIn(List<Double> values) {
            addCriterion("feeder1Speed2 not in", values, "feeder1speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed2Between(Double value1, Double value2) {
            addCriterion("feeder1Speed2 between", value1, value2, "feeder1speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed2NotBetween(Double value1, Double value2) {
            addCriterion("feeder1Speed2 not between", value1, value2, "feeder1speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder1water2IsNull() {
            addCriterion("feeder1Water2 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder1water2IsNotNull() {
            addCriterion("feeder1Water2 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder1water2EqualTo(Double value) {
            addCriterion("feeder1Water2 =", value, "feeder1water2");
            return (Criteria) this;
        }

        public Criteria andFeeder1water2NotEqualTo(Double value) {
            addCriterion("feeder1Water2 <>", value, "feeder1water2");
            return (Criteria) this;
        }

        public Criteria andFeeder1water2GreaterThan(Double value) {
            addCriterion("feeder1Water2 >", value, "feeder1water2");
            return (Criteria) this;
        }

        public Criteria andFeeder1water2GreaterThanOrEqualTo(Double value) {
            addCriterion("feeder1Water2 >=", value, "feeder1water2");
            return (Criteria) this;
        }

        public Criteria andFeeder1water2LessThan(Double value) {
            addCriterion("feeder1Water2 <", value, "feeder1water2");
            return (Criteria) this;
        }

        public Criteria andFeeder1water2LessThanOrEqualTo(Double value) {
            addCriterion("feeder1Water2 <=", value, "feeder1water2");
            return (Criteria) this;
        }

        public Criteria andFeeder1water2In(List<Double> values) {
            addCriterion("feeder1Water2 in", values, "feeder1water2");
            return (Criteria) this;
        }

        public Criteria andFeeder1water2NotIn(List<Double> values) {
            addCriterion("feeder1Water2 not in", values, "feeder1water2");
            return (Criteria) this;
        }

        public Criteria andFeeder1water2Between(Double value1, Double value2) {
            addCriterion("feeder1Water2 between", value1, value2, "feeder1water2");
            return (Criteria) this;
        }

        public Criteria andFeeder1water2NotBetween(Double value1, Double value2) {
            addCriterion("feeder1Water2 not between", value1, value2, "feeder1water2");
            return (Criteria) this;
        }

        public Criteria andFeeder1start3IsNull() {
            addCriterion("feeder1Start3 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder1start3IsNotNull() {
            addCriterion("feeder1Start3 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder1start3EqualTo(String value) {
            addCriterion("feeder1Start3 =", value, "feeder1start3");
            return (Criteria) this;
        }

        public Criteria andFeeder1start3NotEqualTo(String value) {
            addCriterion("feeder1Start3 <>", value, "feeder1start3");
            return (Criteria) this;
        }

        public Criteria andFeeder1start3GreaterThan(String value) {
            addCriterion("feeder1Start3 >", value, "feeder1start3");
            return (Criteria) this;
        }

        public Criteria andFeeder1start3GreaterThanOrEqualTo(String value) {
            addCriterion("feeder1Start3 >=", value, "feeder1start3");
            return (Criteria) this;
        }

        public Criteria andFeeder1start3LessThan(String value) {
            addCriterion("feeder1Start3 <", value, "feeder1start3");
            return (Criteria) this;
        }

        public Criteria andFeeder1start3LessThanOrEqualTo(String value) {
            addCriterion("feeder1Start3 <=", value, "feeder1start3");
            return (Criteria) this;
        }

        public Criteria andFeeder1start3Like(String value) {
            addCriterion("feeder1Start3 like", value, "feeder1start3");
            return (Criteria) this;
        }

        public Criteria andFeeder1start3NotLike(String value) {
            addCriterion("feeder1Start3 not like", value, "feeder1start3");
            return (Criteria) this;
        }

        public Criteria andFeeder1start3In(List<String> values) {
            addCriterion("feeder1Start3 in", values, "feeder1start3");
            return (Criteria) this;
        }

        public Criteria andFeeder1start3NotIn(List<String> values) {
            addCriterion("feeder1Start3 not in", values, "feeder1start3");
            return (Criteria) this;
        }

        public Criteria andFeeder1start3Between(String value1, String value2) {
            addCriterion("feeder1Start3 between", value1, value2, "feeder1start3");
            return (Criteria) this;
        }

        public Criteria andFeeder1start3NotBetween(String value1, String value2) {
            addCriterion("feeder1Start3 not between", value1, value2, "feeder1start3");
            return (Criteria) this;
        }

        public Criteria andFeeder1end3IsNull() {
            addCriterion("feeder1End3 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder1end3IsNotNull() {
            addCriterion("feeder1End3 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder1end3EqualTo(String value) {
            addCriterion("feeder1End3 =", value, "feeder1end3");
            return (Criteria) this;
        }

        public Criteria andFeeder1end3NotEqualTo(String value) {
            addCriterion("feeder1End3 <>", value, "feeder1end3");
            return (Criteria) this;
        }

        public Criteria andFeeder1end3GreaterThan(String value) {
            addCriterion("feeder1End3 >", value, "feeder1end3");
            return (Criteria) this;
        }

        public Criteria andFeeder1end3GreaterThanOrEqualTo(String value) {
            addCriterion("feeder1End3 >=", value, "feeder1end3");
            return (Criteria) this;
        }

        public Criteria andFeeder1end3LessThan(String value) {
            addCriterion("feeder1End3 <", value, "feeder1end3");
            return (Criteria) this;
        }

        public Criteria andFeeder1end3LessThanOrEqualTo(String value) {
            addCriterion("feeder1End3 <=", value, "feeder1end3");
            return (Criteria) this;
        }

        public Criteria andFeeder1end3Like(String value) {
            addCriterion("feeder1End3 like", value, "feeder1end3");
            return (Criteria) this;
        }

        public Criteria andFeeder1end3NotLike(String value) {
            addCriterion("feeder1End3 not like", value, "feeder1end3");
            return (Criteria) this;
        }

        public Criteria andFeeder1end3In(List<String> values) {
            addCriterion("feeder1End3 in", values, "feeder1end3");
            return (Criteria) this;
        }

        public Criteria andFeeder1end3NotIn(List<String> values) {
            addCriterion("feeder1End3 not in", values, "feeder1end3");
            return (Criteria) this;
        }

        public Criteria andFeeder1end3Between(String value1, String value2) {
            addCriterion("feeder1End3 between", value1, value2, "feeder1end3");
            return (Criteria) this;
        }

        public Criteria andFeeder1end3NotBetween(String value1, String value2) {
            addCriterion("feeder1End3 not between", value1, value2, "feeder1end3");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed3IsNull() {
            addCriterion("feeder1Speed3 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed3IsNotNull() {
            addCriterion("feeder1Speed3 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed3EqualTo(Double value) {
            addCriterion("feeder1Speed3 =", value, "feeder1speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed3NotEqualTo(Double value) {
            addCriterion("feeder1Speed3 <>", value, "feeder1speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed3GreaterThan(Double value) {
            addCriterion("feeder1Speed3 >", value, "feeder1speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed3GreaterThanOrEqualTo(Double value) {
            addCriterion("feeder1Speed3 >=", value, "feeder1speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed3LessThan(Double value) {
            addCriterion("feeder1Speed3 <", value, "feeder1speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed3LessThanOrEqualTo(Double value) {
            addCriterion("feeder1Speed3 <=", value, "feeder1speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed3In(List<Double> values) {
            addCriterion("feeder1Speed3 in", values, "feeder1speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed3NotIn(List<Double> values) {
            addCriterion("feeder1Speed3 not in", values, "feeder1speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed3Between(Double value1, Double value2) {
            addCriterion("feeder1Speed3 between", value1, value2, "feeder1speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed3NotBetween(Double value1, Double value2) {
            addCriterion("feeder1Speed3 not between", value1, value2, "feeder1speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder1water3IsNull() {
            addCriterion("feeder1Water3 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder1water3IsNotNull() {
            addCriterion("feeder1Water3 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder1water3EqualTo(Double value) {
            addCriterion("feeder1Water3 =", value, "feeder1water3");
            return (Criteria) this;
        }

        public Criteria andFeeder1water3NotEqualTo(Double value) {
            addCriterion("feeder1Water3 <>", value, "feeder1water3");
            return (Criteria) this;
        }

        public Criteria andFeeder1water3GreaterThan(Double value) {
            addCriterion("feeder1Water3 >", value, "feeder1water3");
            return (Criteria) this;
        }

        public Criteria andFeeder1water3GreaterThanOrEqualTo(Double value) {
            addCriterion("feeder1Water3 >=", value, "feeder1water3");
            return (Criteria) this;
        }

        public Criteria andFeeder1water3LessThan(Double value) {
            addCriterion("feeder1Water3 <", value, "feeder1water3");
            return (Criteria) this;
        }

        public Criteria andFeeder1water3LessThanOrEqualTo(Double value) {
            addCriterion("feeder1Water3 <=", value, "feeder1water3");
            return (Criteria) this;
        }

        public Criteria andFeeder1water3In(List<Double> values) {
            addCriterion("feeder1Water3 in", values, "feeder1water3");
            return (Criteria) this;
        }

        public Criteria andFeeder1water3NotIn(List<Double> values) {
            addCriterion("feeder1Water3 not in", values, "feeder1water3");
            return (Criteria) this;
        }

        public Criteria andFeeder1water3Between(Double value1, Double value2) {
            addCriterion("feeder1Water3 between", value1, value2, "feeder1water3");
            return (Criteria) this;
        }

        public Criteria andFeeder1water3NotBetween(Double value1, Double value2) {
            addCriterion("feeder1Water3 not between", value1, value2, "feeder1water3");
            return (Criteria) this;
        }

        public Criteria andFeeder1start4IsNull() {
            addCriterion("feeder1Start4 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder1start4IsNotNull() {
            addCriterion("feeder1Start4 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder1start4EqualTo(String value) {
            addCriterion("feeder1Start4 =", value, "feeder1start4");
            return (Criteria) this;
        }

        public Criteria andFeeder1start4NotEqualTo(String value) {
            addCriterion("feeder1Start4 <>", value, "feeder1start4");
            return (Criteria) this;
        }

        public Criteria andFeeder1start4GreaterThan(String value) {
            addCriterion("feeder1Start4 >", value, "feeder1start4");
            return (Criteria) this;
        }

        public Criteria andFeeder1start4GreaterThanOrEqualTo(String value) {
            addCriterion("feeder1Start4 >=", value, "feeder1start4");
            return (Criteria) this;
        }

        public Criteria andFeeder1start4LessThan(String value) {
            addCriterion("feeder1Start4 <", value, "feeder1start4");
            return (Criteria) this;
        }

        public Criteria andFeeder1start4LessThanOrEqualTo(String value) {
            addCriterion("feeder1Start4 <=", value, "feeder1start4");
            return (Criteria) this;
        }

        public Criteria andFeeder1start4Like(String value) {
            addCriterion("feeder1Start4 like", value, "feeder1start4");
            return (Criteria) this;
        }

        public Criteria andFeeder1start4NotLike(String value) {
            addCriterion("feeder1Start4 not like", value, "feeder1start4");
            return (Criteria) this;
        }

        public Criteria andFeeder1start4In(List<String> values) {
            addCriterion("feeder1Start4 in", values, "feeder1start4");
            return (Criteria) this;
        }

        public Criteria andFeeder1start4NotIn(List<String> values) {
            addCriterion("feeder1Start4 not in", values, "feeder1start4");
            return (Criteria) this;
        }

        public Criteria andFeeder1start4Between(String value1, String value2) {
            addCriterion("feeder1Start4 between", value1, value2, "feeder1start4");
            return (Criteria) this;
        }

        public Criteria andFeeder1start4NotBetween(String value1, String value2) {
            addCriterion("feeder1Start4 not between", value1, value2, "feeder1start4");
            return (Criteria) this;
        }

        public Criteria andFeeder1end4IsNull() {
            addCriterion("feeder1End4 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder1end4IsNotNull() {
            addCriterion("feeder1End4 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder1end4EqualTo(String value) {
            addCriterion("feeder1End4 =", value, "feeder1end4");
            return (Criteria) this;
        }

        public Criteria andFeeder1end4NotEqualTo(String value) {
            addCriterion("feeder1End4 <>", value, "feeder1end4");
            return (Criteria) this;
        }

        public Criteria andFeeder1end4GreaterThan(String value) {
            addCriterion("feeder1End4 >", value, "feeder1end4");
            return (Criteria) this;
        }

        public Criteria andFeeder1end4GreaterThanOrEqualTo(String value) {
            addCriterion("feeder1End4 >=", value, "feeder1end4");
            return (Criteria) this;
        }

        public Criteria andFeeder1end4LessThan(String value) {
            addCriterion("feeder1End4 <", value, "feeder1end4");
            return (Criteria) this;
        }

        public Criteria andFeeder1end4LessThanOrEqualTo(String value) {
            addCriterion("feeder1End4 <=", value, "feeder1end4");
            return (Criteria) this;
        }

        public Criteria andFeeder1end4Like(String value) {
            addCriterion("feeder1End4 like", value, "feeder1end4");
            return (Criteria) this;
        }

        public Criteria andFeeder1end4NotLike(String value) {
            addCriterion("feeder1End4 not like", value, "feeder1end4");
            return (Criteria) this;
        }

        public Criteria andFeeder1end4In(List<String> values) {
            addCriterion("feeder1End4 in", values, "feeder1end4");
            return (Criteria) this;
        }

        public Criteria andFeeder1end4NotIn(List<String> values) {
            addCriterion("feeder1End4 not in", values, "feeder1end4");
            return (Criteria) this;
        }

        public Criteria andFeeder1end4Between(String value1, String value2) {
            addCriterion("feeder1End4 between", value1, value2, "feeder1end4");
            return (Criteria) this;
        }

        public Criteria andFeeder1end4NotBetween(String value1, String value2) {
            addCriterion("feeder1End4 not between", value1, value2, "feeder1end4");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed4IsNull() {
            addCriterion("feeder1Speed4 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed4IsNotNull() {
            addCriterion("feeder1Speed4 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed4EqualTo(Double value) {
            addCriterion("feeder1Speed4 =", value, "feeder1speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed4NotEqualTo(Double value) {
            addCriterion("feeder1Speed4 <>", value, "feeder1speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed4GreaterThan(Double value) {
            addCriterion("feeder1Speed4 >", value, "feeder1speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed4GreaterThanOrEqualTo(Double value) {
            addCriterion("feeder1Speed4 >=", value, "feeder1speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed4LessThan(Double value) {
            addCriterion("feeder1Speed4 <", value, "feeder1speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed4LessThanOrEqualTo(Double value) {
            addCriterion("feeder1Speed4 <=", value, "feeder1speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed4In(List<Double> values) {
            addCriterion("feeder1Speed4 in", values, "feeder1speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed4NotIn(List<Double> values) {
            addCriterion("feeder1Speed4 not in", values, "feeder1speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed4Between(Double value1, Double value2) {
            addCriterion("feeder1Speed4 between", value1, value2, "feeder1speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder1speed4NotBetween(Double value1, Double value2) {
            addCriterion("feeder1Speed4 not between", value1, value2, "feeder1speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder1water4IsNull() {
            addCriterion("feeder1Water4 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder1water4IsNotNull() {
            addCriterion("feeder1Water4 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder1water4EqualTo(Double value) {
            addCriterion("feeder1Water4 =", value, "feeder1water4");
            return (Criteria) this;
        }

        public Criteria andFeeder1water4NotEqualTo(Double value) {
            addCriterion("feeder1Water4 <>", value, "feeder1water4");
            return (Criteria) this;
        }

        public Criteria andFeeder1water4GreaterThan(Double value) {
            addCriterion("feeder1Water4 >", value, "feeder1water4");
            return (Criteria) this;
        }

        public Criteria andFeeder1water4GreaterThanOrEqualTo(Double value) {
            addCriterion("feeder1Water4 >=", value, "feeder1water4");
            return (Criteria) this;
        }

        public Criteria andFeeder1water4LessThan(Double value) {
            addCriterion("feeder1Water4 <", value, "feeder1water4");
            return (Criteria) this;
        }

        public Criteria andFeeder1water4LessThanOrEqualTo(Double value) {
            addCriterion("feeder1Water4 <=", value, "feeder1water4");
            return (Criteria) this;
        }

        public Criteria andFeeder1water4In(List<Double> values) {
            addCriterion("feeder1Water4 in", values, "feeder1water4");
            return (Criteria) this;
        }

        public Criteria andFeeder1water4NotIn(List<Double> values) {
            addCriterion("feeder1Water4 not in", values, "feeder1water4");
            return (Criteria) this;
        }

        public Criteria andFeeder1water4Between(Double value1, Double value2) {
            addCriterion("feeder1Water4 between", value1, value2, "feeder1water4");
            return (Criteria) this;
        }

        public Criteria andFeeder1water4NotBetween(Double value1, Double value2) {
            addCriterion("feeder1Water4 not between", value1, value2, "feeder1water4");
            return (Criteria) this;
        }

        public Criteria andFeeder2start1IsNull() {
            addCriterion("feeder2Start1 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder2start1IsNotNull() {
            addCriterion("feeder2Start1 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder2start1EqualTo(String value) {
            addCriterion("feeder2Start1 =", value, "feeder2start1");
            return (Criteria) this;
        }

        public Criteria andFeeder2start1NotEqualTo(String value) {
            addCriterion("feeder2Start1 <>", value, "feeder2start1");
            return (Criteria) this;
        }

        public Criteria andFeeder2start1GreaterThan(String value) {
            addCriterion("feeder2Start1 >", value, "feeder2start1");
            return (Criteria) this;
        }

        public Criteria andFeeder2start1GreaterThanOrEqualTo(String value) {
            addCriterion("feeder2Start1 >=", value, "feeder2start1");
            return (Criteria) this;
        }

        public Criteria andFeeder2start1LessThan(String value) {
            addCriterion("feeder2Start1 <", value, "feeder2start1");
            return (Criteria) this;
        }

        public Criteria andFeeder2start1LessThanOrEqualTo(String value) {
            addCriterion("feeder2Start1 <=", value, "feeder2start1");
            return (Criteria) this;
        }

        public Criteria andFeeder2start1Like(String value) {
            addCriterion("feeder2Start1 like", value, "feeder2start1");
            return (Criteria) this;
        }

        public Criteria andFeeder2start1NotLike(String value) {
            addCriterion("feeder2Start1 not like", value, "feeder2start1");
            return (Criteria) this;
        }

        public Criteria andFeeder2start1In(List<String> values) {
            addCriterion("feeder2Start1 in", values, "feeder2start1");
            return (Criteria) this;
        }

        public Criteria andFeeder2start1NotIn(List<String> values) {
            addCriterion("feeder2Start1 not in", values, "feeder2start1");
            return (Criteria) this;
        }

        public Criteria andFeeder2start1Between(String value1, String value2) {
            addCriterion("feeder2Start1 between", value1, value2, "feeder2start1");
            return (Criteria) this;
        }

        public Criteria andFeeder2start1NotBetween(String value1, String value2) {
            addCriterion("feeder2Start1 not between", value1, value2, "feeder2start1");
            return (Criteria) this;
        }

        public Criteria andFeeder2end1IsNull() {
            addCriterion("feeder2End1 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder2end1IsNotNull() {
            addCriterion("feeder2End1 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder2end1EqualTo(String value) {
            addCriterion("feeder2End1 =", value, "feeder2end1");
            return (Criteria) this;
        }

        public Criteria andFeeder2end1NotEqualTo(String value) {
            addCriterion("feeder2End1 <>", value, "feeder2end1");
            return (Criteria) this;
        }

        public Criteria andFeeder2end1GreaterThan(String value) {
            addCriterion("feeder2End1 >", value, "feeder2end1");
            return (Criteria) this;
        }

        public Criteria andFeeder2end1GreaterThanOrEqualTo(String value) {
            addCriterion("feeder2End1 >=", value, "feeder2end1");
            return (Criteria) this;
        }

        public Criteria andFeeder2end1LessThan(String value) {
            addCriterion("feeder2End1 <", value, "feeder2end1");
            return (Criteria) this;
        }

        public Criteria andFeeder2end1LessThanOrEqualTo(String value) {
            addCriterion("feeder2End1 <=", value, "feeder2end1");
            return (Criteria) this;
        }

        public Criteria andFeeder2end1Like(String value) {
            addCriterion("feeder2End1 like", value, "feeder2end1");
            return (Criteria) this;
        }

        public Criteria andFeeder2end1NotLike(String value) {
            addCriterion("feeder2End1 not like", value, "feeder2end1");
            return (Criteria) this;
        }

        public Criteria andFeeder2end1In(List<String> values) {
            addCriterion("feeder2End1 in", values, "feeder2end1");
            return (Criteria) this;
        }

        public Criteria andFeeder2end1NotIn(List<String> values) {
            addCriterion("feeder2End1 not in", values, "feeder2end1");
            return (Criteria) this;
        }

        public Criteria andFeeder2end1Between(String value1, String value2) {
            addCriterion("feeder2End1 between", value1, value2, "feeder2end1");
            return (Criteria) this;
        }

        public Criteria andFeeder2end1NotBetween(String value1, String value2) {
            addCriterion("feeder2End1 not between", value1, value2, "feeder2end1");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed1IsNull() {
            addCriterion("feeder2Speed1 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed1IsNotNull() {
            addCriterion("feeder2Speed1 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed1EqualTo(Double value) {
            addCriterion("feeder2Speed1 =", value, "feeder2speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed1NotEqualTo(Double value) {
            addCriterion("feeder2Speed1 <>", value, "feeder2speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed1GreaterThan(Double value) {
            addCriterion("feeder2Speed1 >", value, "feeder2speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed1GreaterThanOrEqualTo(Double value) {
            addCriterion("feeder2Speed1 >=", value, "feeder2speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed1LessThan(Double value) {
            addCriterion("feeder2Speed1 <", value, "feeder2speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed1LessThanOrEqualTo(Double value) {
            addCriterion("feeder2Speed1 <=", value, "feeder2speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed1In(List<Double> values) {
            addCriterion("feeder2Speed1 in", values, "feeder2speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed1NotIn(List<Double> values) {
            addCriterion("feeder2Speed1 not in", values, "feeder2speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed1Between(Double value1, Double value2) {
            addCriterion("feeder2Speed1 between", value1, value2, "feeder2speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed1NotBetween(Double value1, Double value2) {
            addCriterion("feeder2Speed1 not between", value1, value2, "feeder2speed1");
            return (Criteria) this;
        }

        public Criteria andFeeder2water1IsNull() {
            addCriterion("feeder2Water1 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder2water1IsNotNull() {
            addCriterion("feeder2Water1 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder2water1EqualTo(Double value) {
            addCriterion("feeder2Water1 =", value, "feeder2water1");
            return (Criteria) this;
        }

        public Criteria andFeeder2water1NotEqualTo(Double value) {
            addCriterion("feeder2Water1 <>", value, "feeder2water1");
            return (Criteria) this;
        }

        public Criteria andFeeder2water1GreaterThan(Double value) {
            addCriterion("feeder2Water1 >", value, "feeder2water1");
            return (Criteria) this;
        }

        public Criteria andFeeder2water1GreaterThanOrEqualTo(Double value) {
            addCriterion("feeder2Water1 >=", value, "feeder2water1");
            return (Criteria) this;
        }

        public Criteria andFeeder2water1LessThan(Double value) {
            addCriterion("feeder2Water1 <", value, "feeder2water1");
            return (Criteria) this;
        }

        public Criteria andFeeder2water1LessThanOrEqualTo(Double value) {
            addCriterion("feeder2Water1 <=", value, "feeder2water1");
            return (Criteria) this;
        }

        public Criteria andFeeder2water1In(List<Double> values) {
            addCriterion("feeder2Water1 in", values, "feeder2water1");
            return (Criteria) this;
        }

        public Criteria andFeeder2water1NotIn(List<Double> values) {
            addCriterion("feeder2Water1 not in", values, "feeder2water1");
            return (Criteria) this;
        }

        public Criteria andFeeder2water1Between(Double value1, Double value2) {
            addCriterion("feeder2Water1 between", value1, value2, "feeder2water1");
            return (Criteria) this;
        }

        public Criteria andFeeder2water1NotBetween(Double value1, Double value2) {
            addCriterion("feeder2Water1 not between", value1, value2, "feeder2water1");
            return (Criteria) this;
        }

        public Criteria andFeeder2start2IsNull() {
            addCriterion("feeder2Start2 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder2start2IsNotNull() {
            addCriterion("feeder2Start2 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder2start2EqualTo(String value) {
            addCriterion("feeder2Start2 =", value, "feeder2start2");
            return (Criteria) this;
        }

        public Criteria andFeeder2start2NotEqualTo(String value) {
            addCriterion("feeder2Start2 <>", value, "feeder2start2");
            return (Criteria) this;
        }

        public Criteria andFeeder2start2GreaterThan(String value) {
            addCriterion("feeder2Start2 >", value, "feeder2start2");
            return (Criteria) this;
        }

        public Criteria andFeeder2start2GreaterThanOrEqualTo(String value) {
            addCriterion("feeder2Start2 >=", value, "feeder2start2");
            return (Criteria) this;
        }

        public Criteria andFeeder2start2LessThan(String value) {
            addCriterion("feeder2Start2 <", value, "feeder2start2");
            return (Criteria) this;
        }

        public Criteria andFeeder2start2LessThanOrEqualTo(String value) {
            addCriterion("feeder2Start2 <=", value, "feeder2start2");
            return (Criteria) this;
        }

        public Criteria andFeeder2start2Like(String value) {
            addCriterion("feeder2Start2 like", value, "feeder2start2");
            return (Criteria) this;
        }

        public Criteria andFeeder2start2NotLike(String value) {
            addCriterion("feeder2Start2 not like", value, "feeder2start2");
            return (Criteria) this;
        }

        public Criteria andFeeder2start2In(List<String> values) {
            addCriterion("feeder2Start2 in", values, "feeder2start2");
            return (Criteria) this;
        }

        public Criteria andFeeder2start2NotIn(List<String> values) {
            addCriterion("feeder2Start2 not in", values, "feeder2start2");
            return (Criteria) this;
        }

        public Criteria andFeeder2start2Between(String value1, String value2) {
            addCriterion("feeder2Start2 between", value1, value2, "feeder2start2");
            return (Criteria) this;
        }

        public Criteria andFeeder2start2NotBetween(String value1, String value2) {
            addCriterion("feeder2Start2 not between", value1, value2, "feeder2start2");
            return (Criteria) this;
        }

        public Criteria andFeeder2end2IsNull() {
            addCriterion("feeder2End2 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder2end2IsNotNull() {
            addCriterion("feeder2End2 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder2end2EqualTo(String value) {
            addCriterion("feeder2End2 =", value, "feeder2end2");
            return (Criteria) this;
        }

        public Criteria andFeeder2end2NotEqualTo(String value) {
            addCriterion("feeder2End2 <>", value, "feeder2end2");
            return (Criteria) this;
        }

        public Criteria andFeeder2end2GreaterThan(String value) {
            addCriterion("feeder2End2 >", value, "feeder2end2");
            return (Criteria) this;
        }

        public Criteria andFeeder2end2GreaterThanOrEqualTo(String value) {
            addCriterion("feeder2End2 >=", value, "feeder2end2");
            return (Criteria) this;
        }

        public Criteria andFeeder2end2LessThan(String value) {
            addCriterion("feeder2End2 <", value, "feeder2end2");
            return (Criteria) this;
        }

        public Criteria andFeeder2end2LessThanOrEqualTo(String value) {
            addCriterion("feeder2End2 <=", value, "feeder2end2");
            return (Criteria) this;
        }

        public Criteria andFeeder2end2Like(String value) {
            addCriterion("feeder2End2 like", value, "feeder2end2");
            return (Criteria) this;
        }

        public Criteria andFeeder2end2NotLike(String value) {
            addCriterion("feeder2End2 not like", value, "feeder2end2");
            return (Criteria) this;
        }

        public Criteria andFeeder2end2In(List<String> values) {
            addCriterion("feeder2End2 in", values, "feeder2end2");
            return (Criteria) this;
        }

        public Criteria andFeeder2end2NotIn(List<String> values) {
            addCriterion("feeder2End2 not in", values, "feeder2end2");
            return (Criteria) this;
        }

        public Criteria andFeeder2end2Between(String value1, String value2) {
            addCriterion("feeder2End2 between", value1, value2, "feeder2end2");
            return (Criteria) this;
        }

        public Criteria andFeeder2end2NotBetween(String value1, String value2) {
            addCriterion("feeder2End2 not between", value1, value2, "feeder2end2");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed2IsNull() {
            addCriterion("feeder2Speed2 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed2IsNotNull() {
            addCriterion("feeder2Speed2 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed2EqualTo(Double value) {
            addCriterion("feeder2Speed2 =", value, "feeder2speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed2NotEqualTo(Double value) {
            addCriterion("feeder2Speed2 <>", value, "feeder2speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed2GreaterThan(Double value) {
            addCriterion("feeder2Speed2 >", value, "feeder2speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed2GreaterThanOrEqualTo(Double value) {
            addCriterion("feeder2Speed2 >=", value, "feeder2speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed2LessThan(Double value) {
            addCriterion("feeder2Speed2 <", value, "feeder2speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed2LessThanOrEqualTo(Double value) {
            addCriterion("feeder2Speed2 <=", value, "feeder2speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed2In(List<Double> values) {
            addCriterion("feeder2Speed2 in", values, "feeder2speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed2NotIn(List<Double> values) {
            addCriterion("feeder2Speed2 not in", values, "feeder2speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed2Between(Double value1, Double value2) {
            addCriterion("feeder2Speed2 between", value1, value2, "feeder2speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed2NotBetween(Double value1, Double value2) {
            addCriterion("feeder2Speed2 not between", value1, value2, "feeder2speed2");
            return (Criteria) this;
        }

        public Criteria andFeeder2water2IsNull() {
            addCriterion("feeder2Water2 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder2water2IsNotNull() {
            addCriterion("feeder2Water2 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder2water2EqualTo(Double value) {
            addCriterion("feeder2Water2 =", value, "feeder2water2");
            return (Criteria) this;
        }

        public Criteria andFeeder2water2NotEqualTo(Double value) {
            addCriterion("feeder2Water2 <>", value, "feeder2water2");
            return (Criteria) this;
        }

        public Criteria andFeeder2water2GreaterThan(Double value) {
            addCriterion("feeder2Water2 >", value, "feeder2water2");
            return (Criteria) this;
        }

        public Criteria andFeeder2water2GreaterThanOrEqualTo(Double value) {
            addCriterion("feeder2Water2 >=", value, "feeder2water2");
            return (Criteria) this;
        }

        public Criteria andFeeder2water2LessThan(Double value) {
            addCriterion("feeder2Water2 <", value, "feeder2water2");
            return (Criteria) this;
        }

        public Criteria andFeeder2water2LessThanOrEqualTo(Double value) {
            addCriterion("feeder2Water2 <=", value, "feeder2water2");
            return (Criteria) this;
        }

        public Criteria andFeeder2water2In(List<Double> values) {
            addCriterion("feeder2Water2 in", values, "feeder2water2");
            return (Criteria) this;
        }

        public Criteria andFeeder2water2NotIn(List<Double> values) {
            addCriterion("feeder2Water2 not in", values, "feeder2water2");
            return (Criteria) this;
        }

        public Criteria andFeeder2water2Between(Double value1, Double value2) {
            addCriterion("feeder2Water2 between", value1, value2, "feeder2water2");
            return (Criteria) this;
        }

        public Criteria andFeeder2water2NotBetween(Double value1, Double value2) {
            addCriterion("feeder2Water2 not between", value1, value2, "feeder2water2");
            return (Criteria) this;
        }

        public Criteria andFeeder2start3IsNull() {
            addCriterion("feeder2Start3 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder2start3IsNotNull() {
            addCriterion("feeder2Start3 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder2start3EqualTo(String value) {
            addCriterion("feeder2Start3 =", value, "feeder2start3");
            return (Criteria) this;
        }

        public Criteria andFeeder2start3NotEqualTo(String value) {
            addCriterion("feeder2Start3 <>", value, "feeder2start3");
            return (Criteria) this;
        }

        public Criteria andFeeder2start3GreaterThan(String value) {
            addCriterion("feeder2Start3 >", value, "feeder2start3");
            return (Criteria) this;
        }

        public Criteria andFeeder2start3GreaterThanOrEqualTo(String value) {
            addCriterion("feeder2Start3 >=", value, "feeder2start3");
            return (Criteria) this;
        }

        public Criteria andFeeder2start3LessThan(String value) {
            addCriterion("feeder2Start3 <", value, "feeder2start3");
            return (Criteria) this;
        }

        public Criteria andFeeder2start3LessThanOrEqualTo(String value) {
            addCriterion("feeder2Start3 <=", value, "feeder2start3");
            return (Criteria) this;
        }

        public Criteria andFeeder2start3Like(String value) {
            addCriterion("feeder2Start3 like", value, "feeder2start3");
            return (Criteria) this;
        }

        public Criteria andFeeder2start3NotLike(String value) {
            addCriterion("feeder2Start3 not like", value, "feeder2start3");
            return (Criteria) this;
        }

        public Criteria andFeeder2start3In(List<String> values) {
            addCriterion("feeder2Start3 in", values, "feeder2start3");
            return (Criteria) this;
        }

        public Criteria andFeeder2start3NotIn(List<String> values) {
            addCriterion("feeder2Start3 not in", values, "feeder2start3");
            return (Criteria) this;
        }

        public Criteria andFeeder2start3Between(String value1, String value2) {
            addCriterion("feeder2Start3 between", value1, value2, "feeder2start3");
            return (Criteria) this;
        }

        public Criteria andFeeder2start3NotBetween(String value1, String value2) {
            addCriterion("feeder2Start3 not between", value1, value2, "feeder2start3");
            return (Criteria) this;
        }

        public Criteria andFeeder2end3IsNull() {
            addCriterion("feeder2End3 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder2end3IsNotNull() {
            addCriterion("feeder2End3 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder2end3EqualTo(String value) {
            addCriterion("feeder2End3 =", value, "feeder2end3");
            return (Criteria) this;
        }

        public Criteria andFeeder2end3NotEqualTo(String value) {
            addCriterion("feeder2End3 <>", value, "feeder2end3");
            return (Criteria) this;
        }

        public Criteria andFeeder2end3GreaterThan(String value) {
            addCriterion("feeder2End3 >", value, "feeder2end3");
            return (Criteria) this;
        }

        public Criteria andFeeder2end3GreaterThanOrEqualTo(String value) {
            addCriterion("feeder2End3 >=", value, "feeder2end3");
            return (Criteria) this;
        }

        public Criteria andFeeder2end3LessThan(String value) {
            addCriterion("feeder2End3 <", value, "feeder2end3");
            return (Criteria) this;
        }

        public Criteria andFeeder2end3LessThanOrEqualTo(String value) {
            addCriterion("feeder2End3 <=", value, "feeder2end3");
            return (Criteria) this;
        }

        public Criteria andFeeder2end3Like(String value) {
            addCriterion("feeder2End3 like", value, "feeder2end3");
            return (Criteria) this;
        }

        public Criteria andFeeder2end3NotLike(String value) {
            addCriterion("feeder2End3 not like", value, "feeder2end3");
            return (Criteria) this;
        }

        public Criteria andFeeder2end3In(List<String> values) {
            addCriterion("feeder2End3 in", values, "feeder2end3");
            return (Criteria) this;
        }

        public Criteria andFeeder2end3NotIn(List<String> values) {
            addCriterion("feeder2End3 not in", values, "feeder2end3");
            return (Criteria) this;
        }

        public Criteria andFeeder2end3Between(String value1, String value2) {
            addCriterion("feeder2End3 between", value1, value2, "feeder2end3");
            return (Criteria) this;
        }

        public Criteria andFeeder2end3NotBetween(String value1, String value2) {
            addCriterion("feeder2End3 not between", value1, value2, "feeder2end3");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed3IsNull() {
            addCriterion("feeder2Speed3 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed3IsNotNull() {
            addCriterion("feeder2Speed3 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed3EqualTo(Double value) {
            addCriterion("feeder2Speed3 =", value, "feeder2speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed3NotEqualTo(Double value) {
            addCriterion("feeder2Speed3 <>", value, "feeder2speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed3GreaterThan(Double value) {
            addCriterion("feeder2Speed3 >", value, "feeder2speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed3GreaterThanOrEqualTo(Double value) {
            addCriterion("feeder2Speed3 >=", value, "feeder2speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed3LessThan(Double value) {
            addCriterion("feeder2Speed3 <", value, "feeder2speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed3LessThanOrEqualTo(Double value) {
            addCriterion("feeder2Speed3 <=", value, "feeder2speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed3In(List<Double> values) {
            addCriterion("feeder2Speed3 in", values, "feeder2speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed3NotIn(List<Double> values) {
            addCriterion("feeder2Speed3 not in", values, "feeder2speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed3Between(Double value1, Double value2) {
            addCriterion("feeder2Speed3 between", value1, value2, "feeder2speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed3NotBetween(Double value1, Double value2) {
            addCriterion("feeder2Speed3 not between", value1, value2, "feeder2speed3");
            return (Criteria) this;
        }

        public Criteria andFeeder2water3IsNull() {
            addCriterion("feeder2Water3 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder2water3IsNotNull() {
            addCriterion("feeder2Water3 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder2water3EqualTo(Double value) {
            addCriterion("feeder2Water3 =", value, "feeder2water3");
            return (Criteria) this;
        }

        public Criteria andFeeder2water3NotEqualTo(Double value) {
            addCriterion("feeder2Water3 <>", value, "feeder2water3");
            return (Criteria) this;
        }

        public Criteria andFeeder2water3GreaterThan(Double value) {
            addCriterion("feeder2Water3 >", value, "feeder2water3");
            return (Criteria) this;
        }

        public Criteria andFeeder2water3GreaterThanOrEqualTo(Double value) {
            addCriterion("feeder2Water3 >=", value, "feeder2water3");
            return (Criteria) this;
        }

        public Criteria andFeeder2water3LessThan(Double value) {
            addCriterion("feeder2Water3 <", value, "feeder2water3");
            return (Criteria) this;
        }

        public Criteria andFeeder2water3LessThanOrEqualTo(Double value) {
            addCriterion("feeder2Water3 <=", value, "feeder2water3");
            return (Criteria) this;
        }

        public Criteria andFeeder2water3In(List<Double> values) {
            addCriterion("feeder2Water3 in", values, "feeder2water3");
            return (Criteria) this;
        }

        public Criteria andFeeder2water3NotIn(List<Double> values) {
            addCriterion("feeder2Water3 not in", values, "feeder2water3");
            return (Criteria) this;
        }

        public Criteria andFeeder2water3Between(Double value1, Double value2) {
            addCriterion("feeder2Water3 between", value1, value2, "feeder2water3");
            return (Criteria) this;
        }

        public Criteria andFeeder2water3NotBetween(Double value1, Double value2) {
            addCriterion("feeder2Water3 not between", value1, value2, "feeder2water3");
            return (Criteria) this;
        }

        public Criteria andFeeder2start4IsNull() {
            addCriterion("feeder2Start4 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder2start4IsNotNull() {
            addCriterion("feeder2Start4 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder2start4EqualTo(String value) {
            addCriterion("feeder2Start4 =", value, "feeder2start4");
            return (Criteria) this;
        }

        public Criteria andFeeder2start4NotEqualTo(String value) {
            addCriterion("feeder2Start4 <>", value, "feeder2start4");
            return (Criteria) this;
        }

        public Criteria andFeeder2start4GreaterThan(String value) {
            addCriterion("feeder2Start4 >", value, "feeder2start4");
            return (Criteria) this;
        }

        public Criteria andFeeder2start4GreaterThanOrEqualTo(String value) {
            addCriterion("feeder2Start4 >=", value, "feeder2start4");
            return (Criteria) this;
        }

        public Criteria andFeeder2start4LessThan(String value) {
            addCriterion("feeder2Start4 <", value, "feeder2start4");
            return (Criteria) this;
        }

        public Criteria andFeeder2start4LessThanOrEqualTo(String value) {
            addCriterion("feeder2Start4 <=", value, "feeder2start4");
            return (Criteria) this;
        }

        public Criteria andFeeder2start4Like(String value) {
            addCriterion("feeder2Start4 like", value, "feeder2start4");
            return (Criteria) this;
        }

        public Criteria andFeeder2start4NotLike(String value) {
            addCriterion("feeder2Start4 not like", value, "feeder2start4");
            return (Criteria) this;
        }

        public Criteria andFeeder2start4In(List<String> values) {
            addCriterion("feeder2Start4 in", values, "feeder2start4");
            return (Criteria) this;
        }

        public Criteria andFeeder2start4NotIn(List<String> values) {
            addCriterion("feeder2Start4 not in", values, "feeder2start4");
            return (Criteria) this;
        }

        public Criteria andFeeder2start4Between(String value1, String value2) {
            addCriterion("feeder2Start4 between", value1, value2, "feeder2start4");
            return (Criteria) this;
        }

        public Criteria andFeeder2start4NotBetween(String value1, String value2) {
            addCriterion("feeder2Start4 not between", value1, value2, "feeder2start4");
            return (Criteria) this;
        }

        public Criteria andFeeder2end4IsNull() {
            addCriterion("feeder2End4 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder2end4IsNotNull() {
            addCriterion("feeder2End4 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder2end4EqualTo(String value) {
            addCriterion("feeder2End4 =", value, "feeder2end4");
            return (Criteria) this;
        }

        public Criteria andFeeder2end4NotEqualTo(String value) {
            addCriterion("feeder2End4 <>", value, "feeder2end4");
            return (Criteria) this;
        }

        public Criteria andFeeder2end4GreaterThan(String value) {
            addCriterion("feeder2End4 >", value, "feeder2end4");
            return (Criteria) this;
        }

        public Criteria andFeeder2end4GreaterThanOrEqualTo(String value) {
            addCriterion("feeder2End4 >=", value, "feeder2end4");
            return (Criteria) this;
        }

        public Criteria andFeeder2end4LessThan(String value) {
            addCriterion("feeder2End4 <", value, "feeder2end4");
            return (Criteria) this;
        }

        public Criteria andFeeder2end4LessThanOrEqualTo(String value) {
            addCriterion("feeder2End4 <=", value, "feeder2end4");
            return (Criteria) this;
        }

        public Criteria andFeeder2end4Like(String value) {
            addCriterion("feeder2End4 like", value, "feeder2end4");
            return (Criteria) this;
        }

        public Criteria andFeeder2end4NotLike(String value) {
            addCriterion("feeder2End4 not like", value, "feeder2end4");
            return (Criteria) this;
        }

        public Criteria andFeeder2end4In(List<String> values) {
            addCriterion("feeder2End4 in", values, "feeder2end4");
            return (Criteria) this;
        }

        public Criteria andFeeder2end4NotIn(List<String> values) {
            addCriterion("feeder2End4 not in", values, "feeder2end4");
            return (Criteria) this;
        }

        public Criteria andFeeder2end4Between(String value1, String value2) {
            addCriterion("feeder2End4 between", value1, value2, "feeder2end4");
            return (Criteria) this;
        }

        public Criteria andFeeder2end4NotBetween(String value1, String value2) {
            addCriterion("feeder2End4 not between", value1, value2, "feeder2end4");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed4IsNull() {
            addCriterion("feeder2Speed4 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed4IsNotNull() {
            addCriterion("feeder2Speed4 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed4EqualTo(Double value) {
            addCriterion("feeder2Speed4 =", value, "feeder2speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed4NotEqualTo(Double value) {
            addCriterion("feeder2Speed4 <>", value, "feeder2speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed4GreaterThan(Double value) {
            addCriterion("feeder2Speed4 >", value, "feeder2speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed4GreaterThanOrEqualTo(Double value) {
            addCriterion("feeder2Speed4 >=", value, "feeder2speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed4LessThan(Double value) {
            addCriterion("feeder2Speed4 <", value, "feeder2speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed4LessThanOrEqualTo(Double value) {
            addCriterion("feeder2Speed4 <=", value, "feeder2speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed4In(List<Double> values) {
            addCriterion("feeder2Speed4 in", values, "feeder2speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed4NotIn(List<Double> values) {
            addCriterion("feeder2Speed4 not in", values, "feeder2speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed4Between(Double value1, Double value2) {
            addCriterion("feeder2Speed4 between", value1, value2, "feeder2speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder2speed4NotBetween(Double value1, Double value2) {
            addCriterion("feeder2Speed4 not between", value1, value2, "feeder2speed4");
            return (Criteria) this;
        }

        public Criteria andFeeder2water4IsNull() {
            addCriterion("feeder2Water4 is null");
            return (Criteria) this;
        }

        public Criteria andFeeder2water4IsNotNull() {
            addCriterion("feeder2Water4 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeder2water4EqualTo(Double value) {
            addCriterion("feeder2Water4 =", value, "feeder2water4");
            return (Criteria) this;
        }

        public Criteria andFeeder2water4NotEqualTo(Double value) {
            addCriterion("feeder2Water4 <>", value, "feeder2water4");
            return (Criteria) this;
        }

        public Criteria andFeeder2water4GreaterThan(Double value) {
            addCriterion("feeder2Water4 >", value, "feeder2water4");
            return (Criteria) this;
        }

        public Criteria andFeeder2water4GreaterThanOrEqualTo(Double value) {
            addCriterion("feeder2Water4 >=", value, "feeder2water4");
            return (Criteria) this;
        }

        public Criteria andFeeder2water4LessThan(Double value) {
            addCriterion("feeder2Water4 <", value, "feeder2water4");
            return (Criteria) this;
        }

        public Criteria andFeeder2water4LessThanOrEqualTo(Double value) {
            addCriterion("feeder2Water4 <=", value, "feeder2water4");
            return (Criteria) this;
        }

        public Criteria andFeeder2water4In(List<Double> values) {
            addCriterion("feeder2Water4 in", values, "feeder2water4");
            return (Criteria) this;
        }

        public Criteria andFeeder2water4NotIn(List<Double> values) {
            addCriterion("feeder2Water4 not in", values, "feeder2water4");
            return (Criteria) this;
        }

        public Criteria andFeeder2water4Between(Double value1, Double value2) {
            addCriterion("feeder2Water4 between", value1, value2, "feeder2water4");
            return (Criteria) this;
        }

        public Criteria andFeeder2water4NotBetween(Double value1, Double value2) {
            addCriterion("feeder2Water4 not between", value1, value2, "feeder2water4");
            return (Criteria) this;
        }

        public Criteria andTailingpondtimeIsNull() {
            addCriterion("tailingPondTime is null");
            return (Criteria) this;
        }

        public Criteria andTailingpondtimeIsNotNull() {
            addCriterion("tailingPondTime is not null");
            return (Criteria) this;
        }

        public Criteria andTailingpondtimeEqualTo(Double value) {
            addCriterion("tailingPondTime =", value, "tailingpondtime");
            return (Criteria) this;
        }

        public Criteria andTailingpondtimeNotEqualTo(Double value) {
            addCriterion("tailingPondTime <>", value, "tailingpondtime");
            return (Criteria) this;
        }

        public Criteria andTailingpondtimeGreaterThan(Double value) {
            addCriterion("tailingPondTime >", value, "tailingpondtime");
            return (Criteria) this;
        }

        public Criteria andTailingpondtimeGreaterThanOrEqualTo(Double value) {
            addCriterion("tailingPondTime >=", value, "tailingpondtime");
            return (Criteria) this;
        }

        public Criteria andTailingpondtimeLessThan(Double value) {
            addCriterion("tailingPondTime <", value, "tailingpondtime");
            return (Criteria) this;
        }

        public Criteria andTailingpondtimeLessThanOrEqualTo(Double value) {
            addCriterion("tailingPondTime <=", value, "tailingpondtime");
            return (Criteria) this;
        }

        public Criteria andTailingpondtimeIn(List<Double> values) {
            addCriterion("tailingPondTime in", values, "tailingpondtime");
            return (Criteria) this;
        }

        public Criteria andTailingpondtimeNotIn(List<Double> values) {
            addCriterion("tailingPondTime not in", values, "tailingpondtime");
            return (Criteria) this;
        }

        public Criteria andTailingpondtimeBetween(Double value1, Double value2) {
            addCriterion("tailingPondTime between", value1, value2, "tailingpondtime");
            return (Criteria) this;
        }

        public Criteria andTailingpondtimeNotBetween(Double value1, Double value2) {
            addCriterion("tailingPondTime not between", value1, value2, "tailingpondtime");
            return (Criteria) this;
        }

        public Criteria andLimepump1runtimeIsNull() {
            addCriterion("limePump1RunTime is null");
            return (Criteria) this;
        }

        public Criteria andLimepump1runtimeIsNotNull() {
            addCriterion("limePump1RunTime is not null");
            return (Criteria) this;
        }

        public Criteria andLimepump1runtimeEqualTo(Double value) {
            addCriterion("limePump1RunTime =", value, "limepump1runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump1runtimeNotEqualTo(Double value) {
            addCriterion("limePump1RunTime <>", value, "limepump1runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump1runtimeGreaterThan(Double value) {
            addCriterion("limePump1RunTime >", value, "limepump1runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump1runtimeGreaterThanOrEqualTo(Double value) {
            addCriterion("limePump1RunTime >=", value, "limepump1runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump1runtimeLessThan(Double value) {
            addCriterion("limePump1RunTime <", value, "limepump1runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump1runtimeLessThanOrEqualTo(Double value) {
            addCriterion("limePump1RunTime <=", value, "limepump1runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump1runtimeIn(List<Double> values) {
            addCriterion("limePump1RunTime in", values, "limepump1runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump1runtimeNotIn(List<Double> values) {
            addCriterion("limePump1RunTime not in", values, "limepump1runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump1runtimeBetween(Double value1, Double value2) {
            addCriterion("limePump1RunTime between", value1, value2, "limepump1runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump1runtimeNotBetween(Double value1, Double value2) {
            addCriterion("limePump1RunTime not between", value1, value2, "limepump1runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump2runtimeIsNull() {
            addCriterion("limePump2RunTime is null");
            return (Criteria) this;
        }

        public Criteria andLimepump2runtimeIsNotNull() {
            addCriterion("limePump2RunTime is not null");
            return (Criteria) this;
        }

        public Criteria andLimepump2runtimeEqualTo(Double value) {
            addCriterion("limePump2RunTime =", value, "limepump2runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump2runtimeNotEqualTo(Double value) {
            addCriterion("limePump2RunTime <>", value, "limepump2runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump2runtimeGreaterThan(Double value) {
            addCriterion("limePump2RunTime >", value, "limepump2runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump2runtimeGreaterThanOrEqualTo(Double value) {
            addCriterion("limePump2RunTime >=", value, "limepump2runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump2runtimeLessThan(Double value) {
            addCriterion("limePump2RunTime <", value, "limepump2runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump2runtimeLessThanOrEqualTo(Double value) {
            addCriterion("limePump2RunTime <=", value, "limepump2runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump2runtimeIn(List<Double> values) {
            addCriterion("limePump2RunTime in", values, "limepump2runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump2runtimeNotIn(List<Double> values) {
            addCriterion("limePump2RunTime not in", values, "limepump2runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump2runtimeBetween(Double value1, Double value2) {
            addCriterion("limePump2RunTime between", value1, value2, "limepump2runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump2runtimeNotBetween(Double value1, Double value2) {
            addCriterion("limePump2RunTime not between", value1, value2, "limepump2runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump3runtimeIsNull() {
            addCriterion("limePump3RunTime is null");
            return (Criteria) this;
        }

        public Criteria andLimepump3runtimeIsNotNull() {
            addCriterion("limePump3RunTime is not null");
            return (Criteria) this;
        }

        public Criteria andLimepump3runtimeEqualTo(Double value) {
            addCriterion("limePump3RunTime =", value, "limepump3runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump3runtimeNotEqualTo(Double value) {
            addCriterion("limePump3RunTime <>", value, "limepump3runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump3runtimeGreaterThan(Double value) {
            addCriterion("limePump3RunTime >", value, "limepump3runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump3runtimeGreaterThanOrEqualTo(Double value) {
            addCriterion("limePump3RunTime >=", value, "limepump3runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump3runtimeLessThan(Double value) {
            addCriterion("limePump3RunTime <", value, "limepump3runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump3runtimeLessThanOrEqualTo(Double value) {
            addCriterion("limePump3RunTime <=", value, "limepump3runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump3runtimeIn(List<Double> values) {
            addCriterion("limePump3RunTime in", values, "limepump3runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump3runtimeNotIn(List<Double> values) {
            addCriterion("limePump3RunTime not in", values, "limepump3runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump3runtimeBetween(Double value1, Double value2) {
            addCriterion("limePump3RunTime between", value1, value2, "limepump3runtime");
            return (Criteria) this;
        }

        public Criteria andLimepump3runtimeNotBetween(Double value1, Double value2) {
            addCriterion("limePump3RunTime not between", value1, value2, "limepump3runtime");
            return (Criteria) this;
        }

        public Criteria andSewageregulationtimeIsNull() {
            addCriterion("sewageRegulationTime is null");
            return (Criteria) this;
        }

        public Criteria andSewageregulationtimeIsNotNull() {
            addCriterion("sewageRegulationTime is not null");
            return (Criteria) this;
        }

        public Criteria andSewageregulationtimeEqualTo(Double value) {
            addCriterion("sewageRegulationTime =", value, "sewageregulationtime");
            return (Criteria) this;
        }

        public Criteria andSewageregulationtimeNotEqualTo(Double value) {
            addCriterion("sewageRegulationTime <>", value, "sewageregulationtime");
            return (Criteria) this;
        }

        public Criteria andSewageregulationtimeGreaterThan(Double value) {
            addCriterion("sewageRegulationTime >", value, "sewageregulationtime");
            return (Criteria) this;
        }

        public Criteria andSewageregulationtimeGreaterThanOrEqualTo(Double value) {
            addCriterion("sewageRegulationTime >=", value, "sewageregulationtime");
            return (Criteria) this;
        }

        public Criteria andSewageregulationtimeLessThan(Double value) {
            addCriterion("sewageRegulationTime <", value, "sewageregulationtime");
            return (Criteria) this;
        }

        public Criteria andSewageregulationtimeLessThanOrEqualTo(Double value) {
            addCriterion("sewageRegulationTime <=", value, "sewageregulationtime");
            return (Criteria) this;
        }

        public Criteria andSewageregulationtimeIn(List<Double> values) {
            addCriterion("sewageRegulationTime in", values, "sewageregulationtime");
            return (Criteria) this;
        }

        public Criteria andSewageregulationtimeNotIn(List<Double> values) {
            addCriterion("sewageRegulationTime not in", values, "sewageregulationtime");
            return (Criteria) this;
        }

        public Criteria andSewageregulationtimeBetween(Double value1, Double value2) {
            addCriterion("sewageRegulationTime between", value1, value2, "sewageregulationtime");
            return (Criteria) this;
        }

        public Criteria andSewageregulationtimeNotBetween(Double value1, Double value2) {
            addCriterion("sewageRegulationTime not between", value1, value2, "sewageregulationtime");
            return (Criteria) this;
        }

        public Criteria andEquipmentlubricationIsNull() {
            addCriterion("equipmentLubrication is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentlubricationIsNotNull() {
            addCriterion("equipmentLubrication is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentlubricationEqualTo(String value) {
            addCriterion("equipmentLubrication =", value, "equipmentlubrication");
            return (Criteria) this;
        }

        public Criteria andEquipmentlubricationNotEqualTo(String value) {
            addCriterion("equipmentLubrication <>", value, "equipmentlubrication");
            return (Criteria) this;
        }

        public Criteria andEquipmentlubricationGreaterThan(String value) {
            addCriterion("equipmentLubrication >", value, "equipmentlubrication");
            return (Criteria) this;
        }

        public Criteria andEquipmentlubricationGreaterThanOrEqualTo(String value) {
            addCriterion("equipmentLubrication >=", value, "equipmentlubrication");
            return (Criteria) this;
        }

        public Criteria andEquipmentlubricationLessThan(String value) {
            addCriterion("equipmentLubrication <", value, "equipmentlubrication");
            return (Criteria) this;
        }

        public Criteria andEquipmentlubricationLessThanOrEqualTo(String value) {
            addCriterion("equipmentLubrication <=", value, "equipmentlubrication");
            return (Criteria) this;
        }

        public Criteria andEquipmentlubricationLike(String value) {
            addCriterion("equipmentLubrication like", value, "equipmentlubrication");
            return (Criteria) this;
        }

        public Criteria andEquipmentlubricationNotLike(String value) {
            addCriterion("equipmentLubrication not like", value, "equipmentlubrication");
            return (Criteria) this;
        }

        public Criteria andEquipmentlubricationIn(List<String> values) {
            addCriterion("equipmentLubrication in", values, "equipmentlubrication");
            return (Criteria) this;
        }

        public Criteria andEquipmentlubricationNotIn(List<String> values) {
            addCriterion("equipmentLubrication not in", values, "equipmentlubrication");
            return (Criteria) this;
        }

        public Criteria andEquipmentlubricationBetween(String value1, String value2) {
            addCriterion("equipmentLubrication between", value1, value2, "equipmentlubrication");
            return (Criteria) this;
        }

        public Criteria andEquipmentlubricationNotBetween(String value1, String value2) {
            addCriterion("equipmentLubrication not between", value1, value2, "equipmentlubrication");
            return (Criteria) this;
        }

        public Criteria andMachinesanitationIsNull() {
            addCriterion("machineSanitation is null");
            return (Criteria) this;
        }

        public Criteria andMachinesanitationIsNotNull() {
            addCriterion("machineSanitation is not null");
            return (Criteria) this;
        }

        public Criteria andMachinesanitationEqualTo(String value) {
            addCriterion("machineSanitation =", value, "machinesanitation");
            return (Criteria) this;
        }

        public Criteria andMachinesanitationNotEqualTo(String value) {
            addCriterion("machineSanitation <>", value, "machinesanitation");
            return (Criteria) this;
        }

        public Criteria andMachinesanitationGreaterThan(String value) {
            addCriterion("machineSanitation >", value, "machinesanitation");
            return (Criteria) this;
        }

        public Criteria andMachinesanitationGreaterThanOrEqualTo(String value) {
            addCriterion("machineSanitation >=", value, "machinesanitation");
            return (Criteria) this;
        }

        public Criteria andMachinesanitationLessThan(String value) {
            addCriterion("machineSanitation <", value, "machinesanitation");
            return (Criteria) this;
        }

        public Criteria andMachinesanitationLessThanOrEqualTo(String value) {
            addCriterion("machineSanitation <=", value, "machinesanitation");
            return (Criteria) this;
        }

        public Criteria andMachinesanitationLike(String value) {
            addCriterion("machineSanitation like", value, "machinesanitation");
            return (Criteria) this;
        }

        public Criteria andMachinesanitationNotLike(String value) {
            addCriterion("machineSanitation not like", value, "machinesanitation");
            return (Criteria) this;
        }

        public Criteria andMachinesanitationIn(List<String> values) {
            addCriterion("machineSanitation in", values, "machinesanitation");
            return (Criteria) this;
        }

        public Criteria andMachinesanitationNotIn(List<String> values) {
            addCriterion("machineSanitation not in", values, "machinesanitation");
            return (Criteria) this;
        }

        public Criteria andMachinesanitationBetween(String value1, String value2) {
            addCriterion("machineSanitation between", value1, value2, "machinesanitation");
            return (Criteria) this;
        }

        public Criteria andMachinesanitationNotBetween(String value1, String value2) {
            addCriterion("machineSanitation not between", value1, value2, "machinesanitation");
            return (Criteria) this;
        }

        public Criteria andChecktime1IsNull() {
            addCriterion("checkTime1 is null");
            return (Criteria) this;
        }

        public Criteria andChecktime1IsNotNull() {
            addCriterion("checkTime1 is not null");
            return (Criteria) this;
        }

        public Criteria andChecktime1EqualTo(String value) {
            addCriterion("checkTime1 =", value, "checktime1");
            return (Criteria) this;
        }

        public Criteria andChecktime1NotEqualTo(String value) {
            addCriterion("checkTime1 <>", value, "checktime1");
            return (Criteria) this;
        }

        public Criteria andChecktime1GreaterThan(String value) {
            addCriterion("checkTime1 >", value, "checktime1");
            return (Criteria) this;
        }

        public Criteria andChecktime1GreaterThanOrEqualTo(String value) {
            addCriterion("checkTime1 >=", value, "checktime1");
            return (Criteria) this;
        }

        public Criteria andChecktime1LessThan(String value) {
            addCriterion("checkTime1 <", value, "checktime1");
            return (Criteria) this;
        }

        public Criteria andChecktime1LessThanOrEqualTo(String value) {
            addCriterion("checkTime1 <=", value, "checktime1");
            return (Criteria) this;
        }

        public Criteria andChecktime1Like(String value) {
            addCriterion("checkTime1 like", value, "checktime1");
            return (Criteria) this;
        }

        public Criteria andChecktime1NotLike(String value) {
            addCriterion("checkTime1 not like", value, "checktime1");
            return (Criteria) this;
        }

        public Criteria andChecktime1In(List<String> values) {
            addCriterion("checkTime1 in", values, "checktime1");
            return (Criteria) this;
        }

        public Criteria andChecktime1NotIn(List<String> values) {
            addCriterion("checkTime1 not in", values, "checktime1");
            return (Criteria) this;
        }

        public Criteria andChecktime1Between(String value1, String value2) {
            addCriterion("checkTime1 between", value1, value2, "checktime1");
            return (Criteria) this;
        }

        public Criteria andChecktime1NotBetween(String value1, String value2) {
            addCriterion("checkTime1 not between", value1, value2, "checktime1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check1IsNull() {
            addCriterion("materialTank1Check1 is null");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check1IsNotNull() {
            addCriterion("materialTank1Check1 is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check1EqualTo(String value) {
            addCriterion("materialTank1Check1 =", value, "materialtank1check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check1NotEqualTo(String value) {
            addCriterion("materialTank1Check1 <>", value, "materialtank1check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check1GreaterThan(String value) {
            addCriterion("materialTank1Check1 >", value, "materialtank1check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check1GreaterThanOrEqualTo(String value) {
            addCriterion("materialTank1Check1 >=", value, "materialtank1check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check1LessThan(String value) {
            addCriterion("materialTank1Check1 <", value, "materialtank1check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check1LessThanOrEqualTo(String value) {
            addCriterion("materialTank1Check1 <=", value, "materialtank1check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check1Like(String value) {
            addCriterion("materialTank1Check1 like", value, "materialtank1check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check1NotLike(String value) {
            addCriterion("materialTank1Check1 not like", value, "materialtank1check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check1In(List<String> values) {
            addCriterion("materialTank1Check1 in", values, "materialtank1check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check1NotIn(List<String> values) {
            addCriterion("materialTank1Check1 not in", values, "materialtank1check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check1Between(String value1, String value2) {
            addCriterion("materialTank1Check1 between", value1, value2, "materialtank1check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check1NotBetween(String value1, String value2) {
            addCriterion("materialTank1Check1 not between", value1, value2, "materialtank1check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check1IsNull() {
            addCriterion("materialTank2Check1 is null");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check1IsNotNull() {
            addCriterion("materialTank2Check1 is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check1EqualTo(String value) {
            addCriterion("materialTank2Check1 =", value, "materialtank2check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check1NotEqualTo(String value) {
            addCriterion("materialTank2Check1 <>", value, "materialtank2check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check1GreaterThan(String value) {
            addCriterion("materialTank2Check1 >", value, "materialtank2check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check1GreaterThanOrEqualTo(String value) {
            addCriterion("materialTank2Check1 >=", value, "materialtank2check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check1LessThan(String value) {
            addCriterion("materialTank2Check1 <", value, "materialtank2check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check1LessThanOrEqualTo(String value) {
            addCriterion("materialTank2Check1 <=", value, "materialtank2check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check1Like(String value) {
            addCriterion("materialTank2Check1 like", value, "materialtank2check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check1NotLike(String value) {
            addCriterion("materialTank2Check1 not like", value, "materialtank2check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check1In(List<String> values) {
            addCriterion("materialTank2Check1 in", values, "materialtank2check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check1NotIn(List<String> values) {
            addCriterion("materialTank2Check1 not in", values, "materialtank2check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check1Between(String value1, String value2) {
            addCriterion("materialTank2Check1 between", value1, value2, "materialtank2check1");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check1NotBetween(String value1, String value2) {
            addCriterion("materialTank2Check1 not between", value1, value2, "materialtank2check1");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck1IsNull() {
            addCriterion("screwFeederCheck1 is null");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck1IsNotNull() {
            addCriterion("screwFeederCheck1 is not null");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck1EqualTo(String value) {
            addCriterion("screwFeederCheck1 =", value, "screwfeedercheck1");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck1NotEqualTo(String value) {
            addCriterion("screwFeederCheck1 <>", value, "screwfeedercheck1");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck1GreaterThan(String value) {
            addCriterion("screwFeederCheck1 >", value, "screwfeedercheck1");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck1GreaterThanOrEqualTo(String value) {
            addCriterion("screwFeederCheck1 >=", value, "screwfeedercheck1");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck1LessThan(String value) {
            addCriterion("screwFeederCheck1 <", value, "screwfeedercheck1");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck1LessThanOrEqualTo(String value) {
            addCriterion("screwFeederCheck1 <=", value, "screwfeedercheck1");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck1Like(String value) {
            addCriterion("screwFeederCheck1 like", value, "screwfeedercheck1");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck1NotLike(String value) {
            addCriterion("screwFeederCheck1 not like", value, "screwfeedercheck1");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck1In(List<String> values) {
            addCriterion("screwFeederCheck1 in", values, "screwfeedercheck1");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck1NotIn(List<String> values) {
            addCriterion("screwFeederCheck1 not in", values, "screwfeedercheck1");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck1Between(String value1, String value2) {
            addCriterion("screwFeederCheck1 between", value1, value2, "screwfeedercheck1");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck1NotBetween(String value1, String value2) {
            addCriterion("screwFeederCheck1 not between", value1, value2, "screwfeedercheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck1IsNull() {
            addCriterion("mixingDrum3mCheck1 is null");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck1IsNotNull() {
            addCriterion("mixingDrum3mCheck1 is not null");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck1EqualTo(String value) {
            addCriterion("mixingDrum3mCheck1 =", value, "mixingdrum3mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck1NotEqualTo(String value) {
            addCriterion("mixingDrum3mCheck1 <>", value, "mixingdrum3mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck1GreaterThan(String value) {
            addCriterion("mixingDrum3mCheck1 >", value, "mixingdrum3mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck1GreaterThanOrEqualTo(String value) {
            addCriterion("mixingDrum3mCheck1 >=", value, "mixingdrum3mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck1LessThan(String value) {
            addCriterion("mixingDrum3mCheck1 <", value, "mixingdrum3mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck1LessThanOrEqualTo(String value) {
            addCriterion("mixingDrum3mCheck1 <=", value, "mixingdrum3mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck1Like(String value) {
            addCriterion("mixingDrum3mCheck1 like", value, "mixingdrum3mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck1NotLike(String value) {
            addCriterion("mixingDrum3mCheck1 not like", value, "mixingdrum3mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck1In(List<String> values) {
            addCriterion("mixingDrum3mCheck1 in", values, "mixingdrum3mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck1NotIn(List<String> values) {
            addCriterion("mixingDrum3mCheck1 not in", values, "mixingdrum3mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck1Between(String value1, String value2) {
            addCriterion("mixingDrum3mCheck1 between", value1, value2, "mixingdrum3mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck1NotBetween(String value1, String value2) {
            addCriterion("mixingDrum3mCheck1 not between", value1, value2, "mixingdrum3mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck1IsNull() {
            addCriterion("mixingDrum4mCheck1 is null");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck1IsNotNull() {
            addCriterion("mixingDrum4mCheck1 is not null");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck1EqualTo(String value) {
            addCriterion("mixingDrum4mCheck1 =", value, "mixingdrum4mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck1NotEqualTo(String value) {
            addCriterion("mixingDrum4mCheck1 <>", value, "mixingdrum4mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck1GreaterThan(String value) {
            addCriterion("mixingDrum4mCheck1 >", value, "mixingdrum4mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck1GreaterThanOrEqualTo(String value) {
            addCriterion("mixingDrum4mCheck1 >=", value, "mixingdrum4mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck1LessThan(String value) {
            addCriterion("mixingDrum4mCheck1 <", value, "mixingdrum4mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck1LessThanOrEqualTo(String value) {
            addCriterion("mixingDrum4mCheck1 <=", value, "mixingdrum4mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck1Like(String value) {
            addCriterion("mixingDrum4mCheck1 like", value, "mixingdrum4mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck1NotLike(String value) {
            addCriterion("mixingDrum4mCheck1 not like", value, "mixingdrum4mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck1In(List<String> values) {
            addCriterion("mixingDrum4mCheck1 in", values, "mixingdrum4mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck1NotIn(List<String> values) {
            addCriterion("mixingDrum4mCheck1 not in", values, "mixingdrum4mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck1Between(String value1, String value2) {
            addCriterion("mixingDrum4mCheck1 between", value1, value2, "mixingdrum4mcheck1");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck1NotBetween(String value1, String value2) {
            addCriterion("mixingDrum4mCheck1 not between", value1, value2, "mixingdrum4mcheck1");
            return (Criteria) this;
        }

        public Criteria andPumpcheck1IsNull() {
            addCriterion("pumpCheck1 is null");
            return (Criteria) this;
        }

        public Criteria andPumpcheck1IsNotNull() {
            addCriterion("pumpCheck1 is not null");
            return (Criteria) this;
        }

        public Criteria andPumpcheck1EqualTo(String value) {
            addCriterion("pumpCheck1 =", value, "pumpcheck1");
            return (Criteria) this;
        }

        public Criteria andPumpcheck1NotEqualTo(String value) {
            addCriterion("pumpCheck1 <>", value, "pumpcheck1");
            return (Criteria) this;
        }

        public Criteria andPumpcheck1GreaterThan(String value) {
            addCriterion("pumpCheck1 >", value, "pumpcheck1");
            return (Criteria) this;
        }

        public Criteria andPumpcheck1GreaterThanOrEqualTo(String value) {
            addCriterion("pumpCheck1 >=", value, "pumpcheck1");
            return (Criteria) this;
        }

        public Criteria andPumpcheck1LessThan(String value) {
            addCriterion("pumpCheck1 <", value, "pumpcheck1");
            return (Criteria) this;
        }

        public Criteria andPumpcheck1LessThanOrEqualTo(String value) {
            addCriterion("pumpCheck1 <=", value, "pumpcheck1");
            return (Criteria) this;
        }

        public Criteria andPumpcheck1Like(String value) {
            addCriterion("pumpCheck1 like", value, "pumpcheck1");
            return (Criteria) this;
        }

        public Criteria andPumpcheck1NotLike(String value) {
            addCriterion("pumpCheck1 not like", value, "pumpcheck1");
            return (Criteria) this;
        }

        public Criteria andPumpcheck1In(List<String> values) {
            addCriterion("pumpCheck1 in", values, "pumpcheck1");
            return (Criteria) this;
        }

        public Criteria andPumpcheck1NotIn(List<String> values) {
            addCriterion("pumpCheck1 not in", values, "pumpcheck1");
            return (Criteria) this;
        }

        public Criteria andPumpcheck1Between(String value1, String value2) {
            addCriterion("pumpCheck1 between", value1, value2, "pumpcheck1");
            return (Criteria) this;
        }

        public Criteria andPumpcheck1NotBetween(String value1, String value2) {
            addCriterion("pumpCheck1 not between", value1, value2, "pumpcheck1");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck1IsNull() {
            addCriterion("electricMachineryCheck1 is null");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck1IsNotNull() {
            addCriterion("electricMachineryCheck1 is not null");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck1EqualTo(String value) {
            addCriterion("electricMachineryCheck1 =", value, "electricmachinerycheck1");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck1NotEqualTo(String value) {
            addCriterion("electricMachineryCheck1 <>", value, "electricmachinerycheck1");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck1GreaterThan(String value) {
            addCriterion("electricMachineryCheck1 >", value, "electricmachinerycheck1");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck1GreaterThanOrEqualTo(String value) {
            addCriterion("electricMachineryCheck1 >=", value, "electricmachinerycheck1");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck1LessThan(String value) {
            addCriterion("electricMachineryCheck1 <", value, "electricmachinerycheck1");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck1LessThanOrEqualTo(String value) {
            addCriterion("electricMachineryCheck1 <=", value, "electricmachinerycheck1");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck1Like(String value) {
            addCriterion("electricMachineryCheck1 like", value, "electricmachinerycheck1");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck1NotLike(String value) {
            addCriterion("electricMachineryCheck1 not like", value, "electricmachinerycheck1");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck1In(List<String> values) {
            addCriterion("electricMachineryCheck1 in", values, "electricmachinerycheck1");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck1NotIn(List<String> values) {
            addCriterion("electricMachineryCheck1 not in", values, "electricmachinerycheck1");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck1Between(String value1, String value2) {
            addCriterion("electricMachineryCheck1 between", value1, value2, "electricmachinerycheck1");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck1NotBetween(String value1, String value2) {
            addCriterion("electricMachineryCheck1 not between", value1, value2, "electricmachinerycheck1");
            return (Criteria) this;
        }

        public Criteria andChecktime2IsNull() {
            addCriterion("checkTime2 is null");
            return (Criteria) this;
        }

        public Criteria andChecktime2IsNotNull() {
            addCriterion("checkTime2 is not null");
            return (Criteria) this;
        }

        public Criteria andChecktime2EqualTo(String value) {
            addCriterion("checkTime2 =", value, "checktime2");
            return (Criteria) this;
        }

        public Criteria andChecktime2NotEqualTo(String value) {
            addCriterion("checkTime2 <>", value, "checktime2");
            return (Criteria) this;
        }

        public Criteria andChecktime2GreaterThan(String value) {
            addCriterion("checkTime2 >", value, "checktime2");
            return (Criteria) this;
        }

        public Criteria andChecktime2GreaterThanOrEqualTo(String value) {
            addCriterion("checkTime2 >=", value, "checktime2");
            return (Criteria) this;
        }

        public Criteria andChecktime2LessThan(String value) {
            addCriterion("checkTime2 <", value, "checktime2");
            return (Criteria) this;
        }

        public Criteria andChecktime2LessThanOrEqualTo(String value) {
            addCriterion("checkTime2 <=", value, "checktime2");
            return (Criteria) this;
        }

        public Criteria andChecktime2Like(String value) {
            addCriterion("checkTime2 like", value, "checktime2");
            return (Criteria) this;
        }

        public Criteria andChecktime2NotLike(String value) {
            addCriterion("checkTime2 not like", value, "checktime2");
            return (Criteria) this;
        }

        public Criteria andChecktime2In(List<String> values) {
            addCriterion("checkTime2 in", values, "checktime2");
            return (Criteria) this;
        }

        public Criteria andChecktime2NotIn(List<String> values) {
            addCriterion("checkTime2 not in", values, "checktime2");
            return (Criteria) this;
        }

        public Criteria andChecktime2Between(String value1, String value2) {
            addCriterion("checkTime2 between", value1, value2, "checktime2");
            return (Criteria) this;
        }

        public Criteria andChecktime2NotBetween(String value1, String value2) {
            addCriterion("checkTime2 not between", value1, value2, "checktime2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check2IsNull() {
            addCriterion("materialTank1Check2 is null");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check2IsNotNull() {
            addCriterion("materialTank1Check2 is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check2EqualTo(String value) {
            addCriterion("materialTank1Check2 =", value, "materialtank1check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check2NotEqualTo(String value) {
            addCriterion("materialTank1Check2 <>", value, "materialtank1check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check2GreaterThan(String value) {
            addCriterion("materialTank1Check2 >", value, "materialtank1check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check2GreaterThanOrEqualTo(String value) {
            addCriterion("materialTank1Check2 >=", value, "materialtank1check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check2LessThan(String value) {
            addCriterion("materialTank1Check2 <", value, "materialtank1check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check2LessThanOrEqualTo(String value) {
            addCriterion("materialTank1Check2 <=", value, "materialtank1check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check2Like(String value) {
            addCriterion("materialTank1Check2 like", value, "materialtank1check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check2NotLike(String value) {
            addCriterion("materialTank1Check2 not like", value, "materialtank1check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check2In(List<String> values) {
            addCriterion("materialTank1Check2 in", values, "materialtank1check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check2NotIn(List<String> values) {
            addCriterion("materialTank1Check2 not in", values, "materialtank1check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check2Between(String value1, String value2) {
            addCriterion("materialTank1Check2 between", value1, value2, "materialtank1check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check2NotBetween(String value1, String value2) {
            addCriterion("materialTank1Check2 not between", value1, value2, "materialtank1check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check2IsNull() {
            addCriterion("materialTank2Check2 is null");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check2IsNotNull() {
            addCriterion("materialTank2Check2 is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check2EqualTo(String value) {
            addCriterion("materialTank2Check2 =", value, "materialtank2check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check2NotEqualTo(String value) {
            addCriterion("materialTank2Check2 <>", value, "materialtank2check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check2GreaterThan(String value) {
            addCriterion("materialTank2Check2 >", value, "materialtank2check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check2GreaterThanOrEqualTo(String value) {
            addCriterion("materialTank2Check2 >=", value, "materialtank2check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check2LessThan(String value) {
            addCriterion("materialTank2Check2 <", value, "materialtank2check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check2LessThanOrEqualTo(String value) {
            addCriterion("materialTank2Check2 <=", value, "materialtank2check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check2Like(String value) {
            addCriterion("materialTank2Check2 like", value, "materialtank2check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check2NotLike(String value) {
            addCriterion("materialTank2Check2 not like", value, "materialtank2check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check2In(List<String> values) {
            addCriterion("materialTank2Check2 in", values, "materialtank2check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check2NotIn(List<String> values) {
            addCriterion("materialTank2Check2 not in", values, "materialtank2check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check2Between(String value1, String value2) {
            addCriterion("materialTank2Check2 between", value1, value2, "materialtank2check2");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check2NotBetween(String value1, String value2) {
            addCriterion("materialTank2Check2 not between", value1, value2, "materialtank2check2");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck2IsNull() {
            addCriterion("screwFeederCheck2 is null");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck2IsNotNull() {
            addCriterion("screwFeederCheck2 is not null");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck2EqualTo(String value) {
            addCriterion("screwFeederCheck2 =", value, "screwfeedercheck2");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck2NotEqualTo(String value) {
            addCriterion("screwFeederCheck2 <>", value, "screwfeedercheck2");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck2GreaterThan(String value) {
            addCriterion("screwFeederCheck2 >", value, "screwfeedercheck2");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck2GreaterThanOrEqualTo(String value) {
            addCriterion("screwFeederCheck2 >=", value, "screwfeedercheck2");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck2LessThan(String value) {
            addCriterion("screwFeederCheck2 <", value, "screwfeedercheck2");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck2LessThanOrEqualTo(String value) {
            addCriterion("screwFeederCheck2 <=", value, "screwfeedercheck2");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck2Like(String value) {
            addCriterion("screwFeederCheck2 like", value, "screwfeedercheck2");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck2NotLike(String value) {
            addCriterion("screwFeederCheck2 not like", value, "screwfeedercheck2");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck2In(List<String> values) {
            addCriterion("screwFeederCheck2 in", values, "screwfeedercheck2");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck2NotIn(List<String> values) {
            addCriterion("screwFeederCheck2 not in", values, "screwfeedercheck2");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck2Between(String value1, String value2) {
            addCriterion("screwFeederCheck2 between", value1, value2, "screwfeedercheck2");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck2NotBetween(String value1, String value2) {
            addCriterion("screwFeederCheck2 not between", value1, value2, "screwfeedercheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck2IsNull() {
            addCriterion("mixingDrum3mCheck2 is null");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck2IsNotNull() {
            addCriterion("mixingDrum3mCheck2 is not null");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck2EqualTo(String value) {
            addCriterion("mixingDrum3mCheck2 =", value, "mixingdrum3mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck2NotEqualTo(String value) {
            addCriterion("mixingDrum3mCheck2 <>", value, "mixingdrum3mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck2GreaterThan(String value) {
            addCriterion("mixingDrum3mCheck2 >", value, "mixingdrum3mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck2GreaterThanOrEqualTo(String value) {
            addCriterion("mixingDrum3mCheck2 >=", value, "mixingdrum3mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck2LessThan(String value) {
            addCriterion("mixingDrum3mCheck2 <", value, "mixingdrum3mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck2LessThanOrEqualTo(String value) {
            addCriterion("mixingDrum3mCheck2 <=", value, "mixingdrum3mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck2Like(String value) {
            addCriterion("mixingDrum3mCheck2 like", value, "mixingdrum3mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck2NotLike(String value) {
            addCriterion("mixingDrum3mCheck2 not like", value, "mixingdrum3mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck2In(List<String> values) {
            addCriterion("mixingDrum3mCheck2 in", values, "mixingdrum3mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck2NotIn(List<String> values) {
            addCriterion("mixingDrum3mCheck2 not in", values, "mixingdrum3mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck2Between(String value1, String value2) {
            addCriterion("mixingDrum3mCheck2 between", value1, value2, "mixingdrum3mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck2NotBetween(String value1, String value2) {
            addCriterion("mixingDrum3mCheck2 not between", value1, value2, "mixingdrum3mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck2IsNull() {
            addCriterion("mixingDrum4mCheck2 is null");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck2IsNotNull() {
            addCriterion("mixingDrum4mCheck2 is not null");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck2EqualTo(String value) {
            addCriterion("mixingDrum4mCheck2 =", value, "mixingdrum4mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck2NotEqualTo(String value) {
            addCriterion("mixingDrum4mCheck2 <>", value, "mixingdrum4mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck2GreaterThan(String value) {
            addCriterion("mixingDrum4mCheck2 >", value, "mixingdrum4mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck2GreaterThanOrEqualTo(String value) {
            addCriterion("mixingDrum4mCheck2 >=", value, "mixingdrum4mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck2LessThan(String value) {
            addCriterion("mixingDrum4mCheck2 <", value, "mixingdrum4mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck2LessThanOrEqualTo(String value) {
            addCriterion("mixingDrum4mCheck2 <=", value, "mixingdrum4mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck2Like(String value) {
            addCriterion("mixingDrum4mCheck2 like", value, "mixingdrum4mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck2NotLike(String value) {
            addCriterion("mixingDrum4mCheck2 not like", value, "mixingdrum4mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck2In(List<String> values) {
            addCriterion("mixingDrum4mCheck2 in", values, "mixingdrum4mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck2NotIn(List<String> values) {
            addCriterion("mixingDrum4mCheck2 not in", values, "mixingdrum4mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck2Between(String value1, String value2) {
            addCriterion("mixingDrum4mCheck2 between", value1, value2, "mixingdrum4mcheck2");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck2NotBetween(String value1, String value2) {
            addCriterion("mixingDrum4mCheck2 not between", value1, value2, "mixingdrum4mcheck2");
            return (Criteria) this;
        }

        public Criteria andPumpcheck2IsNull() {
            addCriterion("pumpCheck2 is null");
            return (Criteria) this;
        }

        public Criteria andPumpcheck2IsNotNull() {
            addCriterion("pumpCheck2 is not null");
            return (Criteria) this;
        }

        public Criteria andPumpcheck2EqualTo(String value) {
            addCriterion("pumpCheck2 =", value, "pumpcheck2");
            return (Criteria) this;
        }

        public Criteria andPumpcheck2NotEqualTo(String value) {
            addCriterion("pumpCheck2 <>", value, "pumpcheck2");
            return (Criteria) this;
        }

        public Criteria andPumpcheck2GreaterThan(String value) {
            addCriterion("pumpCheck2 >", value, "pumpcheck2");
            return (Criteria) this;
        }

        public Criteria andPumpcheck2GreaterThanOrEqualTo(String value) {
            addCriterion("pumpCheck2 >=", value, "pumpcheck2");
            return (Criteria) this;
        }

        public Criteria andPumpcheck2LessThan(String value) {
            addCriterion("pumpCheck2 <", value, "pumpcheck2");
            return (Criteria) this;
        }

        public Criteria andPumpcheck2LessThanOrEqualTo(String value) {
            addCriterion("pumpCheck2 <=", value, "pumpcheck2");
            return (Criteria) this;
        }

        public Criteria andPumpcheck2Like(String value) {
            addCriterion("pumpCheck2 like", value, "pumpcheck2");
            return (Criteria) this;
        }

        public Criteria andPumpcheck2NotLike(String value) {
            addCriterion("pumpCheck2 not like", value, "pumpcheck2");
            return (Criteria) this;
        }

        public Criteria andPumpcheck2In(List<String> values) {
            addCriterion("pumpCheck2 in", values, "pumpcheck2");
            return (Criteria) this;
        }

        public Criteria andPumpcheck2NotIn(List<String> values) {
            addCriterion("pumpCheck2 not in", values, "pumpcheck2");
            return (Criteria) this;
        }

        public Criteria andPumpcheck2Between(String value1, String value2) {
            addCriterion("pumpCheck2 between", value1, value2, "pumpcheck2");
            return (Criteria) this;
        }

        public Criteria andPumpcheck2NotBetween(String value1, String value2) {
            addCriterion("pumpCheck2 not between", value1, value2, "pumpcheck2");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck2IsNull() {
            addCriterion("electricMachineryCheck2 is null");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck2IsNotNull() {
            addCriterion("electricMachineryCheck2 is not null");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck2EqualTo(String value) {
            addCriterion("electricMachineryCheck2 =", value, "electricmachinerycheck2");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck2NotEqualTo(String value) {
            addCriterion("electricMachineryCheck2 <>", value, "electricmachinerycheck2");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck2GreaterThan(String value) {
            addCriterion("electricMachineryCheck2 >", value, "electricmachinerycheck2");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck2GreaterThanOrEqualTo(String value) {
            addCriterion("electricMachineryCheck2 >=", value, "electricmachinerycheck2");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck2LessThan(String value) {
            addCriterion("electricMachineryCheck2 <", value, "electricmachinerycheck2");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck2LessThanOrEqualTo(String value) {
            addCriterion("electricMachineryCheck2 <=", value, "electricmachinerycheck2");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck2Like(String value) {
            addCriterion("electricMachineryCheck2 like", value, "electricmachinerycheck2");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck2NotLike(String value) {
            addCriterion("electricMachineryCheck2 not like", value, "electricmachinerycheck2");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck2In(List<String> values) {
            addCriterion("electricMachineryCheck2 in", values, "electricmachinerycheck2");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck2NotIn(List<String> values) {
            addCriterion("electricMachineryCheck2 not in", values, "electricmachinerycheck2");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck2Between(String value1, String value2) {
            addCriterion("electricMachineryCheck2 between", value1, value2, "electricmachinerycheck2");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck2NotBetween(String value1, String value2) {
            addCriterion("electricMachineryCheck2 not between", value1, value2, "electricmachinerycheck2");
            return (Criteria) this;
        }

        public Criteria andChecktime3IsNull() {
            addCriterion("checkTime3 is null");
            return (Criteria) this;
        }

        public Criteria andChecktime3IsNotNull() {
            addCriterion("checkTime3 is not null");
            return (Criteria) this;
        }

        public Criteria andChecktime3EqualTo(String value) {
            addCriterion("checkTime3 =", value, "checktime3");
            return (Criteria) this;
        }

        public Criteria andChecktime3NotEqualTo(String value) {
            addCriterion("checkTime3 <>", value, "checktime3");
            return (Criteria) this;
        }

        public Criteria andChecktime3GreaterThan(String value) {
            addCriterion("checkTime3 >", value, "checktime3");
            return (Criteria) this;
        }

        public Criteria andChecktime3GreaterThanOrEqualTo(String value) {
            addCriterion("checkTime3 >=", value, "checktime3");
            return (Criteria) this;
        }

        public Criteria andChecktime3LessThan(String value) {
            addCriterion("checkTime3 <", value, "checktime3");
            return (Criteria) this;
        }

        public Criteria andChecktime3LessThanOrEqualTo(String value) {
            addCriterion("checkTime3 <=", value, "checktime3");
            return (Criteria) this;
        }

        public Criteria andChecktime3Like(String value) {
            addCriterion("checkTime3 like", value, "checktime3");
            return (Criteria) this;
        }

        public Criteria andChecktime3NotLike(String value) {
            addCriterion("checkTime3 not like", value, "checktime3");
            return (Criteria) this;
        }

        public Criteria andChecktime3In(List<String> values) {
            addCriterion("checkTime3 in", values, "checktime3");
            return (Criteria) this;
        }

        public Criteria andChecktime3NotIn(List<String> values) {
            addCriterion("checkTime3 not in", values, "checktime3");
            return (Criteria) this;
        }

        public Criteria andChecktime3Between(String value1, String value2) {
            addCriterion("checkTime3 between", value1, value2, "checktime3");
            return (Criteria) this;
        }

        public Criteria andChecktime3NotBetween(String value1, String value2) {
            addCriterion("checkTime3 not between", value1, value2, "checktime3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check3IsNull() {
            addCriterion("materialTank1Check3 is null");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check3IsNotNull() {
            addCriterion("materialTank1Check3 is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check3EqualTo(String value) {
            addCriterion("materialTank1Check3 =", value, "materialtank1check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check3NotEqualTo(String value) {
            addCriterion("materialTank1Check3 <>", value, "materialtank1check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check3GreaterThan(String value) {
            addCriterion("materialTank1Check3 >", value, "materialtank1check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check3GreaterThanOrEqualTo(String value) {
            addCriterion("materialTank1Check3 >=", value, "materialtank1check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check3LessThan(String value) {
            addCriterion("materialTank1Check3 <", value, "materialtank1check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check3LessThanOrEqualTo(String value) {
            addCriterion("materialTank1Check3 <=", value, "materialtank1check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check3Like(String value) {
            addCriterion("materialTank1Check3 like", value, "materialtank1check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check3NotLike(String value) {
            addCriterion("materialTank1Check3 not like", value, "materialtank1check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check3In(List<String> values) {
            addCriterion("materialTank1Check3 in", values, "materialtank1check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check3NotIn(List<String> values) {
            addCriterion("materialTank1Check3 not in", values, "materialtank1check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check3Between(String value1, String value2) {
            addCriterion("materialTank1Check3 between", value1, value2, "materialtank1check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check3NotBetween(String value1, String value2) {
            addCriterion("materialTank1Check3 not between", value1, value2, "materialtank1check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check3IsNull() {
            addCriterion("materialTank2Check3 is null");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check3IsNotNull() {
            addCriterion("materialTank2Check3 is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check3EqualTo(String value) {
            addCriterion("materialTank2Check3 =", value, "materialtank2check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check3NotEqualTo(String value) {
            addCriterion("materialTank2Check3 <>", value, "materialtank2check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check3GreaterThan(String value) {
            addCriterion("materialTank2Check3 >", value, "materialtank2check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check3GreaterThanOrEqualTo(String value) {
            addCriterion("materialTank2Check3 >=", value, "materialtank2check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check3LessThan(String value) {
            addCriterion("materialTank2Check3 <", value, "materialtank2check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check3LessThanOrEqualTo(String value) {
            addCriterion("materialTank2Check3 <=", value, "materialtank2check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check3Like(String value) {
            addCriterion("materialTank2Check3 like", value, "materialtank2check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check3NotLike(String value) {
            addCriterion("materialTank2Check3 not like", value, "materialtank2check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check3In(List<String> values) {
            addCriterion("materialTank2Check3 in", values, "materialtank2check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check3NotIn(List<String> values) {
            addCriterion("materialTank2Check3 not in", values, "materialtank2check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check3Between(String value1, String value2) {
            addCriterion("materialTank2Check3 between", value1, value2, "materialtank2check3");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check3NotBetween(String value1, String value2) {
            addCriterion("materialTank2Check3 not between", value1, value2, "materialtank2check3");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck3IsNull() {
            addCriterion("screwFeederCheck3 is null");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck3IsNotNull() {
            addCriterion("screwFeederCheck3 is not null");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck3EqualTo(String value) {
            addCriterion("screwFeederCheck3 =", value, "screwfeedercheck3");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck3NotEqualTo(String value) {
            addCriterion("screwFeederCheck3 <>", value, "screwfeedercheck3");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck3GreaterThan(String value) {
            addCriterion("screwFeederCheck3 >", value, "screwfeedercheck3");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck3GreaterThanOrEqualTo(String value) {
            addCriterion("screwFeederCheck3 >=", value, "screwfeedercheck3");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck3LessThan(String value) {
            addCriterion("screwFeederCheck3 <", value, "screwfeedercheck3");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck3LessThanOrEqualTo(String value) {
            addCriterion("screwFeederCheck3 <=", value, "screwfeedercheck3");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck3Like(String value) {
            addCriterion("screwFeederCheck3 like", value, "screwfeedercheck3");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck3NotLike(String value) {
            addCriterion("screwFeederCheck3 not like", value, "screwfeedercheck3");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck3In(List<String> values) {
            addCriterion("screwFeederCheck3 in", values, "screwfeedercheck3");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck3NotIn(List<String> values) {
            addCriterion("screwFeederCheck3 not in", values, "screwfeedercheck3");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck3Between(String value1, String value2) {
            addCriterion("screwFeederCheck3 between", value1, value2, "screwfeedercheck3");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck3NotBetween(String value1, String value2) {
            addCriterion("screwFeederCheck3 not between", value1, value2, "screwfeedercheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck3IsNull() {
            addCriterion("mixingDrum3mCheck3 is null");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck3IsNotNull() {
            addCriterion("mixingDrum3mCheck3 is not null");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck3EqualTo(String value) {
            addCriterion("mixingDrum3mCheck3 =", value, "mixingdrum3mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck3NotEqualTo(String value) {
            addCriterion("mixingDrum3mCheck3 <>", value, "mixingdrum3mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck3GreaterThan(String value) {
            addCriterion("mixingDrum3mCheck3 >", value, "mixingdrum3mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck3GreaterThanOrEqualTo(String value) {
            addCriterion("mixingDrum3mCheck3 >=", value, "mixingdrum3mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck3LessThan(String value) {
            addCriterion("mixingDrum3mCheck3 <", value, "mixingdrum3mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck3LessThanOrEqualTo(String value) {
            addCriterion("mixingDrum3mCheck3 <=", value, "mixingdrum3mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck3Like(String value) {
            addCriterion("mixingDrum3mCheck3 like", value, "mixingdrum3mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck3NotLike(String value) {
            addCriterion("mixingDrum3mCheck3 not like", value, "mixingdrum3mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck3In(List<String> values) {
            addCriterion("mixingDrum3mCheck3 in", values, "mixingdrum3mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck3NotIn(List<String> values) {
            addCriterion("mixingDrum3mCheck3 not in", values, "mixingdrum3mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck3Between(String value1, String value2) {
            addCriterion("mixingDrum3mCheck3 between", value1, value2, "mixingdrum3mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck3NotBetween(String value1, String value2) {
            addCriterion("mixingDrum3mCheck3 not between", value1, value2, "mixingdrum3mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck3IsNull() {
            addCriterion("mixingDrum4mCheck3 is null");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck3IsNotNull() {
            addCriterion("mixingDrum4mCheck3 is not null");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck3EqualTo(String value) {
            addCriterion("mixingDrum4mCheck3 =", value, "mixingdrum4mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck3NotEqualTo(String value) {
            addCriterion("mixingDrum4mCheck3 <>", value, "mixingdrum4mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck3GreaterThan(String value) {
            addCriterion("mixingDrum4mCheck3 >", value, "mixingdrum4mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck3GreaterThanOrEqualTo(String value) {
            addCriterion("mixingDrum4mCheck3 >=", value, "mixingdrum4mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck3LessThan(String value) {
            addCriterion("mixingDrum4mCheck3 <", value, "mixingdrum4mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck3LessThanOrEqualTo(String value) {
            addCriterion("mixingDrum4mCheck3 <=", value, "mixingdrum4mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck3Like(String value) {
            addCriterion("mixingDrum4mCheck3 like", value, "mixingdrum4mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck3NotLike(String value) {
            addCriterion("mixingDrum4mCheck3 not like", value, "mixingdrum4mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck3In(List<String> values) {
            addCriterion("mixingDrum4mCheck3 in", values, "mixingdrum4mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck3NotIn(List<String> values) {
            addCriterion("mixingDrum4mCheck3 not in", values, "mixingdrum4mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck3Between(String value1, String value2) {
            addCriterion("mixingDrum4mCheck3 between", value1, value2, "mixingdrum4mcheck3");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck3NotBetween(String value1, String value2) {
            addCriterion("mixingDrum4mCheck3 not between", value1, value2, "mixingdrum4mcheck3");
            return (Criteria) this;
        }

        public Criteria andPumpcheck3IsNull() {
            addCriterion("pumpCheck3 is null");
            return (Criteria) this;
        }

        public Criteria andPumpcheck3IsNotNull() {
            addCriterion("pumpCheck3 is not null");
            return (Criteria) this;
        }

        public Criteria andPumpcheck3EqualTo(String value) {
            addCriterion("pumpCheck3 =", value, "pumpcheck3");
            return (Criteria) this;
        }

        public Criteria andPumpcheck3NotEqualTo(String value) {
            addCriterion("pumpCheck3 <>", value, "pumpcheck3");
            return (Criteria) this;
        }

        public Criteria andPumpcheck3GreaterThan(String value) {
            addCriterion("pumpCheck3 >", value, "pumpcheck3");
            return (Criteria) this;
        }

        public Criteria andPumpcheck3GreaterThanOrEqualTo(String value) {
            addCriterion("pumpCheck3 >=", value, "pumpcheck3");
            return (Criteria) this;
        }

        public Criteria andPumpcheck3LessThan(String value) {
            addCriterion("pumpCheck3 <", value, "pumpcheck3");
            return (Criteria) this;
        }

        public Criteria andPumpcheck3LessThanOrEqualTo(String value) {
            addCriterion("pumpCheck3 <=", value, "pumpcheck3");
            return (Criteria) this;
        }

        public Criteria andPumpcheck3Like(String value) {
            addCriterion("pumpCheck3 like", value, "pumpcheck3");
            return (Criteria) this;
        }

        public Criteria andPumpcheck3NotLike(String value) {
            addCriterion("pumpCheck3 not like", value, "pumpcheck3");
            return (Criteria) this;
        }

        public Criteria andPumpcheck3In(List<String> values) {
            addCriterion("pumpCheck3 in", values, "pumpcheck3");
            return (Criteria) this;
        }

        public Criteria andPumpcheck3NotIn(List<String> values) {
            addCriterion("pumpCheck3 not in", values, "pumpcheck3");
            return (Criteria) this;
        }

        public Criteria andPumpcheck3Between(String value1, String value2) {
            addCriterion("pumpCheck3 between", value1, value2, "pumpcheck3");
            return (Criteria) this;
        }

        public Criteria andPumpcheck3NotBetween(String value1, String value2) {
            addCriterion("pumpCheck3 not between", value1, value2, "pumpcheck3");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck3IsNull() {
            addCriterion("electricMachineryCheck3 is null");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck3IsNotNull() {
            addCriterion("electricMachineryCheck3 is not null");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck3EqualTo(String value) {
            addCriterion("electricMachineryCheck3 =", value, "electricmachinerycheck3");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck3NotEqualTo(String value) {
            addCriterion("electricMachineryCheck3 <>", value, "electricmachinerycheck3");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck3GreaterThan(String value) {
            addCriterion("electricMachineryCheck3 >", value, "electricmachinerycheck3");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck3GreaterThanOrEqualTo(String value) {
            addCriterion("electricMachineryCheck3 >=", value, "electricmachinerycheck3");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck3LessThan(String value) {
            addCriterion("electricMachineryCheck3 <", value, "electricmachinerycheck3");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck3LessThanOrEqualTo(String value) {
            addCriterion("electricMachineryCheck3 <=", value, "electricmachinerycheck3");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck3Like(String value) {
            addCriterion("electricMachineryCheck3 like", value, "electricmachinerycheck3");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck3NotLike(String value) {
            addCriterion("electricMachineryCheck3 not like", value, "electricmachinerycheck3");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck3In(List<String> values) {
            addCriterion("electricMachineryCheck3 in", values, "electricmachinerycheck3");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck3NotIn(List<String> values) {
            addCriterion("electricMachineryCheck3 not in", values, "electricmachinerycheck3");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck3Between(String value1, String value2) {
            addCriterion("electricMachineryCheck3 between", value1, value2, "electricmachinerycheck3");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck3NotBetween(String value1, String value2) {
            addCriterion("electricMachineryCheck3 not between", value1, value2, "electricmachinerycheck3");
            return (Criteria) this;
        }

        public Criteria andChecktime4IsNull() {
            addCriterion("checkTime4 is null");
            return (Criteria) this;
        }

        public Criteria andChecktime4IsNotNull() {
            addCriterion("checkTime4 is not null");
            return (Criteria) this;
        }

        public Criteria andChecktime4EqualTo(String value) {
            addCriterion("checkTime4 =", value, "checktime4");
            return (Criteria) this;
        }

        public Criteria andChecktime4NotEqualTo(String value) {
            addCriterion("checkTime4 <>", value, "checktime4");
            return (Criteria) this;
        }

        public Criteria andChecktime4GreaterThan(String value) {
            addCriterion("checkTime4 >", value, "checktime4");
            return (Criteria) this;
        }

        public Criteria andChecktime4GreaterThanOrEqualTo(String value) {
            addCriterion("checkTime4 >=", value, "checktime4");
            return (Criteria) this;
        }

        public Criteria andChecktime4LessThan(String value) {
            addCriterion("checkTime4 <", value, "checktime4");
            return (Criteria) this;
        }

        public Criteria andChecktime4LessThanOrEqualTo(String value) {
            addCriterion("checkTime4 <=", value, "checktime4");
            return (Criteria) this;
        }

        public Criteria andChecktime4Like(String value) {
            addCriterion("checkTime4 like", value, "checktime4");
            return (Criteria) this;
        }

        public Criteria andChecktime4NotLike(String value) {
            addCriterion("checkTime4 not like", value, "checktime4");
            return (Criteria) this;
        }

        public Criteria andChecktime4In(List<String> values) {
            addCriterion("checkTime4 in", values, "checktime4");
            return (Criteria) this;
        }

        public Criteria andChecktime4NotIn(List<String> values) {
            addCriterion("checkTime4 not in", values, "checktime4");
            return (Criteria) this;
        }

        public Criteria andChecktime4Between(String value1, String value2) {
            addCriterion("checkTime4 between", value1, value2, "checktime4");
            return (Criteria) this;
        }

        public Criteria andChecktime4NotBetween(String value1, String value2) {
            addCriterion("checkTime4 not between", value1, value2, "checktime4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check4IsNull() {
            addCriterion("materialTank1Check4 is null");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check4IsNotNull() {
            addCriterion("materialTank1Check4 is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check4EqualTo(String value) {
            addCriterion("materialTank1Check4 =", value, "materialtank1check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check4NotEqualTo(String value) {
            addCriterion("materialTank1Check4 <>", value, "materialtank1check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check4GreaterThan(String value) {
            addCriterion("materialTank1Check4 >", value, "materialtank1check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check4GreaterThanOrEqualTo(String value) {
            addCriterion("materialTank1Check4 >=", value, "materialtank1check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check4LessThan(String value) {
            addCriterion("materialTank1Check4 <", value, "materialtank1check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check4LessThanOrEqualTo(String value) {
            addCriterion("materialTank1Check4 <=", value, "materialtank1check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check4Like(String value) {
            addCriterion("materialTank1Check4 like", value, "materialtank1check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check4NotLike(String value) {
            addCriterion("materialTank1Check4 not like", value, "materialtank1check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check4In(List<String> values) {
            addCriterion("materialTank1Check4 in", values, "materialtank1check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check4NotIn(List<String> values) {
            addCriterion("materialTank1Check4 not in", values, "materialtank1check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check4Between(String value1, String value2) {
            addCriterion("materialTank1Check4 between", value1, value2, "materialtank1check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank1check4NotBetween(String value1, String value2) {
            addCriterion("materialTank1Check4 not between", value1, value2, "materialtank1check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check4IsNull() {
            addCriterion("materialTank2Check4 is null");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check4IsNotNull() {
            addCriterion("materialTank2Check4 is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check4EqualTo(String value) {
            addCriterion("materialTank2Check4 =", value, "materialtank2check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check4NotEqualTo(String value) {
            addCriterion("materialTank2Check4 <>", value, "materialtank2check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check4GreaterThan(String value) {
            addCriterion("materialTank2Check4 >", value, "materialtank2check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check4GreaterThanOrEqualTo(String value) {
            addCriterion("materialTank2Check4 >=", value, "materialtank2check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check4LessThan(String value) {
            addCriterion("materialTank2Check4 <", value, "materialtank2check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check4LessThanOrEqualTo(String value) {
            addCriterion("materialTank2Check4 <=", value, "materialtank2check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check4Like(String value) {
            addCriterion("materialTank2Check4 like", value, "materialtank2check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check4NotLike(String value) {
            addCriterion("materialTank2Check4 not like", value, "materialtank2check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check4In(List<String> values) {
            addCriterion("materialTank2Check4 in", values, "materialtank2check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check4NotIn(List<String> values) {
            addCriterion("materialTank2Check4 not in", values, "materialtank2check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check4Between(String value1, String value2) {
            addCriterion("materialTank2Check4 between", value1, value2, "materialtank2check4");
            return (Criteria) this;
        }

        public Criteria andMaterialtank2check4NotBetween(String value1, String value2) {
            addCriterion("materialTank2Check4 not between", value1, value2, "materialtank2check4");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck4IsNull() {
            addCriterion("screwFeederCheck4 is null");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck4IsNotNull() {
            addCriterion("screwFeederCheck4 is not null");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck4EqualTo(String value) {
            addCriterion("screwFeederCheck4 =", value, "screwfeedercheck4");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck4NotEqualTo(String value) {
            addCriterion("screwFeederCheck4 <>", value, "screwfeedercheck4");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck4GreaterThan(String value) {
            addCriterion("screwFeederCheck4 >", value, "screwfeedercheck4");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck4GreaterThanOrEqualTo(String value) {
            addCriterion("screwFeederCheck4 >=", value, "screwfeedercheck4");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck4LessThan(String value) {
            addCriterion("screwFeederCheck4 <", value, "screwfeedercheck4");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck4LessThanOrEqualTo(String value) {
            addCriterion("screwFeederCheck4 <=", value, "screwfeedercheck4");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck4Like(String value) {
            addCriterion("screwFeederCheck4 like", value, "screwfeedercheck4");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck4NotLike(String value) {
            addCriterion("screwFeederCheck4 not like", value, "screwfeedercheck4");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck4In(List<String> values) {
            addCriterion("screwFeederCheck4 in", values, "screwfeedercheck4");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck4NotIn(List<String> values) {
            addCriterion("screwFeederCheck4 not in", values, "screwfeedercheck4");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck4Between(String value1, String value2) {
            addCriterion("screwFeederCheck4 between", value1, value2, "screwfeedercheck4");
            return (Criteria) this;
        }

        public Criteria andScrewfeedercheck4NotBetween(String value1, String value2) {
            addCriterion("screwFeederCheck4 not between", value1, value2, "screwfeedercheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck4IsNull() {
            addCriterion("mixingDrum3mCheck4 is null");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck4IsNotNull() {
            addCriterion("mixingDrum3mCheck4 is not null");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck4EqualTo(String value) {
            addCriterion("mixingDrum3mCheck4 =", value, "mixingdrum3mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck4NotEqualTo(String value) {
            addCriterion("mixingDrum3mCheck4 <>", value, "mixingdrum3mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck4GreaterThan(String value) {
            addCriterion("mixingDrum3mCheck4 >", value, "mixingdrum3mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck4GreaterThanOrEqualTo(String value) {
            addCriterion("mixingDrum3mCheck4 >=", value, "mixingdrum3mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck4LessThan(String value) {
            addCriterion("mixingDrum3mCheck4 <", value, "mixingdrum3mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck4LessThanOrEqualTo(String value) {
            addCriterion("mixingDrum3mCheck4 <=", value, "mixingdrum3mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck4Like(String value) {
            addCriterion("mixingDrum3mCheck4 like", value, "mixingdrum3mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck4NotLike(String value) {
            addCriterion("mixingDrum3mCheck4 not like", value, "mixingdrum3mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck4In(List<String> values) {
            addCriterion("mixingDrum3mCheck4 in", values, "mixingdrum3mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck4NotIn(List<String> values) {
            addCriterion("mixingDrum3mCheck4 not in", values, "mixingdrum3mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck4Between(String value1, String value2) {
            addCriterion("mixingDrum3mCheck4 between", value1, value2, "mixingdrum3mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum3mcheck4NotBetween(String value1, String value2) {
            addCriterion("mixingDrum3mCheck4 not between", value1, value2, "mixingdrum3mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck4IsNull() {
            addCriterion("mixingDrum4mCheck4 is null");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck4IsNotNull() {
            addCriterion("mixingDrum4mCheck4 is not null");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck4EqualTo(String value) {
            addCriterion("mixingDrum4mCheck4 =", value, "mixingdrum4mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck4NotEqualTo(String value) {
            addCriterion("mixingDrum4mCheck4 <>", value, "mixingdrum4mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck4GreaterThan(String value) {
            addCriterion("mixingDrum4mCheck4 >", value, "mixingdrum4mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck4GreaterThanOrEqualTo(String value) {
            addCriterion("mixingDrum4mCheck4 >=", value, "mixingdrum4mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck4LessThan(String value) {
            addCriterion("mixingDrum4mCheck4 <", value, "mixingdrum4mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck4LessThanOrEqualTo(String value) {
            addCriterion("mixingDrum4mCheck4 <=", value, "mixingdrum4mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck4Like(String value) {
            addCriterion("mixingDrum4mCheck4 like", value, "mixingdrum4mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck4NotLike(String value) {
            addCriterion("mixingDrum4mCheck4 not like", value, "mixingdrum4mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck4In(List<String> values) {
            addCriterion("mixingDrum4mCheck4 in", values, "mixingdrum4mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck4NotIn(List<String> values) {
            addCriterion("mixingDrum4mCheck4 not in", values, "mixingdrum4mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck4Between(String value1, String value2) {
            addCriterion("mixingDrum4mCheck4 between", value1, value2, "mixingdrum4mcheck4");
            return (Criteria) this;
        }

        public Criteria andMixingdrum4mcheck4NotBetween(String value1, String value2) {
            addCriterion("mixingDrum4mCheck4 not between", value1, value2, "mixingdrum4mcheck4");
            return (Criteria) this;
        }

        public Criteria andPumpcheck4IsNull() {
            addCriterion("pumpCheck4 is null");
            return (Criteria) this;
        }

        public Criteria andPumpcheck4IsNotNull() {
            addCriterion("pumpCheck4 is not null");
            return (Criteria) this;
        }

        public Criteria andPumpcheck4EqualTo(String value) {
            addCriterion("pumpCheck4 =", value, "pumpcheck4");
            return (Criteria) this;
        }

        public Criteria andPumpcheck4NotEqualTo(String value) {
            addCriterion("pumpCheck4 <>", value, "pumpcheck4");
            return (Criteria) this;
        }

        public Criteria andPumpcheck4GreaterThan(String value) {
            addCriterion("pumpCheck4 >", value, "pumpcheck4");
            return (Criteria) this;
        }

        public Criteria andPumpcheck4GreaterThanOrEqualTo(String value) {
            addCriterion("pumpCheck4 >=", value, "pumpcheck4");
            return (Criteria) this;
        }

        public Criteria andPumpcheck4LessThan(String value) {
            addCriterion("pumpCheck4 <", value, "pumpcheck4");
            return (Criteria) this;
        }

        public Criteria andPumpcheck4LessThanOrEqualTo(String value) {
            addCriterion("pumpCheck4 <=", value, "pumpcheck4");
            return (Criteria) this;
        }

        public Criteria andPumpcheck4Like(String value) {
            addCriterion("pumpCheck4 like", value, "pumpcheck4");
            return (Criteria) this;
        }

        public Criteria andPumpcheck4NotLike(String value) {
            addCriterion("pumpCheck4 not like", value, "pumpcheck4");
            return (Criteria) this;
        }

        public Criteria andPumpcheck4In(List<String> values) {
            addCriterion("pumpCheck4 in", values, "pumpcheck4");
            return (Criteria) this;
        }

        public Criteria andPumpcheck4NotIn(List<String> values) {
            addCriterion("pumpCheck4 not in", values, "pumpcheck4");
            return (Criteria) this;
        }

        public Criteria andPumpcheck4Between(String value1, String value2) {
            addCriterion("pumpCheck4 between", value1, value2, "pumpcheck4");
            return (Criteria) this;
        }

        public Criteria andPumpcheck4NotBetween(String value1, String value2) {
            addCriterion("pumpCheck4 not between", value1, value2, "pumpcheck4");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck4IsNull() {
            addCriterion("electricMachineryCheck4 is null");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck4IsNotNull() {
            addCriterion("electricMachineryCheck4 is not null");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck4EqualTo(String value) {
            addCriterion("electricMachineryCheck4 =", value, "electricmachinerycheck4");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck4NotEqualTo(String value) {
            addCriterion("electricMachineryCheck4 <>", value, "electricmachinerycheck4");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck4GreaterThan(String value) {
            addCriterion("electricMachineryCheck4 >", value, "electricmachinerycheck4");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck4GreaterThanOrEqualTo(String value) {
            addCriterion("electricMachineryCheck4 >=", value, "electricmachinerycheck4");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck4LessThan(String value) {
            addCriterion("electricMachineryCheck4 <", value, "electricmachinerycheck4");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck4LessThanOrEqualTo(String value) {
            addCriterion("electricMachineryCheck4 <=", value, "electricmachinerycheck4");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck4Like(String value) {
            addCriterion("electricMachineryCheck4 like", value, "electricmachinerycheck4");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck4NotLike(String value) {
            addCriterion("electricMachineryCheck4 not like", value, "electricmachinerycheck4");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck4In(List<String> values) {
            addCriterion("electricMachineryCheck4 in", values, "electricmachinerycheck4");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck4NotIn(List<String> values) {
            addCriterion("electricMachineryCheck4 not in", values, "electricmachinerycheck4");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck4Between(String value1, String value2) {
            addCriterion("electricMachineryCheck4 between", value1, value2, "electricmachinerycheck4");
            return (Criteria) this;
        }

        public Criteria andElectricmachinerycheck4NotBetween(String value1, String value2) {
            addCriterion("electricMachineryCheck4 not between", value1, value2, "electricmachinerycheck4");
            return (Criteria) this;
        }

        public Criteria andProductionIsNull() {
            addCriterion("production is null");
            return (Criteria) this;
        }

        public Criteria andProductionIsNotNull() {
            addCriterion("production is not null");
            return (Criteria) this;
        }

        public Criteria andProductionEqualTo(String value) {
            addCriterion("production =", value, "production");
            return (Criteria) this;
        }

        public Criteria andProductionNotEqualTo(String value) {
            addCriterion("production <>", value, "production");
            return (Criteria) this;
        }

        public Criteria andProductionGreaterThan(String value) {
            addCriterion("production >", value, "production");
            return (Criteria) this;
        }

        public Criteria andProductionGreaterThanOrEqualTo(String value) {
            addCriterion("production >=", value, "production");
            return (Criteria) this;
        }

        public Criteria andProductionLessThan(String value) {
            addCriterion("production <", value, "production");
            return (Criteria) this;
        }

        public Criteria andProductionLessThanOrEqualTo(String value) {
            addCriterion("production <=", value, "production");
            return (Criteria) this;
        }

        public Criteria andProductionLike(String value) {
            addCriterion("production like", value, "production");
            return (Criteria) this;
        }

        public Criteria andProductionNotLike(String value) {
            addCriterion("production not like", value, "production");
            return (Criteria) this;
        }

        public Criteria andProductionIn(List<String> values) {
            addCriterion("production in", values, "production");
            return (Criteria) this;
        }

        public Criteria andProductionNotIn(List<String> values) {
            addCriterion("production not in", values, "production");
            return (Criteria) this;
        }

        public Criteria andProductionBetween(String value1, String value2) {
            addCriterion("production between", value1, value2, "production");
            return (Criteria) this;
        }

        public Criteria andProductionNotBetween(String value1, String value2) {
            addCriterion("production not between", value1, value2, "production");
            return (Criteria) this;
        }

        public Criteria andEquipmentoperationIsNull() {
            addCriterion("equipmentOperation is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentoperationIsNotNull() {
            addCriterion("equipmentOperation is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentoperationEqualTo(String value) {
            addCriterion("equipmentOperation =", value, "equipmentoperation");
            return (Criteria) this;
        }

        public Criteria andEquipmentoperationNotEqualTo(String value) {
            addCriterion("equipmentOperation <>", value, "equipmentoperation");
            return (Criteria) this;
        }

        public Criteria andEquipmentoperationGreaterThan(String value) {
            addCriterion("equipmentOperation >", value, "equipmentoperation");
            return (Criteria) this;
        }

        public Criteria andEquipmentoperationGreaterThanOrEqualTo(String value) {
            addCriterion("equipmentOperation >=", value, "equipmentoperation");
            return (Criteria) this;
        }

        public Criteria andEquipmentoperationLessThan(String value) {
            addCriterion("equipmentOperation <", value, "equipmentoperation");
            return (Criteria) this;
        }

        public Criteria andEquipmentoperationLessThanOrEqualTo(String value) {
            addCriterion("equipmentOperation <=", value, "equipmentoperation");
            return (Criteria) this;
        }

        public Criteria andEquipmentoperationLike(String value) {
            addCriterion("equipmentOperation like", value, "equipmentoperation");
            return (Criteria) this;
        }

        public Criteria andEquipmentoperationNotLike(String value) {
            addCriterion("equipmentOperation not like", value, "equipmentoperation");
            return (Criteria) this;
        }

        public Criteria andEquipmentoperationIn(List<String> values) {
            addCriterion("equipmentOperation in", values, "equipmentoperation");
            return (Criteria) this;
        }

        public Criteria andEquipmentoperationNotIn(List<String> values) {
            addCriterion("equipmentOperation not in", values, "equipmentoperation");
            return (Criteria) this;
        }

        public Criteria andEquipmentoperationBetween(String value1, String value2) {
            addCriterion("equipmentOperation between", value1, value2, "equipmentoperation");
            return (Criteria) this;
        }

        public Criteria andEquipmentoperationNotBetween(String value1, String value2) {
            addCriterion("equipmentOperation not between", value1, value2, "equipmentoperation");
            return (Criteria) this;
        }

        public Criteria andShiftremarkIsNull() {
            addCriterion("shiftRemark is null");
            return (Criteria) this;
        }

        public Criteria andShiftremarkIsNotNull() {
            addCriterion("shiftRemark is not null");
            return (Criteria) this;
        }

        public Criteria andShiftremarkEqualTo(String value) {
            addCriterion("shiftRemark =", value, "shiftremark");
            return (Criteria) this;
        }

        public Criteria andShiftremarkNotEqualTo(String value) {
            addCriterion("shiftRemark <>", value, "shiftremark");
            return (Criteria) this;
        }

        public Criteria andShiftremarkGreaterThan(String value) {
            addCriterion("shiftRemark >", value, "shiftremark");
            return (Criteria) this;
        }

        public Criteria andShiftremarkGreaterThanOrEqualTo(String value) {
            addCriterion("shiftRemark >=", value, "shiftremark");
            return (Criteria) this;
        }

        public Criteria andShiftremarkLessThan(String value) {
            addCriterion("shiftRemark <", value, "shiftremark");
            return (Criteria) this;
        }

        public Criteria andShiftremarkLessThanOrEqualTo(String value) {
            addCriterion("shiftRemark <=", value, "shiftremark");
            return (Criteria) this;
        }

        public Criteria andShiftremarkLike(String value) {
            addCriterion("shiftRemark like", value, "shiftremark");
            return (Criteria) this;
        }

        public Criteria andShiftremarkNotLike(String value) {
            addCriterion("shiftRemark not like", value, "shiftremark");
            return (Criteria) this;
        }

        public Criteria andShiftremarkIn(List<String> values) {
            addCriterion("shiftRemark in", values, "shiftremark");
            return (Criteria) this;
        }

        public Criteria andShiftremarkNotIn(List<String> values) {
            addCriterion("shiftRemark not in", values, "shiftremark");
            return (Criteria) this;
        }

        public Criteria andShiftremarkBetween(String value1, String value2) {
            addCriterion("shiftRemark between", value1, value2, "shiftremark");
            return (Criteria) this;
        }

        public Criteria andShiftremarkNotBetween(String value1, String value2) {
            addCriterion("shiftRemark not between", value1, value2, "shiftremark");
            return (Criteria) this;
        }

        public Criteria andSuccessionremarkIsNull() {
            addCriterion("successionRemark is null");
            return (Criteria) this;
        }

        public Criteria andSuccessionremarkIsNotNull() {
            addCriterion("successionRemark is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessionremarkEqualTo(String value) {
            addCriterion("successionRemark =", value, "successionremark");
            return (Criteria) this;
        }

        public Criteria andSuccessionremarkNotEqualTo(String value) {
            addCriterion("successionRemark <>", value, "successionremark");
            return (Criteria) this;
        }

        public Criteria andSuccessionremarkGreaterThan(String value) {
            addCriterion("successionRemark >", value, "successionremark");
            return (Criteria) this;
        }

        public Criteria andSuccessionremarkGreaterThanOrEqualTo(String value) {
            addCriterion("successionRemark >=", value, "successionremark");
            return (Criteria) this;
        }

        public Criteria andSuccessionremarkLessThan(String value) {
            addCriterion("successionRemark <", value, "successionremark");
            return (Criteria) this;
        }

        public Criteria andSuccessionremarkLessThanOrEqualTo(String value) {
            addCriterion("successionRemark <=", value, "successionremark");
            return (Criteria) this;
        }

        public Criteria andSuccessionremarkLike(String value) {
            addCriterion("successionRemark like", value, "successionremark");
            return (Criteria) this;
        }

        public Criteria andSuccessionremarkNotLike(String value) {
            addCriterion("successionRemark not like", value, "successionremark");
            return (Criteria) this;
        }

        public Criteria andSuccessionremarkIn(List<String> values) {
            addCriterion("successionRemark in", values, "successionremark");
            return (Criteria) this;
        }

        public Criteria andSuccessionremarkNotIn(List<String> values) {
            addCriterion("successionRemark not in", values, "successionremark");
            return (Criteria) this;
        }

        public Criteria andSuccessionremarkBetween(String value1, String value2) {
            addCriterion("successionRemark between", value1, value2, "successionremark");
            return (Criteria) this;
        }

        public Criteria andSuccessionremarkNotBetween(String value1, String value2) {
            addCriterion("successionRemark not between", value1, value2, "successionremark");
            return (Criteria) this;
        }

        public Criteria andShiftnameIsNull() {
            addCriterion("shiftName is null");
            return (Criteria) this;
        }

        public Criteria andShiftnameIsNotNull() {
            addCriterion("shiftName is not null");
            return (Criteria) this;
        }

        public Criteria andShiftnameEqualTo(String value) {
            addCriterion("shiftName =", value, "shiftname");
            return (Criteria) this;
        }

        public Criteria andShiftnameNotEqualTo(String value) {
            addCriterion("shiftName <>", value, "shiftname");
            return (Criteria) this;
        }

        public Criteria andShiftnameGreaterThan(String value) {
            addCriterion("shiftName >", value, "shiftname");
            return (Criteria) this;
        }

        public Criteria andShiftnameGreaterThanOrEqualTo(String value) {
            addCriterion("shiftName >=", value, "shiftname");
            return (Criteria) this;
        }

        public Criteria andShiftnameLessThan(String value) {
            addCriterion("shiftName <", value, "shiftname");
            return (Criteria) this;
        }

        public Criteria andShiftnameLessThanOrEqualTo(String value) {
            addCriterion("shiftName <=", value, "shiftname");
            return (Criteria) this;
        }

        public Criteria andShiftnameLike(String value) {
            addCriterion("shiftName like", value, "shiftname");
            return (Criteria) this;
        }

        public Criteria andShiftnameNotLike(String value) {
            addCriterion("shiftName not like", value, "shiftname");
            return (Criteria) this;
        }

        public Criteria andShiftnameIn(List<String> values) {
            addCriterion("shiftName in", values, "shiftname");
            return (Criteria) this;
        }

        public Criteria andShiftnameNotIn(List<String> values) {
            addCriterion("shiftName not in", values, "shiftname");
            return (Criteria) this;
        }

        public Criteria andShiftnameBetween(String value1, String value2) {
            addCriterion("shiftName between", value1, value2, "shiftname");
            return (Criteria) this;
        }

        public Criteria andShiftnameNotBetween(String value1, String value2) {
            addCriterion("shiftName not between", value1, value2, "shiftname");
            return (Criteria) this;
        }

        public Criteria andSuccessionnameIsNull() {
            addCriterion("successionName is null");
            return (Criteria) this;
        }

        public Criteria andSuccessionnameIsNotNull() {
            addCriterion("successionName is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessionnameEqualTo(String value) {
            addCriterion("successionName =", value, "successionname");
            return (Criteria) this;
        }

        public Criteria andSuccessionnameNotEqualTo(String value) {
            addCriterion("successionName <>", value, "successionname");
            return (Criteria) this;
        }

        public Criteria andSuccessionnameGreaterThan(String value) {
            addCriterion("successionName >", value, "successionname");
            return (Criteria) this;
        }

        public Criteria andSuccessionnameGreaterThanOrEqualTo(String value) {
            addCriterion("successionName >=", value, "successionname");
            return (Criteria) this;
        }

        public Criteria andSuccessionnameLessThan(String value) {
            addCriterion("successionName <", value, "successionname");
            return (Criteria) this;
        }

        public Criteria andSuccessionnameLessThanOrEqualTo(String value) {
            addCriterion("successionName <=", value, "successionname");
            return (Criteria) this;
        }

        public Criteria andSuccessionnameLike(String value) {
            addCriterion("successionName like", value, "successionname");
            return (Criteria) this;
        }

        public Criteria andSuccessionnameNotLike(String value) {
            addCriterion("successionName not like", value, "successionname");
            return (Criteria) this;
        }

        public Criteria andSuccessionnameIn(List<String> values) {
            addCriterion("successionName in", values, "successionname");
            return (Criteria) this;
        }

        public Criteria andSuccessionnameNotIn(List<String> values) {
            addCriterion("successionName not in", values, "successionname");
            return (Criteria) this;
        }

        public Criteria andSuccessionnameBetween(String value1, String value2) {
            addCriterion("successionName between", value1, value2, "successionname");
            return (Criteria) this;
        }

        public Criteria andSuccessionnameNotBetween(String value1, String value2) {
            addCriterion("successionName not between", value1, value2, "successionname");
            return (Criteria) this;
        }

        public Criteria andShiftstateIsNull() {
            addCriterion("shiftState is null");
            return (Criteria) this;
        }

        public Criteria andShiftstateIsNotNull() {
            addCriterion("shiftState is not null");
            return (Criteria) this;
        }

        public Criteria andShiftstateEqualTo(String value) {
            addCriterion("shiftState =", value, "shiftstate");
            return (Criteria) this;
        }

        public Criteria andShiftstateNotEqualTo(String value) {
            addCriterion("shiftState <>", value, "shiftstate");
            return (Criteria) this;
        }

        public Criteria andShiftstateGreaterThan(String value) {
            addCriterion("shiftState >", value, "shiftstate");
            return (Criteria) this;
        }

        public Criteria andShiftstateGreaterThanOrEqualTo(String value) {
            addCriterion("shiftState >=", value, "shiftstate");
            return (Criteria) this;
        }

        public Criteria andShiftstateLessThan(String value) {
            addCriterion("shiftState <", value, "shiftstate");
            return (Criteria) this;
        }

        public Criteria andShiftstateLessThanOrEqualTo(String value) {
            addCriterion("shiftState <=", value, "shiftstate");
            return (Criteria) this;
        }

        public Criteria andShiftstateLike(String value) {
            addCriterion("shiftState like", value, "shiftstate");
            return (Criteria) this;
        }

        public Criteria andShiftstateNotLike(String value) {
            addCriterion("shiftState not like", value, "shiftstate");
            return (Criteria) this;
        }

        public Criteria andShiftstateIn(List<String> values) {
            addCriterion("shiftState in", values, "shiftstate");
            return (Criteria) this;
        }

        public Criteria andShiftstateNotIn(List<String> values) {
            addCriterion("shiftState not in", values, "shiftstate");
            return (Criteria) this;
        }

        public Criteria andShiftstateBetween(String value1, String value2) {
            addCriterion("shiftState between", value1, value2, "shiftstate");
            return (Criteria) this;
        }

        public Criteria andShiftstateNotBetween(String value1, String value2) {
            addCriterion("shiftState not between", value1, value2, "shiftstate");
            return (Criteria) this;
        }

        public Criteria andSuccessionstateIsNull() {
            addCriterion("successionState is null");
            return (Criteria) this;
        }

        public Criteria andSuccessionstateIsNotNull() {
            addCriterion("successionState is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessionstateEqualTo(String value) {
            addCriterion("successionState =", value, "successionstate");
            return (Criteria) this;
        }

        public Criteria andSuccessionstateNotEqualTo(String value) {
            addCriterion("successionState <>", value, "successionstate");
            return (Criteria) this;
        }

        public Criteria andSuccessionstateGreaterThan(String value) {
            addCriterion("successionState >", value, "successionstate");
            return (Criteria) this;
        }

        public Criteria andSuccessionstateGreaterThanOrEqualTo(String value) {
            addCriterion("successionState >=", value, "successionstate");
            return (Criteria) this;
        }

        public Criteria andSuccessionstateLessThan(String value) {
            addCriterion("successionState <", value, "successionstate");
            return (Criteria) this;
        }

        public Criteria andSuccessionstateLessThanOrEqualTo(String value) {
            addCriterion("successionState <=", value, "successionstate");
            return (Criteria) this;
        }

        public Criteria andSuccessionstateLike(String value) {
            addCriterion("successionState like", value, "successionstate");
            return (Criteria) this;
        }

        public Criteria andSuccessionstateNotLike(String value) {
            addCriterion("successionState not like", value, "successionstate");
            return (Criteria) this;
        }

        public Criteria andSuccessionstateIn(List<String> values) {
            addCriterion("successionState in", values, "successionstate");
            return (Criteria) this;
        }

        public Criteria andSuccessionstateNotIn(List<String> values) {
            addCriterion("successionState not in", values, "successionstate");
            return (Criteria) this;
        }

        public Criteria andSuccessionstateBetween(String value1, String value2) {
            addCriterion("successionState between", value1, value2, "successionstate");
            return (Criteria) this;
        }

        public Criteria andSuccessionstateNotBetween(String value1, String value2) {
            addCriterion("successionState not between", value1, value2, "successionstate");
            return (Criteria) this;
        }

        public Criteria andShifttimeIsNull() {
            addCriterion("shiftTime is null");
            return (Criteria) this;
        }

        public Criteria andShifttimeIsNotNull() {
            addCriterion("shiftTime is not null");
            return (Criteria) this;
        }

        public Criteria andShifttimeEqualTo(String value) {
            addCriterion("shiftTime =", value, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeNotEqualTo(String value) {
            addCriterion("shiftTime <>", value, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeGreaterThan(String value) {
            addCriterion("shiftTime >", value, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeGreaterThanOrEqualTo(String value) {
            addCriterion("shiftTime >=", value, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeLessThan(String value) {
            addCriterion("shiftTime <", value, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeLessThanOrEqualTo(String value) {
            addCriterion("shiftTime <=", value, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeLike(String value) {
            addCriterion("shiftTime like", value, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeNotLike(String value) {
            addCriterion("shiftTime not like", value, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeIn(List<String> values) {
            addCriterion("shiftTime in", values, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeNotIn(List<String> values) {
            addCriterion("shiftTime not in", values, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeBetween(String value1, String value2) {
            addCriterion("shiftTime between", value1, value2, "shifttime");
            return (Criteria) this;
        }

        public Criteria andShifttimeNotBetween(String value1, String value2) {
            addCriterion("shiftTime not between", value1, value2, "shifttime");
            return (Criteria) this;
        }

        public Criteria andSuccessiontimeIsNull() {
            addCriterion("successionTime is null");
            return (Criteria) this;
        }

        public Criteria andSuccessiontimeIsNotNull() {
            addCriterion("successionTime is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessiontimeEqualTo(String value) {
            addCriterion("successionTime =", value, "successiontime");
            return (Criteria) this;
        }

        public Criteria andSuccessiontimeNotEqualTo(String value) {
            addCriterion("successionTime <>", value, "successiontime");
            return (Criteria) this;
        }

        public Criteria andSuccessiontimeGreaterThan(String value) {
            addCriterion("successionTime >", value, "successiontime");
            return (Criteria) this;
        }

        public Criteria andSuccessiontimeGreaterThanOrEqualTo(String value) {
            addCriterion("successionTime >=", value, "successiontime");
            return (Criteria) this;
        }

        public Criteria andSuccessiontimeLessThan(String value) {
            addCriterion("successionTime <", value, "successiontime");
            return (Criteria) this;
        }

        public Criteria andSuccessiontimeLessThanOrEqualTo(String value) {
            addCriterion("successionTime <=", value, "successiontime");
            return (Criteria) this;
        }

        public Criteria andSuccessiontimeLike(String value) {
            addCriterion("successionTime like", value, "successiontime");
            return (Criteria) this;
        }

        public Criteria andSuccessiontimeNotLike(String value) {
            addCriterion("successionTime not like", value, "successiontime");
            return (Criteria) this;
        }

        public Criteria andSuccessiontimeIn(List<String> values) {
            addCriterion("successionTime in", values, "successiontime");
            return (Criteria) this;
        }

        public Criteria andSuccessiontimeNotIn(List<String> values) {
            addCriterion("successionTime not in", values, "successiontime");
            return (Criteria) this;
        }

        public Criteria andSuccessiontimeBetween(String value1, String value2) {
            addCriterion("successionTime between", value1, value2, "successiontime");
            return (Criteria) this;
        }

        public Criteria andSuccessiontimeNotBetween(String value1, String value2) {
            addCriterion("successionTime not between", value1, value2, "successiontime");
            return (Criteria) this;
        }

        public Criteria andParam1IsNull() {
            addCriterion("param1 is null");
            return (Criteria) this;
        }

        public Criteria andParam1IsNotNull() {
            addCriterion("param1 is not null");
            return (Criteria) this;
        }

        public Criteria andParam1EqualTo(String value) {
            addCriterion("param1 =", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1NotEqualTo(String value) {
            addCriterion("param1 <>", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1GreaterThan(String value) {
            addCriterion("param1 >", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1GreaterThanOrEqualTo(String value) {
            addCriterion("param1 >=", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1LessThan(String value) {
            addCriterion("param1 <", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1LessThanOrEqualTo(String value) {
            addCriterion("param1 <=", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1Like(String value) {
            addCriterion("param1 like", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1NotLike(String value) {
            addCriterion("param1 not like", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1In(List<String> values) {
            addCriterion("param1 in", values, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1NotIn(List<String> values) {
            addCriterion("param1 not in", values, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1Between(String value1, String value2) {
            addCriterion("param1 between", value1, value2, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1NotBetween(String value1, String value2) {
            addCriterion("param1 not between", value1, value2, "param1");
            return (Criteria) this;
        }

        public Criteria andParam2IsNull() {
            addCriterion("param2 is null");
            return (Criteria) this;
        }

        public Criteria andParam2IsNotNull() {
            addCriterion("param2 is not null");
            return (Criteria) this;
        }

        public Criteria andParam2EqualTo(String value) {
            addCriterion("param2 =", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2NotEqualTo(String value) {
            addCriterion("param2 <>", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2GreaterThan(String value) {
            addCriterion("param2 >", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2GreaterThanOrEqualTo(String value) {
            addCriterion("param2 >=", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2LessThan(String value) {
            addCriterion("param2 <", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2LessThanOrEqualTo(String value) {
            addCriterion("param2 <=", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2Like(String value) {
            addCriterion("param2 like", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2NotLike(String value) {
            addCriterion("param2 not like", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2In(List<String> values) {
            addCriterion("param2 in", values, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2NotIn(List<String> values) {
            addCriterion("param2 not in", values, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2Between(String value1, String value2) {
            addCriterion("param2 between", value1, value2, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2NotBetween(String value1, String value2) {
            addCriterion("param2 not between", value1, value2, "param2");
            return (Criteria) this;
        }

        public Criteria andParam3IsNull() {
            addCriterion("param3 is null");
            return (Criteria) this;
        }

        public Criteria andParam3IsNotNull() {
            addCriterion("param3 is not null");
            return (Criteria) this;
        }

        public Criteria andParam3EqualTo(String value) {
            addCriterion("param3 =", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3NotEqualTo(String value) {
            addCriterion("param3 <>", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3GreaterThan(String value) {
            addCriterion("param3 >", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3GreaterThanOrEqualTo(String value) {
            addCriterion("param3 >=", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3LessThan(String value) {
            addCriterion("param3 <", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3LessThanOrEqualTo(String value) {
            addCriterion("param3 <=", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3Like(String value) {
            addCriterion("param3 like", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3NotLike(String value) {
            addCriterion("param3 not like", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3In(List<String> values) {
            addCriterion("param3 in", values, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3NotIn(List<String> values) {
            addCriterion("param3 not in", values, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3Between(String value1, String value2) {
            addCriterion("param3 between", value1, value2, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3NotBetween(String value1, String value2) {
            addCriterion("param3 not between", value1, value2, "param3");
            return (Criteria) this;
        }

        public Criteria andParam4IsNull() {
            addCriterion("param4 is null");
            return (Criteria) this;
        }

        public Criteria andParam4IsNotNull() {
            addCriterion("param4 is not null");
            return (Criteria) this;
        }

        public Criteria andParam4EqualTo(String value) {
            addCriterion("param4 =", value, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4NotEqualTo(String value) {
            addCriterion("param4 <>", value, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4GreaterThan(String value) {
            addCriterion("param4 >", value, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4GreaterThanOrEqualTo(String value) {
            addCriterion("param4 >=", value, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4LessThan(String value) {
            addCriterion("param4 <", value, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4LessThanOrEqualTo(String value) {
            addCriterion("param4 <=", value, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4Like(String value) {
            addCriterion("param4 like", value, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4NotLike(String value) {
            addCriterion("param4 not like", value, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4In(List<String> values) {
            addCriterion("param4 in", values, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4NotIn(List<String> values) {
            addCriterion("param4 not in", values, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4Between(String value1, String value2) {
            addCriterion("param4 between", value1, value2, "param4");
            return (Criteria) this;
        }

        public Criteria andParam4NotBetween(String value1, String value2) {
            addCriterion("param4 not between", value1, value2, "param4");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}