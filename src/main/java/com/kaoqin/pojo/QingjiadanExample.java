package com.kaoqin.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QingjiadanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public QingjiadanExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andQjtime1IsNull() {
            addCriterion("qjtime1 is null");
            return (Criteria) this;
        }

        public Criteria andQjtime1IsNotNull() {
            addCriterion("qjtime1 is not null");
            return (Criteria) this;
        }

        public Criteria andQjtime1EqualTo(String value) {
            addCriterion("qjtime1 =", value, "qjtime1");
            return (Criteria) this;
        }

        public Criteria andQjtime1NotEqualTo(String value) {
            addCriterion("qjtime1 <>", value, "qjtime1");
            return (Criteria) this;
        }

        public Criteria andQjtime1GreaterThan(String value) {
            addCriterion("qjtime1 >", value, "qjtime1");
            return (Criteria) this;
        }

        public Criteria andQjtime1GreaterThanOrEqualTo(String value) {
            addCriterion("qjtime1 >=", value, "qjtime1");
            return (Criteria) this;
        }

        public Criteria andQjtime1LessThan(String value) {
            addCriterion("qjtime1 <", value, "qjtime1");
            return (Criteria) this;
        }

        public Criteria andQjtime1LessThanOrEqualTo(String value) {
            addCriterion("qjtime1 <=", value, "qjtime1");
            return (Criteria) this;
        }

        public Criteria andQjtime1Like(String value) {
            addCriterion("qjtime1 like", value, "qjtime1");
            return (Criteria) this;
        }

        public Criteria andQjtime1NotLike(String value) {
            addCriterion("qjtime1 not like", value, "qjtime1");
            return (Criteria) this;
        }

        public Criteria andQjtime1In(List<String> values) {
            addCriterion("qjtime1 in", values, "qjtime1");
            return (Criteria) this;
        }

        public Criteria andQjtime1NotIn(List<String> values) {
            addCriterion("qjtime1 not in", values, "qjtime1");
            return (Criteria) this;
        }

        public Criteria andQjtime1Between(String value1, String value2) {
            addCriterion("qjtime1 between", value1, value2, "qjtime1");
            return (Criteria) this;
        }

        public Criteria andQjtime1NotBetween(String value1, String value2) {
            addCriterion("qjtime1 not between", value1, value2, "qjtime1");
            return (Criteria) this;
        }

        public Criteria andQjtime2IsNull() {
            addCriterion("qjtime2 is null");
            return (Criteria) this;
        }

        public Criteria andQjtime2IsNotNull() {
            addCriterion("qjtime2 is not null");
            return (Criteria) this;
        }

        public Criteria andQjtime2EqualTo(String value) {
            addCriterion("qjtime2 =", value, "qjtime2");
            return (Criteria) this;
        }

        public Criteria andQjtime2NotEqualTo(String value) {
            addCriterion("qjtime2 <>", value, "qjtime2");
            return (Criteria) this;
        }

        public Criteria andQjtime2GreaterThan(String value) {
            addCriterion("qjtime2 >", value, "qjtime2");
            return (Criteria) this;
        }

        public Criteria andQjtime2GreaterThanOrEqualTo(String value) {
            addCriterion("qjtime2 >=", value, "qjtime2");
            return (Criteria) this;
        }

        public Criteria andQjtime2LessThan(String value) {
            addCriterion("qjtime2 <", value, "qjtime2");
            return (Criteria) this;
        }

        public Criteria andQjtime2LessThanOrEqualTo(String value) {
            addCriterion("qjtime2 <=", value, "qjtime2");
            return (Criteria) this;
        }

        public Criteria andQjtime2Like(String value) {
            addCriterion("qjtime2 like", value, "qjtime2");
            return (Criteria) this;
        }

        public Criteria andQjtime2NotLike(String value) {
            addCriterion("qjtime2 not like", value, "qjtime2");
            return (Criteria) this;
        }

        public Criteria andQjtime2In(List<String> values) {
            addCriterion("qjtime2 in", values, "qjtime2");
            return (Criteria) this;
        }

        public Criteria andQjtime2NotIn(List<String> values) {
            addCriterion("qjtime2 not in", values, "qjtime2");
            return (Criteria) this;
        }

        public Criteria andQjtime2Between(String value1, String value2) {
            addCriterion("qjtime2 between", value1, value2, "qjtime2");
            return (Criteria) this;
        }

        public Criteria andQjtime2NotBetween(String value1, String value2) {
            addCriterion("qjtime2 not between", value1, value2, "qjtime2");
            return (Criteria) this;
        }

        public Criteria andQingjiacontentIsNull() {
            addCriterion("qingjiacontent is null");
            return (Criteria) this;
        }

        public Criteria andQingjiacontentIsNotNull() {
            addCriterion("qingjiacontent is not null");
            return (Criteria) this;
        }

        public Criteria andQingjiacontentEqualTo(String value) {
            addCriterion("qingjiacontent =", value, "qingjiacontent");
            return (Criteria) this;
        }

        public Criteria andQingjiacontentNotEqualTo(String value) {
            addCriterion("qingjiacontent <>", value, "qingjiacontent");
            return (Criteria) this;
        }

        public Criteria andQingjiacontentGreaterThan(String value) {
            addCriterion("qingjiacontent >", value, "qingjiacontent");
            return (Criteria) this;
        }

        public Criteria andQingjiacontentGreaterThanOrEqualTo(String value) {
            addCriterion("qingjiacontent >=", value, "qingjiacontent");
            return (Criteria) this;
        }

        public Criteria andQingjiacontentLessThan(String value) {
            addCriterion("qingjiacontent <", value, "qingjiacontent");
            return (Criteria) this;
        }

        public Criteria andQingjiacontentLessThanOrEqualTo(String value) {
            addCriterion("qingjiacontent <=", value, "qingjiacontent");
            return (Criteria) this;
        }

        public Criteria andQingjiacontentLike(String value) {
            addCriterion("qingjiacontent like", value, "qingjiacontent");
            return (Criteria) this;
        }

        public Criteria andQingjiacontentNotLike(String value) {
            addCriterion("qingjiacontent not like", value, "qingjiacontent");
            return (Criteria) this;
        }

        public Criteria andQingjiacontentIn(List<String> values) {
            addCriterion("qingjiacontent in", values, "qingjiacontent");
            return (Criteria) this;
        }

        public Criteria andQingjiacontentNotIn(List<String> values) {
            addCriterion("qingjiacontent not in", values, "qingjiacontent");
            return (Criteria) this;
        }

        public Criteria andQingjiacontentBetween(String value1, String value2) {
            addCriterion("qingjiacontent between", value1, value2, "qingjiacontent");
            return (Criteria) this;
        }

        public Criteria andQingjiacontentNotBetween(String value1, String value2) {
            addCriterion("qingjiacontent not between", value1, value2, "qingjiacontent");
            return (Criteria) this;
        }

        public Criteria andShenheIsNull() {
            addCriterion("shenhe is null");
            return (Criteria) this;
        }

        public Criteria andShenheIsNotNull() {
            addCriterion("shenhe is not null");
            return (Criteria) this;
        }

        public Criteria andShenheEqualTo(String value) {
            addCriterion("shenhe =", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheNotEqualTo(String value) {
            addCriterion("shenhe <>", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheGreaterThan(String value) {
            addCriterion("shenhe >", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheGreaterThanOrEqualTo(String value) {
            addCriterion("shenhe >=", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheLessThan(String value) {
            addCriterion("shenhe <", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheLessThanOrEqualTo(String value) {
            addCriterion("shenhe <=", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheLike(String value) {
            addCriterion("shenhe like", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheNotLike(String value) {
            addCriterion("shenhe not like", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheIn(List<String> values) {
            addCriterion("shenhe in", values, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheNotIn(List<String> values) {
            addCriterion("shenhe not in", values, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheBetween(String value1, String value2) {
            addCriterion("shenhe between", value1, value2, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheNotBetween(String value1, String value2) {
            addCriterion("shenhe not between", value1, value2, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenhecontentIsNull() {
            addCriterion("shenhecontent is null");
            return (Criteria) this;
        }

        public Criteria andShenhecontentIsNotNull() {
            addCriterion("shenhecontent is not null");
            return (Criteria) this;
        }

        public Criteria andShenhecontentEqualTo(String value) {
            addCriterion("shenhecontent =", value, "shenhecontent");
            return (Criteria) this;
        }

        public Criteria andShenhecontentNotEqualTo(String value) {
            addCriterion("shenhecontent <>", value, "shenhecontent");
            return (Criteria) this;
        }

        public Criteria andShenhecontentGreaterThan(String value) {
            addCriterion("shenhecontent >", value, "shenhecontent");
            return (Criteria) this;
        }

        public Criteria andShenhecontentGreaterThanOrEqualTo(String value) {
            addCriterion("shenhecontent >=", value, "shenhecontent");
            return (Criteria) this;
        }

        public Criteria andShenhecontentLessThan(String value) {
            addCriterion("shenhecontent <", value, "shenhecontent");
            return (Criteria) this;
        }

        public Criteria andShenhecontentLessThanOrEqualTo(String value) {
            addCriterion("shenhecontent <=", value, "shenhecontent");
            return (Criteria) this;
        }

        public Criteria andShenhecontentLike(String value) {
            addCriterion("shenhecontent like", value, "shenhecontent");
            return (Criteria) this;
        }

        public Criteria andShenhecontentNotLike(String value) {
            addCriterion("shenhecontent not like", value, "shenhecontent");
            return (Criteria) this;
        }

        public Criteria andShenhecontentIn(List<String> values) {
            addCriterion("shenhecontent in", values, "shenhecontent");
            return (Criteria) this;
        }

        public Criteria andShenhecontentNotIn(List<String> values) {
            addCriterion("shenhecontent not in", values, "shenhecontent");
            return (Criteria) this;
        }

        public Criteria andShenhecontentBetween(String value1, String value2) {
            addCriterion("shenhecontent between", value1, value2, "shenhecontent");
            return (Criteria) this;
        }

        public Criteria andShenhecontentNotBetween(String value1, String value2) {
            addCriterion("shenhecontent not between", value1, value2, "shenhecontent");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
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