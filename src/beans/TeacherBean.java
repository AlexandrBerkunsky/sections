package beans;

import dao.TeacherDAO;
import tables.Teacher;
import utils.CommonUtils;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class TeacherBean implements Serializable {
    @EJB
    TeacherDAO teacherDAO;

    @Inject
    CommonUtils util;
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    private Boolean edit;

    public Boolean getEdit() {
        return edit;
    }

    private Teacher teacher = new Teacher();


    public List<Teacher> getTeachers(){
        return teacherDAO.findAll();
    }

    public void add() {
        teacherDAO.add(teacher);
        teacher = new Teacher();

        util.redirectWithGet();
    }

    public void delete(int id) {
        teacherDAO.delete(id);
        util.redirectWithGet();
    }

    public void editTeacher(Teacher teacher){
        this.teacher = teacher;
        edit = true;

        util.redirectWithGet();
    }

    public void saveEdit(){
        teacherDAO.save(teacher);
        this.teacher = new Teacher();
        edit = false;

        util.redirectWithGet();
    }

    public void cancelEdit(){
        this.teacher = new Teacher();
        edit = false;

        util.redirectWithGet();
    }

}
