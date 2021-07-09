package com.kaoqin.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BanjiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public BanjiExample() {
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

    public void setForUpdate(Boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public Boolean getForUpdate() {
        return forUpdate;
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

        public Criteria andBanjinameIsNull() {
            addCriterion("banjiname is null");
            return (Criteria) this;
        }

        public Criteria andBanjinameIsNotNull() {
            addCriterion("banjiname is not null");
            return (Criteria) this;
        }

        public Criteria andBanjinameEqualTo(String value) {
            addCriterion("banjiname =", value, "banjiname");
            return (Criteria) this;
        }

        public Criteria andBanjinameNotEqualTo(String value) {
            addCriterion("banjiname <>", value, "banjiname");
            return (Criteria) this;
        }

        public Criteria andBanjinameGreaterThan(String value) {
            addCriterion("banjiname >", value, "banjiname");
            return (Criteria) this;
        }

        public Criteria andBanjinameGreaterThanOrEqualTo(String value) {
            addCriterion("banjiname >=", value, "banjiname");
            return (Criteria) this;
        }

        public Criteria andBanjinameLessThan(String value) {
            addCriterion("banjiname <", value, "banjiname");
            return (Criteria) this;
        }

        public Criteria andBanjinameLessThanOrEqualTo(String value) {
            addCriterion("banjiname <=", value, "banjiname");
            return (Criteria) this;
        }

        public Criteria andBanjinameLike(String value) {
            addCriterion("banjiname like", value, "banjiname");
            return (Criteria) this;
        }

        public Criteria andBanjinameNotLike(String value) {
            addCriterion("banjiname not like", value, "banjiname");
            return (Criteria) this;
        }

        public Criteria andBanjinameIn(List<String> values) {
            addCriterion("banjiname in", values, "banjiname");
            return (Criteria) this;
        }

        public Criteria andBanjinameNotIn(List<String> values) {
            addCriterion("banjiname not in", values, "banjiname");
            return (Criteria) this;
        }

        public Criteria andBanjinameBetween(String value1, String value2) {
            addCriterion("banjiname between", value1, value2, "banjiname");
            return (Criteria) this;
        }

        public Criteria andBanjinameNotBetween(String value1, String value2) {
            addCriterion("banjiname not between", value1, value2, "banjiname");
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

        public Criteria andYuanxiIsNull() {
            addCriterion("yuanxi is null");
            return (Criteria) this;
        }

        public Criteria andYuanxiIsNotNull() {
            addCriterion("yuanxi is not null");
            return (Criteria) this;
        }

        public Criteria andYuanxiEqualTo(String value) {
            addCriterion("yuanxi =", value, "yuanxi");
            return (Criteria) this;
        }

        public Criteria andYuanxiNotEqualTo(String value) {
            addCriterion("yuanxi <>", value, "yuanxi");
            return (Criteria) this;
        }

        public Criteria andYuanxiGreaterThan(String value) {
            addCriterion("yuanxi >", value, "yuanxi");
            return (Criteria) this;
        }

        public Criteria andYuanxiGreaterThanOrEqualTo(String value) {
            addCriterion("yuanxi >=", value, "yuanxi");
            return (Criteria) this;
        }

        public Criteria andYuanxiLessThan(String value) {
            addCriterion("yuanxi <", value, "yuanxi");
            return (Criteria) this;
        }

        public Criteria andYuanxiLessThanOrEqualTo(String value) {
            addCriterion("yuanxi <=", value, "yuanxi");
            return (Criteria) this;
        }

        public Criteria andYuanxiLike(String value) {
            addCriterion("yuanxi like", value, "yuanxi");
            return (Criteria) this;
        }

        public Criteria andYuanxiNotLike(String value) {
            addCriterion("yuanxi not like", value, "yuanxi");
            return (Criteria) this;
        }

        public Criteria andYuanxiIn(List<String> values) {
            addCriterion("yuanxi in", values, "yuanxi");
            return (Criteria) this;
        }

        public Criteria andYuanxiNotIn(List<String> values) {
            addCriterion("yuanxi not in", values, "yuanxi");
            return (Criteria) this;
        }

        public Criteria andYuanxiBetween(String value1, String value2) {
            addCriterion("yuanxi between", value1, value2, "yuanxi");
            return (Criteria) this;
        }

        public Criteria andYuanxiNotBetween(String value1, String value2) {
            addCriterion("yuanxi not between", value1, value2, "yuanxi");
            return (Criteria) this;
        }

        public Criteria andZhuanyeIsNull() {
            addCriterion("zhuanye is null");
            return (Criteria) this;
        }

        public Criteria andZhuanyeIsNotNull() {
            addCriterion("zhuanye is not null");
            return (Criteria) this;
        }

        public Criteria andZhuanyeEqualTo(String value) {
            addCriterion("zhuanye =", value, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeNotEqualTo(String value) {
            addCriterion("zhuanye <>", value, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeGreaterThan(String value) {
            addCriterion("zhuanye >", value, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeGreaterThanOrEqualTo(String value) {
            addCriterion("zhuanye >=", value, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeLessThan(String value) {
            addCriterion("zhuanye <", value, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeLessThanOrEqualTo(String value) {
            addCriterion("zhuanye <=", value, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeLike(String value) {
            addCriterion("zhuanye like", value, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeNotLike(String value) {
            addCriterion("zhuanye not like", value, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeIn(List<String> values) {
            addCriterion("zhuanye in", values, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeNotIn(List<String> values) {
            addCriterion("zhuanye not in", values, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeBetween(String value1, String value2) {
            addCriterion("zhuanye between", value1, value2, "zhuanye");
            return (Criteria) this;
        }

        public Criteria andZhuanyeNotBetween(String value1, String value2) {
            addCriterion("zhuanye not between", value1, value2, "zhuanye");
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