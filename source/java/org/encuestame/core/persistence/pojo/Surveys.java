package org.encuestame.core.persistence.pojo;

// Generated 29-may-2009 13:17:50 by Hibernate Tools 3.2.2.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Surveys generated by hbm2java
 */
public class Surveys implements java.io.Serializable {

	private long sid;
	private SecUsers secUsers;
	private int ticket;
	private Date startDate;
	private Date endDate;
	private Date dateInterview;
	private String complete;
	private Integer idSidFormat;
	private Set<SurveyTime> surveyTimes = new HashSet<SurveyTime>(0);

	public Surveys() {
	}

	public Surveys(long sid, SecUsers secUsers, int ticket, Date startDate,
			Date endDate) {
		this.sid = sid;
		this.secUsers = secUsers;
		this.ticket = ticket;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Surveys(long sid, SecUsers secUsers, int ticket, Date startDate,
			Date endDate, Date dateInterview, String complete,
			Integer idSidFormat, Set<SurveyTime> surveyTimes) {
		this.sid = sid;
		this.secUsers = secUsers;
		this.ticket = ticket;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dateInterview = dateInterview;
		this.complete = complete;
		this.idSidFormat = idSidFormat;
		this.surveyTimes = surveyTimes;
	}

	public long getSid() {
		return this.sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public SecUsers getSecUsers() {
		return this.secUsers;
	}

	public void setSecUsers(SecUsers secUsers) {
		this.secUsers = secUsers;
	}

	public int getTicket() {
		return this.ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getDateInterview() {
		return this.dateInterview;
	}

	public void setDateInterview(Date dateInterview) {
		this.dateInterview = dateInterview;
	}

	public String getComplete() {
		return this.complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}

	public Integer getIdSidFormat() {
		return this.idSidFormat;
	}

	public void setIdSidFormat(Integer idSidFormat) {
		this.idSidFormat = idSidFormat;
	}

	public Set<SurveyTime> getSurveyTimes() {
		return this.surveyTimes;
	}

	public void setSurveyTimes(Set<SurveyTime> surveyTimes) {
		this.surveyTimes = surveyTimes;
	}

}