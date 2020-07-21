package com.github.mra9776.saving_privates_bike.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.github.mra9776.saving_privates_bike.model.Officers;
import com.github.mra9776.saving_privates_bike.model.helper.OfficerStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficersRepository extends JpaRepository<Officers, Integer>{
	List <Officers> findByOfficerStatus(OfficerStatus officerStatus);
	List <Officers> findByOfficerStatusOrderByLastCase(OfficerStatus officerStatus);
	Optional<Officers> findByOfficerId(UUID officerId);
	void deleteByOfficerId(UUID officerId);
	
}
