package com.clickbus.place.service;

import java.util.List;

import com.clickbus.place.domain.Place;

public interface PlaceService {

	Place createPlace(Place place);
	
	Place getPlaceById(Long idPlace);
	
	List<Place> getPlacesByName(String name);

	Place editPlace(Place newPlace, Long id);
}
