package com.github.mra9776.saving_privates_bike;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

enum CaseStatus {
	PENDING, 
	WORKING, 
	DONE
}

@Entity
public class Cases {
	
	@Id
	@GeneratedValue
	Integer case_id;
	
	CaseStatus caseStatus;
	
	Integer officer_id;
	public Cases() {
		super();
	}
	public Cases(Integer case_id, CaseStatus case_status, Integer officer_id) {
		super();
		this.case_id = case_id;
		this.caseStatus = case_status;
		this.officer_id = officer_id;
	}
	@Override
	public String toString() {
		return "Cases [case_id=" + case_id + ", case_status=" + caseStatus + ", officer_id=" + officer_id + "]";
	}
	public Integer getCase_id() {
		return case_id;
	}
	public void setCase_id(Integer case_id) {
		this.case_id = case_id;
	}
	public CaseStatus getCase_status() {
		return caseStatus;
	}
	public void setCase_status(CaseStatus case_status) {
		this.caseStatus = case_status;
	}
	public Integer getOfficer_id() {
		return officer_id;
	}
	public void setOfficer_id(Integer officer_id) {
		this.officer_id = officer_id;
	}
	
	
}
