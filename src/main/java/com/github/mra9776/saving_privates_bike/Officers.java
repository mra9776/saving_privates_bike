package com.github.mra9776.saving_privates_bike;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

enum OfficerStatus{
	BUSY, 
	FREE
}

@Entity
public class Officers {
	@Id
	@GeneratedValue
	Integer officer_id;
	
	OfficerStatus officerStatus;
	
	Date lastCase;
	
	public Officers() {
		super();
	}
	UUID case_id;
	
	public Officers(Integer officer_id, OfficerStatus officer_status, Date last_case, UUID case_id) {
		super();
		this.officer_id = officer_id;
		this.officerStatus = officer_status;
		this.lastCase = last_case;
		this.case_id = case_id;
	}
	@Override
	public String toString() {
		return "Officers [officer_id=" + officer_id + ", officer_status=" + officerStatus + ", last_case=" + lastCase
				+ ", case_id=" + case_id + "]";
	}
	public Integer getOfficer_id() {
		return officer_id;
	}
	public void setOfficer_id(Integer officer_id) {
		this.officer_id = officer_id;
	}
	public OfficerStatus getOfficer_status() {
		return officerStatus;
	}
	public void setOfficer_status(OfficerStatus officer_status) {
		this.officerStatus = officer_status;
	}
	public Date getLast_case() {
		return lastCase;
	}
	public void setLast_case(Date last_case) {
		this.lastCase = last_case;
	}
	public UUID getCase_id() {
		return case_id;
	}
	public void setCase_id(UUID uuid) {
		this.case_id = uuid;
	}
	
}
