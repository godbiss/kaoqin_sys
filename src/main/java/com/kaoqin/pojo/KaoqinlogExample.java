package com.kaoqin.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KaoqinlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KaoqinlogExample() {
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

        public Criteria andCodenumIsNull() {
            addCriterion("codenum is null");
            return (Criteria) this;
        }

        public Criteria andCodenumIsNotNull() {
            addCriterion("codenum is not null");
            return (Criteria) this;
        }

        public Criteria andCodenumEqualTo(String value) {
            addCriterion("codenum =", value, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumNotEqualTo(String value) {
            addCriterion("codenum <>", value, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumGreaterThan(String value) {
            addCriterion("codenum >", value, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumGreaterThanOrEqualTo(String value) {
            addCriterion("codenum >=", value, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumLessThan(String value) {
            addCriterion("codenum <", value, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumLessThanOrEqualTo(String value) {
            addCriterion("codenum <=", value, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumLike(String value) {
            addCriterion("codenum like", value, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumNotLike(String value) {
            addCriterion("codenum not like", value, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumIn(List<String> values) {
            addCriterion("codenum in", values, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumNotIn(List<String> values) {
            addCriterion("codenum not in", values, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumBetween(String value1, String value2) {
            addCriterion("codenum between", value1, value2, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumNotBetween(String value1, String value2) {
            addCriterion("codenum not between", value1, value2, "codenum");
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

        public Criteria andIskuangkeIsNull() {
            addCriterion("iskuangke is null");
            return (Criteria) this;
        }

        public Criteria andIskuangkeIsNotNull() {
            addCriterion("iskuangke is not null");
            return (Criteria) this;
        }

        public Criteria andIskuangkeEqualTo(Integer value) {
            addCriterion("iskuangke =", value, "iskuangke");
            return (Criteria) this;
        }

        public Criteria andIskuangkeNotEqualTo(Integer value) {
            addCriterion("iskuangke <>", value, "iskuangke");
            return (Criteria) this;
        }

        public Criteria andIskuangkeGreaterThan(Integer value) {
            addCriterion("iskuangke >", value, "iskuangke");
            return (Criteria) this;
        }

        public Criteria andIskuangkeGreaterThanOrEqualTo(Integer value) {
            addCriterion("iskuangke >=", value, "iskuangke");
            return (Criteria) this;
        }

        public Criteria andIskuangkeLessThan(Integer value) {
            addCriterion("iskuangke <", value, "iskuangke");
            return (Criteria) this;
        }

        public Criteria andIskuangkeLessThanOrEqualTo(Integer value) {
            addCriterion("iskuangke <=", value, "iskuangke");
            return (Criteria) this;
        }

        public Criteria andIskuangkeIn(List<Integer> values) {
            addCriterion("iskuangke in", values, "iskuangke");
            return (Criteria) this;
        }

        public Criteria andIskuangkeNotIn(List<Integer> values) {
            addCriterion("iskuangke not in", values, "iskuangke");
            return (Criteria) this;
        }

        public Criteria andIskuangkeBetween(Integer value1, Integer value2) {
            addCriterion("iskuangke between", value1, value2, "iskuangke");
            return (Criteria) this;
        }

        public Criteria andIskuangkeNotBetween(Integer value1, Integer value2) {
            addCriterion("iskuangke not between", value1, value2, "iskuangke");
            return (Criteria) this;
        }

        public Criteria andKechengnameIsNull() {
            addCriterion("kechengname is null");
            return (Criteria) this;
        }

        public Criteria andKechengnameIsNotNull() {
            addCriterion("kechengname is not null");
            return (Criteria) this;
        }

        public Criteria andKechengnameEqualTo(String value) {
            addCriterion("kechengname =", value, "kechengname");
            return (Criteria) this;
        }

        public Criteria andKechengnameNotEqualTo(String value) {
            addCriterion("kechengname <>", value, "kechengname");
            return (Criteria) this;
        }

        public Criteria andKechengnameGreaterThan(String value) {
            addCriterion("kechengname >", value, "kechengname");
            return (Criteria) this;
        }

        public Criteria andKechengnameGreaterThanOrEqualTo(String value) {
            addCriterion("kechengname >=", value, "kechengname");
            return (Criteria) this;
        }

        public Criteria andKechengnameLessThan(String value) {
            addCriterion("kechengname <", value, "kechengname");
            return (Criteria) this;
        }

        public Criteria andKechengnameLessThanOrEqualTo(String value) {
            addCriterion("kechengname <=", value, "kechengname");
            return (Criteria) this;
        }

        public Criteria andKechengnameLike(String value) {
            addCriterion("kechengname like", value, "kechengname");
            return (Criteria) this;
        }

        public Criteria andKechengnameNotLike(String value) {
            addCriterion("kechengname not like", value, "kechengname");
            return (Criteria) this;
        }

        public Criteria andKechengnameIn(List<String> values) {
            addCriterion("kechengname in", values, "kechengname");
            return (Criteria) this;
        }

        public Criteria andKechengnameNotIn(List<String> values) {
            addCriterion("kechengname not in", values, "kechengname");
            return (Criteria) this;
        }

        public Criteria andKechengnameBetween(String value1, String value2) {
            addCriterion("kechengname between", value1, value2, "kechengname");
            return (Criteria) this;
        }

        public Criteria andKechengnameNotBetween(String value1, String value2) {
            addCriterion("kechengname not between", value1, value2, "kechengname");
            return (Criteria) this;
        }

        public Criteria andKuangkenumIsNull() {
            addCriterion("kuangkenum is null");
            return (Criteria) this;
        }

        public Criteria andKuangkenumIsNotNull() {
            addCriterion("kuangkenum is not null");
            return (Criteria) this;
        }

        public Criteria andKuangkenumEqualTo(Integer value) {
            addCriterion("kuangkenum =", value, "kuangkenum");
            return (Criteria) this;
        }

        public Criteria andKuangkenumNotEqualTo(Integer value) {
            addCriterion("kuangkenum <>", value, "kuangkenum");
            return (Criteria) this;
        }

        public Criteria andKuangkenumGreaterThan(Integer value) {
            addCriterion("kuangkenum >", value, "kuangkenum");
            return (Criteria) this;
        }

        public Criteria andKuangkenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("kuangkenum >=", value, "kuangkenum");
            return (Criteria) this;
        }

        public Criteria andKuangkenumLessThan(Integer value) {
            addCriterion("kuangkenum <", value, "kuangkenum");
            return (Criteria) this;
        }

        public Criteria andKuangkenumLessThanOrEqualTo(Integer value) {
            addCriterion("kuangkenum <=", value, "kuangkenum");
            return (Criteria) this;
        }

        public Criteria andKuangkenumIn(List<Integer> values) {
            addCriterion("kuangkenum in", values, "kuangkenum");
            return (Criteria) this;
        }

        public Criteria andKuangkenumNotIn(List<Integer> values) {
            addCriterion("kuangkenum not in", values, "kuangkenum");
            return (Criteria) this;
        }

        public Criteria andKuangkenumBetween(Integer value1, Integer value2) {
            addCriterion("kuangkenum between", value1, value2, "kuangkenum");
            return (Criteria) this;
        }

        public Criteria andKuangkenumNotBetween(Integer value1, Integer value2) {
            addCriterion("kuangkenum not between", value1, value2, "kuangkenum");
            return (Criteria) this;
        }

        public Criteria andRiqiIsNull() {
            addCriterion("riqi is null");
            return (Criteria) this;
        }

        public Criteria andRiqiIsNotNull() {
            addCriterion("riqi is not null");
            return (Criteria) this;
        }

        public Criteria andRiqiEqualTo(String value) {
            addCriterion("riqi =", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotEqualTo(String value) {
            addCriterion("riqi <>", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiGreaterThan(String value) {
            addCriterion("riqi >", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiGreaterThanOrEqualTo(String value) {
            addCriterion("riqi >=", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiLessThan(String value) {
            addCriterion("riqi <", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiLessThanOrEqualTo(String value) {
            addCriterion("riqi <=", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiLike(String value) {
            addCriterion("riqi like", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotLike(String value) {
            addCriterion("riqi not like", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiIn(List<String> values) {
            addCriterion("riqi in", values, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotIn(List<String> values) {
            addCriterion("riqi not in", values, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiBetween(String value1, String value2) {
            addCriterion("riqi between", value1, value2, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotBetween(String value1, String value2) {
            addCriterion("riqi not between", value1, value2, "riqi");
            return (Criteria) this;
        }

        public Criteria andTeacherIsNull() {
            addCriterion("teacher is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIsNotNull() {
            addCriterion("teacher is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherEqualTo(String value) {
            addCriterion("teacher =", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotEqualTo(String value) {
            addCriterion("teacher <>", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherGreaterThan(String value) {
            addCriterion("teacher >", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherGreaterThanOrEqualTo(String value) {
            addCriterion("teacher >=", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLessThan(String value) {
            addCriterion("teacher <", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLessThanOrEqualTo(String value) {
            addCriterion("teacher <=", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLike(String value) {
            addCriterion("teacher like", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotLike(String value) {
            addCriterion("teacher not like", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherIn(List<String> values) {
            addCriterion("teacher in", values, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotIn(List<String> values) {
            addCriterion("teacher not in", values, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherBetween(String value1, String value2) {
            addCriterion("teacher between", value1, value2, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotBetween(String value1, String value2) {
            addCriterion("teacher not between", value1, value2, "teacher");
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