package org.apiRestv1.controller;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apiRestv1.dto.CountryDTO;
import org.apiRestv1.model.Country;
import org.apiRestv1.service.CountryService;
import org.apiRestv1.utils.ModelMapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	ModelMapperUtil mapperUtil;
	
	@RequestMapping(value = "/addCountry", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> addCountry(@RequestBody CountryDTO countryDto) { 
		
		countryService.addCountry(mapperUtil.map(countryDto, Country.class));
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/getCountries", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<?> getCountries(){
		
		List<Country> countries = countryService.getCountries();
		return new ResponseEntity(mapperUtil.mapList(countries, CountryDTO.class), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getCountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<?> getCountryId(@PathVariable("id") String id){
		
		CountryDTO countryDto = mapperUtil.map(countryService.getCountryId(id), CountryDTO.class);
		return new ResponseEntity(countryDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateCountry", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<?> updateCountry(@RequestBody CountryDTO countryEdit){
		
		countryService.updateCountry(mapperUtil.map(countryEdit, Country.class));
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	
	
	

	

	
	/*
	
	
	
	@RequestMapping(value = "/removeCountry", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> removeCountry(@RequestBody Country countryRemove){
		
		countryService.removeCountry(countryRemove);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/removeCountry/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> removeCountry(@PathVariable String id){
		
		countryService.removeCountryId(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	/*
	private CountryDTO convertToDto(Country country) {
		return countryMapper.map(country, CountryDTO.class);
	}
	
	private Country convertToEntity(CountryDTO countryDto) {
		return countryMapper.map(countryDto, Country.class);
	}
	
	private List<Object> mapAll(List<Country> countries){
		return countries.stream().map(new Function<Country, CountryDTO>() {
			public CountryDTO apply(Country country) {
				return convertToDto(country);
			}
		}).collect(Collectors.toList());
		
	}*/
	
	
}
