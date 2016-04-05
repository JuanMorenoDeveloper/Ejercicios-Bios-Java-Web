package com.bios.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hsqldb.util.DatabaseManagerSwing;
import org.jboss.logging.Logger;

import com.bios.entity.Contacto;

@WebServlet(name = "ServletController", urlPatterns = { "/ServletController" }, loadOnStartup = 1)
public class ServletController extends HttpServlet {

	private EntityManagerFactory factory;
	private static final Logger log = Logger.getLogger(ServletController.class.getName());

	@Override
	public void init() {
		this.factory = Persistence.createEntityManagerFactory("testFinal");
		log.info("Inicializando hsqldb manager");
		DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.print("<html>" +
				"<head>" +
				"<title>Servlet controller</title>" +
				"</head>" +
				"<body>" +
				"<h2>Ingrese un contacto</h2>" +
				"<form method='POST' action='ServletController'>" +
				"<label for='nombre'>Nombre:</label>" +
				"<input type='text' id='nombre' name='nombre'>" +
				"<br>" +
				"<label for='nombre'>Email:</label>" +
				"<input type='email' id='email' name='email'>" +
				"<br>" +
				"<input type='submit' value='Guardar'>" +
				"<form>" +
				"<body>" +
				"<br>" +
				"<a href='index.html'>Regresar</a>" +
				"</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManager manager = factory.createEntityManager();
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
		response.sendRedirect("index.html");
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
