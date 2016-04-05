
package com.bios.repository;

import com.bios.entity.Contacto;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AuthorFacade extends JPAFacade<Contacto>{
    private EntityManager entityManager;
    public void initEntityManager(){
        entityManager=Persistence.createEntityManagerFactory("testFinal").createEntityManager();
        this.setEntityClass(Contacto.class);
    }
    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
