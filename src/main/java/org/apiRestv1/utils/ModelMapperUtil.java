package org.apiRestv1.utils;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apiRestv1.dto.CountryDTO;
import org.apiRestv1.model.Country;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelMapperUtil {

	@Autowired
	ModelMapper modelMapper;
	
	/**
	 * 
	 * @param in Object to map
	 * @param out Mapping to Class
	 * @return Object mapped to Class out
	 */
	public <I, O> O map(I in, Class<O> out) {
		return modelMapper.map(in, out);
	}
	
	/**
	 * 
	 * @param inList Objects' list to map
	 * @param out Mapping to Class
	 * @return Objects' list mapped to Class out
	 */
	public <I, O> List<Object> mapList(List<I> inList, final Class<O> out){
		
		return inList.stream().map(new Function<I, O>(){
			public O apply(I c) {
				return map(c, out);
			}
		}).collect(Collectors.toList());
	}
	


	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	
}
