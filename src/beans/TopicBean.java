package beans;

import dao.TopicDAO;
import tables.Topic;
import utils.CommonUtils;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class TopicBean implements Serializable{
    @EJB
    TopicDAO topicDAO;

    private Boolean edit;



    @Inject
    CommonUtils util;

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
        util.redirectWithGet();
    }

    public void delete(int id){
        topicDAO.delete(id);
        util.redirectWithGet();
    }

    public Boolean getEdit() {
        return edit;
    }

    public void editTopic(Topic topic){
        this.topic = topic;
        edit = true;

        util.redirectWithGet();
    }

    public void saveEdit(){
        topicDAO.save(topic);
        this.topic = new Topic();
        edit = false;

        util.redirectWithGet();
    }

    public void cancelEdit(){
        this.topic = new Topic();
        edit = false;

        util.redirectWithGet();
    }
}
