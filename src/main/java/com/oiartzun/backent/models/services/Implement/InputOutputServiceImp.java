package com.oiartzun.backent.models.services.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oiartzun.backent.models.dao.IInputOutputDao;
import com.oiartzun.backent.models.dao.IProductDao;
import com.oiartzun.backent.models.entity.InputOutput;
import com.oiartzun.backent.models.entity.ItemInputOutput;
import com.oiartzun.backent.models.entity.Product;
import com.oiartzun.backent.models.services.IInputOutputService;

@Service
public class InputOutputServiceImp implements IInputOutputService{
	
	@Autowired
	private IInputOutputDao iinputOutputDao;

	@Autowired
	private IProductDao iproductDao;
	
	
	@Override
	public List<InputOutput> findAll() {
		return (List<InputOutput>)iinputOutputDao.findAll();
	}

	@Override
	public List<InputOutput> getProductsById(Long id) {
		return iinputOutputDao.getProductsById(id);
	}

	@Override
	public InputOutput findById(Long id) {
		return iinputOutputDao.findById(id).orElse(null);
	}

	@Override
	public InputOutput save(InputOutput inputOutput) {
		InputOutput io = null;
		for(ItemInputOutput item :inputOutput.getItems()) {
			Product product = iproductDao.findById(item.getProduct().getId()).orElse(null);
			System.err.println(product);
			if(product != null) {
				if(inputOutput.getIsInput()) {					
					product.setAmount(product.getAmount() + item.getAmount());
				}else {
					product.setAmount(product.getAmount() - item.getAmount());
				}
				iproductDao.save(product);
			}else {
				System.err.println("El producto da nulo!!!");
			}
		}
		io=iinputOutputDao.save(inputOutput);
		
		return io;
	}

	@Override
	public void delete(Long id) {
		iinputOutputDao.deleteById(id);
	}

}
