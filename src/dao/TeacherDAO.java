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

    public void add(Teacher teacher) {
        em.persist(teacher);
    }

    public void delete(int id) {
        Teacher teacher = em.find(Teacher.class, id);
        em.remove(teacher);
    }

    public void save(Teacher teacher) {
        em.merge(teacher);
    }
}
