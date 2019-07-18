package com.clickbus.place.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clickbus.place.domain.Place;
import com.clickbus.place.repository.PlaceRepository;
import com.clickbus.place.util.PlaceNoContentException;

@Service("placeService")
public class PlaceServiceImpl implements PlaceService {

	private final PlaceRepository placeRepository;

	public PlaceServiceImpl(PlaceRepository placeRepository) {

		this.placeRepository = placeRepository;
	}

	public Place createPlace(Place place) {

		return placeRepository.save(place);
	}

	@Override
	public Place editPlace(Place newPlace, Long id) {

		return placeRepository.findById(id).map(place -> {
			return placeRepository.save(newPlace);
		}).orElseThrow(() -> new PlaceNoContentException(id));

	}

	public Place getPlaceById(Long idPlace) {

		return placeRepository.findById(idPlace).orElseThrow(() -> new PlaceNoContentException(idPlace));
	}

	public List<Place> getPlacesByName(String name) {
		
		List<Place> listPlaces = placeRepository.findByName(name);
		
		if(listPlaces.isEmpty()) {
			throw new PlaceNoContentException(name);
		}
		
		return placeRepository.findByName(name);
	}

}
