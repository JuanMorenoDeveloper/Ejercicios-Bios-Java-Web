
package com.bios.repository;

import javax.persistence.EntityManager;

import com.bios.entity.Contacto;

public class ContactoFacade extends JPAFacade<Contacto>{
	private EntityManager entityManager;
	public ContactoFacade(){
		entityManager=HibernateUtil.createEntityManager();
		this.setEntityClass(Contacto.class);
	}
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
}
