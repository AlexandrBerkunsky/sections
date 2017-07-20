package beans;

import dao.TopicDAO;
import tables.Topic;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class TopicBean implements Serializable{
    @EJB
    TopicDAO topicDAO;

    public List<Topic> getTopics() {
        return topicDAO.findAll();
    }
}
