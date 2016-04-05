package com.bios.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.bios.entity.Contacto;
import com.bios.repository.HibernateUtil;

@WebServlet(name = "CountContactosController", urlPatterns = { "/CountContactosController" }, loadOnStartup = 1)
public class CountContactosController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CountContactosController.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManager manager = HibernateUtil.createEntityManager();
		// TODO: Leer datos del formulario, guardar el contacto y redirigir a index.z
		// Con JPQL
		// Query query = manager.createQuery("select count(c) from Contacto c");
		// Con API Criteria
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		Long totalContactos = manager.createQuery(query.select(builder.count(query.from(Contacto.class))))
				.getSingleResult();
		log.info("Total de contactos: " + totalContactos);
		response.setContentType("text/html;charset=UTF-8");
		request.setAttribute("totalContactos", totalContactos);
		request.getRequestDispatcher("/contactos/total.jsp").forward(request, response);
	}
}
