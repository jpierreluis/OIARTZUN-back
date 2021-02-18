package com.oiartzun.backent.models.services.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oiartzun.backent.models.dao.IProductDao;
import com.oiartzun.backent.models.entity.Product;
import com.oiartzun.backent.models.services.IProductService;

@Service
public class ProductServiceImpl implements IProductService{
	@Autowired 
	private IProductDao productDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return (List<Product>)productDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> getProductsById(Long id) {
		return (List<Product>)productDao.getProductsById(id);	
	}

	@Override
	@Transactional(readOnly = true)
	public Product findById(Long id) {
		return productDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Product save(Product product) {
		return productDao.save(product);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productDao.deleteById(id);
	}

	@Override
	public List<Product> search(String search) {
		return productDao.search(search);
	}

}
