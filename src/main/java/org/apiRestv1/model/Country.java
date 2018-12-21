package org.apiRestv1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Country")
public class Country extends GenericObject{
	
	@Column(name = "countryName")
	public String countryName;
	
	@Column(name = "population")
	public String population;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}
}
