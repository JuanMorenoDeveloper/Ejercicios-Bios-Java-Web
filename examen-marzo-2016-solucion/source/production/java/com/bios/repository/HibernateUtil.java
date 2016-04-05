package com.bios.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hsqldb.util.DatabaseManagerSwing;
import org.jboss.logging.Logger;

@WebListener
public class HibernateUtil implements ServletContextListener {

	private static EntityManagerFactory emf;
	private static final Logger log = Logger.getLogger(HibernateUtil.class.getName());
	@Override
	public void contextInitialized(ServletContextEvent event) {
		emf = Persistence.createEntityManagerFactory("testFinal");
		log.info("Inicializando hsqldb manager");
		DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
            if(emf!=null&&emf.isOpen()){
		emf.close();
            }
	}

	public static EntityManager createEntityManager() {
		if (emf == null) {
			throw new IllegalStateException("Context is not initialized yet.");
		}

		return emf.createEntityManager();
	}

}