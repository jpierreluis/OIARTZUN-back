package com.oiartzun.backent.models.services;

import java.util.List;

import com.oiartzun.backent.models.entity.InputOutput;

public interface IInputOutputService {
	public List<InputOutput> findAll();
	public List<InputOutput> getProductsById(Long id);
	public InputOutput findById(Long id);
	public InputOutput save(InputOutput inputOutput);
	public void delete(Long id);

}
