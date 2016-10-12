package org.cats.Service;

import java.util.List;
import org.cats.DAO.CatDAO;
import org.cats.Model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CatService {
		
	@Autowired
	private CatDAO catDao;
	
	public void addCat(Cat cat){
		catDao.addCat(cat);
	}

	public List<Cat> getCats() {
		return catDao.getCats();
	}
	
	public Cat getCatById(int id){
		return catDao.getCatById(id);
	}
}
