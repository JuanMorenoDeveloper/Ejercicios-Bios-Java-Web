package com.bios.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.bios.entity.Contacto;
import com.bios.repository.HibernateUtil;

@ManagedBean
@ViewScoped
public class SearchContactosController {
	private Contacto contacto;
	private String nombreBusqueda;
	private static final Logger log = Logger.getLogger(SearchContactosController.class.getName());

	@PostConstruct
	public void init() {
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void buscar(AjaxBehaviorEvent event) {
		EntityManager entityManager = HibernateUtil.createEntityManager();
		try {
			Query query = entityManager.createQuery("select c from Contacto c where c.nombre like :nombre");
			query.setParameter("nombre", nombreBusqueda);
			contacto = (Contacto) query.getSingleResult();
		} catch (NoResultException e) {
			contacto=null;
		}
		log.info("Se encontro a: " + contacto);
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public String getNombreBusqueda() {
		return nombreBusqueda;
	}

	public void setNombreBusqueda(String nombreBusqueda) {
		this.nombreBusqueda = nombreBusqueda;
	}
}
