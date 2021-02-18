package com.oiartzun.backent.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.oiartzun.backent.models.entity.InputOutput;

public interface IInputOutputDao extends CrudRepository<InputOutput, Long>{
	
	@Query("From InputOutput WHERE id=:id")
	public List<InputOutput> getProductsById(@Param("id") Long id);
	
}
