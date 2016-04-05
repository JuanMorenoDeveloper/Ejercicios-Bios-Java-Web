
package com.bios.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.bios.entity.Contacto;
import com.bios.repository.ContactoFacade;

@ManagedBean
@ViewScoped
public class NewJSFManagedBean {
	private List<Contacto> contactos;
	@PostConstruct
	public void init(){
		ContactoFacade contactoFacade=new ContactoFacade();
		contactos=contactoFacade.findAll();
		//TODO: Cargar lista de authores
	}
	//TODO: Definir método para atributos
	public List<Contacto> getContactos() {
		return contactos;
	}
	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}
}
