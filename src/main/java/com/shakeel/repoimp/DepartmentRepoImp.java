package com.shakeel.repoimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shakeel.model.Departments;
import com.shakeel.repo.DepartmentRepo;

import jakarta.persistence.EntityManager;

@Repository
public class DepartmentRepoImp implements DepartmentRepo {
	
	@Autowired
	EntityManager em;

	@Override
	public void addDept(Departments dept) {
		em.persist(dept);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departments> getAllDepertment() {
				
		return  em.createQuery("from Departments").getResultList();
	}

	
	@Override
	public void deleteDept(int id) {
		Departments dept=em.find(Departments.class, id);
		em.remove(dept);
	}
	
	

	@Override
	public boolean updateDept(Departments department) {
		em.merge(department);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departments> getAlldeptName() {
		
		return em.createQuery("select dept from Departments").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departments> getUgDept() {
		return em.createQuery("select dept d from Departments d where courseType = 'UG'").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departments> getPgDept() {
		
		return em.createQuery("select dept d from Departments d where courseType = 'PG'").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departments> getAllPgDetails() {
	
		return em.createQuery("select d from Departments d where courseType = 'PG'").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departments> getAllUgDetails() {
		
		return em.createQuery("select d from Departments d where courseType = 'UG'").getResultList();
	}
	
	

	

}
