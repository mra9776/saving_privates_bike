package com.github.mra9776.saving_privates_bike.data;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.github.mra9776.saving_privates_bike.data.helper.OfficerStatus;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Entity
@ApiModel("Officers Table, Keep the state of Officers")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Officers {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "officerId", updatable = false, nullable = false)
	
	private UUID officerId;
	OfficerStatus officerStatus;
	Date lastCase;
	UUID caseId;
	
}
