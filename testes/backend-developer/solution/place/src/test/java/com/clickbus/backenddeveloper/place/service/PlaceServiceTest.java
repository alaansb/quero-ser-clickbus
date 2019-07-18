package com.clickbus.backenddeveloper.place.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.clickbus.place.domain.Place;
import com.clickbus.place.repository.PlaceRepository;
import com.clickbus.place.service.PlaceServiceImpl;
import com.clickbus.place.util.PlaceNoContentException;

@RunWith(MockitoJUnitRunner.class)
public class PlaceServiceTest {
	
	@InjectMocks
	PlaceServiceImpl placeService;
	
	@Mock
	PlaceRepository placeRepository;
	
	@Test
	public void testFindPlaceByIdSucess() {
		
		Place dummyPlace = new Place();
	
		when(placeRepository.findById(1L)).thenReturn(Optional.of(dummyPlace));
		
		Place place = placeService.getPlaceById(1L);
		
		assertNotNull(place);
		
	}
	
	@Test(expected = PlaceNoContentException.class)
	public void testFindPlaceByIdNoContent() {
		
		when(placeRepository.findById(1L)).thenReturn(Optional.empty());
		
		placeService.getPlaceById(1L);
		
	}
	
	@Test()
	public void testFindPlacesByNameSucess() {
		
		List<Place> dummyListPlace = new ArrayList<Place>();
		Place dummyPlace = new Place();
		
		dummyListPlace.add(dummyPlace);
		
		when(placeRepository.findByName("Brazil")).thenReturn(dummyListPlace);
		
		List<Place> listPlace = placeService.getPlacesByName("Brazil");
		
		assertFalse(listPlace.isEmpty());
	}
	
	@Test(expected = PlaceNoContentException.class)
	public void testFindPlacesByNameNoContent() {
		
		placeService.getPlacesByName("Brazi");
		
	}
	
	@Test(expected = PlaceNoContentException.class)
	public void testEditPlaceNoContent() {
		
		Place place = new Place();

		when(placeRepository.findById(1L)).thenReturn(Optional.empty());
		
		placeService.editPlace(place, 1L);
	}
	
	
}
