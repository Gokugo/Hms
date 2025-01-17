package com.hms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.hms.entities.Admin;

@Repository
public class RegistrationDAOImpl implements RegistrationDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void addAdmin(Admin admin) {
		em.persist(admin);
	}

	@Override
	public List<Admin> findAllAdmin() {
		return  em.createQuery("SELECT a FROM Admin a", Admin.class).getResultList();
	}

}