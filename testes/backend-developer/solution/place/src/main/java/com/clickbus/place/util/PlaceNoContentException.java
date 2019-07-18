package com.clickbus.place.util;

public class PlaceNoContentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PlaceNoContentException(Long id) {

		super("Could not find place " + id);
	}

	public PlaceNoContentException(String name) {

		super("No content places with name: " + name);
	}

}
