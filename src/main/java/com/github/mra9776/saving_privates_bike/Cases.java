package com.github.mra9776.saving_privates_bike;

enum CaseStatus {
	PENDING, 
	WORKING, 
	DONE
}

public class Cases {
	Integer case_id;
	CaseStatus case_status;
	Integer officer_id;
	
	public Cases(Integer case_id, CaseStatus case_status, Integer officer_id) {
		super();
		this.case_id = case_id;
		this.case_status = case_status;
		this.officer_id = officer_id;
	}
	@Override
	public String toString() {
		return "Cases [case_id=" + case_id + ", case_status=" + case_status + ", officer_id=" + officer_id + "]";
	}
	public Integer getCase_id() {
		return case_id;
	}
	public void setCase_id(Integer case_id) {
		this.case_id = case_id;
	}
	public CaseStatus getCase_status() {
		return case_status;
	}
	public void setCase_status(CaseStatus case_status) {
		this.case_status = case_status;
	}
	public Integer getOfficer_id() {
		return officer_id;
	}
	public void setOfficer_id(Integer officer_id) {
		this.officer_id = officer_id;
	}
	
	
}
