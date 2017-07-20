package dao;

import tables.School;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class SchoolDAO {
    @PersistenceContext
    EntityManager em;

    public List<School> findAll(){
        return em.createQuery("select s from School s").getResultList();
    }

    public void add(School school) {
        em.persist(school);
    }
}
