package com.web.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;
import com.web.modelo.Universidad;

@Stateless
public class DAOUniversidad{

    @PersistenceContext
    private EntityManager em;

    public void create(Universidad universidad){
        em.persist(universidad);
    }

    public void update(Universidad universidad){
        em.merge(universidad);
    }

    public Universidad read(int codigo){
        Universidad universidad = em.find(Universidad.class, codigo);
        return universidad;
    }

    public void delete(int codigo){
        Universidad universidad = em.find(Universidad.class, codigo);
        System.out.println(universidad);
        em.remove(universidad);
    }

    public List<Universidad> getAll(){
    	String jpql = "SELECT u FROM Universidad u";//Aqui nos referimos a las entidades no a la base de daros, es sensible a mayuscular y minusculas
		Query q = em.createQuery(jpql, Universidad.class);
		return q.getResultList();
    }

}
