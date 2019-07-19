package com.clickbus.place.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clickbus.place.domain.Place;
import com.clickbus.place.service.PlaceService;
import com.clickbus.place.util.PlaceNoContentException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("v1/places")
@Api(value = "Place")
public class PlaceController {

	private final PlaceService placeService;

	public PlaceController(PlaceService placeService) {

		this.placeService = placeService;
	}
	
	@ApiOperation("Get place by id")
	@GetMapping(value = "/{idPlace}")
	Place getPlaceById(@PathVariable("idPlace") Long idPlace) {

		return placeService.getPlaceById(idPlace);
	}
	
	@ApiOperation("Get places by name")
	@GetMapping(value = "/place/{name}")
	List<Place> getPlacesByName(@PathVariable("name") String name) {

		return placeService.getPlacesByName(name);
	}
	
	@ApiOperation("Create a place")
	@PostMapping(value = "/")
	Place createPlace(@RequestBody Place place) {

		return placeService.createPlace(place);

	}
	
	@ApiOperation("Update a place")
	@PutMapping(value = "/{idPlace}/")
	Place editPlace(@RequestBody Place place, @RequestParam("idPlace") Long idPlace) {

		return placeService.editPlace(place, idPlace);
	}

	@ResponseBody
	@ExceptionHandler(PlaceNoContentException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	String employeeNotFoundHandler(PlaceNoContentException ex) {
		return ex.getMessage();
	}
}
