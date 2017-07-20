package dao;

import tables.Teacher;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TeacherDAO {
    @PersistenceContext
    EntityManager em;

    public List<Teacher> findAll(){
        return em.createQuery("select t from Teacher t").getResultList();
    }
}
