package com.github.mra9776.saving_privates_bike;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficersRepository extends JpaRepository<Officers, Integer>{
	List <Officers> findByOfficerStatus(OfficerStatus officerStatus);
	List <Officers> findByOfficerStatusOrderByLastCase(OfficerStatus officerStatus);
	Optional<Officers> findByOfficerId(UUID officerId);
	void deleteByOfficerId(UUID officerId);
	
}
