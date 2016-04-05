
package com.bios.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.jboss.logging.Logger;

import com.bios.entity.Contacto;
import com.bios.repository.ContactoFacade;

@ManagedBean
@ViewScoped
public class ListContactosController {
	private List<Contacto> contactos;
	private static final Logger log = Logger.getLogger(ListContactosController.class.getName());

	@PostConstruct
	public void init() {
		// TODO: Cargar lista de contactos
		ContactoFacade contactoFacade = new ContactoFacade();
		contactos = contactoFacade.findAll();
	}

	// TODO: Definir método para atributos
	public List<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}
}
