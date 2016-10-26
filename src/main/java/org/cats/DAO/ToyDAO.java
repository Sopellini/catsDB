package org.cats.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;

import org.cats.Model.Toy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ToyDAO {
	
	@Autowired
	private DataSource dataSource;
	
	@PersistenceUnit
	EntityManagerFactory emfactory;

	@PersistenceContext
	EntityManager entityManager;
	
	public void addToy(Toy toy){
		EntityManager entityManager = emfactory.createEntityManager();
		EntityTransaction trans = entityManager.getTransaction();
		trans.begin();
		entityManager.persist(toy);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void deleteToy(int id){
		EntityManager entityManager = emfactory.createEntityManager();
		EntityTransaction trans = entityManager.getTransaction();
		trans.begin();
		entityManager.remove(entityManager.find(Toy.class, id));
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public Toy getToyById(int id){
		EntityManager entityManager = emfactory.createEntityManager();
		return entityManager.find(Toy.class, id);
	}

}
