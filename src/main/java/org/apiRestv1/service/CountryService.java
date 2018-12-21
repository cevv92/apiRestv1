package org.apiRestv1.service;

import org.apiRestv1.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apiRestv1.model.Country;

import java.util.List;

import org.apiRestv1.dao.*;

@Service
public class CountryService {
	
	@Autowired
	IGenericDAO<Country, Long> dao;
	
	@Transactional
	public void addCountry(Country country) {
		dao.saveOrUpdate(country);
	}
	
	public List<Country> getCountries() {
		List<Country> countries = dao.getAll();
		return countries;
	}
	
	public Country getCountryId(String id) {
		return dao.load(new Long(id));
	}
	
	public void updateCountry(Country countryEdit) {
		Country c = getCountryId(countryEdit.getId().toString());
		countryEdit.setVersion(c.getVersion());
		dao.saveOrUpdate(countryEdit);
	}
	
	public void removeCountry(Country countryRemove) {
		dao.remove(countryRemove);
	}

	public void removeCountryId(String id) {
		
		Country country = dao.load(new Long(id));
		if(null != country) {
			dao.remove(country);
		}
		
	}
	

}
