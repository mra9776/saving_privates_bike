package com.github.mra9776.saving_privates_bike.model;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.github.mra9776.saving_privates_bike.model.helper.CaseStatus;

import org.hibernate.annotations.GenericGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cases {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "caseId", updatable = false, nullable = false)
	private UUID caseId;
	private CaseStatus caseStatus;
	private UUID officerId;
	
	public Cases(Map<String, String> map){
		for(Map.Entry<String, String> entry: map.entrySet()){
			switch(entry.getKey()){
				case "caseId":
					this.caseId = UUID.fromString(entry.getValue());
					break;
				case "caseStatus":
					this.caseStatus = CaseStatus.valueOf(entry.getValue());
					break;
				case "officerId":
					this.officerId = UUID.fromString(entry.getValue());
					break;
			}
		}
	}
	
	public Map<String, String> mapOut(){
		Map<String, String> res = new Hashtable<>();
		if (this.caseId != null)
			res.put("caseId", this.caseId.toString());
		if (this.caseStatus != null)
			res.put("caseStatus", this.caseStatus.toString());
		if (this.officerId != null)
			res.put("officerId", this.officerId.toString());
		return res;
	}
}
