package com.clickbus.place.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clickbus.place.domain.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {
	
	List<Place> findByName(String name);

}
