package dao;

import tables.Topic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TopicDAO {
    @PersistenceContext
    EntityManager em;

    public List<Topic> findAll(){
        return em.createQuery("select t from Topic t").getResultList();
    }

    public void add(Topic topic) {
        em.persist(topic);
    }

    public void delete(int id) {
        Topic topic = em.find(Topic.class, id);
        em.remove(topic);
    }

    public void save(Topic topic) {
        em.merge(topic);
    }
}
