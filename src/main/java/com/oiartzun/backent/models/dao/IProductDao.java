package com.oiartzun.backent.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.oiartzun.backent.models.entity.Product;

public interface IProductDao extends CrudRepository<Product, Long>{
	
	@Query("From Product WHERE id=:id")
	public List<Product> getProductsById(@Param("id")Long id);
	
	@Query("From Product WHERE name LIKE %:search% OR inventaryCode LIKE %:search%")
	public List<Product> search(@Param("search") String search);
}
