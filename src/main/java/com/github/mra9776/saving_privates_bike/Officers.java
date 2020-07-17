package com.github.mra9776.saving_privates_bike;

import java.util.Date;

enum OfficerStatus{
	BUSY, 
	FREE
}
public class Officers {
	Integer officer_id;
	OfficerStatus officer_status;
	Date last_case;
	Integer case_id;
	
	
	public Officers(Integer officer_id, OfficerStatus officer_status, Date last_case, Integer case_id) {
		super();
		this.officer_id = officer_id;
		this.officer_status = officer_status;
		this.last_case = last_case;
		this.case_id = case_id;
	}
	@Override
	public String toString() {
		return "Officers [officer_id=" + officer_id + ", officer_status=" + officer_status + ", last_case=" + last_case
				+ ", case_id=" + case_id + "]";
	}
	public Integer getOfficer_id() {
		return officer_id;
	}
	public void setOfficer_id(Integer officer_id) {
		this.officer_id = officer_id;
	}
	public OfficerStatus getOfficer_status() {
		return officer_status;
	}
	public void setOfficer_status(OfficerStatus officer_status) {
		this.officer_status = officer_status;
	}
	public Date getLast_case() {
		return last_case;
	}
	public void setLast_case(Date last_case) {
		this.last_case = last_case;
	}
	public Integer getCase_id() {
		return case_id;
	}
	public void setCase_id(Integer case_id) {
		this.case_id = case_id;
	}
	
}
