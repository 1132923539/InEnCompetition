package com.bs.competition.entity.simple;

import java.util.ArrayList;
import java.util.List;

public class NewsExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table news
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table news
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table news
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table news
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public NewsExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table news
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table news
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table news
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table news
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table news
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table news
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table news
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table news
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table news
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table news
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table news
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
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

		public Criteria andIdEqualTo(String value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(String value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(String value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(String value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(String value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(String value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLike(String value) {
			addCriterion("id like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotLike(String value) {
			addCriterion("id not like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<String> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<String> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(String value1, String value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(String value1, String value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andContentIsNull() {
			addCriterion("content is null");
			return (Criteria) this;
		}

		public Criteria andContentIsNotNull() {
			addCriterion("content is not null");
			return (Criteria) this;
		}

		public Criteria andContentEqualTo(String value) {
			addCriterion("content =", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotEqualTo(String value) {
			addCriterion("content <>", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThan(String value) {
			addCriterion("content >", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThanOrEqualTo(String value) {
			addCriterion("content >=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThan(String value) {
			addCriterion("content <", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThanOrEqualTo(String value) {
			addCriterion("content <=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLike(String value) {
			addCriterion("content like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotLike(String value) {
			addCriterion("content not like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentIn(List<String> values) {
			addCriterion("content in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotIn(List<String> values) {
			addCriterion("content not in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentBetween(String value1, String value2) {
			addCriterion("content between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotBetween(String value1, String value2) {
			addCriterion("content not between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andAddtimeIsNull() {
			addCriterion("addtime is null");
			return (Criteria) this;
		}

		public Criteria andAddtimeIsNotNull() {
			addCriterion("addtime is not null");
			return (Criteria) this;
		}

		public Criteria andAddtimeEqualTo(Long value) {
			addCriterion("addtime =", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotEqualTo(Long value) {
			addCriterion("addtime <>", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeGreaterThan(Long value) {
			addCriterion("addtime >", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeGreaterThanOrEqualTo(Long value) {
			addCriterion("addtime >=", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeLessThan(Long value) {
			addCriterion("addtime <", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeLessThanOrEqualTo(Long value) {
			addCriterion("addtime <=", value, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeIn(List<Long> values) {
			addCriterion("addtime in", values, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotIn(List<Long> values) {
			addCriterion("addtime not in", values, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeBetween(Long value1, Long value2) {
			addCriterion("addtime between", value1, value2, "addtime");
			return (Criteria) this;
		}

		public Criteria andAddtimeNotBetween(Long value1, Long value2) {
			addCriterion("addtime not between", value1, value2, "addtime");
			return (Criteria) this;
		}

		public Criteria andImageidIsNull() {
			addCriterion("imageid is null");
			return (Criteria) this;
		}

		public Criteria andImageidIsNotNull() {
			addCriterion("imageid is not null");
			return (Criteria) this;
		}

		public Criteria andImageidEqualTo(String value) {
			addCriterion("imageid =", value, "imageid");
			return (Criteria) this;
		}

		public Criteria andImageidNotEqualTo(String value) {
			addCriterion("imageid <>", value, "imageid");
			return (Criteria) this;
		}

		public Criteria andImageidGreaterThan(String value) {
			addCriterion("imageid >", value, "imageid");
			return (Criteria) this;
		}

		public Criteria andImageidGreaterThanOrEqualTo(String value) {
			addCriterion("imageid >=", value, "imageid");
			return (Criteria) this;
		}

		public Criteria andImageidLessThan(String value) {
			addCriterion("imageid <", value, "imageid");
			return (Criteria) this;
		}

		public Criteria andImageidLessThanOrEqualTo(String value) {
			addCriterion("imageid <=", value, "imageid");
			return (Criteria) this;
		}

		public Criteria andImageidLike(String value) {
			addCriterion("imageid like", value, "imageid");
			return (Criteria) this;
		}

		public Criteria andImageidNotLike(String value) {
			addCriterion("imageid not like", value, "imageid");
			return (Criteria) this;
		}

		public Criteria andImageidIn(List<String> values) {
			addCriterion("imageid in", values, "imageid");
			return (Criteria) this;
		}

		public Criteria andImageidNotIn(List<String> values) {
			addCriterion("imageid not in", values, "imageid");
			return (Criteria) this;
		}

		public Criteria andImageidBetween(String value1, String value2) {
			addCriterion("imageid between", value1, value2, "imageid");
			return (Criteria) this;
		}

		public Criteria andImageidNotBetween(String value1, String value2) {
			addCriterion("imageid not between", value1, value2, "imageid");
			return (Criteria) this;
		}

		public Criteria andTypeIsNull() {
			addCriterion("type is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("type is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(Integer value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(Integer value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(Integer value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(Integer value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(Integer value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<Integer> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<Integer> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(Integer value1, Integer value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andSysstatusIsNull() {
			addCriterion("sysstatus is null");
			return (Criteria) this;
		}

		public Criteria andSysstatusIsNotNull() {
			addCriterion("sysstatus is not null");
			return (Criteria) this;
		}

		public Criteria andSysstatusEqualTo(Integer value) {
			addCriterion("sysstatus =", value, "sysstatus");
			return (Criteria) this;
		}

		public Criteria andSysstatusNotEqualTo(Integer value) {
			addCriterion("sysstatus <>", value, "sysstatus");
			return (Criteria) this;
		}

		public Criteria andSysstatusGreaterThan(Integer value) {
			addCriterion("sysstatus >", value, "sysstatus");
			return (Criteria) this;
		}

		public Criteria andSysstatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("sysstatus >=", value, "sysstatus");
			return (Criteria) this;
		}

		public Criteria andSysstatusLessThan(Integer value) {
			addCriterion("sysstatus <", value, "sysstatus");
			return (Criteria) this;
		}

		public Criteria andSysstatusLessThanOrEqualTo(Integer value) {
			addCriterion("sysstatus <=", value, "sysstatus");
			return (Criteria) this;
		}

		public Criteria andSysstatusIn(List<Integer> values) {
			addCriterion("sysstatus in", values, "sysstatus");
			return (Criteria) this;
		}

		public Criteria andSysstatusNotIn(List<Integer> values) {
			addCriterion("sysstatus not in", values, "sysstatus");
			return (Criteria) this;
		}

		public Criteria andSysstatusBetween(Integer value1, Integer value2) {
			addCriterion("sysstatus between", value1, value2, "sysstatus");
			return (Criteria) this;
		}

		public Criteria andSysstatusNotBetween(Integer value1, Integer value2) {
			addCriterion("sysstatus not between", value1, value2, "sysstatus");
			return (Criteria) this;
		}

		public Criteria andPubidIsNull() {
			addCriterion("pubid is null");
			return (Criteria) this;
		}

		public Criteria andPubidIsNotNull() {
			addCriterion("pubid is not null");
			return (Criteria) this;
		}

		public Criteria andPubidEqualTo(String value) {
			addCriterion("pubid =", value, "pubid");
			return (Criteria) this;
		}

		public Criteria andPubidNotEqualTo(String value) {
			addCriterion("pubid <>", value, "pubid");
			return (Criteria) this;
		}

		public Criteria andPubidGreaterThan(String value) {
			addCriterion("pubid >", value, "pubid");
			return (Criteria) this;
		}

		public Criteria andPubidGreaterThanOrEqualTo(String value) {
			addCriterion("pubid >=", value, "pubid");
			return (Criteria) this;
		}

		public Criteria andPubidLessThan(String value) {
			addCriterion("pubid <", value, "pubid");
			return (Criteria) this;
		}

		public Criteria andPubidLessThanOrEqualTo(String value) {
			addCriterion("pubid <=", value, "pubid");
			return (Criteria) this;
		}

		public Criteria andPubidLike(String value) {
			addCriterion("pubid like", value, "pubid");
			return (Criteria) this;
		}

		public Criteria andPubidNotLike(String value) {
			addCriterion("pubid not like", value, "pubid");
			return (Criteria) this;
		}

		public Criteria andPubidIn(List<String> values) {
			addCriterion("pubid in", values, "pubid");
			return (Criteria) this;
		}

		public Criteria andPubidNotIn(List<String> values) {
			addCriterion("pubid not in", values, "pubid");
			return (Criteria) this;
		}

		public Criteria andPubidBetween(String value1, String value2) {
			addCriterion("pubid between", value1, value2, "pubid");
			return (Criteria) this;
		}

		public Criteria andPubidNotBetween(String value1, String value2) {
			addCriterion("pubid not between", value1, value2, "pubid");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table news
	 * @mbggenerated  Sun Apr 10 10:52:06 CST 2017
	 */
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table news
     *
     * @mbggenerated do_not_delete_during_merge Mon Mar 28 21:11:51 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
    
    /** paging param start */
	protected Integer start;
	/** paging param end */
	protected Integer end;

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}
}