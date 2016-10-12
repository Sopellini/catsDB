package org.cats.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.cats.Model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CatDAO {

	private List<Cat> catList = new ArrayList<Cat>();

	@Autowired
	private DataSource dataSource;

	@PersistenceUnit
	EntityManagerFactory emfactory;

	@PersistenceContext
	EntityManager entityManager;

	public void addCat(Cat cat) {
		EntityManager entityManager = emfactory.createEntityManager();
		EntityTransaction trans = entityManager.getTransaction();
		trans.begin();
		entityManager.persist(cat);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public List<Cat> getCats() {

		EntityManager entityManager;
		entityManager = emfactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT c FROM Cat c");
		return catList = query.getResultList();
	}

	public Cat getCatById(int id) {
		EntityManager entityManager;
		entityManager = emfactory.createEntityManager();
		return entityManager.find(Cat.class, id);
	}
}
