package com.github.mra9776.saving_privates_bike;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import io.swagger.annotations.ApiModel;

enum OfficerStatus{
	BUSY, 
	FREE
}

@Entity
@ApiModel("Officers Table, Keep the state of Officers")
public class Officers {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id", updatable = false, nullable = false)
	private UUID officerId;
	
	OfficerStatus officerStatus;
	
	Date lastCase;
	
	public Officers() {
		super();
	}
	UUID case_id;

	public UUID getOfficerId() {
		return officerId;
	}
	public void setOfficerId(UUID officerId) {
		this.officerId = officerId;
	}
	public OfficerStatus getOfficerStatus() {
		return officerStatus;
	}
	public void setOfficerStatus(OfficerStatus officerStatus) {
		this.officerStatus = officerStatus;
	}
	public Date getLastCase() {
		return lastCase;
	}
	public void setLastCase(Date lastCase) {
		this.lastCase = lastCase;
	}
	public UUID getCase_id() {
		return case_id;
	}
	public void setCase_id(UUID case_id) {
		this.case_id = case_id;
	}
	@Override
	public String toString() {
		return "Officers [officerId=" + officerId + ", officerStatus=" + officerStatus + ", lastCase=" + lastCase
				+ ", case_id=" + case_id + "]";
	}
	public Officers(UUID officerId, OfficerStatus officerStatus, Date lastCase, UUID case_id) {
		super();
		this.officerId = officerId;
		this.officerStatus = officerStatus;
		this.lastCase = lastCase;
		this.case_id = case_id;
	}
	
	
}
