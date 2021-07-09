package com.kaoqin.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KechengExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KechengExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andBanjiIsNull() {
            addCriterion("banji is null");
            return (Criteria) this;
        }

        public Criteria andBanjiIsNotNull() {
            addCriterion("banji is not null");
            return (Criteria) this;
        }

        public Criteria andBanjiEqualTo(String value) {
            addCriterion("banji =", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiNotEqualTo(String value) {
            addCriterion("banji <>", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiGreaterThan(String value) {
            addCriterion("banji >", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiGreaterThanOrEqualTo(String value) {
            addCriterion("banji >=", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiLessThan(String value) {
            addCriterion("banji <", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiLessThanOrEqualTo(String value) {
            addCriterion("banji <=", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiLike(String value) {
            addCriterion("banji like", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiNotLike(String value) {
            addCriterion("banji not like", value, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiIn(List<String> values) {
            addCriterion("banji in", values, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiNotIn(List<String> values) {
            addCriterion("banji not in", values, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiBetween(String value1, String value2) {
            addCriterion("banji between", value1, value2, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjiNotBetween(String value1, String value2) {
            addCriterion("banji not between", value1, value2, "banji");
            return (Criteria) this;
        }

        public Criteria andBanjinumIsNull() {
            addCriterion("banjinum is null");
            return (Criteria) this;
        }

        public Criteria andBanjinumIsNotNull() {
            addCriterion("banjinum is not null");
            return (Criteria) this;
        }

        public Criteria andBanjinumEqualTo(String value) {
            addCriterion("banjinum =", value, "banjinum");
            return (Criteria) this;
        }

        public Criteria andBanjinumNotEqualTo(String value) {
            addCriterion("banjinum <>", value, "banjinum");
            return (Criteria) this;
        }

        public Criteria andBanjinumGreaterThan(String value) {
            addCriterion("banjinum >", value, "banjinum");
            return (Criteria) this;
        }

        public Criteria andBanjinumGreaterThanOrEqualTo(String value) {
            addCriterion("banjinum >=", value, "banjinum");
            return (Criteria) this;
        }

        public Criteria andBanjinumLessThan(String value) {
            addCriterion("banjinum <", value, "banjinum");
            return (Criteria) this;
        }

        public Criteria andBanjinumLessThanOrEqualTo(String value) {
            addCriterion("banjinum <=", value, "banjinum");
            return (Criteria) this;
        }

        public Criteria andBanjinumLike(String value) {
            addCriterion("banjinum like", value, "banjinum");
            return (Criteria) this;
        }

        public Criteria andBanjinumNotLike(String value) {
            addCriterion("banjinum not like", value, "banjinum");
            return (Criteria) this;
        }

        public Criteria andBanjinumIn(List<String> values) {
            addCriterion("banjinum in", values, "banjinum");
            return (Criteria) this;
        }

        public Criteria andBanjinumNotIn(List<String> values) {
            addCriterion("banjinum not in", values, "banjinum");
            return (Criteria) this;
        }

        public Criteria andBanjinumBetween(String value1, String value2) {
            addCriterion("banjinum between", value1, value2, "banjinum");
            return (Criteria) this;
        }

        public Criteria andBanjinumNotBetween(String value1, String value2) {
            addCriterion("banjinum not between", value1, value2, "banjinum");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andKechengname1IsNull() {
            addCriterion("kechengname1 is null");
            return (Criteria) this;
        }

        public Criteria andKechengname1IsNotNull() {
            addCriterion("kechengname1 is not null");
            return (Criteria) this;
        }

        public Criteria andKechengname1EqualTo(String value) {
            addCriterion("kechengname1 =", value, "kechengname1");
            return (Criteria) this;
        }

        public Criteria andKechengname1NotEqualTo(String value) {
            addCriterion("kechengname1 <>", value, "kechengname1");
            return (Criteria) this;
        }

        public Criteria andKechengname1GreaterThan(String value) {
            addCriterion("kechengname1 >", value, "kechengname1");
            return (Criteria) this;
        }

        public Criteria andKechengname1GreaterThanOrEqualTo(String value) {
            addCriterion("kechengname1 >=", value, "kechengname1");
            return (Criteria) this;
        }

        public Criteria andKechengname1LessThan(String value) {
            addCriterion("kechengname1 <", value, "kechengname1");
            return (Criteria) this;
        }

        public Criteria andKechengname1LessThanOrEqualTo(String value) {
            addCriterion("kechengname1 <=", value, "kechengname1");
            return (Criteria) this;
        }

        public Criteria andKechengname1Like(String value) {
            addCriterion("kechengname1 like", value, "kechengname1");
            return (Criteria) this;
        }

        public Criteria andKechengname1NotLike(String value) {
            addCriterion("kechengname1 not like", value, "kechengname1");
            return (Criteria) this;
        }

        public Criteria andKechengname1In(List<String> values) {
            addCriterion("kechengname1 in", values, "kechengname1");
            return (Criteria) this;
        }

        public Criteria andKechengname1NotIn(List<String> values) {
            addCriterion("kechengname1 not in", values, "kechengname1");
            return (Criteria) this;
        }

        public Criteria andKechengname1Between(String value1, String value2) {
            addCriterion("kechengname1 between", value1, value2, "kechengname1");
            return (Criteria) this;
        }

        public Criteria andKechengname1NotBetween(String value1, String value2) {
            addCriterion("kechengname1 not between", value1, value2, "kechengname1");
            return (Criteria) this;
        }

        public Criteria andKechengname2IsNull() {
            addCriterion("kechengname2 is null");
            return (Criteria) this;
        }

        public Criteria andKechengname2IsNotNull() {
            addCriterion("kechengname2 is not null");
            return (Criteria) this;
        }

        public Criteria andKechengname2EqualTo(String value) {
            addCriterion("kechengname2 =", value, "kechengname2");
            return (Criteria) this;
        }

        public Criteria andKechengname2NotEqualTo(String value) {
            addCriterion("kechengname2 <>", value, "kechengname2");
            return (Criteria) this;
        }

        public Criteria andKechengname2GreaterThan(String value) {
            addCriterion("kechengname2 >", value, "kechengname2");
            return (Criteria) this;
        }

        public Criteria andKechengname2GreaterThanOrEqualTo(String value) {
            addCriterion("kechengname2 >=", value, "kechengname2");
            return (Criteria) this;
        }

        public Criteria andKechengname2LessThan(String value) {
            addCriterion("kechengname2 <", value, "kechengname2");
            return (Criteria) this;
        }

        public Criteria andKechengname2LessThanOrEqualTo(String value) {
            addCriterion("kechengname2 <=", value, "kechengname2");
            return (Criteria) this;
        }

        public Criteria andKechengname2Like(String value) {
            addCriterion("kechengname2 like", value, "kechengname2");
            return (Criteria) this;
        }

        public Criteria andKechengname2NotLike(String value) {
            addCriterion("kechengname2 not like", value, "kechengname2");
            return (Criteria) this;
        }

        public Criteria andKechengname2In(List<String> values) {
            addCriterion("kechengname2 in", values, "kechengname2");
            return (Criteria) this;
        }

        public Criteria andKechengname2NotIn(List<String> values) {
            addCriterion("kechengname2 not in", values, "kechengname2");
            return (Criteria) this;
        }

        public Criteria andKechengname2Between(String value1, String value2) {
            addCriterion("kechengname2 between", value1, value2, "kechengname2");
            return (Criteria) this;
        }

        public Criteria andKechengname2NotBetween(String value1, String value2) {
            addCriterion("kechengname2 not between", value1, value2, "kechengname2");
            return (Criteria) this;
        }

        public Criteria andKechengname3IsNull() {
            addCriterion("kechengname3 is null");
            return (Criteria) this;
        }

        public Criteria andKechengname3IsNotNull() {
            addCriterion("kechengname3 is not null");
            return (Criteria) this;
        }

        public Criteria andKechengname3EqualTo(String value) {
            addCriterion("kechengname3 =", value, "kechengname3");
            return (Criteria) this;
        }

        public Criteria andKechengname3NotEqualTo(String value) {
            addCriterion("kechengname3 <>", value, "kechengname3");
            return (Criteria) this;
        }

        public Criteria andKechengname3GreaterThan(String value) {
            addCriterion("kechengname3 >", value, "kechengname3");
            return (Criteria) this;
        }

        public Criteria andKechengname3GreaterThanOrEqualTo(String value) {
            addCriterion("kechengname3 >=", value, "kechengname3");
            return (Criteria) this;
        }

        public Criteria andKechengname3LessThan(String value) {
            addCriterion("kechengname3 <", value, "kechengname3");
            return (Criteria) this;
        }

        public Criteria andKechengname3LessThanOrEqualTo(String value) {
            addCriterion("kechengname3 <=", value, "kechengname3");
            return (Criteria) this;
        }

        public Criteria andKechengname3Like(String value) {
            addCriterion("kechengname3 like", value, "kechengname3");
            return (Criteria) this;
        }

        public Criteria andKechengname3NotLike(String value) {
            addCriterion("kechengname3 not like", value, "kechengname3");
            return (Criteria) this;
        }

        public Criteria andKechengname3In(List<String> values) {
            addCriterion("kechengname3 in", values, "kechengname3");
            return (Criteria) this;
        }

        public Criteria andKechengname3NotIn(List<String> values) {
            addCriterion("kechengname3 not in", values, "kechengname3");
            return (Criteria) this;
        }

        public Criteria andKechengname3Between(String value1, String value2) {
            addCriterion("kechengname3 between", value1, value2, "kechengname3");
            return (Criteria) this;
        }

        public Criteria andKechengname3NotBetween(String value1, String value2) {
            addCriterion("kechengname3 not between", value1, value2, "kechengname3");
            return (Criteria) this;
        }

        public Criteria andKechengname4IsNull() {
            addCriterion("kechengname4 is null");
            return (Criteria) this;
        }

        public Criteria andKechengname4IsNotNull() {
            addCriterion("kechengname4 is not null");
            return (Criteria) this;
        }

        public Criteria andKechengname4EqualTo(String value) {
            addCriterion("kechengname4 =", value, "kechengname4");
            return (Criteria) this;
        }

        public Criteria andKechengname4NotEqualTo(String value) {
            addCriterion("kechengname4 <>", value, "kechengname4");
            return (Criteria) this;
        }

        public Criteria andKechengname4GreaterThan(String value) {
            addCriterion("kechengname4 >", value, "kechengname4");
            return (Criteria) this;
        }

        public Criteria andKechengname4GreaterThanOrEqualTo(String value) {
            addCriterion("kechengname4 >=", value, "kechengname4");
            return (Criteria) this;
        }

        public Criteria andKechengname4LessThan(String value) {
            addCriterion("kechengname4 <", value, "kechengname4");
            return (Criteria) this;
        }

        public Criteria andKechengname4LessThanOrEqualTo(String value) {
            addCriterion("kechengname4 <=", value, "kechengname4");
            return (Criteria) this;
        }

        public Criteria andKechengname4Like(String value) {
            addCriterion("kechengname4 like", value, "kechengname4");
            return (Criteria) this;
        }

        public Criteria andKechengname4NotLike(String value) {
            addCriterion("kechengname4 not like", value, "kechengname4");
            return (Criteria) this;
        }

        public Criteria andKechengname4In(List<String> values) {
            addCriterion("kechengname4 in", values, "kechengname4");
            return (Criteria) this;
        }

        public Criteria andKechengname4NotIn(List<String> values) {
            addCriterion("kechengname4 not in", values, "kechengname4");
            return (Criteria) this;
        }

        public Criteria andKechengname4Between(String value1, String value2) {
            addCriterion("kechengname4 between", value1, value2, "kechengname4");
            return (Criteria) this;
        }

        public Criteria andKechengname4NotBetween(String value1, String value2) {
            addCriterion("kechengname4 not between", value1, value2, "kechengname4");
            return (Criteria) this;
        }

        public Criteria andKechengname5IsNull() {
            addCriterion("kechengname5 is null");
            return (Criteria) this;
        }

        public Criteria andKechengname5IsNotNull() {
            addCriterion("kechengname5 is not null");
            return (Criteria) this;
        }

        public Criteria andKechengname5EqualTo(String value) {
            addCriterion("kechengname5 =", value, "kechengname5");
            return (Criteria) this;
        }

        public Criteria andKechengname5NotEqualTo(String value) {
            addCriterion("kechengname5 <>", value, "kechengname5");
            return (Criteria) this;
        }

        public Criteria andKechengname5GreaterThan(String value) {
            addCriterion("kechengname5 >", value, "kechengname5");
            return (Criteria) this;
        }

        public Criteria andKechengname5GreaterThanOrEqualTo(String value) {
            addCriterion("kechengname5 >=", value, "kechengname5");
            return (Criteria) this;
        }

        public Criteria andKechengname5LessThan(String value) {
            addCriterion("kechengname5 <", value, "kechengname5");
            return (Criteria) this;
        }

        public Criteria andKechengname5LessThanOrEqualTo(String value) {
            addCriterion("kechengname5 <=", value, "kechengname5");
            return (Criteria) this;
        }

        public Criteria andKechengname5Like(String value) {
            addCriterion("kechengname5 like", value, "kechengname5");
            return (Criteria) this;
        }

        public Criteria andKechengname5NotLike(String value) {
            addCriterion("kechengname5 not like", value, "kechengname5");
            return (Criteria) this;
        }

        public Criteria andKechengname5In(List<String> values) {
            addCriterion("kechengname5 in", values, "kechengname5");
            return (Criteria) this;
        }

        public Criteria andKechengname5NotIn(List<String> values) {
            addCriterion("kechengname5 not in", values, "kechengname5");
            return (Criteria) this;
        }

        public Criteria andKechengname5Between(String value1, String value2) {
            addCriterion("kechengname5 between", value1, value2, "kechengname5");
            return (Criteria) this;
        }

        public Criteria andKechengname5NotBetween(String value1, String value2) {
            addCriterion("kechengname5 not between", value1, value2, "kechengname5");
            return (Criteria) this;
        }

        public Criteria andKechengname6IsNull() {
            addCriterion("kechengname6 is null");
            return (Criteria) this;
        }

        public Criteria andKechengname6IsNotNull() {
            addCriterion("kechengname6 is not null");
            return (Criteria) this;
        }

        public Criteria andKechengname6EqualTo(String value) {
            addCriterion("kechengname6 =", value, "kechengname6");
            return (Criteria) this;
        }

        public Criteria andKechengname6NotEqualTo(String value) {
            addCriterion("kechengname6 <>", value, "kechengname6");
            return (Criteria) this;
        }

        public Criteria andKechengname6GreaterThan(String value) {
            addCriterion("kechengname6 >", value, "kechengname6");
            return (Criteria) this;
        }

        public Criteria andKechengname6GreaterThanOrEqualTo(String value) {
            addCriterion("kechengname6 >=", value, "kechengname6");
            return (Criteria) this;
        }

        public Criteria andKechengname6LessThan(String value) {
            addCriterion("kechengname6 <", value, "kechengname6");
            return (Criteria) this;
        }

        public Criteria andKechengname6LessThanOrEqualTo(String value) {
            addCriterion("kechengname6 <=", value, "kechengname6");
            return (Criteria) this;
        }

        public Criteria andKechengname6Like(String value) {
            addCriterion("kechengname6 like", value, "kechengname6");
            return (Criteria) this;
        }

        public Criteria andKechengname6NotLike(String value) {
            addCriterion("kechengname6 not like", value, "kechengname6");
            return (Criteria) this;
        }

        public Criteria andKechengname6In(List<String> values) {
            addCriterion("kechengname6 in", values, "kechengname6");
            return (Criteria) this;
        }

        public Criteria andKechengname6NotIn(List<String> values) {
            addCriterion("kechengname6 not in", values, "kechengname6");
            return (Criteria) this;
        }

        public Criteria andKechengname6Between(String value1, String value2) {
            addCriterion("kechengname6 between", value1, value2, "kechengname6");
            return (Criteria) this;
        }

        public Criteria andKechengname6NotBetween(String value1, String value2) {
            addCriterion("kechengname6 not between", value1, value2, "kechengname6");
            return (Criteria) this;
        }

        public Criteria andKechengname7IsNull() {
            addCriterion("kechengname7 is null");
            return (Criteria) this;
        }

        public Criteria andKechengname7IsNotNull() {
            addCriterion("kechengname7 is not null");
            return (Criteria) this;
        }

        public Criteria andKechengname7EqualTo(String value) {
            addCriterion("kechengname7 =", value, "kechengname7");
            return (Criteria) this;
        }

        public Criteria andKechengname7NotEqualTo(String value) {
            addCriterion("kechengname7 <>", value, "kechengname7");
            return (Criteria) this;
        }

        public Criteria andKechengname7GreaterThan(String value) {
            addCriterion("kechengname7 >", value, "kechengname7");
            return (Criteria) this;
        }

        public Criteria andKechengname7GreaterThanOrEqualTo(String value) {
            addCriterion("kechengname7 >=", value, "kechengname7");
            return (Criteria) this;
        }

        public Criteria andKechengname7LessThan(String value) {
            addCriterion("kechengname7 <", value, "kechengname7");
            return (Criteria) this;
        }

        public Criteria andKechengname7LessThanOrEqualTo(String value) {
            addCriterion("kechengname7 <=", value, "kechengname7");
            return (Criteria) this;
        }

        public Criteria andKechengname7Like(String value) {
            addCriterion("kechengname7 like", value, "kechengname7");
            return (Criteria) this;
        }

        public Criteria andKechengname7NotLike(String value) {
            addCriterion("kechengname7 not like", value, "kechengname7");
            return (Criteria) this;
        }

        public Criteria andKechengname7In(List<String> values) {
            addCriterion("kechengname7 in", values, "kechengname7");
            return (Criteria) this;
        }

        public Criteria andKechengname7NotIn(List<String> values) {
            addCriterion("kechengname7 not in", values, "kechengname7");
            return (Criteria) this;
        }

        public Criteria andKechengname7Between(String value1, String value2) {
            addCriterion("kechengname7 between", value1, value2, "kechengname7");
            return (Criteria) this;
        }

        public Criteria andKechengname7NotBetween(String value1, String value2) {
            addCriterion("kechengname7 not between", value1, value2, "kechengname7");
            return (Criteria) this;
        }

        public Criteria andShangketimeIsNull() {
            addCriterion("shangketime is null");
            return (Criteria) this;
        }

        public Criteria andShangketimeIsNotNull() {
            addCriterion("shangketime is not null");
            return (Criteria) this;
        }

        public Criteria andShangketimeEqualTo(Date value) {
            addCriterion("shangketime =", value, "shangketime");
            return (Criteria) this;
        }

        public Criteria andShangketimeNotEqualTo(Date value) {
            addCriterion("shangketime <>", value, "shangketime");
            return (Criteria) this;
        }

        public Criteria andShangketimeGreaterThan(Date value) {
            addCriterion("shangketime >", value, "shangketime");
            return (Criteria) this;
        }

        public Criteria andShangketimeGreaterThanOrEqualTo(Date value) {
            addCriterion("shangketime >=", value, "shangketime");
            return (Criteria) this;
        }

        public Criteria andShangketimeLessThan(Date value) {
            addCriterion("shangketime <", value, "shangketime");
            return (Criteria) this;
        }

        public Criteria andShangketimeLessThanOrEqualTo(Date value) {
            addCriterion("shangketime <=", value, "shangketime");
            return (Criteria) this;
        }

        public Criteria andShangketimeIn(List<Date> values) {
            addCriterion("shangketime in", values, "shangketime");
            return (Criteria) this;
        }

        public Criteria andShangketimeNotIn(List<Date> values) {
            addCriterion("shangketime not in", values, "shangketime");
            return (Criteria) this;
        }

        public Criteria andShangketimeBetween(Date value1, Date value2) {
            addCriterion("shangketime between", value1, value2, "shangketime");
            return (Criteria) this;
        }

        public Criteria andShangketimeNotBetween(Date value1, Date value2) {
            addCriterion("shangketime not between", value1, value2, "shangketime");
            return (Criteria) this;
        }
    }

    /**
     */
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