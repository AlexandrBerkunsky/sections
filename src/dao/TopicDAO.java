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
}
