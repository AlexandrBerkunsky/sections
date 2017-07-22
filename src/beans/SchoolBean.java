package beans;

import dao.SchoolDAO;
import tables.School;
import utils.CommonUtils;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class SchoolBean implements Serializable{
    @EJB
    SchoolDAO schoolDAO;

    @Inject
    CommonUtils util;
    private Boolean edit;


    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    private School school = new School();

    public List<School> getSchools() {
        return schoolDAO.findAll();
    }

    public void add(){
        schoolDAO.add(school);
        school = new School();

        util.redirectWithGet();
    }

    public void delete(int id){
        schoolDAO.delete(id);
        util.redirectWithGet();
    }

    public Boolean getEdit() {
        return edit;
    }

    public void editSchool(School school){
        this.school = school;
        edit = true;

        util.redirectWithGet();
    }

    public void saveEdit(){
        schoolDAO.save(school);
        this.school = new School();
        edit = false;

        util.redirectWithGet();
    }

    public void cancelEdit(){
        this.school = new School();
        edit = false;

        util.redirectWithGet();
    }
}
