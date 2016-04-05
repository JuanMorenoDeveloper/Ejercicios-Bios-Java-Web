package com.bios.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

@WebServlet(name = "ServletControllerCount", urlPatterns = { "/ServletControllerCount" }, loadOnStartup = 1)
public class ServletControllerCount extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private EntityManagerFactory factory;
	private static final Logger log = Logger.getLogger(ServletControllerCount.class.getName());

	@Override
	public void init() {
		this.factory = Persistence.createEntityManagerFactory("testFinal");
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long totalContactos=getTotalContactos();
		response.setContentType("text/html;charset=UTF-8");
		request.setAttribute("totalContactos", totalContactos);
		request.getRequestDispatcher("/jsp.jsp")
		.forward(request, response);
	}
	public Long getTotalContactos(){
		EntityManager manager = factory.createEntityManager();
		// TODO: Usar entity transaction, leer datos del formulario, guardar el contacto y redirigir a index.
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Query query = manager.createQuery("Select count(c) from Contacto c");
		Long totalContactos=(Long) query.getSingleResult();
		transaction.commit();
		log.info("Total de contactos: "+totalContactos);
		return totalContactos;
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public void destroy() {
		factory.close();
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}

}
