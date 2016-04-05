package com.bios.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.bios.entity.Contacto;
import com.bios.repository.HibernateUtil;

@WebServlet(name = "AddContactosController", urlPatterns = { "/AddContactosController" }, loadOnStartup = 1)
public class AddContactosController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(AddContactosController.class.getName());

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManager manager = HibernateUtil.createEntityManager();
		// TODO: Usar entity transaction, leer datos del formulario, guardar el contacto y redirigir a index.
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		Contacto contacto = new Contacto();
		contacto.setNombre(nombre);
		contacto.setEmail(email);
		manager.persist(contacto);
		transaction.commit();
		log.info("Contacto guardado");
		response.sendRedirect("index.html");
	}
}
