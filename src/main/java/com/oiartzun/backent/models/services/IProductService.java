package com.oiartzun.backent.models.services;

import java.util.List;

import com.oiartzun.backent.models.entity.Product;
import com.oiartzun.backent.models.filter.SearchFilter;

public interface IProductService {
	public List<Product> findAll();
	public List<Product> getProductsById(Long id);
	public List<Product> search(String search);
	public Product findById(Long id);
	public Product save(Product product);
	public void delete(Long id);
}
