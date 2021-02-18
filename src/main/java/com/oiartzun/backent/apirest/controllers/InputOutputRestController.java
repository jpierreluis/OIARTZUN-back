package com.oiartzun.backent.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oiartzun.backent.models.entity.InputOutput;
import com.oiartzun.backent.models.services.Implement.InputOutputServiceImp;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class InputOutputRestController {
	@Autowired 
	private InputOutputServiceImp inputOutputServiceImp;
	
	@PostMapping("/inputoutput")
	@ResponseStatus(HttpStatus.CREATED)
	public InputOutput create(@RequestBody InputOutput inputoutput) {
		return inputOutputServiceImp.save(inputoutput);
	}
	

}
