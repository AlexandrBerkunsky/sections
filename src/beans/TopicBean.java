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

    private Topic topic = new Topic();

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<Topic> getTopics() {
        return topicDAO.findAll();
    }

    public void add(){
        topicDAO.add(topic);
        topic = new Topic();
    }
}
