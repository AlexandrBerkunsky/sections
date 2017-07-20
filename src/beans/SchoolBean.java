package beans;

import dao.SchoolDAO;
import tables.School;
import utils.CommonUtils;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
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
}
