package com.github.mra9776.saving_privates_bike;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

enum CaseStatus {
	PENDING, 
	WORKING, 
	DONE
}

@Entity
public class Cases {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id", updatable = false, nullable = false)
	private UUID caseId;
	
	CaseStatus caseStatus;
	
	UUID officer_id;
	
	public Cases() {
		super();
	}

	public UUID getCaseId() {
		return caseId;
	}

	public void setCaseId(UUID caseId) {
		this.caseId = caseId;
	}

	public CaseStatus getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(CaseStatus caseStatus) {
		this.caseStatus = caseStatus;
	}

	public UUID getOfficer_id() {
		return officer_id;
	}

	public void setOfficer_id(UUID uuid) {
		this.officer_id = uuid;
	}

	public Cases(UUID caseId, CaseStatus caseStatus, UUID officer_id) {
		super();
		this.caseId = caseId;
		this.caseStatus = caseStatus;
		this.officer_id = officer_id;
	}
	
}
