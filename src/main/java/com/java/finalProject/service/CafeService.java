package com.java.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.finalProject.model.DrinksMenu;
import com.java.finalProject.model.areas;
import com.java.finalProject.model.carts;
import com.java.finalProject.model.category;
import com.java.finalProject.model.tables;
import com.java.finalProject.repository.AreaRepository;
import com.java.finalProject.repository.CartRepository;
import com.java.finalProject.repository.CategoryRepository;
import com.java.finalProject.repository.DrinksMenuRepository;
import com.java.finalProject.repository.TableRepository;
@Service
public class CafeService {
	@Autowired
	private AreaRepository areaRepository;
	@Autowired
	private TableRepository tableRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private DrinksMenuRepository drinksMenuRepository;
	@Autowired
	private CartRepository cartRepository;
	public List<areas> getAllAreas() {
        return areaRepository.findAll();
    }

    public List<tables> getTablesByAreaId(Long areaId) {
        return tableRepository.findByAreaAreaId(areaId);
    }
    public List<category> getAllCategory(){
    	return categoryRepository.findAll();
    }
    public List<DrinksMenu> getMenuByCategoryId(Long categoryId){
    	return drinksMenuRepository.findByCateCategoryId(categoryId);
    };
    public List<String> getAllTableInCart(){
    	return cartRepository.findDistinctTableNames();
    }
    public List<carts> getCartByTableId(String tableName){
    	return cartRepository.findByTableName(tableName);
    }
}
