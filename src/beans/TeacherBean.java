package beans;

import dao.TeacherDAO;
import tables.Teacher;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class TeacherBean implements Serializable {
    @EJB
    TeacherDAO teacherDAO;

    public List<Teacher> getTeachers(){
        return teacherDAO.findAll();
    }
}
