package com.github.mra9776.saving_privates_bike;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficersRepository extends JpaRepository<Officers, Integer>{
	List <Officers> findByOfficerStatus(OfficerStatus officerStatus);
}
