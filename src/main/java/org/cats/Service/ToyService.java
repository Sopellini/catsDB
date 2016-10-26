package org.cats.Service;

import java.util.List;

import org.cats.DAO.CatDAO;
import org.cats.DAO.ToyDAO;
import org.cats.Model.Cat;
import org.cats.Model.Toy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ToyService {
	
	@Autowired
	private ToyDAO toyDao;
	
	public void addToy(Toy toy){
		toyDao.addToy(toy);
	}

	public void deleteToy(int id) {
		toyDao.deleteToy(id);
	}
	
	public Toy getToyById(int id){
		return toyDao.getToyById(id);
	}
}
